package dao.impl;

import dao.CarDao;
import dao.impl.extractUtil.CarExtract;
import model.Car;
import model.Status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static utils.DBQueries.*;

public class CarDaoImpl implements CarDao {

    Connection connection;

    public CarDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean addCar(Car car) {
        try (PreparedStatement ps = connection.prepareStatement(ADD_CAR)) {
            ps.setString(1, car.getCarMark());
            ps.setString(2, car.getCarName());
            ps.setLong(3, car.getCarPrice());
            ps.setString(4, car.getCarQuality());
            ps.setString(5, String.valueOf(Status.READY));
            ps.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean updateCar(Car car, long id) {
        try (PreparedStatement ps = connection.prepareStatement(UPDATE_CAR_BY_ID)) {
            ps.setString(1, car.getCarMark());
            ps.setString(2, car.getCarName());
            ps.setLong(3, car.getCarPrice());
            ps.setString(4, car.getCarQuality());
            ps.setString(5, car.getStatus().name());
            ps.setLong(6, id);
            ps.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Optional<Car> findById(long id) {
        Optional<Car> car = Optional.ofNullable(null);
        try (PreparedStatement ps = connection.prepareStatement(FIND_CAR_BY_ID)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                car = Optional.of(CarExtract.extractCar(rs));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return car;
    }

    @Override
    public List<Car> findAllByCarMark(String carMark) {
        List<Car> cars = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(FIND_CARS_BY_MARK)) {
            ps.setString(1, carMark);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cars.add(CarExtract.extractCar(rs));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return cars;
    }

    @Override
    public List<Car> findAllByCarQuality(String carQuality) {
        List<Car> cars = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(FIND_CARS_BY_QUALITY)) {
            ps.setString(1, carQuality);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cars.add(CarExtract.extractCar(rs));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return cars;
    }

    @Override
    public List<Car> findAll() {
        List<Car> cars = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(FIND_ALL_CARS)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cars.add(CarExtract.extractCar(rs));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return cars;
    }

    @Override
    public boolean deleteById(long id) {
        try(PreparedStatement ps = connection.prepareStatement(DELETE_CAR_BY_ID)){
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch(SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }


}
