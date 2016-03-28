/**
 * 
 */
package de.tlabs.thinkAir.dirService;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author Administrator
 *
 */

public class DBHelper {
	public static final String url = "jdbc:mysql://202.114.10.148:3306/androidlxc";
//	public static final String url = "jdbc:mysql://192.168.155.1:3306/androidlxc";
	public static final String name = "com.mysql.jdbc.Driver";
	public static final String user = "root";
	public static final String password = "KFniuchao88";
	

	public Connection conn = null;
	public Statement dbstate = null;

	public DBHelper() {
		try {
			Class.forName(name);//ָ����������
			conn = DriverManager.getConnection(url, user, password);//��ȡ����
			System.out.println("Database connected");
			dbstate = conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public ResultSet dbSelect(String sql) 
	{
		try{ 
			ResultSet dbresult = dbstate.executeQuery(sql); 
			return dbresult; 
		}catch(Exception err){ 
			System.out.println("Exception: " + err.getMessage()); 
			return null;
		} 
	}//end String dbSelect(��) 
	 
	/** 
	 * �����ݿ���еļ�¼����ɾ������ 
	 * @param tableName 
	 * @param condition 
	 * @return boolֵ����ʾɾ���ɹ�����ʧ�ܡ� 
	 */ 
	public boolean dbDelete(String sql) 
	{//�����C>>>ɾ������ 
		boolean delResult = false; 
		try{ 
			dbstate.executeUpdate(sql);	//return int // int delRe = ?? 
			delResult = true; 
		}catch(Exception e){ 
			System.out.println ("Exception: " + e.getMessage()); 
		} 
		if (delResult) 
			return true; 
		else 
			return false; 
	}//end dbDelete(��)  
	
	
	/** 
	 * �����ݿ���м�¼���и��²��� 
	 * @param tabName 
	 * @param reCount 
	 * @return boolֵ���ɹ�����true��ʧ�ܷ���false 
	 */ 
	public boolean dbUpdate(String sql) 
	{
		boolean updateResult = false;
		try 
		{ 
			dbstate.executeUpdate(sql); 
			updateResult = true; 
		}catch(Exception err){ 
			System.out.println("Exception: " + err.getMessage()); 
		} 
		return updateResult;
	}//end dbUpdate(��) 
	 
	
	/** 
	 * �����ݿ����в������ 
	 * @param tabName 
	 * @param hm 
	 * @return boolֵ���ɹ�����true��ʧ�ܷ���false 
	 */ 
	public boolean dbInsert(String sql) 
	{
		boolean insertResult = false;
		try 
		{ 
			dbstate.executeUpdate(sql); 
			insertResult = true; 
		}catch(Exception e){ 
			System.out.println("Exception: " + e.getMessage()); 
		} 
		return insertResult; 
	}//end dbInsert(��) 
	 
	
	/** 
	 * �Ͽ����ݿ� 
	 * @return boolֵ���ɹ�����true��ʧ�ܷ���false 
	 */ 
	public boolean dbClose() 
	{ 
		boolean closeResult = false; 
		try 
		{ 
			conn.close(); 
			closeResult = true; 
		}catch(Exception e){ 
			System.out.println("Exception: " + e.getMessage()); 
		} 
		return closeResult;
	}//end dbClose() 

}
