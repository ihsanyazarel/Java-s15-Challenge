package libraryProject.library;

import libraryProject.book.Book;
import libraryProject.person.Person;

import java.util.*;

class Library {
    private Map<Integer, Book> books;
    private Map<Person, Set<Book>> members;
    private Map<Integer, Integer> borrowedBooks;

    protected Library() {
        this.books = new HashMap<>();
        this.members = new HashMap<>();
        this.borrowedBooks = new HashMap<>();
    }


    protected Map<Integer, Book> getBookList() {
        return books;
    }

    protected Map<Person, Set<Book>> getMembers() {
        return members;
    }

    protected Map<Integer, Integer> getBorrowedBookMap() {
        return borrowedBooks;
    }

    protected void setBookList(Map<Integer, Book> books) {
        this.books = books;
    }

    protected void setMembers(Map<Person, Set<Book>> members) {
        this.members = members;
    }

    protected void setBorrowedBookMap(Map<Integer, Integer> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }
}
