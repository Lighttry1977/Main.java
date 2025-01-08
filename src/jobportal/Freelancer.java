package jobportal;

public class Freelancer {
    private String name;
    private String specialty;
    private double rating;

    public Freelancer(String name, String specialty, double rating) {
        this.name = name;
        this.specialty = specialty;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Freelancer{" +
                "name='" + name + '\'' +
                ", specialty='" + specialty + '\'' +
                ", rating=" + rating +
                '}';
    }

}
