import entities.Project;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public class Find_Latest_10_Projects_09 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU_Name");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.createQuery("SELECT p " +
                        " FROM Project AS p" +
                        " ORDER BY p.startDate DESC",
                        Project.class)
                .setMaxResults(10)
                .getResultList()
                .stream().sorted(Comparator.comparing(Project::getName))
                .forEach(
                        p ->
                                System.out.println("Project name: " + p.getName() + System.lineSeparator() +
                                        "\tProject Description: " + p.getDescription() + System.lineSeparator() +
                                        "\tProject Start Date: " + getCurrentTimeStamp(p.getStartDate()) + System.lineSeparator() +
                                        "\tProject End Date: " + getCurrentTimeStamp(p.getEndDate()) + System.lineSeparator()));

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static String getCurrentTimeStamp(LocalDateTime dateTime) {
        if (dateTime == null) {
            return null;
        }
        return dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss.S"));
    }
}
