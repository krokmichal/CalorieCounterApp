package classes;

public class Products {
    int id;
    String name;
    int kcal;
    double protein, carbs, fat;


    public Products(int id, String name, int kcal, double protein, double carbs, double fat) {
        this.id = id;
        this.name = name;
        this.kcal = kcal;
        this.protein = protein;
        this.carbs = carbs;
        this.fat = fat;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getKcal() {
        return kcal;
    }

    public double getProtein() {
        return protein;
    }

    public double getCarbs() {
        return carbs;
    }

    public double getFat() {
        return fat;
    }


    public void toString1() {
        System.out.println(id + ". " + name + " - Kalorie: " + kcal + ", Białko: " + protein + ", Węglowodany: " + carbs + ", Tłuszcze: " + fat);

    }
}
