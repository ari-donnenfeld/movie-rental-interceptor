/*
 *
 * Concrete Logger Interceptor
 *
 * Collaborator: Context Object
 * 
 * Responsibility:
 *  - Implements a specific out of band service
 *  - Uses context object to control the concrete framework
 *
 * This is the one that does the thing. In this case, a logger.
 *
 */


package movie.rental.system;

import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;


public class ConcreteLoggerInterceptor implements LoggerInterceptor {

    public void interceptFrequentRenterPoints(Context context) {
        String mov = context.getMovie();
        String cust = context.getCustomer();
        int frp = context.IFRP();
        String fileName = "MovieRentalSystem.log";
        System.out.println("Logging things..."); 
        System.out.println(mov); 
        System.out.println(cust); 



        // Get date and time for logging purpose
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        System.out.println(dtf.format(now));



        try {
            FileWriter fw = new FileWriter(fileName, true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("New log - ");
            bw.write(dtf.format(now));
            bw.newLine();
            bw.write(cust);
            bw.write(" - ");
            bw.write(mov);
            bw.write(": " + frp);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.out.println("We are experiencing some technical dificulties...");
        }
    }

}



