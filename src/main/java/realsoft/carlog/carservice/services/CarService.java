package realsoft.carlog.carservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import realsoft.carlog.carservice.entity.Car;
import realsoft.carlog.carservice.repo.CarRepository;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    private CarRepository repository;

    public List<Car> getAllCars(){
        return repository.findAll();
    }
    public Car getCar(Long carId) throws FileNotFoundException {
        Optional<Car> car = repository.findById(carId);
        if (car.isPresent()){
            return car.get();
        } else {
            throw new FileNotFoundException("Not car exist with this id : " + carId);
        }
    }
    public Car saveCar(Car car){
        return repository.save(car);
    }
    public Car updateCar(Car car, Long carId) throws FileNotFoundException {
        Optional<Car> carreq = repository.findById(carId);
        if(carreq.isPresent()){
            Car resp = carreq.get();
            resp.setCarMake(car.getCarMake());
            resp.setCarModel(car.getCarModel());
            resp.setCarYear(car.getCarYear());
            resp.setIsAssigned(car.getIsAssigned());
            return repository.save(resp);
        } else {
            throw new FileNotFoundException("Car not found with this Id");
        }
    }
    public void deleteCar(Long carId){
        repository.deleteById(carId);
    }
    public List<Car> getAllAvailableCars(){
        return repository.findAllByIsAssignedFalse();
    }
}
