package utils;

import model.Car;
import model.Order;
import model.Status;
import service.OrderService;
import service.UserService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Validations {
    private static OrderService orderService = new OrderService();
    private static UserService userService = new UserService();

    public static boolean checkDateAvailability(Car car, LocalDateTime start, LocalDateTime end) {

        List<LocalDateTime> startDates = orderService.findAll().stream()
                .filter(order -> order.getCar().equals(car))
                .filter(order -> order.getStatus().equals(Status.ACCEPTED))
                .map(Order::getStartTime)
                .collect(Collectors.toList());
        if (startDates.size() == 0) {
            return false;
        }
        List<LocalDateTime> endDates = orderService.findAll().stream()
                .filter(order -> order.getCar().equals(car))
                .filter(order -> order.getStatus().equals(Status.ACCEPTED))
                .map(Order::getEndTime)
                .collect(Collectors.toList());
        Map<LocalDateTime, LocalDateTime> map = IntStream.range(0, startDates.size())
                .boxed()
                .collect(Collectors.toMap(i -> startDates.get(i), i -> endDates.get(i)));

        boolean notValidDate =
                map.entrySet().stream()
                        .anyMatch(entry -> entry.getKey().isBefore(end) && entry.getValue().isAfter(start));

        return notValidDate;
    }

    public static boolean doesPasswordExist(String pass) {
        return userService.findAllUsers().stream().anyMatch(x -> BCrypt.checkpw(pass, x.getPassword()));
    }
}
