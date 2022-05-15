import entities.Address;
import entities.Town;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class Adding_A_New_Address_And_Updating_Employee_06 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        Scanner scanner = new Scanner(System.in);
        String addressText = "Vitoshka 15";

        Town town = new Town();
        town.setName("Denis town");
        entityManager.persist(town);

        Address address = new Address();
        address.setText(addressText);
        address.setTown(town);
        entityManager.persist(address);

        String lastName = scanner.nextLine();
        entityManager.createQuery(
                "UPDATE Employee AS e" +
                        " SET e.address = :address" +
                        " WHERE e.lastName = :name")
                .setParameter("address", address)
                .setParameter("name", lastName)
                .executeUpdate();

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
