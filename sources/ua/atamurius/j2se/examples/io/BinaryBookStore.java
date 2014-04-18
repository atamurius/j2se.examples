package ua.atamurius.j2se.examples.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BinaryBookStore implements BookStore {

    private final String filename;
    
    public BinaryBookStore(String filename) {
        this.filename = filename;
    }

    /**
     * Format:
     * 4 bytes integer: count of books (N)
     * N times repeat:
     *     2 bytes integer: title length
     *     modified UTF-8 representation of title
     *     4 bytes integer: year
     */
    @Override
    public void save(Book[] books) throws IOException {
        DataOutputStream out = new DataOutputStream(
                new FileOutputStream(filename));
        try {
            out.writeInt(books.length);
            for (Book book : books) {
                out.writeUTF(book.getTitle());
                out.writeInt(book.getYear());
            }
        }
        finally {
            out.close();
        }
    }

    @Override
    public Book[] load() throws IOException {
        DataInputStream in = new DataInputStream(
                new FileInputStream(filename));
        try {
            Book[] books = new Book[in.readInt()];
            for (int i = 0; i < books.length; i++) {
                books[i] = new Book(in.readUTF(), in.readInt());
            }
            return books;
        }
        finally {
            in.close();
        }
    }

}
