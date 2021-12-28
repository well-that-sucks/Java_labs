package controller.command.user;

import controller.command.Command;
import model.Car;
import model.Order;
import model.User;
import service.CarService;
import service.OrderService;
import utils.Validations;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

public class CarOrder implements Command {
	static final Logger LOGGER = Logger.getLogger(CarOrder.class);
    private final CarService carService;
    private final OrderService orderService;
    
    public CarOrder(CarService carService, OrderService orderService) {
        this.carService = carService;
        this.orderService = orderService;
    }


    @Override
    public String execute(HttpServletRequest request) {
        if (request.getMethod().equals("GET")) {
            Long carId = Long.parseLong(request.getParameter("carId"));

            try {
                request.setAttribute("carId", carId);
                request.setAttribute("carToOrder",
                        carService.findCarById(carId).orElseThrow(NoSuchElementException::new));

            } catch (Exception e) {
            	LOGGER.error("Failed to load a car info");
                e.printStackTrace();
                return "redirect:/error";
            }
            return "WEB-INF/carOrder.jsp";
        }

        try {
            Long carIdToOrder = Long.parseLong(request.getParameter("carId"));
            request.setAttribute("carId", carIdToOrder);
            Car receivedCar = carService.findCarById(carIdToOrder).orElseThrow(NoSuchElementException::new);
            User user = (User) request.getSession().getAttribute("user");
            Order order = new Order();

            boolean dateNotAvailable = Validations.checkDateAvailability(receivedCar,
                    LocalDateTime.parse(request.getParameter("startTime")),
                    LocalDateTime.parse(request.getParameter("endTime")));

            if (!dateNotAvailable) {
                request.getSession().removeAttribute("dateNotAvailableMessage");
                order.setUser(user);
                order.setCar(receivedCar);
                order.setWithDriver(Boolean.valueOf(request.getParameter("withDriver")) == null ? false : true);
                order.setPassport(request.getParameter("passport"));
                order.setOrderPrice(Long.parseLong(request.getParameter("orderPrice")));
                order.setStartTime(LocalDateTime.parse(request.getParameter("startTime")));
                order.setEndTime( LocalDateTime.parse(request.getParameter("endTime")));
                orderService.addOrder(order, carIdToOrder, user.getId());
            } else {
                request.getSession().setAttribute("dateNotAvailableMessage", "This date is not available");
            }

            request.setAttribute("carToOrder", receivedCar);
        } catch (Exception e) {
        	LOGGER.error("Failed to make a car order");
            e.printStackTrace();
            return "redirect:/error";

        }
        LOGGER.error("Successfully made a car order");
        return "WEB-INF/carOrder.jsp";

    }
}
