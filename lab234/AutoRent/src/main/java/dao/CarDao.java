package dao;

import model.Car;

import java.util.List;
import java.util.Optional;

public interface CarDao {
    boolean addCar(Car car);
    boolean updateCar(Car car, long id);
    Optional<Car> findById(long id);
    List<Car> findAllByCarMark(String carMark);
    List<Car> findAllByCarQuality(String carQuality);

    boolean deleteById(long id);
    List<Car> findAll();

}
