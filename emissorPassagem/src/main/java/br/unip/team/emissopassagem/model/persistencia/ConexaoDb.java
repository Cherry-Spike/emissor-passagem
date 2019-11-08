package br.unip.team.emissopassagem.model.persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;

public class ConexaoDb {

	public ConexaoDb() {
		String connectionUrl = "jdbc:sqlserver://(localdb)\\MSSQLLocalDB;databaseName=Estacao; integratedSecurity=true;";

		try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
			String SQL = "SELECT TOP 10 * FROM Cidade";
			ResultSet rs = stmt.executeQuery(SQL);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
