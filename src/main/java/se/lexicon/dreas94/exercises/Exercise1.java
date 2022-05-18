package se.lexicon.dreas94.exercises;
import se.lexicon.dreas94.exercises.Exercise;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Exercise1 implements Exercise <String>
{
    @Override
    public boolean runExercise()
    {
        System.out.println(Implementation());
        return true;
    }
    @Override
    public String Implementation()
    {
        String result = "";
        try(FileReader fileReader = new FileReader("src/main/java/se/lexicon/dreas94/exercises/files/ex1.txt"))
        {
            char[] a = new char[500];
            fileReader.read(a);
            result = String.valueOf(a);
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(IOException io)
        {
            io.printStackTrace();
        }

        return result;
    }
}
