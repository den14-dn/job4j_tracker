package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Tracker {
    private final List<Item> items = new ArrayList<>();

    public Item add(Item item) {
        item.setId(generateId());
        items.add(item);
        return item;
    }

    private String generateId() {
        Random rn = new Random();
        return String.valueOf(rn.nextLong() + System.currentTimeMillis());
    }

    public Item findById(String id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public List<Item> findByName(String key) {
        List<Item> itemsWithoutNull = new ArrayList<>();
        for (Item el : items) {
            if (el.getName().equals(key)) {
                itemsWithoutNull.add(el);
            }
        }
        return itemsWithoutNull;
    }

    public List<Item> findAll() {
        return this.items;
    }

    public boolean replace(String id, Item item) {
        int index = indexOf(id);
        boolean rst = (index != -1);
        if (rst) {
            item.setId(id);
            items.set(index, item);
        }
        return rst;
    }

    private int indexOf(String id) {
        int rst = -1;
        int index = 0;
        for (Item el : items) {
            if (el.getId().equals(id)) {
                rst = index;
                break;
            }
            index++;
        }
        return rst;
    }

    public boolean delete(String id) {
        int index = indexOf(id);
        boolean rst = (index != -1);
        if (index >= 0) {
            items.remove(index);
        }
        return rst;
    }
}