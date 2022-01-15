package entities;

import java.util.List;

public class ShoppingCart {
    private List<BaseEntity> products;

    public ShoppingCart() {
    }

    public List<BaseEntity> getProducts() {
        return products;
    }

    public void setProducts(List<BaseEntity> products) {
        this.products = products;
    }
}
