package jobportal;

import java.util.Objects;

public class Freelancer extends Person implements Displayable {
    private String specialty;
    private double rating;

    public Freelancer(String name, String specialty, double rating) {
        super(name);
        if (rating < 0.0 || rating > 5.0) {
            throw new IllegalArgumentException("Rating must be between 0.0 and 5.0.");
        }
        this.specialty = specialty;
        this.rating = rating;
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
        if (rating < 0.0 || rating > 5.0) {
            throw new IllegalArgumentException("Rating must be between 0.0 and 5.0.");
        }
        this.rating = rating;
    }

    @Override
    public void display() {
        System.out.printf("| %-15s | %-20s | %-5.1f |\n", name, specialty, rating);
    }

    @Override
    public String toString() {
        return "Freelancer{" +
                "name='" + name + '\'' +
                ", specialty='" + specialty + '\'' +
                ", rating=" + rating +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Freelancer that = (Freelancer) obj;
        return Double.compare(that.rating, rating) == 0 &&
                name.equals(that.name) &&
                specialty.equals(that.specialty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, specialty, rating);
    }
}
