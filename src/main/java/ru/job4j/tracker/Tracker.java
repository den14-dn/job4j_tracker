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
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
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

    public boolean replace(String id, Item item) {
        int index = indexOf(id);
        boolean rst = (index != -1);
        if (rst) {
            item.setId(id);
            items[index] = item;
        }
        return rst;
    }

    private int indexOf(String id) {
        int rst = -1;
        for (int i = 0; i < position; i++) {
            if (items[i].getId().equals(id)) {
                rst = i;
                break;
            }
        }
        return rst;
    }

    public boolean delete(String id) {
        int index = indexOf(id);
        System.arraycopy(items, index + 1, items, index, position - index);
        position--;
        items[position] = null;
        return true;
    }
}