package libraryProject.book;

import libraryProject.enums.Category;
import libraryProject.enums.ScienceType;
import libraryProject.person.Author;

public class Science extends Book{
    private Category category;
    private ScienceType type;
    private int id;

    public Science(String title, Author author, Category category, ScienceType type) {
        super(title, author);
        this.id = super.id;
        this.category = getCategory();
        this.type = type;
        author.addBook(title);
    }

    @Override
    public Category getCategory() {
        return Category.SCIENCE;
    }
}
