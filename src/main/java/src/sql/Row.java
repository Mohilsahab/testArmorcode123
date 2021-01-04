package src.sql;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Row {
    List<Map<Column, Object>> rowMapList;

    Row() {
        rowMapList = new ArrayList<>();
    }

    List<Map<Column, Object>> insert(Map<Column, Object> row) {
        rowMapList.add(row);
        return rowMapList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Row)) return false;
        Row row = (Row) o;
        return Objects.equals(rowMapList, row.rowMapList);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}