package src.sql;

import java.util.List;
import java.util.Map;

public class DBManager implements IDBManager{

    private static IDBManager dbManager;

    private IDatabase database;

    DBManager() {
        database = new DataBase();
    }

    public static IDBManager getInstance() {
        if (dbManager == null) {
            dbManager = new DBManager();
        }
        return dbManager;
    }

    @Override
    public void createTable(String table1, List<Column> columns) {
        database.createTable(table1,  columns);
    }

    @Override
    public void insertRow(String table1, Row row) {
        database.insertRecords(table1, row);
    }

    @Override
    public List<Row> printAllRecords(String table1) {
        return database.printAllRecords(table1);
    }

    @Override
    public List<Row> displayFilteredRecords(String tableName, Map<Column, Object> columns) {
        return database.displayFilteredRecords(tableName, columns);
    }
}
