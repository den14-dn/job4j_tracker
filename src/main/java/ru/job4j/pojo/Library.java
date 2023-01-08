package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book comics = new Book("DC", 115);
        Book textbook = new Book("Chemistry", 342);
        Book stories = new Book("Денискины рассказы", 250);
        Book educational = new Book("Clean code", 223);
        Book[] books = new Book[4];
        books[0] = comics;
        books[1] = textbook;
        books[2] = stories;
        books[3] = educational;
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            System.out.println(book.getName() + " - " + book.getCount());
        }
        System.out.println("Replace books 0 and 3");
        Book tmp = books[0];
        books[0] = books[3];
        books[3] = tmp;
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            System.out.println(book.getName() + " - " + book.getCount());
        }
        System.out.println("Show only books by name 'Clean code'");
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            if ("Clean code".equals(book.getName())) {
                System.out.println(book.getName() + " - " + book.getCount());
            }
        }

    }
}
