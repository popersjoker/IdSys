package servlet;

import java.io.File;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.ServletUtils;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

import dao.IdcardDao;
import table.Idcard;
import table.User_;


/**
 * Servlet implementation class FileSubmit
 */
@WebServlet("/daorudaochu")
public class Daorudaochu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Daorudaochu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action=request.getParameter("action");
		HttpSession session=request.getSession();
		User_ user=(User_)session.getAttribute("User");
		IdcardDao dao=IdcardDao.getInstance();
		Idcard id=null;
		try {
			id=dao.getIdcardTi();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		id.setName("%");
		id.setOwner(user.getUsername());
		if(action.equals("daoru")) {
		String saveDirectory=this.getServletContext().getRealPath("/file");
		File savedir =new File(saveDirectory);
		if(!savedir.exists()) {//上传路径不存在则创建它
			savedir.mkdirs();
		}
		
		int maxPostSize=100*1024*1024;//上传大小限制:5MB
		FileRenamePolicy policy=(FileRenamePolicy)new DefaultFileRenamePolicy();//防止文件重名后被覆盖
		response.setCharacterEncoding("GBK");
		PrintWriter out=response.getWriter();
		MultipartRequest multi;
		multi=new MultipartRequest(request,saveDirectory,maxPostSize,"utf-8",policy);
		Enumeration<String>files=multi.getFileNames();
		//int t=10;
		//out.println(files.hasMoreElements());
		while(files.hasMoreElements()) {
			String name=files.nextElement();//name request对应的parameter名字
			File f=multi.getFile(name);
			if(f!=null) {
				String fileName=multi.getFilesystemName(name);
				String lastFileName=saveDirectory+"\\"+fileName;
				out.println("上传的文件"+lastFileName+"<hr>+<a></a>");
				out.println("<hr>");
				dao.importFormExcel(f, 1);
			}
			
		}
		request.getRequestDispatcher("名片查询.jsp").forward(request, response);
		}
		else 
		{
			String saveDirectory=this.getServletContext().getRealPath("/file")+"/student.xls";
			
			dao.exportToFile(new File(saveDirectory), "");
			response.setContentType("application/octet-stream");
			String filename=new String("student.xls".getBytes("gbk"),"iso-8859-1");
			response.setHeader("Content-Disposition", "attachment;filename="+filename);
			ServletOutputStream out=null;
			out=response.getOutputStream();
			ServletUtils.returnFile(saveDirectory, out);
			new File(saveDirectory).delete();
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
