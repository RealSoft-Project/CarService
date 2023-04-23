package realsoft.carlog.carservice.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import realsoft.carlog.carservice.entity.Car;
import realsoft.carlog.carservice.services.CarService;

//import javax.ws.rs.NotFoundException;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
@Api(value = "Car service Endpoints", tags = {"Cars"})
public class CarController {
    private final CarService service;

    public CarController(CarService service) {
        this.service = service;
    }

    @GetMapping("")
    public ResponseEntity<List<Car>> getAll(){
        return ResponseEntity.ok(service.getAllCars());
    }
    @GetMapping("/available-cars")
    public ResponseEntity<List<Car>> getAllAvailableCars(){
        return ResponseEntity.ok(service.getAllAvailableCars());
    }
    @GetMapping("/{carId}")
    public ResponseEntity<Car> getCar(@PathVariable Long carId) throws FileNotFoundException {
        Car car = service.getCar(carId);
            return ResponseEntity.ok(car);
    }
    @PostMapping
    public ResponseEntity<Car> postCar(@RequestBody Car car){
        return ResponseEntity.ok(service.saveCar(car));
    }
    @PutMapping("/{carId}")
    public ResponseEntity<Car> updateCar(@PathVariable Long carId, @RequestBody Car car) throws FileNotFoundException {
        return ResponseEntity.ok(service.updateCar(car,carId));
    }
    @DeleteMapping("/{carId}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long carId){
        service.deleteCar(carId);
        return ResponseEntity.noContent().build();
    }

}
