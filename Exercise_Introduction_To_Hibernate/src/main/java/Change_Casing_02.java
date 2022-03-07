import entities.Town;
import javax.persistence.*;
import java.util.List;

public class Change_Casing_02 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU_Name");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        Query from_town =
        entityManager.createQuery("FROM Town", Town.class);

        List<Town> resultList = from_town.getResultList();
        for (Town town : resultList) {
            String name = town.getName();

            if (name.length() <= 5) {
                String toUpper = name.toUpperCase();
                town.setName(toUpper);
                entityManager.persist(town);
            }
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}