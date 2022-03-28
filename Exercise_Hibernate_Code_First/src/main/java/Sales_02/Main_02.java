package Sales_02;

import Sales_02.entities.Customer;
import Sales_02.entities.Product;
import Sales_02.entities.Sale;
import Sales_02.entities.StoreLocation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Main_02 {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercise");
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();

        Product product = new Product("Protein", 100, BigDecimal.TEN);
        Customer customer = new Customer("Ivan", "mail@mail.com", "123456789ASD");
        StoreLocation storeLocation = new StoreLocation("Billa");
        Sale sale = new Sale(product, customer, storeLocation, LocalDateTime.now());

        entityManager.persist(product);
        entityManager.persist(customer);
        entityManager.persist(storeLocation);
        entityManager.persist(sale);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
