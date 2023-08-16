package libraryProject.book;

import libraryProject.enums.Category;
import libraryProject.enums.NovelType;
import libraryProject.person.Author;

public class Novel extends Book{
    private Category category;
    private NovelType type;
    private int id;

    public Novel(String title, Author author, NovelType type){
        super(title, author);
        this.id = super.id;
        this.category = getCategory();
        this.type = type;
        author.addBook(title);
    }

    @Override
    public Category getCategory() {
        return Category.NOVEL;
    }
}
