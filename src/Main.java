
import jobportal.Job;
import jobportal.Freelancer;
import jobportal.JobPortal;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Job job1 = new Job("Web Development", "Develop a responsive website", 1500);
        Job job2 = new Job("Graphic Design", "Create a logo and brand identity", 500);
        Job job3 = new Job("Mobile App Development", "Develop an Android app", 2000);
        Job job4 = new Job("Content Writing", "Write SEO-friendly articles", 300);

        Freelancer freelancer1 = new Freelancer("Dimash", "Web Development", 4.8);
        Freelancer freelancer2 = new Freelancer("Baqyt", "Graphic Design", 4.5);
        Freelancer freelancer3 = new Freelancer("Sara", "Mobile App Development", 4.9);
        Freelancer freelancer4 = new Freelancer("Diana", "Content Writing", 4.6);

        JobPortal portal = new JobPortal("FreelanceHub");
        portal.addJob(job1);
        portal.addJob(job2);
        portal.addJob(job3);
        portal.addJob(job4);

        portal.addFreelancer(freelancer1);
        portal.addFreelancer(freelancer2);
        portal.addFreelancer(freelancer3);
        portal.addFreelancer(freelancer4);

        System.out.println("Jobs:");
        displayJobs(portal.getJobs());

        System.out.println("\nFreelancers:");
        displayFreelancers(portal.getFreelancers());
    }

    public static void displayJobs(List<Job> jobs) {
        System.out.println("+----------------------+--------------------------------+------------+");
        System.out.println("| Title               | Description                    | Budget     |");
        System.out.println("+----------------------+--------------------------------+------------+");
        for (Job job : jobs) {
            job.display();
        }
        System.out.println("+----------------------+--------------------------------+------------+");
    }

    public static void displayFreelancers(List<Freelancer> freelancers) {
        System.out.println("+-----------------+----------------------+-------+");
        System.out.println("| Name            | Specialty            | Rating|");
        System.out.println("+-----------------+----------------------+-------+");
        for (Freelancer freelancer : freelancers) {
            freelancer.display();
        }
        System.out.println("+-----------------+----------------------+-------+");
    }
}