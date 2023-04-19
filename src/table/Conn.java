package table;
/*    */ import java.io.IOException;

/*    */ import java.sql.Connection;
/*    */ import java.sql.DriverManager;
/*    */ import java.sql.ResultSet;
/*    */ import java.sql.SQLException;
/*    */ import java.sql.Statement;
/*    */ import java.util.Properties;

/*    */ 
/*    */ public class Conn {
/*    */   private static String username;
/*    */   private static String password;
/* 13 */   private static Properties pro = new Properties();
/*    */   private static String database;
/*    */   
/*    */   static  {
/*    */     try {
/* 18 */       pro.load(Conn.class.getResourceAsStream("account.properties"));
/* 19 */       username = pro.getProperty("username");
/* 20 */       password = pro.getProperty("password");
/* 21 */       database = pro.getProperty("database");
/* 22 */       url = "jdbc:mysql://localhost:3306/" + database;
/* 23 */       Class.forName("com.mysql.cj.jdbc.Driver");
/* 24 */     } catch (ClassNotFoundException e) {
/*    */       
/* 26 */       e.printStackTrace();
/* 27 */     } catch (IOException e) {
/*    */       
/* 29 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */   private static String url;
/*    */   
/* 34 */   public static Connection getConnection() throws SQLException { return DriverManager.getConnection(url, username, password); }
/*    */ 
/*    */   
/*    */   public static void free(Connection conn, Statement stmt, ResultSet rs) throws SQLException {
/* 38 */     if (conn != null) conn.close(); 
/* 39 */     if (stmt != null) stmt.close(); 
/* 40 */     if (rs != null) rs.close(); 
/*    */   }
/*    */ }


/* Location:              C:\Users\lenovo\eclipse-workspace\JavaEE_\src\jdkDynamicProxy\dasds.jar!/Conn.class
 * Java compiler version: 14 (58.0)
 * JD-Core Version:       1.0.7
 */