package Hospital_04;

import Hospital_04.entities.Diagnose;
import Hospital_04.entities.Medicament;
import Hospital_04.entities.Patient;
import Hospital_04.entities.Visitation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Main_04 {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercise");
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();

        Patient patient = new Patient("Ivan", "Ivanov", "Sofia", "mail@mail.bg", LocalDate.now(), "pic_url", false);
        Diagnose diagnose = new Diagnose("Cold", "High temperature");
        Medicament medicament = new Medicament("Aspirin");
        Visitation visitation = new Visitation(LocalDate.now(), "Dr. John", patient, diagnose, medicament);

        entityManager.persist(patient);
        entityManager.persist(diagnose);
        entityManager.persist(medicament);
        entityManager.persist(visitation);


        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
