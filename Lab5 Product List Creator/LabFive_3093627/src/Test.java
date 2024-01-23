import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import exceptions.NegativePriceException;
import exceptions.NullEmptyTitleException;

public class Test {

    public static void main(String[] args)
            throws NullEmptyTitleException, 
            NegativePriceException, 
            CloneNotSupportedException, 
            IOException     
        {

        List<Product> order = new ArrayList<Product>(5);
        //Create products    
        Product product1 = new Product(1, "Product 1", 10.0);
        Product product2 = new Product(2, "Product 2", 20.0);
        Product product3 = new Product(3, "Product 3", 30.0);
        Product product4 = new Product(4, "Product 4", 30.0);
        
        //Add products to the ArrayList order
        order.add(product1);
        order.add(product2);
        order.add(product3);
        order.add(product4);    

        //Asserts for the equals method
        assert !product1.equals(product2) 
           : "Objects with different codes should not be equal";
        assert product1.hashCode() != product2.hashCode()
            : "Hash codes for objects with different codes should be different";

        //Clone of product1   
        Product cloneProduct1 = new Product(product1);

        //Asserts for the equals method
        assert product1.equals(cloneProduct1) 
                : "Objects with the same code should be equal";
        assert product1.hashCode() == cloneProduct1.hashCode()
                : "Hash codes for objects with the same code should be equal";

        //Add cloneProduct1 to the ArrayList order       
        order.add(cloneProduct1);

        //Print the products
        for (Product product : order) {
            System.out.println(product);
        }

        //Sort the products by code
        Collections.sort(order, Comparator.comparingInt(Product::getCode));
        //Write the products to the file order.txt
        writeProductsToFile(order, "order.txt");

        //Sort the products by price and title 
        Collections.sort(order, Comparator.comparing(Product::getPrice)
                .thenComparing(Product::getTitle));
        //Create a condensed order
        List<Product> condensedOrder = getCondensedOrder(order);
        //Write the condensed order to the file OrderCondensed.txt
        writeProductsToCondensedFile(condensedOrder, "OrderCondensed.txt");
    }

    /**
     * @param products
     * @param filename
     * @throws IOException
     */
    private static void writeProductsToFile
                (List<Product> products, String filename) throws IOException {
            
            //Try write the products to the file
            try (BufferedWriter writer = 
                                new BufferedWriter(new FileWriter(filename))) {
                                   
            for (Product product : products) {
                writer.write(product.getCode() + 
                                ", " + 
                                product.getTitle() + 
                                ", " + 
                                product.getPrice());
                //Write a new line
                writer.newLine();
            }
        }
    }

    /**
     * @param order
     * @return condensedOrder
     */
    private static List<Product> getCondensedOrder(List<Product> order) {
        //Create a new ArrayList
        List<Product> condensedOrder = new ArrayList<>();
        //Iterate over the order
        for (Product product : order) {
            int index = condensedOrder.indexOf(product);
            //If the product is already in the condensedOrder
            if (index != -1) {
                //Get the product by index
                Product existingProduct = condensedOrder.get(index);
                //Increment the amount
                existingProduct.incrementAmount();
            //If the product is not in the condensedOrder
            } else {
                //Create a new product
                Product newProduct = new Product(product);
                //Set the amount to 1
                newProduct.setAmount(1);
                //Add the new product to the condensedOrder
                condensedOrder.add(newProduct);
            }
        }
        return condensedOrder; //################## RETURN ####################
    }
    
    /**
     * @param products
     * @param filename
     * @throws IOException
     */
    private static void writeProductsToCondensedFile
                (List<Product> products, String filename) throws IOException 
    {
        
        try (BufferedWriter writer = 
                            new BufferedWriter(new FileWriter(filename))) 
        {
            
            for (Product product : products) {
                writer.write(product.getCode() + 
                                ", " + 
                                product.getTitle() + 
                                ", " + 
                                product.getPrice() + 
                                ", " + 
                                product.getAmount());
                                
                writer.newLine();
            }
        }
    }
}
