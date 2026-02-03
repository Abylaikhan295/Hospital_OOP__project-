package database;

import model.Doctor;
import java.sql.*;
import java.util.ArrayList;

public class DoctorDAO {

    public boolean insertDoctor(Doctor d) {
        String sql = "INSERT INTO doctors(name, age, department, specialization, experience, salary) VALUES(?,?,?,?,?,?)";

        Connection con = DatabaseConnection.getConnection();
        if (con == null) return false;

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, d.getName());
            statement.setInt(2, d.getAge());
            statement.setString(3, d.getDepartment());
            statement.setString(4, d.getSpecialization());
            statement.setInt(5, d.getExperienceYears());
            statement.setDouble(6, d.getSalary());

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(con);
        }
        return false;
    }

    public ArrayList<Doctor> getAllDoctors() {
        ArrayList<Doctor> list = new ArrayList<>();
        String sql = "SELECT * FROM doctors";

        Connection con = DatabaseConnection.getConnection();
        if (con == null) return list;

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                list.add(new Doctor(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("department"),
                        rs.getString("specialization"),
                        rs.getInt("experience"),
                        rs.getDouble("salary")
                ));
            }

            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(con);
        }
        return list;
    }

    public boolean updateDoctor(Doctor d) {
        String sql = "UPDATE doctors SET name=?, age=?, department=?, specialization=?, experience=?, salary=? WHERE id=?";

        Connection con = DatabaseConnection.getConnection();
        if (con == null) return false;

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, d.getName());
            statement.setInt(2, d.getAge());
            statement.setString(3, d.getDepartment());
            statement.setString(4, d.getSpecialization());
            statement.setInt(5, d.getExperienceYears());
            statement.setDouble(6, d.getSalary());
            statement.setInt(7, d.getId());

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(con);
        }
        return false;
    }

    public boolean deleteDoctor(int id) {
        String sql = "DELETE FROM doctors WHERE id=?";
        Connection con = DatabaseConnection.getConnection();
        if (con == null) return false;

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(con);
        }
        return false;
    }

    public Doctor getDoctorById(int id) {
        String sql = "SELECT * FROM doctors WHERE id=?";
        Connection con = DatabaseConnection.getConnection();
        if (con == null) return null;

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return new Doctor(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("department"),
                        rs.getString("specialization"),
                        rs.getInt("experience"),
                        rs.getDouble("salary")
                );
            }

            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(con);
        }
        return null;
    }

    public ArrayList<Doctor> searchByName(String name) {
        ArrayList<Doctor> list = new ArrayList<>();
        String sql = "SELECT * FROM doctors WHERE name ILIKE ?";

        Connection con = DatabaseConnection.getConnection();
        if (con == null) return list;

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, "%" + name + "%");
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                list.add(new Doctor(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("department"),
                        rs.getString("specialization"),
                        rs.getInt("experience"),
                        rs.getDouble("salary")
                ));
            }

            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(con);
        }

        return list;
    }

    public ArrayList<Doctor> searchBySalaryRange(double min, double max) {
        ArrayList<Doctor> list = new ArrayList<>();
        String sql = "SELECT * FROM doctors WHERE salary BETWEEN ? AND ? ORDER BY salary DESC";

        Connection con = DatabaseConnection.getConnection();
        if (con == null) return list;

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setDouble(1, min);
            statement.setDouble(2, max);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                list.add(new Doctor(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("department"),
                        rs.getString("specialization"),
                        rs.getInt("experience"),
                        rs.getDouble("salary")
                ));
            }

            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(con);
        }

        return list;
    }

    public Doctor getMaxSalaryDoctor() {
        String sql = "SELECT * FROM doctors ORDER BY salary DESC LIMIT 1";
        Connection con = DatabaseConnection.getConnection();
        if (con == null) return null;

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return new Doctor(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("department"),
                        rs.getString("specialization"),
                        rs.getInt("experience"),
                        rs.getDouble("salary")
                );
            }

            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(con);
        }

        return null;
    }
}
