package br.unip.team.emissopassagem.model.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.*;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

public class ConnectionFactory {
	private static final Logger LOGGER = Logger.getLogger(ConnectionFactory.class.getName());

	private ConnectionFactory() {
	}

	public static Connection conexaoSQLServer() {
//		
//		SQLServerDataSource ds = new SQLServerDataSource();
//		ds.setServerName("DESKTOP-E021K2T\\\\SQLEXPRESS");
//		ds.setDatabaseName("Estacao");
//		ds.setIntegratedSecurity(true);
		try {
			String connectionUrl = "jdbc:sqlserver://DESKTOP-FERNAND;databaseName=Estacao;integratedSecurity=true;";
			return DriverManager.getConnection(connectionUrl);
		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE,"Conexão banco de dados Sql Server");
		}
		return null;
	}
}
