package Bills_Payment_System_05;

import Bills_Payment_System_05.entities.BillingDetail;
import Bills_Payment_System_05.entities.User;
import Bills_Payment_System_05.enums.BillingDetailType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main_05 {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercise");
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();

        User user = new User("Ivan", "Ivanov", "mail@mail.bg");
        BillingDetail billingDetail1 = new BillingDetail(123456789, user, BillingDetailType.BANK_ACCOUNT);
        BillingDetail billingDetail2 = new BillingDetail(1234567890, user, BillingDetailType.CREDIT_CARD);

        entityManager.persist(user);
        entityManager.persist(billingDetail1);
        entityManager.persist(billingDetail2);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
