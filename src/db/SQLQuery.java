package db;

import classes.Products;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SQLQuery {

    public static boolean isTableEmpty() {
        String query = "SELECT COUNT(*) AS count FROM Products;";
        try {
            ResultSet result = DataBaseConnection.stat.executeQuery(query);
            if (result.next()) {
                int count = result.getInt("count");
                return count == 0;
            }
        } catch (SQLException e) {
            System.err.println("Błąd podczas sprawdzania ilości produktów w bazie danych");
            e.printStackTrace();
        }
        return false;
    }

    public static void insertProducts(Products product) {
        String query = "INSERT INTO Products " +
                "VALUES (NULL, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement prepStmt = DataBaseConnection.conn.prepareStatement(query);

            prepStmt.setString(2, product.getName());
            prepStmt.setInt(3, product.getKcal());
            prepStmt.setDouble(4, product.getProtein());
            prepStmt.setDouble(5, product.getCarbs());
            prepStmt.setDouble(6, product.getFat());

            prepStmt.execute();

        } catch (SQLException e) {
            System.err.println("Blad przy wstawianiu produktu");
            e.printStackTrace();
        }
    }

    public static void insertProducts(ArrayList<Products> products) {

        if (products.isEmpty())
            return;

        String query = "INSERT INTO Products " +
                "VALUES (NULL, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement prepStmt = DataBaseConnection.conn.prepareStatement(query);

            for (Products product : products) {
                prepStmt.setString(1, product.getName());
                prepStmt.setInt(2, product.getKcal());
                prepStmt.setDouble(3, product.getProtein());
                prepStmt.setDouble(4, product.getCarbs());
                prepStmt.setDouble(5, product.getFat());
                prepStmt.addBatch();
            }

            prepStmt.executeBatch();

        } catch (SQLException e) {
            System.err.println("Blad przy wstawianiu kilku produktów");
            e.printStackTrace();
        }
    }

    public static ArrayList<Products> getAllProducts() {

        String query = "SELECT * " +
                "FROM Products";
        int id;
        String name;
        int kcal;
        double protein, carbs, fat;
        ArrayList<Products> products = new ArrayList<Products>();

        try {
            ResultSet result = DataBaseConnection.stat.executeQuery(query);
            while (result.next()) {
                id = result.getInt("id");
                name = result.getString("name");
                kcal = result.getInt("kcal");
                protein = result.getDouble("protein");
                carbs = result.getDouble("carbs");
                fat = result.getDouble("fat");
                products.add(new Products(id, name, kcal, protein, carbs, fat));
            }
        } catch (SQLException e) {
            System.err.println("Blad przy pobieraniu kategorii");
            e.printStackTrace();
            return null;
        }
        return products;
    }
}
