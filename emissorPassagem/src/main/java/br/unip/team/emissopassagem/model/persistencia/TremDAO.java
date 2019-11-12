package br.unip.team.emissopassagem.model.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import br.unip.team.emissopassagem.model.entidade.Estacao;
import br.unip.team.emissopassagem.model.entidade.Trem;

public class TremDAO {
	private static final Logger LOGGER = Logger.getLogger(ConnectionFactory.class.getName());

	public boolean reservarAssento(int id) {
		Connection conexao = ConnectionFactory.conexaoSQLServer();
		String query = "update Trem set assentoDisponivel = " + 
				"(select AssentoDisponivel from Trem where Id = ?) - 1 " + 
				"where Id = ?";
		Estacao estacao = new Estacao();

		try (PreparedStatement pstmt = conexao.prepareStatement(query);) {
			pstmt.setInt(1, id);
			pstmt.setInt(2, id);
			return pstmt.execute();
		} catch (SQLException e) {
			LOGGER.info("Erro na query SQL");
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
		}
		return false;
	}
	
	public Trem obterPorIdCidadeInicial(int id) {
		Connection conexao = ConnectionFactory.conexaoSQLServer();
		String query = "select id, totalAssento, assentoDisponivel, idEstacaoInicial, idEstacaoFinal from Trem where IdEstacaoInicial = ?";
		Trem trem = new Trem();

		try (PreparedStatement pstmt = conexao.prepareStatement(query);) {
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				trem.setAssentoDisponivel(rs.getInt("assentoDisponivel"));
				trem.setTotalAssento(rs.getInt("totalAssento"));
				trem.setIdEstacaoFinal(rs.getInt("idEstacaoFinal"));
			}
			rs.close();
			return trem;
		} catch (SQLException e) {
			LOGGER.info("Erro na query SQL");
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
		}
		return null;
	}
}
