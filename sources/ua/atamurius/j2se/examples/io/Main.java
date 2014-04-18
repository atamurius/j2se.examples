package ua.atamurius.j2se.examples.io;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        final Book[] books = {
            new Book("Alice in Wonderland",  1865),
            new Book("Winnie-the-Pooh",      1926),
            new Book("Karlsson-on-the-Roof", 1970),
            new Book("Pippi Longstocking",   1944),
        };

        BookStore store = createBookStore("books.csv");
        
        store.save(books);
        System.out.println("Books saved.");
        
        System.out.println("Books loaded: ");
        for (Book book : store.load()) {
            System.out.println("\t"+ book);
        }
    }

    private static BookStore createBookStore(String filename) {
        if (filename.endsWith(".serial")) {
            return new SerialBookStore(filename);
        }
        else if (filename.endsWith(".bin")) {
            return new BinaryBookStore(filename);
        }
        else if (filename.endsWith(".csv")) {
            return new CsvBookStore(filename);
        }
        throw new IllegalArgumentException("Unsupported file type: "+ filename);
    }

}
