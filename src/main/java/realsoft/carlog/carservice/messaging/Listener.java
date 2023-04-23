package realsoft.carlog.carservice.messaging;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import realsoft.carlog.carservice.entity.Car;
import realsoft.carlog.carservice.repo.CarRepository;

import java.util.Optional;

@Component
@Slf4j
public class Listener {
    private final CarRepository repository;

    public Listener(CarRepository repository) {
        this.repository = repository;
    }
    @RabbitListener(queues = "car.assign")
    public void assignCar(@Payload Long carId){
        log.info("Received from Rabbit mq car.assign queue");
        Optional<Car> car = repository.findById(carId);
        car.ifPresent(value -> value.setIsAssigned(true));
        repository.save(car.get());
    }

    @RabbitListener(queues = "car.unassign")
    public void unAssignCar(@Payload Long carId){
        log.info("Received from Rabbit mq car.unassign queue");
        Optional<Car> car = repository.findById(carId);
        car.ifPresent(value -> value.setIsAssigned(false));
        repository.save(car.get());
    }
}
