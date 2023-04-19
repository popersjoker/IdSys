package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import table.Idcard;
import table.SQL;
import table.TableI;
import table.Trash;

public class TrashDao extends TableIDao{
	public static TrashDao instance=null;
	public static TrashDao getInstance()
	{

		
			try {
				instance=new TrashDao();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		return instance;
	}
	private TrashDao() throws SQLException {
		super(new Trash(null,null,null,null,null,null,null));
		// TODO Auto-generated constructor stub
	}
	public Trash getTrashTi() throws SQLException
	{
		return (Trash)this.getTi();
	}
	
	public void FalseRemove() throws SQLException
	{
		this.ti=this.QuerySel();
		super.Remove();
		IdcardDao dao=IdcardDao.getInstance();
		Idcard tr=dao.getIdcardTi();
		tr.transfer(this.getTrashTi());
		dao.Insert();
	}
	public static List<Trash> MakeSpecial(List<TableI>ls)
	{
		List<Trash>s=new ArrayList<Trash>();
		for(int i=0;i<ls.size();i++)
		{
			s.add((Trash)ls.get(i));
		}
		return s;
	}
	
}
