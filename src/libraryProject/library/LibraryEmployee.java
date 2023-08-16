package libraryProject.library;

import libraryProject.book.Book;
import libraryProject.enums.Category;
import libraryProject.interfaces.Manageable;
import libraryProject.person.Author;
import libraryProject.person.LibraryMember;
import libraryProject.person.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LibraryEmployee extends Person implements Manageable {
    private int personId;

    private static Library library = new Library();


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

    public Map<Person, Set<Book>> showAllMembersInLibrary(){
        return library.getMembers();
    }

    public List<Book> findBookByKey(Object title){
        List<Book> returnList = new ArrayList<>();
        library.getBookList().values().forEach(item ->{
            if(item.getTitle().contains((String)title)){
                returnList.add(item);
            }
        });
        return returnList;
    }
    // TODO: findBookByKey methodunu teke düşşür.(Objecct key)
    public List<Book> findBookByKey(Person author){
        List<Book> returnList = new ArrayList<>();
        library.getBookList().values().forEach(item ->{
            if(item.getAuthor().equals(author)){
                returnList.add(item);
            }
        });
        return returnList;
    }
    public List<Book> findBookByKey(Category category){
        List<Book> returnList = new ArrayList<>();
        library.getBookList().values().forEach(item ->{
            if(item.getCategory().equals(category)){
                returnList.add(item);
            }
        });
        return returnList;
    }
    public void updateBook(Integer id, Book book){
        try{
            deleteBook(findBookById(id));
            addBook(book);
        } catch (Exception e){
            System.out.println("Verilen kitap sistemde kayıtlı değildir, kitabı kaydedin.");
        }
    }

}
