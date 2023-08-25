package libraryProject.main;

import libraryProject.book.Book;
import libraryProject.book.Encyclopedia;
import libraryProject.book.Novel;
import libraryProject.enums.Category;
import libraryProject.enums.NovelType;
import libraryProject.library.LibraryEmployee;
import libraryProject.person.Author;
import libraryProject.person.LibraryMember;
import libraryProject.person.Person;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Person author1 = new Author("Author1");
        Person author2 = new Author("Author2");
        Person libraryEmployee1 = new LibraryEmployee("Employee1");
        Book book1 = new Novel("title1", (Author) author1, NovelType.MYSTERY);
        Book book2 = new Novel("title2", (Author) author2, NovelType.MYSTERY);
        Book book3 = new Encyclopedia("title3", (Author) author2, 5);
        Book book4 = new Novel("title4", (Author) author1, NovelType.MYSTERY);
        Book book5 = new Novel("title5", (Author) author2, NovelType.MYSTERY);
        Book book6 = new Novel("test", (Author) author1, NovelType.MYSTERY);
        Book book7 = new Novel("test", (Author) author1, NovelType.MYSTERY);

//        System.out.println(book1);
        Person member1 = new LibraryMember("LibraryMember1", 500);
        Person member2 = new LibraryMember("LibraryMember2", 500);
        Person member3 = new LibraryMember("LibraryMember3", 500);
//        System.out.println(member1);
//        System.out.println(author1);
//        System.out.println(book1.equals(book2));
//        System.out.println(book2.equals(book2e));
//        System.out.println(author1.equals(author2));
//        System.out.println(((Author) author1).getBooks());
//        System.out.println(((Author) author2).getBooks());
//        System.out.println(libraryEmployee1);
        LibraryEmployee ihsan = ((LibraryEmployee)libraryEmployee1);
        ihsan.addBook(book1);
//        ihsan.addBook(book1);
        ihsan.addBook(book2);
        ihsan.addBook(book3);
        ihsan.addBook(book4);
        ihsan.addBook(book5);
        ihsan.addBook(book6);
        ihsan.addBook(book7);
//        System.out.println(ihsan.showAllBooksInLibrary());
//        ihsan.deleteBook(book1);
//        ihsan.deleteBook(book2);
//        System.out.println(ihsan.showAllBooksInLibrary());
        ihsan.deleteBook(book1);
//        LibraryEmployee libraryEmployee2 = new LibraryEmployee("Employee2");
//        System.out.println(libraryEmployee2.showAllBooksInLibrary());
//        ihsan.addMember(author1);
        ihsan.addMember(member1);
        ihsan.addMember(member2);
        ihsan.addMember(member3);
        ihsan.removeMember(member2);
//        System.out.println(ihsan.showAllMembersInLibrary());
//        System.out.println(ihsan.findBookById(2));
//        System.out.println(ihsan.findBookByKey("title2"));
//        System.out.println(ihsan.findBookByKey(author1));
//        System.out.println(ihsan.findBookByKey(author2));
//        System.out.println(ihsan.findBookByKey(Category.NOVEL));
//        System.out.println(ihsan.findBookByKey(Category.ENCYCLOPEDIA));
        Book book8 = new Encyclopedia("test2", (Author) author2, 5);
        Book book9 = new Encyclopedia("test3", (Author) author2, 5);
//        System.out.println(ihsan.showAllBooksInLibrary());
//        ihsan.updateBook(2,book8);
//        ihsan.addBook(book9);
//        ihsan.addBook(book8);
//        System.out.println(ihsan.showAllBooksInLibrary());
//        System.out.println(ihsan.showAllMembersInLibrary());
        ihsan.giveBookToMember(book7, member1);
        ihsan.giveBookToMember(book4, member1);
        ihsan.giveBookToMember(book5, member1);
        System.out.println(ihsan.showAllMembersInLibrary());
        ihsan.takeBookFromMember(book7, member1);
        System.out.println(ihsan.showAllMembersInLibrary());






    }
}