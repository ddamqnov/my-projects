

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HiServlet
 */
@WebServlet("/HiServlet")
public class HiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */


	@PersistenceUnit(unitName = "HelloJPAWeb")
	private EntityManagerFactory emf;


	public HiServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String[] arrayData=request.getParameterValues("arrayData[]");
		for(int i=0;i<arrayData.length;i++){
			System.out.println(arrayData[i]);
		}

		
		UserDAO ud = new UserDAO();
		ud.add("Ivan", "petrov");
		UserInformation ui = ud.getUserById("1");
	    
		

//		EntityManager em = emf.createEntityManager();
		
		// And handle the trasnactions yourself
//		EntityTransaction tx = em.getTransaction();
//
//		tx.begin();
//
//
//		UserInformation uf = new UserInformation();
//		uf.setName(arrayData[0]);
//		uf.setPassword(arrayData[1]);
//		em.persist(uf);
//
//		tx.commit(); 
//
//
//
//		em.close();
	}

}
