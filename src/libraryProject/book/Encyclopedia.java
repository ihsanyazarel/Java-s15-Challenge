package libraryProject.book;

import libraryProject.enums.Category;
import libraryProject.person.Author;

public class Encyclopedia extends Book{
    private Category category;

    private int volume;
    private int id;

    public Encyclopedia(String title, Author author, int volume) {
        super(title, author);
        this.id = super.id;
        this.category = getCategory();
        this.volume = volume;
        author.addBook(title);
    }

    @Override
    public Category getCategory() {
        return Category.ENCYCLOPEDIA;
    }
}
