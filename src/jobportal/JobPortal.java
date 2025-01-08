package jobportal;

import java.util.ArrayList;
import java.util.List;

public class JobPortal {
    private String name;
    private final List<Job> jobs;
    private final List<Freelancer> freelancers;

    public JobPortal(String name) {
        this.name = name;
        this.jobs = new ArrayList<>();
        this.freelancers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addJob(Job job) {
        jobs.add(job);
    }

    public void addFreelancer(Freelancer freelancer) {
        freelancers.add(freelancer);
    }

    @Override
    public String toString() {
        return "JobPortal{" +
                "name='" + name + '\'' +
                ", jobs=" + jobs +
                ", freelancers=" + freelancers +
                '}';


    }
}
