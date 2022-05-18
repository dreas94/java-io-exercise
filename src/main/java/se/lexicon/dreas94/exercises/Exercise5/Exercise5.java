package se.lexicon.dreas94.exercises.Exercise5;
import se.lexicon.dreas94.exercises.Exercise;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Exercise5 implements Exercise<Void>
{
    @Override
    public boolean runExercise()
    {
        Implementation();
        return true;
    }

    @Override
    public Void Implementation()
    {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("abc123", "Toyota", "fasdf"));
        cars.add(new Car("def456", "Volkswagen", "das_auto"));
        cars.add(new Car("ghi789", "Opel", "dasff"));
        try(FileOutputStream fileOutputStream = new FileOutputStream("src/main/java/se/lexicon/dreas94/exercises/files/ex5.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOutputStream))
        {
            out.writeObject(cars);
        }
        catch (IOException ex){
            ex.printStackTrace();
        }

        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/main/java/se/lexicon/dreas94/exercises/files/ex5.txt")))
        {
            List<Car> deserialized = (List<Car>) in.readObject();

            for(Car car : deserialized)
            {
                System.out.println(car.toString());
            }
        } catch (IOException | ClassNotFoundException e)
        {
            System.err.println(e);
        }

        return null;
    }
}
