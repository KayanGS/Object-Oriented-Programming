//Student Name: kayan Gemignani
//Student Number: 3093627
//Date: 30/11/2023 15:02 pm
//Last Changed: 30/11/2023 16:49 pm

import java.util.Arrays;
import java.util.Iterator;

public class Test {

    private static String ANSI_YELLOW = "\u001B[33m";
    private static String ANSI_BLUE = "\u001B[34m";
    private static String ANSI_RESET = "\u001B[0m";
    private static String ANSI_GREEN = "\u001B[32m";
    public static void main(String[] args) {

        // Table with Integer field and String values
        Table<Integer, String> table1 = new Table<>();
        table1.addColumn(1, Arrays.asList("Value1", "Value2"));
        table1.addColumn(2, Arrays.asList("Value3", "Value4"));

        //Print the first version of the table
        printTable(table1.iterator(),   ANSI_RESET 
                                        + "First table version:"     
                                        + ANSI_YELLOW 
                                        + "\nTable 1:");

        // Table with String field and Integer values
        Table<String, Integer> table2 = new Table<>();
        table2.addColumn("A", Arrays.asList(10, 20));
        table2.addColumn("B", Arrays.asList(30, 40));

        System.out.println(ANSI_YELLOW + "\nTable 2:");
        printTable(table2.iterator(), ANSI_YELLOW + "Table 2:");

        // Test adding values
        table1.addValue(1, "Value5");
        table2.addValue("A", 50);

        
        //Print the second version of the table where values have been added
        printTable(table1.iterator(), ANSI_RESET 
                                    + "\nTable version after adding values:"     
                                    + ANSI_YELLOW 
                                    + "\nTable 1: \n" 
                                    + ANSI_GREEN
                                    + "Value5 should be added to the Field "
                                    + "1");

        printTable(table2.iterator(), ANSI_YELLOW 
                                    + "\nTable 2:\n" 
                                    + ANSI_GREEN
                                    + "50 should be added to the Field 1");

        // Test removing values
        table1.removeValue(2, "Value4");
        table2.removeValue("B", 40);
        
        //Print the third version of the table where values have been removed
        printTable(table1.iterator(), ANSI_RESET 
                                    + "\nTable version after removing values:"     
                                    + ANSI_YELLOW 
                                    + "\nTable 1: \n" 
                                    + ANSI_GREEN
                                    + "Value4 should be removed from the Field "
                                    + "2");

        printTable(table2.iterator(), ANSI_YELLOW 
                                    + "\nTable 2:\n" 
                                    + ANSI_GREEN
                                    + "40 should be removed from the Field B");

        //testing addColumn method
        table1.addColumn(3, Arrays.asList("Value6", "Value7"));
        table2.addColumn("A", Arrays.asList(60, 70));

        //Print the fourth version of the table where columns have been added
        //In table 1 it should create a new field with the values
        printTable(table1.iterator(), ANSI_RESET 
                                    + "\nTable version after adding columns:"     
                                    + ANSI_YELLOW 
                                    + "\nTable 1: \n" 
                                    + ANSI_GREEN
                                    + "Field 3 should be added with the values "
                                    + "Value6 and Value7");

        // In table 2 it should add the values to the existing field
        printTable(table2.iterator(), ANSI_YELLOW 
                                    + "\nTable 2:\n" 
                                    + ANSI_GREEN
                                    + "60 and 70 should be added to Field A");

        //testing getAllFields method
        System.out.println( ANSI_RESET 
                            + "\nTesting getAllFields method:");
        System.out.println( ANSI_YELLOW
                            + "Table 1:"
                            + ANSI_GREEN
                            + "\nShould return the fields 1, 2 and 3");
        System.out.println(ANSI_BLUE + table1.getAllFields());

        System.out.println( ANSI_YELLOW
                            + "\nTable 2:"
                            + ANSI_GREEN
                            + "\nShould return the fields A and B");
        System.out.println(ANSI_BLUE + table2.getAllFields());

        //testing getValues method that returns the values of a given field
        System.out.println( ANSI_RESET 
                            + "\nTesting getValues method:");
        System.out.println( ANSI_YELLOW
                            + "Table 1:"
                            + ANSI_GREEN
                            + "\nShould return the values of the field 1");
        System.out.println(ANSI_BLUE + table1.getValues(1));

        System.out.println( ANSI_YELLOW
                            + "\nTable 2:"
                            + ANSI_GREEN
                            + "\nShould return the values of the field A");
        System.out.println(ANSI_BLUE + table2.getValues("A"));

        //testing getAllValues method that returns all the values of the table
        System.out.println( ANSI_RESET 
                            + "\nTesting getAllValues method:");
        System.out.println( ANSI_YELLOW
                            + "Table 1:"
                            + ANSI_GREEN
                            + "\nShould return all the values of the table");  
        System.out.println(ANSI_BLUE + table1.getAllValues());

        System.out.println( ANSI_YELLOW
                            + "\nTable 2:"
                            + ANSI_GREEN
                            + "\nShould return all the values of the table");
        System.out.println(ANSI_BLUE + table2.getAllValues());
    }

    /**
     * @param tableIterator
     * @param message
     */
    private static <T, V> void printTable(Iterator<Column<T, V>> tableIterator, 
                                          String message) 
    {
        System.out.println(ANSI_YELLOW + message);
        while (tableIterator.hasNext()) {
            Column<T, V> column = tableIterator.next();
            System.out.println( ANSI_YELLOW 
                                + "Field: " 
                                + ANSI_BLUE 
                                + column.getField() 
                                + ANSI_YELLOW 
                                + ", Values: " 
                                + ANSI_BLUE 
                                + column.getValues());
        }
    }
    
}
