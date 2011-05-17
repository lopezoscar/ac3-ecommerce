package dataBaseAccess;

import interfaces.DBQuery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class DBConnect {
	
	private static DBConnect INSTANCE;
	
	private DBConnect(){
		
	}
	
	public static DBConnect getInstance(){
		if(INSTANCE == null){
			INSTANCE = new DBConnect();
			return INSTANCE;
		}else{
			return INSTANCE;
		}
	}
	
	
	
	String connectionURL = "jdbc:sqlserver://localhost:1433;"+"databaseName = ECOMMERCE";
	String dsn = "lopezoscar";
	String pass = "admin";
	
	Connection connection = null;
	Statement statement = null;
	ResultSet rs;
	
	@SuppressWarnings("finally")
	public Statement connect(){
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
		connection = DriverManager.getConnection(connectionURL,dsn,pass);
		statement = connection.createStatement();
	
		//statement.execute("INSERT INTO users (nombre, apellido, mail) VALUES ('oscar', 'lopez', 'lopezoscar.job@gmail.com')");
		//statement.executeQuery("INSERT INTO users (nombre, apellido, mail) VALUES ('oscar', 'lopez', 'lopezoscar.job@gmail.com')");
//		rs = statement.executeQuery("SELECT * FROM users");
//		rs = statement.executeQuery("SELECT * FROM users");
//		
//		while(rs.next()){
//			System.out.println(rs.getString("nombre"));
//			System.out.println(rs.getString("apellido"));
//			System.out.println(rs.getString("mail"));
//		}
//		rs.close();
	} catch (InstantiationException insE) {
		insE.printStackTrace();
	} catch (IllegalAccessException ilegalE) {
		ilegalE.printStackTrace();
	} catch (ClassNotFoundException classNtF) {
		classNtF.printStackTrace();
	} catch (SQLException sqlE) {
		sqlE.printStackTrace();
	}
		return statement;
	}
	
	public ResultSet commandSelect(DBQuery object){
		
		String select = " SELECT "+object.getColumna()+" FROM "+object.getTabla();
		
		if(object.getCondicion()!=null){
			select+=" WHERE "+object.getCondicion();
		}
		
		try {
			rs = statement.executeQuery(select);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			return rs;
		}	
	}
	
	public void commandInsert(DBQuery object,String[]values){
		/**
		 * Comando INSERT
		 * INSERT INTO TABLENAME (campo1,campo2) VALUES('Valor1','valor2');
		 */
		String insert = " INSERT INTO "+object.getTabla()+"("+object.getColumna()+")"+ " VALUES "+values;
		try {
			statement.execute(insert);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}



