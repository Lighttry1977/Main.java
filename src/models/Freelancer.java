package models;

public class Freelancer {
    private final int id;
    private String name;
    private String specialty;
    private double rating;
    private String email;

    public Freelancer(int id, String name, String specialty, double rating, String email) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
        this.rating = rating;
        this.email = email;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getSpecialty() { return specialty; }
    public double getRating() { return rating; }
    public String getEmail() { return email; }

    public void setName(String name) { this.name = name; }
    public void setSpecialty(String specialty) { this.specialty = specialty; }
    public void setRating(double rating) { this.rating = rating; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "Freelancer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", specialty='" + specialty + '\'' +
                ", rating=" + rating +
                ", email='" + email + '\'' +
                '}';
    }
}
