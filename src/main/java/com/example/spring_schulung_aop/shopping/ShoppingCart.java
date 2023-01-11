package com.example.spring_schulung_aop.shopping;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ShoppingCart {
    private Map<Item, Long> cart = new HashMap<>();
    private long itemCount = 0;
    private long price = 0;

    public void addItem(Item item) {
        long amountOfItem = cart.getOrDefault(item, 0L);
        amountOfItem++;
        cart.put(item, amountOfItem);
    }

    public void removeItem(Item item) {
        if (!cart.containsKey(item)) return;

        Long amountOfItem = cart.get(item);
        amountOfItem--;
        if (amountOfItem == 0) {
            cart.remove(item);
        } else {
            cart.put(item, amountOfItem);
        }
    }

    public void deleteItem(Item item) {
        cart.remove(item);
    }

    public void updateItemCount() {
        this.itemCount = cart.values().stream().mapToLong(Long::longValue).sum();
    }

    public void updatePrice() {
        this.price = cart.entrySet().parallelStream()
                .mapToLong(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }

    public void checkout() {
        System.out.println("Shopping Cart contains " + itemCount + " Items.");
        System.out.println("Price is " + price + " Cents");
    }
}
