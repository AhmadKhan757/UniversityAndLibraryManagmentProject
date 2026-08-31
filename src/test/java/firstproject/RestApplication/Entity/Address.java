package firstproject.RestApplication.Entity;



import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    @OneToOne(mappedBy = "address")
    private StudentData studentData;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            name = "city",
            nullable = false)
    private String city;

    @Column(
            name = "street",
            nullable = false)
    private String street;

    public Address() {
    }

    public Address(Long id, String city, String street) {
        this.id = id;
        this.city = city;
        this.street = street;
    }

    // Getters and Setters


    public Long getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}

