package se.lexicon.dreas94.exercises;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Exercise3 implements Exercise <Void>
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
        Exercise2 ex2 = new Exercise2();

        List<String> source = new ArrayList<String>(ex2.Implementation());

        File destination = new File("src/main/java/se/lexicon/dreas94/exercises/files/ex3.txt");


        if (destination.length() != 0)
            destination.delete();


        try (BufferedWriter writer = new BufferedWriter(new FileWriter(destination))) {
            for (String toWrite : source) {
                writer.write(toWrite);
                writer.newLine();
            }
            writer.flush();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException io)
        {
            io.printStackTrace();
        }
        return null;
    }
}
