package br.unip.team.emissopassagem.model.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.*;

public class ConnectionFactory {
	private static final Logger LOGGER = Logger.getLogger(ConnectionFactory.class.getName());
	private static final String HOST = "DESKTOP-E021K2T";

	private ConnectionFactory() {
	}

	public static Connection conexaoSQLServer() {

		try {
			String connectionUrl = "jdbc:sqlserver://" + HOST + ";databaseName=Estacao;integratedSecurity=true;";
			return DriverManager.getConnection(connectionUrl);
		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, "Conexão banco de dados Sql Server");
		}
		return null;
	}
}
