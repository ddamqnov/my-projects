import javax.management.Query;
import javax.persistence.EntityTransaction;


public class UserDAO extends BaseDAO implements IUsersDAO{

	@Override
	public UserInformation add(String userName, String userPassword) {
		// TODO Auto-generated method stub
		
		UserInformation uf = new UserInformation();
		uf.setName(userName);
		uf.setPassword(userPassword);
		
		EntityTransaction t = getEntityManager().getTransaction();
		t.begin();
		getEntityManager().persist(uf);
		t.commit();
		
		return uf;	
	}

	@Override
	public UserInformation getUserById(String userId) {
		// TODO Auto-generated method stub
	    javax.persistence.Query q = getEntityManager().createQuery("select x from userinfo x where x=:userId");
	    q.setParameter("userId", userId);
	    return (UserInformation) q.getSingleResult();
	}

	@Override
	public UserInformation removeuserById(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInformation getUserByName(String userName) {
		// TODO Auto-generated method stub
		
		return null;
	}

}
