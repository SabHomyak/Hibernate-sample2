import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    static EntityManagerFactory emf;
    static EntityManager em;

    public static void main(String[] args) {
        try {
            emf = Persistence.createEntityManagerFactory("JPATest");
            em = emf.createEntityManager();
            try {
                em.getTransaction().begin();
                People people1 = new People("Peoples");
                people1.addPerson(new Person("John", 12));
                people1.addPerson(new Person("Jack", 13));
                people1.addPerson(new Person("George", 15));
                em.merge(people1);
                em.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
                em.getTransaction().rollback();
            }
        } finally {
            emf.close();
            em.close();
        }
    }
}
