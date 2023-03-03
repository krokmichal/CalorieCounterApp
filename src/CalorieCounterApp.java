import classes.ListOfProducts;
import classes.MacroElements;
import classes.Products;
import classes.SelectedProduct;
import db.DataBaseConnection;
import db.SQLQuery;
import java.util.ArrayList;
import java.util.Scanner;

public class CalorieCounterApp {
    static DataBaseConnection manager = new DataBaseConnection();

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        ListOfProducts allFood = new ListOfProducts(SQLQuery.getAllProducts());
        ArrayList<SelectedProduct> foodEaten = new ArrayList<SelectedProduct>();
        MacroElements actualMacro = new MacroElements();
        int choice = 0;

        for (; ; ) {
            System.out.println("1. Dodaj produkt, który spożyłeś");
            System.out.println("2. Sprawdź produkty jakie spożyłeś");
            System.out.println("3. Sprawdź kalorie i makroskładniki jakie spożyłeś");
            System.out.println("4. Sprawdź kalorie i makroskładniki produktów");
            System.out.println("5. Oblicz swoje dzienne zapotrzebowanie kaloryczne");
            System.out.println("0. Wyjdź z programu");

            choice = scan.nextInt();


            switch (choice) {
                case 0:
                    break;
                case 1:
                    System.out.println("Produkty do wyboru: ");
                    for (Products product : allFood.getListOfProducts()) {
                        System.out.println(" - " + product.getId() + ". " + product.getName());
                    }
                    Products selectedProduct = allFood.findProduct(scan.nextInt());
                    System.out.println("Wybrany produkt to "+selectedProduct.getName());
                    System.out.print("Podaj ilość spożytego produktu spożywczego (w gramach): ");
                    foodEaten.add(new SelectedProduct(selectedProduct, scan.nextInt()));
                    actualMacro.calculateMacro(foodEaten);
                    actualMacro.getMacro();
                    break;
                case 2:
                    System.out.println("Oto lista produktów, które już spożyłeś: \n");
                    for (SelectedProduct selected : foodEaten)
                    {
                        System.out.println("Nazwa: " + selected.getProduct().getName());
                    }
                    System.out.println("\n");
                    break;
                case 3:
                    System.out.println("Oto kalorie i makroskładniki jakie już spożyłeś: \n");
                    actualMacro.getFinalMacro();
                    break;
                case 4:
                    System.out.println("Lista wszystkich produktów i ich makroskładników: \n");
                    for (Products product : allFood.getListOfProducts())
                    {
                      product.toString1();
                    }
                    System.out.println("\n");
                    break;
                case 5:
                    System.out.println("Podaj swoją wagę w kg: ");
                    double waga = scan.nextDouble();
                    System.out.println("Podaj swój wzrost w cm: ");
                    double wzrost = scan.nextDouble();
                    System.out.println("Podaj swój wiek w latach: ");
                    double wiek = scan.nextDouble();
                    double BMR;
                    try {
                        BMR = 66 + (13.7 * waga) + (5 * wzrost) - (6.8 * wiek);
                        System.out.println("Twoje dzienne zapotrzebowanie kaloryczne wynosi " + (double) Math.round(BMR * 1d) / 1d + " kcal\n\n");
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    System.out.println("Ta opcja nie jest jeszcze dostępna.");
            }

        }

    }


}