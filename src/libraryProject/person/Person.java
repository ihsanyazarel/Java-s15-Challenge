package libraryProject.person;

import libraryProject.enums.Category;

import java.util.Objects;

public abstract class Person {
    private static int count = 1;

    protected int personId;
    protected String fullName;

    public Person(String fullName) {
        this.personId = count;
        count++;
        this.fullName = fullName;
    }
    public abstract int getPersonId();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return personId == person.personId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId);
    }
}
