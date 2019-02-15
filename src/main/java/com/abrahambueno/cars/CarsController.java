package com.abrahambueno.cars;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/cars")
@RestController
@Slf4j
public class CarsController {

    private final CarsRepository carsrepos;
    private final RabbitTemplate rt;

    public CarsController(CarsRepository carsrepos, RabbitTemplate rt) {
        this.carsrepos = carsrepos;
        this.rt = rt;
    }

    /*
    GET
    /cars/id/{id} returns the car based of of id
    /cars/year/{year} returns a list of cars of that year model
    /cars/brand/{brand} returns a list of cars of that brand
    This gest logged with a message of "search for {brand}".
    So put the brand of the car that was searched in the message itself.
    */

    /*
        POST
        /cars/upload
        loads multiple sets of data from the RequestBody This gets logged with a message of "Data loaded"

        DELETE
        /cars/delete/{id}
        deletes a car from the list based off of the id
        This gets logged with a message of "{id} Data deleted". So, put the id of the car that got deleted in the message itself.
     */

    @PostMapping("/upload")
    public List<Cars> newCar(@RequestBody List<Cars> newCars) {
        return carsrepos.saveAll(newCars);
    }
}
