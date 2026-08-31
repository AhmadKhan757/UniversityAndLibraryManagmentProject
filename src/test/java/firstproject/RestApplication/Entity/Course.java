package firstproject.RestApplication.Entity;



import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course {

    @ManyToMany(mappedBy = "courses")
    private List<StudentData> studentData = new ArrayList<>();

    @OneToMany(mappedBy = "course")
    private List<Enrollment> enrollment;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private int credits;

    public Course() {
    }

    public Course(Long id, String title, int credits) {
        this.id = id;
        this.title = title;
        this.credits = credits;
    }

    // Getters and Setters


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
