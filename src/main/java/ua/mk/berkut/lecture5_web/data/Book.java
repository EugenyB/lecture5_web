package ua.mk.berkut.lecture5_web.data;

public class Book {
    private int id;
    private String title;
    private int pages;

    public Book(int id, String title, int pages) {
        this.id = id;
        this.title = title;
        this.pages = pages;
    }

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
