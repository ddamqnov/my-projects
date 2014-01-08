
public interface IUsersDAO {

	public UserInformation add(String userName,String userPassword);
	public UserInformation getUserById(String userId);
	public UserInformation removeuserById(String userId);
	public UserInformation getUserByName(String userName);


}
