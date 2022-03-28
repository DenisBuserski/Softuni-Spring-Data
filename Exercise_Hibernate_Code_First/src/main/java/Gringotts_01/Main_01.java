package Gringotts_01;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

public class Main_01 {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercise");
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();


        WizardDeposits wizard = new WizardDeposits(
                "Gandalf",
                "The White",
                "Can kill anyone",
                55,
                "asd",
                (short) 11,
                "Camelot",
                LocalDateTime.now(),
                BigDecimal.valueOf(3.14),
                BigDecimal.valueOf(95.92),
                BigDecimal.valueOf(12.37),
                LocalDateTime.of(2022, Month.DECEMBER, 12, 21, 24, 37),
                false
                );

        entityManager.persist(wizard);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
