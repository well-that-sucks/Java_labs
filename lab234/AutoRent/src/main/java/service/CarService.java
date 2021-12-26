package service;

import dao.CarDao;
import dao.impl.DaoFactory;
import model.Car;

import java.util.List;
import java.util.Optional;

public class CarService {
    CarDao dao = DaoFactory.getCarDao();

    public Optional<Car> findCarById(long id) {
        return dao.findById(id);
    }

    public List<Car> findAllByCarMark(String carMark) {
        return dao.findAllByCarMark(carMark);
    }

    public List<Car> findAllByCarQuality(String carQuality) {
        return dao.findAllByCarQuality(carQuality);
    }

    public List<Car> findAll() {
        return dao.findAll();
    }

    public boolean deleteCarById(long id) {
        return dao.deleteById(id);
    }

    public boolean addCar(Car car) {
        return dao.addCar(car);
    }
    public boolean updateCar(Car car, long id) {
        return dao.updateCar(car, id);
    }

}
