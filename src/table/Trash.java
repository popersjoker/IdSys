package table;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Trash extends TableI {
/*
 * 
 * */
	protected String id,name,sex,account,pswd,email,owner;

	public Trash(String id, String name, String sex, String account, String pswd,
		String email,String owner) {
	super("Trash", "(id varchar(30) primary key,name varchar(30),sex varchar(4),account varchar(30) references user(username),pswd varchar(30) references user(password),email varchar(20),owner varchar(20) references user(username))");
	this.id = id;this.owner=owner;
	this.name = name;
	this.sex = sex;
	
	this.account = account;
	this.pswd = pswd;
	this.email = email;
}

	@Override
	public ArrayList<String> getInitArr_(int ch, boolean eq) {
		// TODO Auto-generated method stub
		 ArrayList<String> arr = new ArrayList<String>();
		    String str = "";
		    if ((ch & 0x1) == 1) { if (eq) str = String.valueOf((String)this.outlook.get(0)) + "=";  arr.add(String.valueOf(str) + FS(this.id)); }
		    if ((ch & 0x2) != 0) { if (eq) str = String.valueOf((String)this.outlook.get(1)) + "=";  arr.add(String.valueOf(str) + FS(this.name)); }
		    if ((ch & 0x4) != 0) { if (eq) str = String.valueOf((String)this.outlook.get(2)) + "=";  arr.add(String.valueOf(str) + FS(this.sex)); }
		    if ((ch & 0x8) != 0) { if (eq) str = String.valueOf((String)this.outlook.get(3)) + "=";  arr.add(String.valueOf(str) + FS(this.account)); }
		    if ((ch & 16) != 0) { if (eq) str = String.valueOf((String)this.outlook.get(4)) + "=";  arr.add(String.valueOf(str) + FS(this.pswd)); }
		    if ((ch & 32) != 0) { if (eq) str = String.valueOf((String)this.outlook.get(5)) + "=";  arr.add(String.valueOf(str) + FS(this.email)); }

		    if ((ch & 64) != 0) { if (eq) str = String.valueOf((String)this.outlook.get(6)) + "=";  arr.add(String.valueOf(str) + FS(this.owner)); }
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
		return new Trash(rs.getString("id"),rs.getString("name"),rs.getString("sex"),rs.getString("account"),rs.getString("pswd"),rs.getString("email"),rs.getString("owner"));
	}
	
	@Override
	public String head() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String QuerySel() {
		// TODO Auto-generated method stub
		return SQL.quy(super.getColStr(127), this.tableName, super.getWhereStr_(65));
	}

	@Override
	public String DeleteSel() {
		// TODO Auto-generated method stub
		return SQL.rev(tableName, super.getWhereStr_(65));
	}

	@Override
	public String InsertNew() {
		// TODO Auto-generated method stub
		return SQL.add(tableName, super.getInitStr_(),super.getParamSet(127));
	}

	@Override
	public String UpdateNew() {
		// TODO Auto-generated method stub
		return SQL.upt(tableName, super.getSetStr_(126), super.getWhereStr_(65));
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void transfer(Idcard id_)
	{
		this.owner=id_.getOwner();
		this.sex=id_.getSex();
		this.id=id_.getId();
		this.email=id_.getEmail();
		this.account=id_.getAccount();
		this.pswd=id_.getPswd();
		this.name=id_.getName();
		System.err.println(id_.getName());
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
	@Override 
	public String QueryAll()
	{
		return SQL.quy(super.getColStr(0), tableName,super.getWhereStr_(2).replace("=", " Like "));
	}
	 


}
