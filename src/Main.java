import models.*;

public class Main {
    public static void main(String[] args) {
        FreelancerDAO freelancerDAO = new FreelancerDAO();
        JobDAO jobDAO = new JobDAO();

        // Добавляем фрилансеров
        try {
            Freelancer freelancer1 = new Freelancer(0, "Иван", "Web-разработчик", 4.8, "ivan@example.com");
            freelancerDAO.addFreelancer(freelancer1);
            System.out.println("✅ Добавлен фрилансер: " + freelancer1);

            Freelancer freelancer2 = new Freelancer(0, "Анна", "Дизайнер", 4.5, "anna@example.com");
            freelancerDAO.addFreelancer(freelancer2);
            System.out.println("✅ Добавлен фрилансер: " + freelancer2);
        } catch (UserExistsException e) {
            System.out.println("❌ Ошибка: " + e.getMessage());
        }

        // Добавляем работы
        Job job1 = new Job(0, "Создание портала", "Нужно сделать лендинг", 500);
        jobDAO.addJob(job1);
        System.out.println("✅ Добавлена работа: " + job1);

        Job job2 = new Job(0, "Разработка логотипа", "Нужно создать стильный логотип", 200);
        jobDAO.addJob(job2);
        System.out.println("✅ Добавлена работа: " + job2);

        // Вывод всех фрилансеров
        System.out.println("\n📌 Список всех фрилансеров:");
        for (Freelancer f : freelancerDAO.getAllFreelancers()) {
            System.out.println(f);
        }

        // Вывод всех работ
        System.out.println("\n📌 Список всех работ:");
        for (Job j : jobDAO.getAllJobs()) {
            System.out.println(j);
        }
    }
}
