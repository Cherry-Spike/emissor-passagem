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
		String connectionUrl = "jdbc:sqlserver://DESKTOP-E021K2T\\SQLEXPRESS;databaseName=Estacao;integratedSecurity=true;";
		
		try (Connection conexao = DriverManager.getConnection(connectionUrl);) {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			return conexao;
		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE,"Conexão banco de dados Sql Server");
		}
		catch(ClassNotFoundException c) {
			LOGGER.log(Level.INFO,"Driver Sql Server");
		}
		return null;
	}
}
