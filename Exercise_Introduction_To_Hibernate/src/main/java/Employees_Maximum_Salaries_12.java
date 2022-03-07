import entities.Employee;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Comparator;

public class Employees_Maximum_Salaries_12 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU_Name");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        StringBuilder output = new StringBuilder();

        entityManager.createQuery("SELECT e" +
                        " FROM Employee e" +
                        " WHERE e.salary NOT BETWEEN 30000 AND 70000" +
                        " GROUP BY e.department" +
                        " ORDER BY e.salary DESC",
                        Employee.class)
                .getResultList()
                .stream()
                .sorted(Comparator.comparing(e -> e.getDepartment().getId()))
                .forEach(e ->
                        output.append(String.format("%s %.2f%n",
                        e.getDepartment().getName(),
                                e.getSalary())));

        System.out.println(output.toString().trim());

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
