package models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FreelancerDAO {
    private static final Logger LOGGER = Logger.getLogger(FreelancerDAO.class.getName());

    // ✅ Добавление фрилансера
    public void addFreelancer(Freelancer freelancer) throws UserExistsException {
        String sql = "INSERT INTO freelancers (name, specialty, rating, email) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            if (emailExists(freelancer.getEmail())) {
                throw new UserExistsException("Фрилансер с email " + freelancer.getEmail() + " уже существует!");
            }

            stmt.setString(1, freelancer.getName());
            stmt.setString(2, freelancer.getSpecialty());
            stmt.setDouble(3, freelancer.getRating());
            stmt.setString(4, freelancer.getEmail());

            stmt.executeUpdate();
            System.out.println("✅ Фрилансер добавлен: " + freelancer.getName());

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Ошибка при работе с базой данных", e);
        }
    }

    // ✅ Проверка, существует ли email в базе
    private boolean emailExists(String email) throws SQLException {
        String sql = "SELECT COUNT(*) FROM freelancers WHERE email = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, email);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        }
        return false;
    }

    // ✅ Получение списка всех фрилансеров
    public List<Freelancer> getAllFreelancers() {
        List<Freelancer> freelancers = new ArrayList<>();
        String sql = "SELECT * FROM freelancers";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Freelancer freelancer = new Freelancer(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("specialty"),
                        rs.getDouble("rating"),
                        rs.getString("email")
                );
                freelancers.add(freelancer);
            }

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Ошибка при работе с базой данных", e);
        }

        return freelancers;
    }

    // ✅ Обновление фрилансера
    public void updateFreelancer(int id, Freelancer updatedFreelancer) {
        String sql = "UPDATE freelancers SET name = ?, specialty = ?, rating = ?, email = ? WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, updatedFreelancer.getName());
            stmt.setString(2, updatedFreelancer.getSpecialty());
            stmt.setDouble(3, updatedFreelancer.getRating());
            stmt.setString(4, updatedFreelancer.getEmail());
            stmt.setInt(5, id);

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("✅ Фрилансер обновлен: " + updatedFreelancer.getName());
            } else {
                System.out.println("⚠️ Фрилансер с ID " + id + " не найден.");
            }

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Ошибка при обновлении фрилансера", e);
        }
    }

    // ✅ Удаление фрилансера
    public void deleteFreelancer(int id) {
        String sql = "DELETE FROM freelancers WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, id);

            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("✅ Фрилансер удален (ID: " + id + ")");
            } else {
                System.out.println("⚠️ Фрилансер с ID " + id + " не найден.");
            }

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Ошибка при удалении фрилансера", e);
        }
    }
}
