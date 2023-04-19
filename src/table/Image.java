package table;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Image extends TableI {
	private String username,Path;
	
	public Image(String username, String path) {
		super("image","(username varchar(10) references User_(username),path varchar(200) default 'demo.jpeg')");
		this.username = username;
		Path = path;
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPath() {
		
		return Path;
	}

	public void setPath(String path) {
		if(path==null)path="demo.jpeg";
		Path = path;
	}

	@Override
	public ArrayList<String> getInitArr_(int ch, boolean eq) {
		// TODO Auto-generated method stub
		 ArrayList<String> arr = new ArrayList<String>();
		    String str = "";
		    if ((ch & 0x1) == 1) { if (eq) str = String.valueOf((String)this.outlook.get(0)) + "=";  arr.add(String.valueOf(str) + FS(this.username)); }
		    if ((ch & 0x2) != 0) { if (eq) str = String.valueOf((String)this.outlook.get(1)) + "=";  arr.add(String.valueOf(str) + FS(this.Path)); }
		    return arr;
	}

	@Override
	public String tr(String paramString1, String paramString2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TableI Maker(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return new Image(rs.getString("username"),rs.getString("path"));
	}

	@Override
	public String head() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String QuerySel() {
		// TODO Auto-generated method stub
		return SQL.quy(super.getColStr(3), this.tableName, super.getWhereStr_(1));
	}

	@Override
	public String DeleteSel() {
		// TODO Auto-generated method stub
		return SQL.rev(tableName, super.getWhereStr_(1));
	}

	@Override
	public String InsertNew() {
		// TODO Auto-generated method stub
		return SQL.add(tableName, getInitStr_(), super.getParamSet(3));
	}

	@Override
	public String UpdateNew() {
		// TODO Auto-generated method stub
		return SQL.upt(tableName, getSetStr_(2), super.getWhereStr_(1));
	}

}
