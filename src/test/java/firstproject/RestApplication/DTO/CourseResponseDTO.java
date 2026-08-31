package firstproject.RestApplication.DTO;

public class CourseResponseDTO {
    private Long id;
    private String title;
    private int credits;

    public CourseResponseDTO() {
    }

    public CourseResponseDTO(Long id, String title, int credits) {
        this.id = id;
        this.title = title;
        this.credits = credits;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getCredits() {
        return credits;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }
}
