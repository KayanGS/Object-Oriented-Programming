package exceptions;
public class NegativePriceException extends Exception {
    
    /**
     * @param message
     */
    public NegativePriceException(String message) {
        super(message);
    }
}