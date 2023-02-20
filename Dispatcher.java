/*
 *
 *
 * Collaborator: interceptor, Application
 *
 * Responsibility:
 *  - Allows applications to register and remove concrete interceptors 
 *  - Dispatches registered concrete interceptor callbacks when events occur
 *
 */

package movie.rental.system;
import java.util.ArrayList;


public class Dispatcher {
    
    // List of interceptors
    private ArrayList<ConcreteLoggerInterceptor> clis = new ArrayList<ConcreteLoggerInterceptor>();
    
    
    public void attach(ConcreteLoggerInterceptor cli) {
        clis.add(cli);
    }

    public void detach(ConcreteLoggerInterceptor cli) {
        // clis.remove(Integer.valueOf(cli));
        clis.remove(cli);
    }

    // Itterate List
    public void notify(Context context) {
        for (ConcreteLoggerInterceptor cli : clis) {
            cli.interceptFrequentRenterPoints(context); 
        }

    }

    public void IFRP(Context context) {
        // useless function for readability
        notify(context);
    }

}
