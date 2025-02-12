package models;

public class Job {
    private int id;
    private String title;
    private String description;
    private double budget;

    public Job(int id, String title, String description, double budget) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.budget = budget;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public double getBudget() { return budget; }

    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setBudget(double budget) { this.budget = budget; }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", budget=" + budget +
                '}';
    }
}

