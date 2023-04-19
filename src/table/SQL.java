package table;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SQL
/*    */ {
	      private  static boolean BUG=false;
/*  6 */   public static String add(String tableName, String itable, String params) { String sql="insert into " + tableName + itable + " values " + params;
if(BUG)System.err.println(sql);
return sql; }
/*    */ 
/*    */ 
/*    */   
/* 10 */   public static String rev(String tableName, String where) { String sql="delete from " + tableName + " where " + where; 
if(BUG)System.err.println(sql);
return sql;
}
/*    */ 
/*    */ 
/*    */   
/* 14 */   public static String upt(String tableName, String set, String where) { String sql= "update " + tableName + " set " + set + " where " + where;
if(BUG)System.err.println(sql);
return sql;}
/*    */ 
/*    */ 
/*    */   
/* 18 */   public static String quy(String cols, String tableName, String where) {String sql= "select " + cols + " from " + tableName + " where " + where;
if(BUG)System.err.println(sql);
return sql;}
		   public static String limit(String quy,int from,int seg)
		   {
			   String sql= quy+ " limit "+from+","+seg; 
			   if(BUG)System.err.println(sql);
			   return sql;	   
		   }
		   public static void bug()
		   {
			   BUG=!BUG;
		   }
/*    */ }


/* Location:              C:\Users\lenovo\eclipse-workspace\JavaEE_\src\jdkDynamicProxy\dasds.jar!/SQL.class
 * Java compiler version: 14 (58.0)
 * JD-Core Version:       1.0.7
 */