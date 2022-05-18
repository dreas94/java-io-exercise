package se.lexicon.dreas94.exercises;

import java.io.*;

public class Exercise4 implements Exercise<Void>
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
        File source = new File("src/main/java/se/lexicon/dreas94/exercises/files/ex4Src.txt");
        File destination = new File("src/main/java/se/lexicon/dreas94/exercises/files/ex4Dest.txt");
        try(BufferedInputStream in = new BufferedInputStream(new FileInputStream(source));
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(destination)))
        {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while((bytesRead = in.read(buffer)) > 0)
            {
                out.write(buffer, 0, bytesRead);
                out.flush();
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
