package libraryProject.interfaces;

import libraryProject.book.Book;
import libraryProject.person.LibraryMember;
import libraryProject.person.Person;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface Manageable {

    void addBook(Book book);
    void deleteBook(Book book);
    void addMember(Person person);
    void removeMember(Person person);
    Book findBookById(Integer id);
    List<Book> findBookByKey(Object key);
    void updateBook(Integer id, Book book);
    void giveBookToMember(Book book, Person member);
    void takeBookFromMember(Book book, Person member);



}
