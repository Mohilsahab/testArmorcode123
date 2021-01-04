package src.sql;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Client {
    public static void main(String[] args) {
//        IDBManager dbManager = DBManager.getInstance();
        IDBManager dbManager = new DBManager();
        List<Column> columns = getColumns();
        dbManager.createTable("table1", columns);

        dbManager.insertRow("table1", getRow(123, "test1"));

        dbManager.insertRow("table1", getRow(456, "test2"));

        List<Row> rows = dbManager.printAllRecords("table1");
        List<Map<Column, Object>> rowMapList = null;
        for (Row rw : rows) {
            rowMapList = rw.rowMapList;
            for (Map<Column, Object> rowMp : rowMapList) {
                System.out.println("----Print Row----");
                for(Map.Entry<Column, Object> mp : rowMp.entrySet()) {
                    Column column = mp.getKey();
                    System.out.print("column name: " + column.key + " ## column Type : "  + column.type);
                    System.out.println(" ## value : " + mp.getValue());
                }
            }
        }



        Map<Column, Object> mp1 = new HashMap<>();
        mp1.put(getColummn("column1", Type.INT_TYPE), 123);
        List<Row> filteredRows = dbManager.displayFilteredRecords("table1", mp1);
        for (Row rw : filteredRows) {
            rowMapList = rw.rowMapList;
            for (Map<Column, Object> rowMp : rowMapList) {
                System.out.println("----Print Row----");
                for(Map.Entry<Column, Object> mp : rowMp.entrySet()) {
                    Column column = mp.getKey();
                    System.out.print("column name: " + column.key + " ## column Type : "  + column.type);
                    System.out.println(" ## value : " + mp.getValue());
                }
            }
        }
    }

    private static Row getRow(int i, String test) {
        Map<Column, Object> rowMap = new HashMap<>();
        rowMap.put(getColummn("column1", Type.INT_TYPE), i);
        rowMap.put(getColummn("column2", Type.STRING_TYPE), test);
        Row row = new Row();
        row.insert(rowMap);
        return row;
    }

    private static List<Column> getColumns() {
        List<Column> columns = new ArrayList<>();
        columns.add(new Column("column1", Type.INT_TYPE));
        columns.add(new Column("column2", Type.STRING_TYPE));
        return columns;
    }

    private static Column getColummn(String name, Type type) {
        return new Column(name, type);
    }
}
