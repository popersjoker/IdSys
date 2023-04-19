package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IdcardDao;
import dao.UserDao;
import table.Idcard;
import table.SQL;
import table.User_;

/**
 * Servlet implementation class Add_user
 */
@WebServlet("/Add_user")
public class Add_user extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add_user() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String realname=request.getParameter("realname");
		UserDao dao=UserDao.getInstance();
		//SQL.bug();
		IdcardDao idao=IdcardDao.getInstance();
		try {
			User_ user=dao.getUserTi();
			user.setPassword(password);
			user.setUsername(username);
			user.setRealname(realname);
			dao.Insert();
			Idcard id=idao.getIdcardTi();
			id.setAccount(username);
			id.setPswd(password);
			id.setId("0");
			id.setOwner(username);
			id.setName(realname);
			idao.Insert();//新建用户时插入初始化名片
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			request.getRequestDispatcher("Register.jsp").forward(request, response);
			e.printStackTrace();
			
		}
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
