package se.lexicon.dreas94;
import se.lexicon.dreas94.exercises.*;
import se.lexicon.dreas94.exercises.Exercise5.Exercise5;
import se.lexicon.dreas94.exercises.Exercise6.car_register;

import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        int choice;
        do
        {
            Scanner sc = new Scanner(System.in);
            do
            {
                choice = -1;
                System.out.println("--------------------------------------------------");
                System.out.print("Pick Exercise to run (1-6), 0 exits the program: ");
                if (sc.hasNextInt())
                {
                    choice = sc.nextInt();
                    if(choice != 0)
                        System.out.println("Running Exercise " + choice);
                    else
                        System.out.println("Exiting Program");
                }
                else {
                    System.out.println("That is not a number between 0-16, TRY AGAIN!");
                    sc.nextLine();
                }
            }
            while (choice == -1);

            System.out.println("--------------------------------------------------");

            boolean completed = false;

            Exercise exercise = null;

            switch(choice)
            {
                case 1:
                    //Completed
                    exercise = new Exercise1();
                    break;
                case 2:
                    //Completed
                    exercise = new Exercise2();
                    break;
                case 3:
                    //Completed
                    exercise = new Exercise3();
                    break;
                case 4:
                    //Completed
                    exercise = new Exercise4();
                    break;
                case 5:
                    //Completed
                    exercise = new Exercise5();
                    break;
                case 6:
                    //Completed
                    exercise = new car_register();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
            }

            if(exercise != null && exercise.runExercise())
                System.out.println("Exercise " + choice + " has finished.");
            else
                System.out.println("Exercise " + choice + " has not been completed. Try again later.");

            System.out.println("Returning to menu!");
        }while(choice != 0);
    }
}

