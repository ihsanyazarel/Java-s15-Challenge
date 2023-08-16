package libraryProject.interfaces;

import libraryProject.book.Book;
import libraryProject.person.Person;

import java.util.List;

public interface Manageable {
    void addBook(Book book);
    void deleteBook(Book book);
    void addMember(Person person);
    void removeMember(Person person);
    Book findBookById(Integer id);
    List<Book> findBookByKey(Object key);



}
