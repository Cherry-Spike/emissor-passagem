package br.unip.team.emissopassagem.model.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import br.unip.team.emissopassagem.model.entidade.Passagem;

public class PassagemDAO {
	private static final Logger LOGGER = Logger.getLogger(PassagemDAO.class.getName());
	private static final String INSERT_PASSAGEM = "insert into Passagem(IdItinerario,numero) values(?,?)";
	private static final String PASSAGEM_POR_ID = "select id, idItinerario, numero from Passagem where id = ?";

	public int adicionar(int idItinerario, long numero) {
		Connection conexao = ConnectionFactory.conexaoSQLServer();
		String[] idRetornado = { "id" };

		try (PreparedStatement pstmt = conexao.prepareStatement(INSERT_PASSAGEM, idRetornado);) {
			pstmt.setInt(1, idItinerario);
			pstmt.setLong(2, numero);
			pstmt.getGeneratedKeys();

			int linhasAfetadas = pstmt.executeUpdate();

			if (linhasAfetadas == 0) {
				throw new SQLException("Insert falhou, nenhuma linha afetada.");
			}

			try (ResultSet rs = pstmt.getGeneratedKeys()) {
				if (rs.next()) {
					return rs.getInt(1);
				}
			}
		} catch (SQLException e) {
			LOGGER.info("Erro na query SQL");
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
		}
		return 0;
	}

	public Passagem obterPorId(int id) {
		
		Connection conexao = ConnectionFactory.conexaoSQLServer();
		try (PreparedStatement pstmt = conexao.prepareStatement(PASSAGEM_POR_ID);) {
			Passagem passagem = new Passagem();
			pstmt.setInt(1, id);
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					passagem.setId(rs.getInt("id"));
					passagem.setIdItinerario(rs.getInt("id"));
					passagem.setNumero(rs.getInt("numero"));
				}
				return passagem;
			}
		} catch (SQLException e) {
			LOGGER.info("Erro na query SQL");
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
		}
		return null;
	}
}
