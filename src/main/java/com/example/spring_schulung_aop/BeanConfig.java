package com.example.spring_schulung_aop;

import com.example.spring_schulung_aop.shopping.Item;
import com.example.spring_schulung_aop.shopping.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Autowired
    ShoppingCart shoppingCart;

    @Bean
    public CommandLineRunner myAopApp() {
        return args -> {
            System.out.println("Start Shopping");
            Item item0 = new Item("Ketchup", 100);
            Item item1 = new Item("Mayo", 70);

            shoppingCart.checkout();
            shoppingCart.addItem(item0);
            shoppingCart.checkout();
            shoppingCart.addItem(item0);
            shoppingCart.checkout();
            shoppingCart.addItem(item1);
            shoppingCart.checkout();
            shoppingCart.removeItem(item0);
            shoppingCart.checkout();
        };
    }
}
