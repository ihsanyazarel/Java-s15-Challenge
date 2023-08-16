package libraryProject.person;

import libraryProject.book.Book;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LibraryMember extends Person{
    private int personId;

    private double money;
    private Set<Book> borrowedList;

    public LibraryMember(String fullName, double money) {
        super(fullName);
        this.personId = super.personId;
        this.money = money;
        this.borrowedList = new HashSet<>();
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Set<Book> getBorrowedList() {
        return borrowedList;
    }

    public void setBorrowedList(Set<Book> borrowedList) {
        this.borrowedList = borrowedList;
    }

    @Override
    public int getPersonId() {
        return super.personId;
    }

    @Override
    public String toString() {
        return "LibraryMember{" +
                "money=" + money +
                ", borrowedList=" + borrowedList +
                ", personId=" + personId +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
