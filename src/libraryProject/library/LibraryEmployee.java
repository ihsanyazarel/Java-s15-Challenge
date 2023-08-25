package libraryProject.library;

import libraryProject.book.Book;
import libraryProject.enums.Category;
import libraryProject.interfaces.Manageable;
import libraryProject.person.Author;
import libraryProject.person.LibraryMember;
import libraryProject.person.Person;

import java.lang.reflect.Member;
import java.util.*;

public class LibraryEmployee extends Person implements Manageable {
    private int personId;

    private Library library = Library.getInstance();


    public LibraryEmployee(String fullName) {
        super(fullName);
        this.personId = super.personId;
    }



    @Override
    public int getPersonId() {
        return super.personId;
    }

    @Override
    public String toString() {
        return "LibraryEmployee{" +
                "personId=" + personId +
                ", fullName='" + fullName + '\'' +
                '}';
    }

    public Map<Integer, Book> showAllBooksInLibrary(){
        return library.getBookList();
    }
    public Map<Person, Set<Book>> showAllMembersInLibrary(){
        return library.getMembers();
    }


    @Override
    public void addBook(Book book) {
        Map<Integer, Book> bookList = library.getBookList();
        if (bookList.containsKey(book.getId())){
            System.out.println(book.getId() + " id numaralı kitap zaten kütüphaneye kayıtlıdır.");
        }
        else {
            bookList.put(book.getId(), book);
        }
    }

    @Override
    public void deleteBook(Book book) {
        Map<Integer, Book> bookList = library.getBookList();
        int bookId = book.getId();
        if (bookList.containsKey(bookId)){
            bookList.remove(bookId);
        } else {
            System.out.println(bookId + " id numaralı kitap zaten kütüphanede hayıtlı değildir.");
        }
    }

    @Override
    public void addMember(Person person) {
        Map<Person, Set<Book>> memberList = library.getMembers();
        try{
            if (memberList.containsKey(person)){
                System.out.println(person + " kişisi zaten kayıtlıdır.");
            } else {
                memberList.put(person, ((LibraryMember)person).getBorrowedList());
//                library.setMembers(memberList);
            }
        } catch (Exception e){
            System.out.println("LibraryMember tipinde bir obje göndermelisiniz!");
        }
    }

    @Override
    public void removeMember(Person person) {
        Map<Person, Set<Book>> memberList = library.getMembers();
        if (memberList.containsKey(person)){
            memberList.remove(person);
//            library.setMembers(memberList);
        } else {
            System.out.println(person.getPersonId() + " id numaralı kişi zaten kütüphanede kayıtlı değil.");
        }
    }

    @Override
    public Book findBookById(Integer id) {
        return library.getBookList().get(id);
    }


    @Override
    public List<Book> findBookByKey(Object key){
        List<Book> returnList = new ArrayList<>();
        for (Book item : library.getBookList().values()) {
            if (key instanceof String && item.getTitle().contains((String) key)
                    || key instanceof Person && item.getAuthor().equals(key)
                    || key instanceof Category && item.getCategory().equals(key)) {
                returnList.add(item);
            }
        }
        return returnList;
    }

    @Override
    public void updateBook(Integer id, Book book){
        try{
            deleteBook(findBookById(id));
            addBook(book);
        } catch (Exception e){
            System.out.println("Verilen kitap sistemde kayıtlı değildir, kitabı kaydedin.");
        }
    }

    @Override
    public void giveBookToMember(Book book, Person member) {
        if (library.getMembers().containsKey(member)){
            if (library.getBookList().containsKey(book.getId())){
                if (library.getMembers().get(member).size() < 6){
                    if (((LibraryMember)member).getMoney() >=50){
                        Set<Book> membersBookList = library.getMembers().get(member);
                        membersBookList.add(book);
                        ((LibraryMember)member).setMoney(((LibraryMember)member).getMoney() - 50);
                    }else {
                        System.out.println("Bakiye yetersiz!");
                    }
                } else {
                    System.out.println("Bir üye en fazla 5 adet kitap ödünç alabilir!.");
                }
            } else {
                System.out.println("Bu kitap kütüphaneye kayıtlı değil!");
            }
        } else {
            System.out.println("Bu kişi kütüphaneye kayıtlı değil!");
        }
    }

    @Override
    public void takeBookFromMember(Book book, Person member) {
        Set<Book> membersBookList = library.getMembers().get(member);
        membersBookList.remove(book);
        ((LibraryMember)member).setMoney(((LibraryMember)member).getMoney() + 50);
    }

}
