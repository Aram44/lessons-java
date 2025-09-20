package test;

import java.util.List;

public class Basket {
    private List<Products> products;

    public Basket(List<Products> products) {
        if (products == null || products.isEmpty()) {
            throw new RuntimeException("basket.is.empty");
        }
        this.products = products;
    }

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }
}
