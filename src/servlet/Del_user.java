package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IdcardDao;
import dao.TrashDao;
import dao.UserDao;
import table.Idcard;
import table.SQL;
import table.Trash;
import table.User_;

/**
 * Servlet implementation class Del_user
 */
@WebServlet("/Del_user")
public class Del_user extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Del_user() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=request.getParameter("username");
		UserDao dao=UserDao.getInstance();
		IdcardDao id=IdcardDao.getInstance();
		TrashDao td=TrashDao.getInstance();
		List<Idcard>ls;
		List<Trash>trs;
		Idcard id_ = null;
		Trash tr=null;
		try {
		    tr=td.getTrashTi();
			
			id_ = id.getIdcardTi();
			User_ user=dao.getUserTi();
			id_.setName("%");
			ls=id.MakeSpecial(id.QueryAll());
			user.setUsername(username);
			id_.setOwner(username);
			dao.Remove();
			Idcard tool=null;
			for(int i=0;i<ls.size();i++)
			{
				tool=ls.get(i);
				id_.setId(tool.getId());
				id.Remove();
			}
			tr.setName("%");
			trs=TrashDao.MakeSpecial(td.QueryAll());
			tr.setOwner(username);
			Trash tro=null;
			for(int i=0;i<trs.size();i++)
			{
				tro=trs.get(i);
				tr.setId(tro.getId());
				td.Remove();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("用户查询.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
