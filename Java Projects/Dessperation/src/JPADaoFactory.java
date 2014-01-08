import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class JPADaoFactory {
	 
	  private static final String PERSISTENCE_UNIT_NAME = "HelloJPAWeb";
	 
	  private static EntityManagerFactory entityManagerFactory;
	  private static EntityManager entityManager;
	 
	  /**
	   * Returns reference to EntityManager instance. If null then create it
	   * using the persistence unit name as defined in the persistence.xml
	   *
	   * @return EntityManager
	   */
	  public static EntityManager createEntityManager() {
	 
	   if(entityManager == null) {
	     entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	     entityManager = entityManagerFactory.createEntityManager();
	   }
	   return entityManager;
	  }
	 
	  public static void close() {
	   entityManager.close();
	   entityManagerFactory.close();
	  }
}
	 
