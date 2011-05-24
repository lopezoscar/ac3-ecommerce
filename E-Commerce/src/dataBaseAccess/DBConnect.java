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
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//connect();
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
	
	public Connection connect(){
	try {
		
		connection = DriverManager.getConnection(connectionURL,dsn,pass);
		//statement = connection.createStatement();
	
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
	}  catch (SQLException sqlE) {
		sqlE.printStackTrace();
	}
		return connection;
	}
	
	public ResultSet commandSelect(String query){
		try {
			rs = statement.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet commandSelect(DBQuery object){
		
		String select = " SELECT "+object.getColumna()+" FROM "+object.getTabla();
		
		if(object.getCondicion()!=null){
			select+=" WHERE "+object.getCondicion();
		}
		
		try {
			rs = null;
			rs = statement.executeQuery(select);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public Boolean commandInsert(String query){
		Boolean queryOk = false;
		try{
			statement.execute(query);
			queryOk = true;
		}catch(SQLException e){
			e.printStackTrace();
			queryOk = false;
		}
		
		return queryOk;
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



