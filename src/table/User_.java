package table;
/*     */ 
/*     */ //import element.Box;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class User_
/*     */   extends TableI
/*     */ {
/*     */   private String username;
/*     */   private String password;
/*     */   private short role;
/*     */ 	private String realname;
/*     */   
/*     */   public User_(String username, String password, short role,String realname) {
/*  22 */     super("User_", "(username varchar(10),password varchar(10),role smallint,realname varchar(20))");
/*  23 */     this.username = username;
/*  24 */     this.password = password;
/*  25 */     this.role = role;
			  this.realname=realname;
/*  26 */  //   this.rebook = rebook;
/*     */   }
/*     */ 
//			@Override
//			protected String FS(String str) { return "'" + MD5.encrypt(str) + "'"; }//字符串加密
/*     */   
/*  30 */   public String getUsername() { return this.username; }
/*     */ 
/*     */   
/*  33 */   public void setUsername(String username) { this.username = username; }
/*     */ 
/*     */   
/*  36 */   public String getPassword() { return this.password; }
/*     */ 
/*     */   
/*  39 */   public void setPassword(String password) { this.password = password; }
/*     */ 
/*     */   
/*  42 */   public short getRole() { return this.role; }
/*     */ 
/*     */   
/*  45 */   public void setRole(short role) { this.role = role; }
/*     */ 
/*     */   
///*  48 */   public short getRebook() { return this.rebook; }
///*     */ 
///*     */   
///*  51 */   public void setRebook(short rebook) { this.rebook = rebook; }
/*     */ 
/*     */ 
/*     */   
/*  55 */   private String whichRole(short t) { return (t == 1) ? "管理员" : "普通用户"; }
/*     */ 
/*     */   
/*     */   public String head() {
/*  59 */     return null;
/*     */   }
/*     */ 
/*     */   
/*  67 */   public String tr(String anmae, String src) { return null; }
/*     */ 
/*     */ 
/*     */   
/*  71 */   public TableI Maker(ResultSet rs) throws SQLException { return new User_(rs.getString("username"), rs.getString("password"), rs.getShort("role"),rs.getString("realname")); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrayList<String> getInitArr_(int ch, boolean eq) {
/*  77 */     ArrayList<String> arr = new ArrayList<String>();
/*  78 */     String str = "";
/*  79 */     if ((ch & 0x1) == 1) { if (eq) str = String.valueOf((String)this.outlook.get(0)) + "=";  arr.add(String.valueOf(str) + FS(this.username)); }
/*  80 */      if ((ch & 0x2) != 0) { if (eq) str = String.valueOf((String)this.outlook.get(1)) + "=";  arr.add(String.valueOf(str) + FS(this.password)); }
/*  81 */      if ((ch & 0x4) != 0) { if (eq) str = String.valueOf((String)this.outlook.get(2)) + "=";  arr.add(String.valueOf(str) + this.role); }
/*  82 */      if ((ch & 8) != 0) { if (eq) str = String.valueOf((String)this.outlook.get(3)) + "=";  arr.add(String.valueOf(str) + FS(this.realname)); }
/*  83 */      return arr;
/*     */   }
public String getRealname() {
	return realname;
}
public void setRealname(String realname) {
	this.realname = realname;
}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  95 */   public String QuerySel() { return SQL.quy(getColStr(15), this.tableName, getWhereStr_(1)); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 100 */   public String DeleteSel() { return SQL.rev(this.tableName, getWhereStr_(1)); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 106 */   public String InsertNew() { return SQL.add(this.tableName, getInitStr_(), getParamSet(15)); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 111 */   public String UpdateNew() { return SQL.upt(this.tableName, getSetStr_(15), getWhereStr_(1)); }
/*     */ }


/* Location:              C:\Users\lenovo\eclipse-workspace\JavaEE_\src\jdkDynamicProxy\dasds.jar!/User_.class
 * Java compiler version: 14 (58.0)
 * JD-Core Version:       1.0.7
 */