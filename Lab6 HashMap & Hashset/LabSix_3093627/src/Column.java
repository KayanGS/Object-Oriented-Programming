//Student Name: kayan Gemignani
//Student Number: 3093627
//Date: 30/11/2023 11:14 am
//Last Changed: 30/11/2023 16:10 am

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;

public class Column<T, V> {

    private HashMap<T, LinkedHashSet<V>> columnMap;

    // Constructor
    public Column() {
        columnMap = new HashMap<>();
    }

    /**
     * @param field
     * @param value
     */
    public void addValue(T field, V value) {
        columnMap.computeIfAbsent(field, k -> new LinkedHashSet<>()).add(value);
    }

    /**
     * @param field
     * @param value
     */
    public void removeValue(T field, V value) {
        LinkedHashSet<V> values = columnMap.get(field);
        if (values != null) {
            values.remove(value);
        }
    }

    /**
     * @param field
     * @return all values in the column
     */
    public T getField() {
        return columnMap.keySet().stream().findFirst().orElse(null);
    }

    /**
     * @param field
     * @return all values in the column
     */
     public ArrayList<V> getValues() {
        ArrayList<V> allValues = new ArrayList<>();
        columnMap.values().forEach(allValues::addAll);
        return allValues;
    }
}