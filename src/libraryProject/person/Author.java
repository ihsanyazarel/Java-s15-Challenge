package libraryProject.person;
import libraryProject.book.Book;
import libraryProject.person.Person;
import java.util.HashSet;
import java.util.List;

public class Author extends Person {
    HashSet<String> books;
    private int personId;

    public Author(String fullName) {
        super(fullName);
        this.personId = super.personId;
        this.books = new HashSet<>();
    }

    @Override
    public int getPersonId() {
        return super.personId;
    }

    public HashSet getBooks() {
        return this.books;
    }

    public void addBook(String book) {
        this.books.add(book);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Person Id: ");
        builder.append(getPersonId());
        builder.append(" - Full Name: ");
        builder.append(super.fullName);
        builder.append(" - Books: ");
        builder.append(books);
        return builder.toString();
    }
}
