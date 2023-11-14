public class Books {
    private String title;
    private String author;
    private String isbn;
    private int publicationDate;

    public Books(String title, String author, int publicationDate, String isbn) {
        this.title = title;
        this.author = author;
        this.publicationDate = publicationDate;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getDate() {
        return publicationDate;
    }

    public String printBook() {
        return "Title: " + this.title + ", Author: " + this.author + ", Publication Date: " + publicationDate + ", ISBN: " + this.isbn + "\n";
    }
}
