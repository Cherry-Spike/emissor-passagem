package br.unip.team.emissopassagem.model.persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;

public class ConexaoDb {

	public ConexaoDb() throws ClassNotFoundException {
		String connectionUrl = "jdbc:sqlserver://DESKTOP-E021K2T\\SQLEXPRESS;databaseName=Estacao;integratedSecurity=true;";
		try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String SQL = "SELECT TOP 10 * FROM Cidade";
			ResultSet rs = stmt.executeQuery(SQL);
		      while(rs.next()){
		          System.out.println(rs.getString("nome"));
		       }
		       rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
