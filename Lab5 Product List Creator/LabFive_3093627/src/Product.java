import exceptions.NegativePriceException;
import exceptions.NullEmptyTitleException;

public class Product implements Comparable<Product>{
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    
    private int code;
    private String title;
    private double price;
    private static int lastCode = 0;   
    private int amount;

    /**
     * @param code
     * @param title
     * @param price
     * Constructor
     */
    public Product(int code, String title, double price) throws NullEmptyTitleException, NegativePriceException {
        if (title == null || title.isEmpty()) {
            throw new NullEmptyTitleException("Title cannot be null or empty");
        }
        if (price < 0) {
            throw new NegativePriceException("Price cannot be negative");
        }
        this.code = ++lastCode;
        this.title = title;
        this.price = price;
    }

    /**
     * @param otherProduct
     * Copy Constructor
     */
    public Product(Product otherProduct) {
        this.code = otherProduct.code;
        this.title = otherProduct.title;
        this.price = otherProduct.price;
    }
    /**
     * @return code
     */
    public int getCode() {
        return code; //####################### RETURN #########################
    }

    /**
     * @return title
     */
    public String getTitle() {
        return title; //####################### RETURN #########################
    }

    /**
     * @return price
     */
    public double getPrice() {
        return price; //####################### RETURN #########################
    }

    /**
     * @param title
     */
    public void setTitle(String title) throws NullEmptyTitleException{
        if(title == null || title.isEmpty()){
            throw new NullEmptyTitleException("Title cannot be null or empty");
        }
        this.title = title; 
    }

    /**
     * @param price
     */
    public void setPrice(double price) throws NegativePriceException{
        if (price > 0){
            throw new NegativePriceException("Price cannot be negative");
        }
        this.price = price; 
    }

    @Override
    /**
     * @param object
     * @return boolean
     */
    public boolean equals(Object object){
        if (object == null){
            return false; //################### RETURN #####################
        }
        if (object instanceof Product){
            Product product = (Product) object;
            return this.code == product.code; //######### RETURN ###########
        }
        return false; //#################### RETURN #######################
    }

    @Override
    /**
     * @return hashCode
     */
    public int hashCode(){
        return this.code; //################# RETURN #######################
    }

    @Override
    /**
     * @param product
     * @return int
     */
    public int compareTo(Product product) {
        return this.title.compareTo(product.title); //######## RETURN #########
    }

    /**
     * @return amount
     */
    public int getAmount() {
        return amount;
    }

    /**
     * @param amount
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void incrementAmount() {
        this.amount++;
    }

    @Override
    /**
     * @return toString
     */
    public String toString() {
        return ANSI_YELLOW + //############### RETURN #################
                "Product [code=" + 
                ANSI_BLUE +
                code + 
                ANSI_YELLOW +
                ", price=" + 
                ANSI_BLUE +
                price + 
                ANSI_YELLOW +
                ", title=" + 
                ANSI_BLUE +
                title + 
                ANSI_YELLOW +
                "]";
    }
}
