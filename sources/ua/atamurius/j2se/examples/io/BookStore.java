package ua.atamurius.j2se.examples.io;

import java.io.IOException;

public interface BookStore {

    void save(Book[] books) throws IOException;
    
    Book[] load() throws IOException;
}
