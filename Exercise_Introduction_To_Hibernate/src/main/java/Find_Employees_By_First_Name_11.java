import entities.Employee;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class Find_Employees_By_First_Name_11 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU_Name");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        Scanner scanner = new Scanner(System.in);
        String pattern = scanner.nextLine();

        entityManager.createQuery("FROM Employee AS e" +
                                " WHERE e.firstName" +
                                " LIKE :employeeName",
                        Employee.class)
                .setParameter("employeeName", pattern + "%")
                .getResultList()
                .forEach(e ->
                        System.out.printf("%s %s - %s -($%.2f)%n",
                                e.getFirstName(),
                                e.getLastName(),
                                e.getJobTitle(),
                                e.getSalary()));

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
