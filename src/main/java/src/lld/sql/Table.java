package src.lld.sql;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Table {
    static List<Column> columns;
    static List<Row> rows;

    Table(List<Column> columns) {
        this.columns = new ArrayList<>(columns);
        rows = new ArrayList<>();
    }

    int addRow(Row row) {
        rows.add(row);
        return 1;
    }

    List<Row> getRows() {
        return this.rows;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Table)) return false;
        Table table = (Table) o;
        return Objects.equals(columns, table.columns) &&
                Objects.equals(rows, table.rows);
    }

    @Override
    public int hashCode() {
        return Objects.hash(columns, rows);
    }
}
