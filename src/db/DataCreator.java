package db;

import java.sql.SQLException;
import java.sql.Statement;

public class DataCreator {
    private final Statement stat;

    public DataCreator(Statement stat) {
        this.stat = stat;
    }

    public void createTables() {

        try {
            stat.execute(TableCreator.CREATE_PRODUCTS);
            if (SQLQuery.isTableEmpty()) {
                TableCreator.AddSampleProducts();
            }
        } catch (SQLException e) {
            System.err.println("Bląd przy tworzeniu tabel");
            e.printStackTrace();
        }
    }
}


