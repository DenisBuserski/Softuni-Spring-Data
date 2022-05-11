import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Increase_Minions_Age_08 {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        String [] minionsIds = scanner.nextLine().split("\\s+");

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", properties);

        for (String minionsId : minionsIds) {
            PreparedStatement updateMinionsNames = connection.prepareStatement
                    ("UPDATE minions" +
                            " SET name = LOWER(name)" +
                            " WHERE id = ?;");
            updateMinionsNames.setString(1, minionsId);
            updateMinionsNames.executeUpdate();
        }

        for (String minionsId : minionsIds) {
            PreparedStatement updateMinionsAges = connection.prepareStatement
                    ("UPDATE minions" +
                            " SET age = age + 1" +
                            " WHERE id = ?;");
            updateMinionsAges.setString(1, minionsId);
            updateMinionsAges.executeUpdate();
        }


        checkResult(connection);

        connection.close();
    }

    private static void checkResult(Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement
                ("SELECT" +
                        " name," +
                        " age" +
                        " FROM minions;");
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            String minionName = resultSet.getString("name");
            int minionAge= resultSet.getInt("age");
            System.out.println(minionName + " " + minionAge);
        }
    }
}