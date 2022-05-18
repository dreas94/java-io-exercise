package se.lexicon.dreas94.exercises.Exercise6.dao.impl;

import se.lexicon.dreas94.exercises.Exercise6.Car;
import se.lexicon.dreas94.exercises.Exercise6.dao.CarDAO;
import se.lexicon.dreas94.exercises.Exercise6.exception.ObjectNotFoundException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CarDAOImpl implements CarDAO
{
    private List<Car> storage;

    public CarDAOImpl()
    {
        this.storage = new ArrayList<>();
    }

    @Override
    public Car create(Car car)
    {
        if(car == null) throw new IllegalArgumentException("car data is null");
        storage.add(car);
        return car;
    }

    @Override
    public Optional<Car> findById(String id)
    {
        if (id == null) throw new IllegalArgumentException("Id is null");
        return storage.stream().filter(car -> car.getCarId().equalsIgnoreCase(id)).findFirst();
    }

    @Override
    public List<Car> findByRegNumber(String regNumber)
    {
        if (regNumber == null) throw new IllegalArgumentException("regNumber is null");
        return storage.stream().filter(car -> car.getRegNumber().equalsIgnoreCase(regNumber)).collect(Collectors.toList());
    }

    @Override
    public List<Car> findByBrand(String brand)
    {
        if (brand == null) throw new IllegalArgumentException("brand is null");
        return storage.stream().filter(car -> car.getBrand().equalsIgnoreCase(brand)).collect(Collectors.toList());
    }

    @Override
    public List<Car> findByModel(String model)
    {
        if (model == null) throw new IllegalArgumentException("model is null");
        return storage.stream().filter(car -> car.getModel().equalsIgnoreCase(model)).collect(Collectors.toList());
    }

    @Override
    public List<Car> findByRegDate(LocalDate regDate)
    {
        if (regDate == null) throw new IllegalArgumentException("model is null");
        return storage.stream().filter(car -> car.getRegDate().equals(regDate)).collect(Collectors.toList());
    }

    @Override
    public List<Car> findAll()
    {
        return new ArrayList<>(storage);
    }

    @Override
    public void remove(String id) throws ObjectNotFoundException
    {
        Optional<Car> optionalCar = findById(id);
        if (optionalCar.isPresent())
        {
            storage.remove(optionalCar.get());
        }
        else
        {
            throw new ObjectNotFoundException("Car id (" + id + ") does not exist");
        }
    }
}
