package models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JobDAO {
    private static final Logger LOGGER = Logger.getLogger(JobDAO.class.getName());

    // ✅ Добавление работы
    public void addJob(Job job) {
        String sql = "INSERT INTO jobs (title, description, budget) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, job.getTitle());
            stmt.setString(2, job.getDescription());
            stmt.setDouble(3, job.getBudget());

            stmt.executeUpdate();
            System.out.println("✅ Работа добавлена: " + job.getTitle());

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Ошибка при добавлении работы", e);
        }
    }

    // ✅ Получение всех работ
    public List<Job> getAllJobs() {
        List<Job> jobs = new ArrayList<>();
        String sql = "SELECT * FROM jobs";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Job job = new Job(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getDouble("budget")
                );
                jobs.add(job);
            }

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Ошибка при получении списка работ", e);
        }

        return jobs;
    }

    // ✅ Обновление работы
    public void updateJob(int id, Job updatedJob) {
        String sql = "UPDATE jobs SET title = ?, description = ?, budget = ? WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, updatedJob.getTitle());
            stmt.setString(2, updatedJob.getDescription());
            stmt.setDouble(3, updatedJob.getBudget());
            stmt.setInt(4, id);

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("✅ Работа обновлена: " + updatedJob.getTitle());
            } else {
                System.out.println("⚠️ Работа с ID " + id + " не найдена.");
            }

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Ошибка при обновлении работы", e);
        }
    }

    // ✅ Удаление работы
    public void deleteJob(int id) {
        String sql = "DELETE FROM jobs WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, id);

            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("✅ Работа удалена (ID: " + id + ")");
            } else {
                System.out.println("⚠️ Работа с ID " + id + " не найдена.");
            }

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Ошибка при удалении работы", e);
        }
    }
}

