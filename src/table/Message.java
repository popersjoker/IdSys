package table;

import java.sql.ResultSet;


import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Message extends TableI {
	private String sender,receiver,message;
	private java.util.Date time;
	
	public Message( String sender, String receiver, String message, Date time) {
		super("message", "(sender varchar(10) references User_(username),receiver varchar(10) references User_(username),message varchar(100),time datetime)");
		this.sender = sender;
		this.receiver = receiver;
		this.message = message;
		this.time = time;
	}

	@Override
	public ArrayList<String> getInitArr_(int ch, boolean eq) {
		// TODO Auto-generated method stub
		 ArrayList<String> arr = new ArrayList<String>();
		    String str = "";
		    if ((ch & 0x1) == 1) { if (eq) str = String.valueOf((String)this.outlook.get(0)) + "=";  arr.add(String.valueOf(str) + FS(this.sender)); }
		    if ((ch & 0x2) != 0) { if (eq) str = String.valueOf((String)this.outlook.get(1)) + "=";  arr.add(String.valueOf(str) + FS(this.receiver)); }
		    if ((ch & 0x4) != 0) { if (eq) str = String.valueOf((String)this.outlook.get(2)) + "=";  arr.add(String.valueOf(str) + FS(this.message)); }
		    if ((ch & 0x8) != 0) { if (eq) str = String.valueOf((String)this.outlook.get(3)) + "=";  arr.add(String.valueOf(str) + "str_to_date(" + "'" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(this.time) + "'" + ",'%Y-%m-%d %H:%i:%s')"); }
		  return arr;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public java.util.Date getTime() {
		return time;
	}

	public void setTime(java.util.Date time) {
		this.time = time;
	}

	@Override
	public String tr(String paramString1, String paramString2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TableI Maker(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return new Message(rs.getString("sender"),rs.getString("receiver"),rs.getString("message"),rs.getTimestamp("time"));
	}

	@Override
	public String head() {
return null;
	}

	@Override
	public String QuerySel() {
		// TODO Auto-generated method stub
		return SQL.quy(super.getColStr(13), this.tableName, this.getWhereStr_(2));
	}

	@Override
	public String DeleteSel() {
		// TODO Auto-generated method stub
		return SQL.rev(tableName, super.getWhereStr_(11));
	}

	@Override
	public String InsertNew() {
		// TODO Auto-generated method stub
		return SQL.add(tableName, super.getInitStr_(), super.getParamSet(15));
	}

	@Override
	public String UpdateNew() {
		// TODO Auto-generated method stub
		return SQL.upt(tableName, super.getSetStr_(4), super.getWhereStr_(3));
	}

}
