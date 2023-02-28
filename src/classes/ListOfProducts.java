package classes;
import java.util.ArrayList;

public class ListOfProducts {
    static ArrayList<Products> list = new ArrayList<>();
         public ListOfProducts() {
           this.list = new ArrayList<Products>();
       }

    public ListOfProducts(ArrayList<Products> list) {
           this.list = list;
       }

       public ArrayList<Products> getListOfProducts() {
           return list;
       }

       public void setListOfProducts(ArrayList<Products> list) {
           this.list = list;
       }

    public static Products findProduct(int id){
        for (Products product : list) {
            if (id == product.getId())
                return product;
        }
        return null;
    }

    public void addFoodToList(Products newProduct){
        this.list.add(newProduct);
        }
        
    }
    


