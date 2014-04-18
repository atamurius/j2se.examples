package ua.atamurius.j2se.examples.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerialBookStore implements BookStore {

    private final String filename;
    
    public SerialBookStore(String filename) {
        this.filename = filename;
    }

    public void save(Book[] books) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(filename));
        try {
            out.writeObject(books);
        }
        finally {
            out.close();
        }
    }

    public Book[] load() throws IOException {
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(filename));
        try {
            return (Book[]) in.readObject();
        }
        catch (ClassNotFoundException e) {
            throw new IOException(e);
        }
        finally {
            in.close();
        }
    }

}
