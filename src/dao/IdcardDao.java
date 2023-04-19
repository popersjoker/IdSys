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
import table.Trash;


public class IdcardDao extends TableIDao{
	public static IdcardDao instance=null;
	public  static IdcardDao getInstance()
	{

	
			try {
				instance=new IdcardDao();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		return instance;
	
		
	}
	private IdcardDao() throws SQLException {
		super(new Idcard(null,null,null,null,null,null,null));
		// TODO Auto-generated constructor stub
	}
	public Idcard getIdcardTi() throws SQLException
	{
		return (Idcard)this.getTi();
	}
	public static List<Idcard> MakeSpecial(List<TableI>ls)
	{
		List<Idcard>s=new ArrayList<Idcard>();
		for(int i=0;i<ls.size();i++)
		{
			s.add((Idcard)ls.get(i));
		}
		return s;
	}

	public void FalseRemove() throws SQLException
	{
		this.ti=this.QuerySel();
		super.Remove();
		TrashDao dao=TrashDao.getInstance();
		Trash tr=dao.getTrashTi();
		
		tr.transfer(this.getIdcardTi());
		dao.Insert();
	}
	public void importFormExcel(File excelF,int sheetNo)
	{
		try {
			//久居兰室不闻其香 久居鲍市不闻其臭
			//User user=null;
			this.conn=Conn.getConnection();
			String sql="insert into idcard values(?,?,?,?,?,?,?)";
			stmt=this.conn.prepareStatement(sql);
			Workbook workbook=Workbook.getWorkbook(excelF);
			Sheet sheet=workbook.getSheet(sheetNo-1);
			int r=sheet.getRows();
			int c=sheet.getColumns();
			Idcard id=this.getIdcardTi();
			for(int i=1;i<r;i++)
			{
				
				for(int j=0;j<c;j++)
				{
					stmt.setString(j+1, sheet.getCell(j, i).getContents().trim());
				}
				if(id.getOwner()!=null)
				stmt.setString(7, id.getOwner());
			stmt.addBatch();
			}
			stmt.executeBatch();
			if(workbook!=null)workbook.close();
			Conn.free(null, stmt, rs);
		} catch (BiffException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void exportToFile(File path,String condition)
	{
		try {
			List<Idcard> ulist=MakeSpecial(this.QueryLike());
			WritableWorkbook book=Workbook.createWorkbook(path);
			WritableSheet sheet=book.createSheet("idcard", 0);
			String[] titles=new String[] {"编号","姓名","性别","账户","密码","邮箱","拥有者"};
			int col=titles.length;
			for(int i=0;i<col;i++)
			{
				sheet.addCell(new Label(i,0,titles[i]));
			}
			for(int i=1;i<=ulist.size();i++)
			{
				Idcard user=ulist.get(i-1);
				sheet.addCell(new Label(0,i,user.getId()));
				sheet.addCell(new Label(1,i,user.getName()));
				sheet.addCell(new Label(2,i,user.getSex()));
				sheet.addCell(new Label(3,i,user.getAccount()));
				sheet.addCell(new Label(4,i,user.getPswd()));
				sheet.addCell(new Label(5,i,user.getEmail()));
				sheet.addCell(new Label(6,i,user.getOwner()));
			}
			book.write();
			if(book!=null)book.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
