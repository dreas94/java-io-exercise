package se.lexicon.dreas94.exercises.Exercise6;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class Car implements Serializable
{
    private final String carId;
    private String regNumber;
    private String brand;
    private String model;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    final private LocalDate regDate;

    private Owner owner;

    public Car()
    {
        this.carId = UUID.randomUUID().toString();
        this.regDate = LocalDate.now();
    }

    public Car(String regNumber, String brand, String model, LocalDate regDate, Owner owner)
    {
        this();
        setRegNumber(regNumber);
        setBrand(brand);
        setModel(model);
        setOwner(owner);
    }

    public String getCarId()
    {
        return carId;
    }

    public String getRegNumber()
    {
        return regNumber;
    }

    public void setRegNumber(String regNumber)
    {
        this.regNumber = regNumber;
    }

    public String getBrand()
    {
        return brand;
    }

    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    public String getModel()
    {
        return model;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    public LocalDate getRegDate()
    {
        return regDate;
    }

    public Owner getOwner()
    {
        return owner;
    }

    public void setOwner(Owner owner)
    {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return getCarId().equals(car.getCarId()) && getRegNumber().equals(car.getRegNumber()) && getBrand().equals(car.getBrand()) && getModel().equals(car.getModel()) && getRegDate().equals(car.getRegDate()) && getOwner().equals(car.getOwner());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getCarId(), getRegNumber(), getBrand(), getModel(), getRegDate(), getOwner());
    }
}
