import entities.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Addresses_With_Employee_Count_07 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU_Name");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        int limit = 10;

        entityManager
                .createQuery("FROM Address AS a" +
                                " ORDER BY a.employees.size DESC",
                        Address.class)
                .setMaxResults(limit)
                .getResultStream()
                .forEach(a -> {
                    String out = String.format("%s, %s - %d employees", a.getText(), a.getTown().getName(), a.getEmployees().size());
                    System.out.println(out);
                });

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
