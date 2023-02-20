/*
 * Interceptor
 *
 * Responsibility:
 *  - Defines an interface for out of band services
 *
 */


package movie.rental.system;

interface LoggerInterceptor {
    public void interceptFrequentRenterPoints(Context context);
}
