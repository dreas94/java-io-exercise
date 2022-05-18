package se.lexicon.dreas94.exercises;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Exercise2 implements Exercise <List<String>>
{
    @Override
    public boolean runExercise()
    {
        System.out.println(Implementation().toString());
        return true;
    }

    @Override
    public List<String> Implementation()
    {
        List<String> strings = new ArrayList<>();
        File source = new File("src/main/java/se/lexicon/dreas94/exercises/files/ex2.txt");
        try(BufferedReader reader = new BufferedReader(new FileReader(source)))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                strings.add(line);
            }
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(IOException io)
        {
            io.printStackTrace();
        }
        return strings;
    }
}
