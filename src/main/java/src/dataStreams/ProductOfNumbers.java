package src.dataStreams;

import java.util.ArrayList;
import java.util.List;

public class ProductOfNumbers {
    public static void main(String[] args) {
        ProductOfNumbers productOfNumbers = new ProductOfNumbers();
        productOfNumbers.add(3);
        productOfNumbers.add(0);
        productOfNumbers.add(2);
        productOfNumbers.add(5);
        productOfNumbers.add(4);
        System.out.println(productOfNumbers.getProduct(2));
        System.out.println(productOfNumbers.getProduct(3));
        System.out.println(productOfNumbers.getProduct(4));
        productOfNumbers.add(8);
        System.out.println(productOfNumbers.getProduct(2));
    }

    private List<Integer> products;

    public ProductOfNumbers() {
        this.products = new ArrayList<>();
        products.add(1);
    }

    public void add(int num) {
        if (num == 0) {
            products.clear();
            products.add(1);
        } else {
            products.add(products.get(products.size()-1) * num);
        }
    }

    public int getProduct(int k) {
        return products.size() <= k ? 0 : products.get(products.size()-1)/products.get(products.size() - 1 - k);
    }
}
