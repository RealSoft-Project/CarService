package realsoft.carlog.carservice.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import realsoft.carlog.carservice.entity.Car;
import realsoft.carlog.carservice.repo.CarRepository;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class CarServiceTest {
    @Mock
    private CarRepository repository;
    @BeforeEach
    public void saveCarBefore(){
        Car car = Car.builder().carId(1L).carMake("nissan").carModel("maxima").carYear(2005L).isAssigned(false).build();
        repository.save(car);
    }
    @Test
    void getAllCars() {

    }

    @Test
    void getCar() {
    }

    @Test
    void saveCar() {
//        Car car = Car.builder().carId(2L).carMake("nissan").carModel("maxima").carYear(2005L).isAssigned(false).build();
//      Car savedCar =  repository.save(car);
//        Assertions.assertEquals(false,repository.findById(2L).get().getIsAssigned());
    }

    @Test
    void updateCar() {
    }

    @Test
    void deleteCar() {
    }

    @Test
    void getAllAvailableCars() {
    }
}