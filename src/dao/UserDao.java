package dao;

import java.io.File;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import table.Conn;
import table.Idcard;
import table.TableI;
import table.User_;

public class UserDao extends TableIDao {
	public static UserDao instance=null;
	public  static UserDao getInstance()
	{
		
		
			try {
				instance=new UserDao();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		return instance;
	}
	private UserDao() throws SQLException {
		super(new User_(null,null,(short)0,null));
		// TODO Auto-generated constructor stub
	}
	public User_ getUserTi() throws SQLException
	{
		return (User_)this.getTi();
	}
	public static List<User_> MakeSpecial(List<TableI>ls)
	{
		List<User_>s=new ArrayList<User_>();
		for(int i=0;i<ls.size();i++)
		{
			s.add((User_)ls.get(i));
		}
		return s;
	}
	
}
