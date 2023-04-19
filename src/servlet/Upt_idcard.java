package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IdcardDao;
import table.Idcard;

/**
 * Servlet implementation class Upt_idcard
 */
@WebServlet("/Upt_idcard")
public class Upt_idcard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Upt_idcard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String sex=request.getParameter("sex");
		String account=request.getParameter("account");
		String email=request.getParameter("email");
		String pswd=request.getParameter("pswd");
		String owner=request.getParameter("owner");
		IdcardDao dao=IdcardDao.getInstance();
		try {
			Idcard id_=dao.getIdcardTi();
			id_.setEmail(email);
			id_.setId(id);
			id_.setName(name);
			id_.setOwner(owner);
			id_.setPswd(pswd);
			id_.setSex(sex);
			id_.setAccount(account);
			
			dao.Update();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("名片查询.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
