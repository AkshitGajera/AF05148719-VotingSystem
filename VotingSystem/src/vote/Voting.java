package vote;
import java.sql.*;
import java.util.Scanner;

public class Voting {

    public static void vote() {
        try (Connection con = DBConnection.getConnection();
             Statement stmt = con.createStatement();
             Scanner sc = new Scanner(System.in)) {

            // Display candidates
            ResultSet rs = stmt.executeQuery("SELECT * FROM candidate");
            System.out.println("Candidates:");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + ". " + rs.getString("name"));
            }

            // Vote
            System.out.print("Enter candidate ID to vote: ");
            int id = sc.nextInt();
            stmt.executeUpdate("UPDATE candidate SET votes = votes + 1 WHERE id = " + id);

            System.out.println("Vote cast successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void showResults() {
        try (Connection con = DBConnection.getConnection();
             Statement stmt = con.createStatement()) {

            ResultSet rs = stmt.executeQuery("SELECT * FROM candidate");
            System.out.println("\nVoting Results:");
            while (rs.next()) {
                System.out.println(rs.getString("name") + " : " + rs.getInt("votes") + " votes");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}