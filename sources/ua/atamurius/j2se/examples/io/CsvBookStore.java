package ua.atamurius.j2se.examples.io;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CsvBookStore implements BookStore {

    private final String filename;
    
    public CsvBookStore(String filename) {
        this.filename = filename;
    }

    @Override
    public void save(Book[] books) throws IOException {
        PrintWriter out = new PrintWriter(
                new FileWriter(filename));
        try {
            out.printf("%-20s;%4s%n", "Title","Year");
            for (Book book : books) {
                out.printf("%-20s;%4d%n", book.getTitle(), book.getYear());
            }
        }
        finally {
            out.close();
        }
    }

    @Override
    public Book[] load() throws IOException {
        BufferedReader in = new BufferedReader(
                new FileReader(filename));
        try {
            List<Book> books = new ArrayList<Book>();
            in.readLine(); // header line
            String line;
            while ((line = in.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length != 2)
                    break;
                books.add(new Book(parts[0].trim(), parseInt(parts[1].trim())));
            }
            return books.toArray(new Book[books.size()]);
        }
        finally {
            in.close();
        }
    }

}
