package firstproject.RestApplication.DTO;

public class CourseRequestDTO {
    private String title;
    private int credits;

    public CourseRequestDTO() {
    }

    public CourseRequestDTO(String title, int credits) {
        this.title = title;
        this.credits = credits;
    }

    public String getTitle() {
        return title;
    }

    public int getCredits() {
        return credits;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }
}
