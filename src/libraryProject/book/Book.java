package libraryProject.book;

import libraryProject.enums.Category;
import libraryProject.person.Author;

import java.util.Objects;

public abstract class Book {
    private static int count = 1;
    protected int id;
    private String title;
    private Author author;

    public Book(String title, Author author) {
        this.id = count;
        count++;
        this.title = title;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public abstract Category getCategory();

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Book Id= ");
        builder.append(id);
        builder.append(" - Book Title= ");
        builder.append(title);
        builder.append(" - Book Category= ");
        builder.append(getCategory());
        builder.append(" - Author= (");
        builder.append(getAuthor());
        builder.append(")\n");
        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }
}
