package dao;
/*     */
import java.sql.*;
/*     */ import java.util.ArrayList;
import java.util.List;

import table.Conn;
import table.TableI;
			public class TableIDao {
/*     */   protected TableI ti;
			protected PreparedStatement stmt; 
			protected ResultSet rs;
/*     */   protected int PageCount=-1;
			protected Connection conn;
			
			public TableIDao(TableI ti) throws SQLException {
/*     */   
			  this.conn = Conn.getConnection();
/*  17 */     this.stmt = this.conn.prepareStatement("create table if not exists " + ti.getTableName() + " " + ti.getInitTable());
/*  18 */     this.stmt.executeUpdate();
/*  19 */     this.stmt.close();
/*  20 */     this.conn = Conn.getConnection();
/*  21 */     this.ti = ti;
/*     */   }
/*     */   
/*     */   public ArrayList<TableI> QueryAll() throws SQLException {
/*  25 */     String sql = this.ti.QueryAll();
/*  26 */     //System.err.println(sql);
/*  27 */     this.stmt = this.conn.prepareStatement(sql);
/*  28 */     this.rs = this.stmt.executeQuery();
/*  29 */     ArrayList<TableI> tarr = new ArrayList<TableI>();
/*  30 */     while (this.rs.next())
/*     */     {
/*  32 */       tarr.add(this.ti.Maker(this.rs));
/*     */     }
/*  34 */     Conn.free(null, this.stmt, this.rs);
/*  35 */     return tarr;
/*     */   }
/*     */   
/*     */   public ArrayList<TableI> QueryLike() throws SQLException {
/*  39 */     String sql = this.ti.QueryLike();
/*  40 */    System.err.println(sql);
/*  41 */     this.stmt = this.conn.prepareStatement(sql);
/*  42 */     this.rs = this.stmt.executeQuery();
/*  43 */     ArrayList<TableI> tarr = new ArrayList<TableI>();
/*  44 */     while (this.rs.next())
/*     */     {
/*  46 */       tarr.add(this.ti.Maker(this.rs));
/*     */     }
/*  48 */     Conn.free(null, this.stmt, this.rs);
/*  49 */     return tarr;
/*     */   }
/*     */   
/*     */   public TableI QuerySel() throws SQLException {
/*  53 */     String sql = this.ti.QuerySel();
///*     */     System.err.println("!!!"+sql);
/*  55 */     this.stmt = this.conn.prepareStatement(sql);
/*  56 */     this.rs = this.stmt.executeQuery();
/*  57 */     TableI tis = null;
/*  58 */     if (this.rs.next())
/*  59 */       tis = this.ti.Maker(this.rs); 
/*  60 */     Conn.free(null, this.stmt, this.rs);
/*  61 */     return tis;
/*     */   }
/*     */ 
/*     */   
/*     */   public ArrayList<TableI> QuerySelSet() throws SQLException {
/*  66 */     String sql = this.ti.QuerySel();
/*  67 */   //  System.err.println(sql);
/*  68 */     this.stmt = this.conn.prepareStatement(sql);
/*  69 */     this.rs = this.stmt.executeQuery();
/*  70 */     ArrayList<TableI> tarr = new ArrayList<TableI>();
/*  71 */     while (this.rs.next())
/*     */     {
/*  73 */       tarr.add(this.ti.Maker(this.rs));
/*     */     }
/*  75 */     Conn.free(null, this.stmt, this.rs);
/*  76 */     return tarr;
/*     */   }
/*     */   
/*     */   public void Remove() throws SQLException {
/*  80 */     String sql = this.ti.DeleteSel();
/*  81 */     this.stmt = this.conn.prepareStatement(sql);
/*  82 */     this.stmt.executeUpdate();
/*  83 */     Conn.free(null, this.stmt, this.rs);
/*     */   }
/*     */   
/*     */   public boolean Insert() throws SQLException {
/*  87 */     String sql = this.ti.InsertNew();
/*  88 */    // System.err.println(sql);
/*  89 */     this.stmt = this.conn.prepareStatement(sql);
/*  90 */     int c = this.stmt.executeUpdate();
/*  91 */     Conn.free(null, this.stmt, this.rs);
/*  92 */     return (c == 1);
/*     */   }
/*     */   
/*  95 */   public TableI getTi() throws SQLException { return this.ti; }
/*     */ 
/*     */   
/*  98 */   public void setTi(TableI ti) throws SQLException { this.ti = ti; }
/*     */ 
/*     */   
/*     */   public boolean Update() throws SQLException {
/* 102 */     String sql = this.ti.UpdateNew();
/* 103 */    //System.err.println(sql);
/* 104 */     this.stmt = this.conn.prepareStatement(sql);
/* 105 */     int c = this.stmt.executeUpdate();
/* 106 */     Conn.free(null, this.stmt, this.rs);
/* 107 */     return (c == 1);
/*     */   }
			public void SetPageCount(int pageContains) throws SQLException
			{
				List<TableI>ls=this.QueryAll();
				int tot=ls.size();
				this.PageCount=(tot/pageContains)+((tot%pageContains==0)?0:1);
			}
			public int GetPageCount()
			{
				return this.PageCount;
			}
			public void InitPageCount()
			{
				this.PageCount=-1;
			}
			public List<TableI>Ptable(int page,int pageContains) throws SQLException
			{
				int tot=(page-1)*pageContains;
				String sql=this.ti.limit(tot,pageContains);
				this.stmt=this.conn.prepareStatement(sql);
				this.rs=this.stmt.executeQuery();
				List<TableI>ls=new ArrayList<TableI>();
				while(rs.next())
				{
					ls.add(this.ti.Maker(rs));
				}
				return ls;
			}
			
/*     */ }