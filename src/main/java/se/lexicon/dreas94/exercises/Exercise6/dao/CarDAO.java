package se.lexicon.dreas94.exercises.Exercise6.dao;

import se.lexicon.dreas94.exercises.Exercise6.Car;
import se.lexicon.dreas94.exercises.Exercise6.exception.ObjectNotFoundException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CarDAO
{
    Car create(Car car);

    Optional<Car> findById(String id);

    List<Car> findByRegNumber(String regNumber);

    List<Car> findByBrand(String brand);

    List<Car> findByModel(String model);

    List<Car> findByRegDate(LocalDate regDate);

    List<Car> findAll();

    void remove(String id) throws ObjectNotFoundException;
}
