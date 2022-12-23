import entities.User;
import orm.EntityManager;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import static orm.MyConnector.*;

public class Main {
    public static void main(String[] args) throws SQLException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {
        // CREATE DATABASE custom_orm;

        Connection connection = getConnection("root", "denis", "custom_orm");

        EntityManager<User> userEntityManager = new EntityManager<>(connection);

        // CREATE_TABLE(userEntityManager);

        // INSERT_USER(userEntityManager);

        // INSERT_UPDATE(userEntityManager);

        // UPDATE_USER(userEntityManager);

        // DELETE_USER(userEntityManager);

        // ADD_NEW_FIELD(userEntityManager);

        // FIND_FIRST_USER(userEntityManager); // Find first user

        // FIND_FIRST_USER_WHERE(userEntityManager); // Find first user where age = 25

        // FIND_USER_WHERE(userEntityManager); // Find user with id = 1

        // FIND_USER_WHERE_2(userEntityManager);

        // FIND_USER(userEntityManager);

        closeConnection();
    }

    private static void FIND_USER(EntityManager<User> userEntityManager) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        userEntityManager.find(User.class).forEach(System.out::println);
    }

    private static void FIND_USER_WHERE_2(EntityManager<User> userEntityManager) throws SQLException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        userEntityManager.find(User.class, "id < 5")
                .stream()
                .forEach(System.out::println); // Print users with id < 5
    }

    private static void UPDATE_USER(EntityManager<User> userEntityManager) throws SQLException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        User userToUpdate = userEntityManager.find(User.class, "id = 10").get(0); // Update user with id = 10
        userEntityManager.update(userToUpdate, "50");
    }

    private static void FIND_USER_WHERE(EntityManager<User> userEntityManager) throws SQLException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        System.out.println(userEntityManager.find(User.class, "id = 8").get(0));
    }

    private static void FIND_FIRST_USER_WHERE(EntityManager<User> userEntityManager) throws SQLException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        System.out.println(userEntityManager.findFirst(User.class, "age = 25"));
    }

    private static void FIND_FIRST_USER(EntityManager<User> userEntityManager) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        System.out.println(userEntityManager.findFirst(User.class));
    }

    private static void ADD_NEW_FIELD(EntityManager<User> userEntityManager) throws SQLException {
        // If we add new column to a class, we use this method to add it to the DB
        userEntityManager.alterTable(User.class);
    }

    private static void INSERT_UPDATE(EntityManager<User> userEntityManager) throws IllegalAccessException, SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException {
        User user = userEntityManager.find(User.class, "id = 10").get(0);
        user.setUsername("No name");
        userEntityManager.persist(user);
    }

    private static void DELETE_USER(EntityManager<User> userEntityManager) throws SQLException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        User userToDelete = userEntityManager.find(User.class, "id = 10").get(0); // Delete user with id = 10
        userEntityManager.delete(userToDelete);
    }

    private static void INSERT_USER(EntityManager<User> userEntityManager) throws IllegalAccessException, SQLException {
        for (int i = 0; i < 10; i++) {
            User user = new User("User - " + i, 20 + i, LocalDate.of(2022, 5, 1 + i));
            userEntityManager.persist(user);
        }
    }

    private static void CREATE_TABLE(EntityManager<User> userEntityManager) throws SQLException {
        userEntityManager.createTable(User.class);
    }
}
