package se.lexicon.dreas94.exercises.Exercise6;

import se.lexicon.dreas94.exercises.Exercise;
import se.lexicon.dreas94.exercises.Exercise6.dao.CarDAO;
import se.lexicon.dreas94.exercises.Exercise6.dao.OwnerDAO;
import se.lexicon.dreas94.exercises.Exercise6.dao.impl.CarDAOImpl;
import se.lexicon.dreas94.exercises.Exercise6.dao.impl.OwnerDAOImpl;
import se.lexicon.dreas94.exercises.Exercise6.exception.ObjectNotFoundException;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class car_register implements Exercise<Void>
{
    static Scanner scanner = new Scanner(System.in);
    static CarDAO carDAO = new CarDAOImpl();
    static OwnerDAO ownerDAO = new OwnerDAOImpl();
    @Override
    public boolean runExercise()
    {
        boolean done = false;

        JsonIO jsonManager = new JsonIO();

        List<Car> carTemp = new ArrayList<>(jsonManager.deserializeFromJson(new File("src/main/java/se/lexicon/dreas94/exercises/files/car.json"), Car.class));
        List<Owner> ownerTemp = jsonManager.deserializeFromJson(new File("src/main/java/se/lexicon/dreas94/exercises/files/owner.json"), Owner.class);

        for(Car car: carTemp)
        {
            Optional<Car> existingCars = carDAO.findById(car.getCarId());
            if(!existingCars.isPresent())
                carDAO.create(car);
        }

        for(Owner owner: ownerTemp)
        {
            Optional<Owner> existingOwner = ownerDAO.findById(owner.getOwnerId());
            if(!existingOwner.isPresent())
                ownerDAO.create(owner);
        }

        while (!done)
        {
            System.out.println("#################");
            System.out.println("1. Create #######");
            System.out.println("2. Find All #####");
            System.out.println("3. Find By Id ###");
            System.out.println("4. Delete By Id #");
            System.out.println("5. Exit #########");
            System.out.println("#################");

            System.out.println("Enter a valid operation:");
            String operationType = scanner.next();

            switch (operationType) {
                case "1":
                    // business logic for creating a shipment
                    create();
                    break;
                case "2":
                    findAll();
                    break;
                case "3":
                    find();
                    break;
                case "4":
                    delete();
                    break;
                case "5":
                    File carFile = new File("src/main/java/se/lexicon/dreas94/exercises/files/car.json");
                    carFile.delete();
                    jsonManager.serializeToJson(carDAO.findAll(), carFile);
                    File ownerFile = new File("src/main/java/se/lexicon/dreas94/exercises/files/owner.json");
                    ownerFile.delete();
                    jsonManager.serializeToJson(ownerDAO.findAll(), ownerFile);
                    done = true;
                    break;
                default:
                    System.out.println("Operation is not valid");
            }
        }
        return true;
    }

    public static void findAll() {
        List<Car> carList = carDAO.findAll();
        System.out.println("------------");
        for(Car car : carList)
        {
            System.out.println(car.toString());
        }
        System.out.println("------------");
    }

    public static void create() {
        Owner consoleDataForOwner = getOwnerData();

        ownerDAO.create(consoleDataForOwner);

        Car consoleDataForCar = getCarData(consoleDataForOwner);

        carDAO.create(consoleDataForCar);

        System.out.println("Operation is Done!");
        System.out.println("Car Information: " + consoleDataForCar.toString());
        System.out.println("Owner Information: " + consoleDataForOwner.toString());
    }

    public static void find() {
        System.out.println("Enter Car id:");
        String boxId = scanner.next();
        Optional<Car> optionalCar = carDAO.findById(boxId);
        if (optionalCar.isPresent())
        {
            System.out.println(optionalCar.get());
        }
        else
        {
            System.out.println("id is not valid");
        }
    }

    public static void delete()
    {
        System.out.println("Enter car id:");
        try
        {
            carDAO.remove(scanner.next());
        }
        catch (ObjectNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static Owner getOwnerData()
    {
        Owner owner = new Owner();

        System.out.println("Owner Information:");
        while (true)
        {
            System.out.println("What is the owners name?");
            String name = scanner.next();
            try
            {
                owner.setName(name);
                break;
            }
            catch (IllegalArgumentException e)
            {
                System.out.println(e.getMessage());
            }
        }


        while (true) {
            System.out.println("What is the owners date of birth, answer in yyyy-mm-dd:");
            LocalDate birthday = LocalDate.parse(scanner.next());
            try
            {
                owner.setBirthdate(birthday);
                break;
            }
            catch (IllegalArgumentException e)
            {
                System.out.println(e.getMessage());
            }
        }

        return owner;
    }

    public static Car getCarData(Owner owner)
    {
        Car car = new Car();

        System.out.println("Car Information:");
        while (true)
        {
            System.out.println("What Reg Number does the car have");
            String regNumber = scanner.next();
            try
            {
                car.setRegNumber(regNumber);
                break;
            }
            catch (IllegalArgumentException e)
            {
                System.out.println(e.getMessage());
            }
        }


        while (true)
        {
            System.out.println("What brand is the car?");
            String brand = scanner.next();
            try
            {
                car.setBrand(brand);
                break;
            }
            catch (IllegalArgumentException e)
            {
                System.out.println(e.getMessage());
            }
        }


        while (true)
        {
            System.out.println("What model is the car?");
            String brand = scanner.next();
            try
            {
                car.setBrand(brand);
                break;
            }
            catch (IllegalArgumentException e)
            {
                System.out.println(e.getMessage());
            }
        }

        car.setOwner(owner);

        return car;
    }

    @Override
    public Void Implementation()
    {
        return null;
    }
}
