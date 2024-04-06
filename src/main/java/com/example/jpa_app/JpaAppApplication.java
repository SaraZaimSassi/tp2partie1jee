package com.example.jpa_app;

import com.example.jpa_app.entities.Product;
import com.example.jpa_app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class JpaAppApplication implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public void run(String... args) throws Exception {
        productRepository.save(new Product(null,"Sac",4600,3));
        productRepository.save(new Product(null,"Computer",460,9));
        productRepository.save(new Product(null,"Perfume",4300,5));
        productRepository.save(new Product(null,"NailPolish",46,30));
        List<Product> products = productRepository.findAll();
        products.forEach(p->{
            System.out.println(p.toString());
        });
        Product product=productRepository.findById(Long.valueOf(1)).get();
        System.out.println("*********");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getPrice());
        System.out.println(product.getQuantity());
        System.out.println("*********");
        System.out.println("-----------------------------");
        List<Product> productList = productRepository.findByNameContains("C");
        productList.forEach(p ->{
            System.out.println(p);
        } );
        System.out.println("-----------------------------");
        List<Product> productList2 = productRepository.search("%C%");
        productList2.forEach(p ->{
            System.out.println(p);
        } );
        System.out.println("-----------------------------");
        List<Product> productList3 = productRepository.findByPriceGreaterThan(1000);
        productList3.forEach(p ->{
            System.out.println(p);
        } );
        System.out.println("-----------------------------");
        List<Product> productList4 = productRepository.searchByPrice(4000);
        productList4.forEach(p ->{
            System.out.println(p);
        } );

    }

    public static void main(String[] args) {
        SpringApplication.run(JpaAppApplication.class, args);
    }

}
