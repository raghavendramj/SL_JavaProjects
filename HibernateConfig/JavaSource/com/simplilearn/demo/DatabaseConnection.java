package com.simplilearn.demo;

//Singleton Design pattern!
class JDBCConnection {

	// Eager/Early Initialzation!
	// private static JDBCConnection jdbcConnection = new JDBCConnection();
	
	//Lazy initialization
	private static JDBCConnection jdbcConnection;

	private JDBCConnection() {
	}

	public static JDBCConnection getObject() {
		if (jdbcConnection == null) {
			//Lazy initialization
			jdbcConnection = new JDBCConnection();
		}
		return jdbcConnection;
	}
}

public class DatabaseConnection {

	public static void main(String[] args) {
		JDBCConnection connection1 = JDBCConnection.getObject();
		System.out.println("My Object is " + connection1);

		JDBCConnection connection2 = JDBCConnection.getObject();
		System.out.println("My Object is " + connection2);
		JDBCConnection connection3 = JDBCConnection.getObject();
		System.out.println("My Object is " + connection3);
		JDBCConnection connection4 = JDBCConnection.getObject();
		System.out.println("My Object is " + connection4);
	}
}
