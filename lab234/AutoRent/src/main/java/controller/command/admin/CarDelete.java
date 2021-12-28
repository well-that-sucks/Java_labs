package controller.command.admin;

import controller.command.Command;
import service.CarService;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

public class CarDelete implements Command {
	static final Logger LOGGER = Logger.getLogger(CarDelete.class);
    private final CarService carService;

    public CarDelete(CarService carService) {
        this.carService = carService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        Long carId = Long.parseLong(request.getParameter("carId"));
        try {
            carService.deleteCarById(carId);
        } catch (Exception e) {
        	LOGGER.error("Failed to delete a car from DB");
            e.printStackTrace();
            return "redirect:/error";
        }
        LOGGER.info("Successfully deleted a car from DB");
        return "redirect:/carPage";
    }
}
