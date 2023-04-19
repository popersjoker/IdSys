package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import table.TableI;
import table.Message;

public class MessageDao extends TableIDao {
	public static MessageDao instance=null;
	public  static MessageDao getInstance()
	{
		

			try {
				instance=new MessageDao();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		return instance;
	}
	private MessageDao() throws SQLException {
		super(new Message(null,null,null,new Date()));
		// TODO Auto-generated constructor stub
	}
	public Message getMessageTi() throws SQLException
	{
		return (Message)this.getTi();
	}
	public static List<Message> MakeSpecial(List<TableI>ls)
	{
		List<Message>s=new ArrayList<Message>();
		for(int i=0;i<ls.size();i++)
		{
			s.add((Message)ls.get(i));
		}
		return s;
	}
}
