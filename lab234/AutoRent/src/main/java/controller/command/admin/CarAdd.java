package controller.command.admin;

import controller.command.Command;
import model.Car;
import service.CarService;

import javax.servlet.http.HttpServletRequest;


public class CarAdd implements Command {

    private final CarService carService;

    public CarAdd(CarService carService) {
        this.carService = carService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        if (request.getMethod().equals("GET")) {
            return "WEB-INF/carAdd.jsp";
        }

        Car car = new Car();
        car.setCarName(request.getParameter("carName"));
        car.setCarMark(request.getParameter("carMark"));
        car.setCarQuality(request.getParameter("carQuality"));
        car.setCarPrice(Long.parseLong(request.getParameter("carPrice")));

        try {
            carService.addCar(car);
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/carAdd";
        }
        return "redirect:/carAdd";
    }
}
