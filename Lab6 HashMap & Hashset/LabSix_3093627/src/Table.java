//Student Name: kayan Gemignani
//Student Number: 3093627
//Date: 30/11/2023 11:44 am
//Last Changed: 30/11/2023 16:09 pm

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Table<T, V> implements Iterable<Column<T, V>> {
    private List<Column<T, V>> columns;

    // Constructor
    public Table() {
        columns = new ArrayList<>();
    }

    /**
     * @param field
     * @param values
     */
    public void addColumn(T field, List<V> values) {
        // Check if column already exists
        boolean columnExists = false;

        // Loop through all columns
        for (Column<T, V> column : columns) {
            // If column exists, add values to it and exit the method
            if (Objects.equals(column.getField(), field)) {
                // Add all values to the column
                for (V value : values) {
                    column.addValue(field, value);
                }
                columnExists = true;
                break; //##################### BREAK #######################
            }
        }

        // If column doesn't exist, create a new one
        if (!columnExists) {
            Column<T, V> newColumn = new Column<>();
            for (V value : values) {
                newColumn.addValue(field, value);
            }
            columns.add(newColumn);
        }
    }

    /**
     * @param field 
     * removes a column from the table based on the field
     */
    public void removeColumn(T field) {
        columns.removeIf(column -> Objects.equals(column.getField(), field));
    }

    /**
     * @param field
     * @return all fields in the table
     */
    public List<T> getAllFields() {
        List<T> fieldList = new ArrayList<>();
        for (Column<T, V> column : columns) {
            fieldList.add(column.getField());
        }
        return fieldList; //##################### RETURN ####################
    }

    /**
     * @param field 
     * @param value
     * adds a value to the table based on the field
     */
    public void addValue(T field, V value) {
        for (Column<T, V> column : columns) {
            if (Objects.equals(column.getField(), field)) {
                column.addValue(field, value);
            }
        }
    }

    /**
     * @param field
     * @param value
     * removes a value from the table based on the field
     */
    public void removeValue(T field, V value) {
        for (Column<T, V> column : columns) {
            if (Objects.equals(column.getField(), field)) {
                column.removeValue(field, value);
            }
        }
    }
    
    /**
     * @param field
     * @return all values in the table based on the field
     */
    public List<V> getValues(T field) {
        for (Column<T, V> column : columns) {
            if (Objects.equals(column.getField(), field)) {
                return column.getValues(); //############# RETURN ############
            }
        }
        // Return an empty list if field not found
        return new ArrayList<>(); //################ RETURN #################
    }

    /**
     * @return all values in the table
     */
    public List<V> getAllValues() {
        List<V> allValues = new ArrayList<>();
        for (Column<T, V> column : columns) {
            allValues.addAll(column.getValues());
        }
        return allValues; //##################### RETURN ####################
    }

    /**
     * @return the number of columns in the table
     */
    @Override
    public Iterator<Column<T, V>> iterator() {
        return columns.iterator(); //################ RETURN #################
    }

}