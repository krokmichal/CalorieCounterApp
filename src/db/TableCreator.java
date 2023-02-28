package db;

import classes.Products;

import java.util.ArrayList;

public class TableCreator {
    public static final String CREATE_PRODUCTS =
            "CREATE TABLE IF NOT EXISTS Products " +
                    "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "name varchar(255), " +
                    "kcal INTEGER, " +
                    "protein DOUBLE, " +
                    "carbs DOUBLE, " +
                    "fat DOUBLE);";

    public static void AddSampleProducts() {
        ArrayList<Products> products = new ArrayList<Products>(30);
        products.add(new Products(1, "Masło", 400, 3, 0, 23));
        products.add(new Products(2, "Jajka", 155, 13, 1.1, 11));
        products.add(new Products(3, "Chleb pszenny", 250, 8, 48, 1.5));
        products.add(new Products(4, "Mleko 2% tłuszczu", 51, 3.4, 4.7, 2));
        products.add(new Products(5, "Jogurt naturalny", 63, 3.6, 4.7, 3.2));
        products.add(new Products(6, "Ser żółty", 402, 25, 1.3, 33));
        products.add(new Products(7, "Twaróg", 136, 18, 3, 6));
        products.add(new Products(8, "Kurczak gotowany", 165, 31, 0, 3.6));
        products.add(new Products(9, "Tuńczyk w oleju", 191, 27, 0, 8));
        products.add(new Products(10, "Szynka z piersi kurczaka", 107, 21, 1, 2));
        products.add(new Products(11, "Kasza jaglana", 120, 3, 28, 1.3));
        products.add(new Products(12, "Ryż brązowy", 111, 2.6, 23, 0.9));
        products.add(new Products(13, "Makaron pełnoziarnisty", 131, 7.5, 25, 1.5));
        products.add(new Products(14, "Ciecierzyca", 119, 7, 20, 2));
        products.add(new Products(15, "Soczewica", 115, 9, 20, 0.7));
        products.add(new Products(16, "Fasola", 127, 9, 23, 0.5));
        products.add(new Products(17, "Awokado", 160, 2, 9, 15));
        products.add(new Products(18, "Pomarańcza", 62, 1.2, 15, 0.2));
        products.add(new Products(19, "Jabłko", 52, 0.3, 14, 0.2));
        products.add(new Products(20, "Banan", 89, 1.1, 23, 0.3));
        products.add(new Products(21, "Truskawki", 32, 0.7, 8, 0.3));
        products.add(new Products(22, "Pomidory", 18, 0.9, 3.9, 0.2));
        products.add(new Products(23, "Ogórek", 15, 0.7, 3.6, 0.1));
        products.add(new Products(24, "Sałata lodowa", 14, 0.9, 2.2, 0.2));
        products.add(new Products(25, "Szpinak", 23, 2.9, 1.4, 0.4));
        products.add(new Products(26, "Kalafior", 25, 2, 5, 0.3));
        products.add(new Products(27, "Brokuły", 35, 2.8, 7, 0.4));
        SQLQuery.insertProducts(products);
    }

}

