package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

public class Tracker {
    private final Item[] items = new Item[100];
    private int position = 0;

    public Item add(Item item) {
        item.setId(generateId());
        items[position++] = item;
        return item;
    }

    private String generateId() {
        Random rn = new Random();
        return String.valueOf(rn.nextLong() + System.currentTimeMillis());
    }

    public Item findById(String id) {
        Item rsl = null;
        for (int index = 0; index < position; index++) {
            Item item = items[index];
            if (item.getId().equals(id)) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findByName(String key) {
        Item[] rst = new Item[position];
        int index = 0;
        for (Item el : items) {
            if (el != null && el.getName().equals(key)) {
                rst[index++] = el;
            }
        }
        return rst;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, position);
    }
}