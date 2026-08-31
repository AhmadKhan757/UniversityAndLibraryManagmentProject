package firstproject.RestApplication.DTO;

public class BookRequestDTO {

    private String title;
    private String author;
    private String publisher;
    private String category;

    public BookRequestDTO
            ( String title, String author, String publisher, String category) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.category = category;
    }

    public BookRequestDTO() {
    }

    //  GETTERS

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getCategory() {
        return category;
    }


            //   SETTERS

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
