package table;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ public abstract class TableI {
/*     */   protected String tableName;
/*     */   protected ArrayList<String> outlook;
/*     */   protected String InitTable;
/*     */   
/*     */   public TableI(String tableName, String InitTable) {
/*  12 */     this.outlook = new ArrayList();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  17 */     this.InitTable = InitTable;
/*  18 */     this.tableName = tableName;
/*  19 */     String trs = InitTable.substring(1, InitTable.length() - 1);
/*  20 */     String[] spt = trs.split(",");
/*  21 */     for (int i = 0; i < spt.length; i++)
/*     */     {
/*  23 */       this.outlook.add(spt[i].split(" ")[0]);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  29 */   public String getTableName() { return this.tableName; }
/*     */ 
/*     */   
/*  32 */   public void setTableName(String tableName) { this.tableName = tableName; }
/*     */ 
/*     */   
/*  35 */   public String getInitTable() { return this.InitTable; }
/*     */ 
/*     */   
/*  38 */   public void setInitTable(String initTable) { this.InitTable = initTable; }
/*     */   
/*     */   public abstract ArrayList<String> getInitArr_(int paramInt, boolean paramBoolean);
/*     */   
/*     */   public String getColStr(int ch) {
/*  43 */     String init = "";
/*  44 */     for (int i = 0; i < this.outlook.size(); i++) {
/*     */       
/*  46 */       if (i != 0) init = String.valueOf(init) + ","; 
/*  47 */       init = String.valueOf(init) + (String)this.outlook.get(i);
/*     */     } 
/*  49 */     return (new StringBuilder(String.valueOf(init))).toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getInitStr_() {
/*  54 */     String init = "(";
/*  55 */     for (int i = 0; i < this.outlook.size(); i++) {
/*     */       
/*  57 */       if (i != 0) init = String.valueOf(init) + ","; 
/*  58 */       init = String.valueOf(init) + (String)this.outlook.get(i);
/*     */     } 
/*  60 */     return String.valueOf(init) + ")";
/*     */   }
/*     */   
/*     */   public String getParamSet(int ch) {
/*  64 */     ArrayList<String> arr = getInitArr_(ch, false);
/*  65 */     String init = "(";
/*  66 */     for (int i = 0; i < arr.size(); i++) {
/*     */       
/*  68 */       if (i != 0) init = String.valueOf(init) + ","; 
/*  69 */       init = String.valueOf(init) + (String)arr.get(i);
/*     */     } 
/*  71 */     return String.valueOf(init) + ")";
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSetStr_(int ch) {
/*  76 */     ArrayList<String> arr = getInitArr_(ch, true);
/*  77 */     String init = "";
/*  78 */     for (int i = 0; i < arr.size(); i++) {
/*     */       
/*  80 */       if (i != 0) init = String.valueOf(init) + ","; 
/*  81 */       init = String.valueOf(init) + (String)arr.get(i);
/*     */     } 
/*  83 */     return (new StringBuilder(String.valueOf(init))).toString();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  88 */ 
public String QueryLike()
{
	return SQL.quy(this.getColStr(0),this.tableName,this.getWhereStr_(2)).replace("=", " like ")+" And "+this.getWhereStr_(64);
}
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhereStr_(int ch) {
/*  93 */     if (ch == 0) return "true"; 
/*  94 */     ArrayList<String> arr = getInitArr_(ch, true);
/*  95 */     String init = "";
/*  96 */     for (int i = 0; i < arr.size(); i++) {
/*     */       
/*  98 */       if (i != 0) init = String.valueOf(init) + " and "; 
/*  99 */       init+=arr.get(i);
/*     */     } 

/* 101 */     return init;
/*     */   }
/*     */ 
/*     */   
/* 105 */   public String getForm(String action, String submit) { return tr(submit, action); }
/*     */   
/*     */   public abstract String tr(String paramString1, String paramString2);
/*     */   
/*     */   public abstract TableI Maker(ResultSet paramResultSet) throws SQLException;
/*     */   
/*     */   public abstract String head();
/*     */   
/* 113 */   protected String FS(String str) { return "'" + str + "'"; }//字符串加密
/*     */ 
/*     */ 
/*     */   
/* 117 */   public String QueryAll() { return "select * from " + getTableName(); }
/*     */   
/*     */   public abstract String QuerySel();
/*     */   
/*     */   public abstract String DeleteSel();
/*     */   
/*     */   public abstract String InsertNew();
/*     */   
/*     */   public abstract String UpdateNew();

			public  String limit(int page,int pageC)
			{
				return SQL.limit(this.QueryLike(), page, pageC);
			}
/*     */ }


/* Location:              C:\Users\lenovo\eclipse-workspace\JavaEE_\src\jdkDynamicProxy\dasds.jar!/TableI.class
 * Java compiler version: 14 (58.0)
 * JD-Core Version:       1.0.7
 */