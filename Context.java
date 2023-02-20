/*
 *
 * Context Object
 *
 * 
 * Collaborator: Concrete Framework
 *
 * Responsibility:
 *  - Allows services to obtain state information from the concrete framework
 *  - Allows services to control certain behaviours in the concrete framework
 *
 */

package movie.rental.system;


public class Context {

    private Rental rental;
    private Customer customer;

    public Context(Rental rent, Customer cust) {
        rental = rent;
        customer = cust;
    }

    public String getMovie() {
        return rental.getMovie().getTitle();
    }

    public String getCustomer () {
        return customer.getName();
    }

    public int IFRP () {
         return customer.getTotalFrequentRenterPoints();
    }


}





