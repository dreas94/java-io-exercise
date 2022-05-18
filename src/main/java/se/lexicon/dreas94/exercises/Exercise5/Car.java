package se.lexicon.dreas94.exercises.Exercise5;

import java.io.Serializable;
import java.util.Objects;

public class Car implements Serializable
{
    private String regNumber;
    private String brand;
    private String model;

    public Car(String regNumber, String brand, String model)
    {
        setRegNumber(regNumber);

        this.model = model;
    }

    public String getRegNumber()
    {
        return regNumber;
    }

    public void setRegNumber(String regNumber)
    {
        if(regNumber == null || regNumber.isEmpty()) throw new IllegalArgumentException("RegNumber is not valid");
        this.regNumber = regNumber;
    }

    public String getBrand()
    {
        return brand;
    }

    public void setBrand(String brand)
    {
        if(brand == null || brand.isEmpty()) throw new IllegalArgumentException("Brand is not valid");
        this.brand = brand;
    }

    public String getModel()
    {
        return model;
    }

    public void setModel(String model)
    {
        if(model == null || model.isEmpty()) throw new IllegalArgumentException("Model is not valid");
        this.model = model;
    }

    @Override
    public String toString()
    {
        return "Car{" +
                "regNumber='" + regNumber + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return getRegNumber().equals(car.getRegNumber()) && getBrand().equals(car.getBrand()) && getModel().equals(car.getModel());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getRegNumber(), getBrand(), getModel());
    }
}
