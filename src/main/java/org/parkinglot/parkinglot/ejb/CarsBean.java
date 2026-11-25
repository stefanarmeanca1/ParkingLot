package org.parkinglot.parkinglot.ejb;

import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.example.parkingLot.entities.Car;
import org.example.parkingLot.entities.User;
import org.parkinglot.parkinglot.common.CarDTO;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Logger;

@Stateless
public class CarsBean
{
    private static final Logger LOG = Logger.getLogger(CarsBean.class.getName());

    @PersistenceContext
    EntityManager entitiyManager;

    List<CarDTO> copyCarsToDTO(List<Car> cars) {
        List<CarDTO> carDTOs = new ArrayList<>();

        for (Car car : cars) {
            CarDTO carDTO = new CarDTO(car.getId(),
                    car.getLicensePlate(),
                    car.getParkingSpot(),
                    car.getOwner().getUsername());

            carDTOs.add(carDTO);
        }

        return carDTOs;
    }

    public List<CarDTO> findAllCars() {
        LOG.info("findAllCars");

        try {
            TypedQuery<Car> typedQuery = entitiyManager.createQuery("SELECT c FROM Car c", Car.class);
            List<Car> cars = typedQuery.getResultList();
            return copyCarsToDTO(cars);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    public void createCar(String licensePlate, String parkingSpot, Long userId)
    {
        LOG.info("createCar");

        Car car = new Car();
        car.setLicensePlate(licensePlate);
        car.setParkingSpot(parkingSpot);

        User user = entitiyManager.find(User.class, userId);
        user.getCars().add(car);
        car.setOwner(user);

        entitiyManager.persist(car);
    }
}











































