package src.sql;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataBase implements IDatabase{

    static Map<String, Table> tables;
    DataBase() {
        tables = new HashMap<>();
    }

    @Override
    public int createTable(String name, List<Column> columns) {
        if (tables.containsKey(name)) {
            return 0;
        }
        tables.put(name, new Table(columns));
        return 1;
    }

    @Override
    public int deleteTable(String name) {
        if (tables.containsKey(name)) {
            tables.remove(name);
            return 1;
        }
        return 0;
    }

    @Override
    public int insertRecords(String tableName, Row row) {
        Table table = tables.get(tableName);
        if (table != null) {
            table.addRow(row);
            return 1;
        }
        return 0;
    }

    @Override
    public List<Row> printAllRecords(String tableName) {
        Table table = tables.get(tableName);
        if (table != null) {
            return table.getRows();
        }
        return null;
    }

    @Override
    public List<Row> displayFilteredRecords(String tableName, Map<Column, Object> filter) {
        Table table = tables.get(tableName);
        List<Row> rows = table.getRows();
        List<Row> result = new ArrayList<>();
        List<Map<Column, Object>> rowMapList;
        boolean flag;
        for (Row row : rows) {
            flag = true;
            rowMapList = row.rowMapList;
            for (Map<Column, Object> column : rowMapList) {
                if (!column.equals(filter)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result.add(row);
            }
        }
        return result;
    }
}
