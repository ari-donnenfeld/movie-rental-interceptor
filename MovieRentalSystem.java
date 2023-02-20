
/*
 *
 * Collaborator: Dispatcher
 * 
 * Responsibility:
 *  - Defines application services
 *  - Integrates dispatchers which allow applications to intercept events
 *  - Delegates events to associated dispatchers
 *
 */


package movie.rental.system;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MovieRentalSystem {


    private static boolean verify(String str) {
        // Verify that the logger has logged
        try {
            File myObj = new File("MovieRentalSystem.log");
            Scanner myReader = new Scanner(myObj);
            String lastLine = "";
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                lastLine = data;
            }
            myReader.close();

            if (lastLine.equals(str)) { return true; }

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }

        return false;

    }

    public static void main(String[] args) {
        System.out.println("Hello there");



        Dispatcher disp = new Dispatcher();
        ConcreteLoggerInterceptor cli = new ConcreteLoggerInterceptor(); 

        disp.attach(cli);

        // Examples emulating what could be a GUI input
        Movie bttf = new Movie("Back to the Future", 0);
        Customer clark = new Customer("Clark");
        Rental rent = new Rental(bttf, 5);
        Context context = new Context(rent, clark);
        clark.addRental(rent);
        System.out.println(clark.statement(disp));


        // Check that the last logged line is correct
        if (verify("Clark - Back to the Future: 1")) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }



    }

}
