
package jobportal;

import models.Freelancer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public List<Job> getJobs() {
        return jobs;
    }

    public List<Freelancer> getFreelancers() {
        return freelancers;
    }

    @Override
    public String toString() {
        return "JobPortal{" +
                "name='" + name + '\'' +
                ", jobs=" + jobs +
                ", freelancers=" + freelancers +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        JobPortal portal = (JobPortal) obj;
        return name.equals(portal.name) &&
                jobs.equals(portal.jobs) &&
                freelancers.equals(portal.freelancers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, jobs, freelancers);
    }
}
