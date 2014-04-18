package ua.atamurius.j2se.examples.io;

import static java.lang.String.format;

import java.io.Serializable;

/**
 * Example class, that we will store and load.
 */
public class Book implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private String title;
    private int year;

    public Book(String title, int year) {
        this.title = title;
        this.year = year;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    @Override
    public String toString() {
        return format("Book \"%s\", %4d", getTitle(), getYear());
    }
}
