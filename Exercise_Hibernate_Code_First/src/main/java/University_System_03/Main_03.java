package University_System_03;

import University_System_03.entities.Course;
import University_System_03.entities.Person;
import University_System_03.entities.Student;
import University_System_03.entities.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Main_03 {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercise");
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();


        Student student = new Student("Ivan", "Ivanov", "1234567890", 4.88, 15);
        Teacher teacher = new Teacher("Pencho", "Penkov", "0987654321", "mail@mail.com", 15.49f);
        Course course = new Course("Java", "We love Java", LocalDate.now(), LocalDate.now(), 50, teacher);

        entityManager.persist(student);
        entityManager.persist(teacher);
        entityManager.persist(course);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
