package src.lld.sql;

import java.util.List;
import java.util.Map;

public interface IDBManager {
    void createTable(String table1, List<Column> columns);


    void insertRow(String table1, Row row);

    List<Row> printAllRecords(String table1);

    List<Row> displayFilteredRecords(String tableName, Map<Column, Object> columns);
}
