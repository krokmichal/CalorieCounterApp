package classes;

public class SelectedProduct {
    Products product;
    int gram;

    public SelectedProduct(Products product, int gram) {
        this.product = product;
        this.gram = gram;
    }

    public Products getProduct() {
        return product;
    }

    public int getGram() {
        return gram;
    }
}
