import entities.Address;
import entities.User;
import orm.EntityManager;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

import static orm.MyConnector.createConnection;
import static orm.MyConnector.getConnection;

public class Main {
    public static void main(String[] args) throws SQLException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {
        createConnection("root", "denis", "custom_orm");
        Connection connection = getConnection();

        EntityManager<User> userEntityManager = new EntityManager<>(connection);

//        userEntityManager.createTable(User.class); // Create table
//        userEntityManager.alterTable(User.class);
//
//        User user = new User("Denis", 25, LocalDate.now());
//        userEntityManager.persist(user); // Add user

//        User searchedUser = userEntityManager.findFirst(User.class, "id = 1");
//        System.out.println(searchedUser);
//        System.out.println(userEntityManager.findFirst(User.class));

//        User user2 = new User("Alex", 30, LocalDate.now());
//        User user3 = new User("Kamen", 30, LocalDate.now());
//        User user4 = new User("Ivan", 30, LocalDate.now());
//        User user5 = new User("Maria", 30, LocalDate.now());
//        User user6 = new User("Petar", 30, LocalDate.now());
//        userEntityManager.persist(user2);
//        userEntityManager.persist(user3);
//        userEntityManager.persist(user4);
//        userEntityManager.persist(user5);
//        userEntityManager.persist(user6);

//        Iterable<User> users = userEntityManager.find(User.class, "id < 5"); // Print users with id < 5
//        users.forEach(System.out::println);

//        Iterable<User> users = userEntityManager.find(User.class);
//        users.forEach(System.out::println);
//        userEntityManager.find(User.class).forEach(System.out::println);

//        User userToDelete = userEntityManager.findFirst(User.class, "id = 2"); // Delete user with id = 2
//        userEntityManager.delete(userToDelete);

//        User userToUpdate = userEntityManager.findFirst(User.class, "id = 1");
//        userEntityManager.update(userToUpdate, "27");

//        EntityManager<Address> addressEntityManager = new EntityManager<>(connection);
//        addressEntityManager.createTable(Address.class);

        connection.close();
    }
}
