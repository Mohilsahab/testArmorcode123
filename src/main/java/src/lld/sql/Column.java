package src.lld.sql;

public class Column {
    String key;
    Type type;

    Column(String name, Type type) {
        this.key = name;
        this.type  = type;
    }
}
