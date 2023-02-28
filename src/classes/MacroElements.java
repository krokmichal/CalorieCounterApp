package classes;

import java.util.ArrayList;

public class MacroElements {
    int kcal;
    static int actualKcal;
    double protein, carbs, fat;
    static double actualProtein, actualCarbs, actualFat;


    public void getMacro() {
        System.out.println("\nkcal: " + kcal + "\nprotein: " + protein + "\ncarbs: " + carbs + "\nfat: " + fat + "\n\n");
    }
    public void getFinalMacro() {
        System.out.println("\nkcal: " + actualKcal + "\nprotein: " + actualProtein + "\ncarbs: " + actualCarbs + "\nfat: " + actualFat + "\n\n");
    }

    public MacroElements() {
        kcal = 0;
        protein = 0;
        carbs = 0;
        fat = 0;
        actualKcal = 0;
        actualProtein = 0;
        actualCarbs = 0;
        actualFat = 0;
    }

    // Obliczamy ilość kalorii dla danej ilości produktu spożywczego (w gramach)
    public void calculateMacro(ArrayList<SelectedProduct> list) {
            SelectedProduct product = list.get(list.size()-1);
            actualKcal += product.getProduct().getKcal() * product.getGram() / 100;
            actualProtein += product.getProduct().getProtein() * product.getGram() / 100;
            actualCarbs += product.getProduct().getCarbs() * product.getGram() / 100;
            actualFat += product.getProduct().getFat() * product.getGram() / 100;
            kcal = product.getProduct().getKcal() * product.getGram() / 100;
            protein = product.getProduct().getProtein() * product.getGram() / 100;
            carbs = product.getProduct().getCarbs() * product.getGram() / 100;
            fat = product.getProduct().getFat() * product.getGram() / 100;

            }

    }

