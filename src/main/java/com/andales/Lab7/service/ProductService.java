package com.andales.Lab7.service;

import com.andales.Lab7.model.Product;
import org.springframework.stereotype.Service;

import java.util.*;

@Service   // <-- Required for Spring to detect this service
public class ProductService {

    private Map<Long, Product> products = new HashMap<>();

    public List<Product> getAllProducts() {
        return new ArrayList<>(products.values());
    }

    public Product getProductById(Long id) {
        return products.get(id);
    }

    public Product addProduct(Product product) {
        products.put(product.getId(), product);
        return product;
    }

    public Product updateProduct(Long id, Product updatedProduct) {
        Product existing = products.get(id);
        if (existing == null) {
            return null;
        }

        existing.setName(updatedProduct.getName());
        existing.setPrice(updatedProduct.getPrice());

        products.put(id, existing);
        return existing;
    }

    public boolean deleteProduct(Long id) {
        if (!products.containsKey(id)) {
            return false;
        }
        products.remove(id);
        return true;
    }
}