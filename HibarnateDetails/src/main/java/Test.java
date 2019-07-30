import org.hibernate.Session;
import sun.management.HotspotInternal;

public class Test {
    public static void main(String[] args) {
        Department department = new Department("managers");

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(department);
        session.getTransaction().commit();

    }

}
