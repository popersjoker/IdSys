package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import table.TableI;
import table.User_;

/**
 * Servlet implementation class Check_login
 */
@WebServlet("/Check_login")
public class Check_login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Check_login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		UserDao dao=UserDao.getInstance();
		boolean islogin=false;
		User_ user=null;
		TableI ti=null;
		try {
		    user=dao.getUserTi();
			user.setPassword(password);
			user.setUsername(username);
			islogin=((ti=dao.QuerySel())!=null);
			if(ti!=null)user=(User_) ti;
			if(islogin)
			{
				if(!user.getPassword().equals(password))
					islogin=false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(islogin)
		{
			session.setAttribute("User", ti);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		else 
		{
			request.setAttribute("msg", "检查你的账户和密码");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
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
