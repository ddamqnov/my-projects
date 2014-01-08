import javax.persistence.EntityManager;


public class BaseDAO {

	public EntityManager getEntityManager() {
		  return JPADaoFactory.createEntityManager();
	}  
}
