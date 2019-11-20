package br.unip.team.emissopassagem.model.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import br.unip.team.emissopassagem.model.entidade.Passagem;
import br.unip.team.emissopassagem.model.entidade.PassagemValueObject;

public class PassagemDAO {
	private static final Logger LOGGER = Logger.getLogger(PassagemDAO.class.getName());
	private static final String INSERT_PASSAGEM = "insert into Passagem(IdItinerario,numero) values(?,?)";
	private static final String PASSAGEM_POR_ID = "select numero, estE.nome as estEmbarque, estD.nome as estDesembarque, hr.Hora from passagem as pg "
			+ "inner join itinerario as it on pg.IdItinerario = it.Id "
			+ "inner join estacao as estE on it.IdEstacaoEmbarque = estE.Id  "
			+ "inner join estacao as estD on it.IdEstacaoDesembarque = estD.Id  "
			+ "inner join horario as hr on it.IdHorarioEmbarque = hr.id where pg.id = ?;";

	public int adicionar(int idItinerario, long numero) {
		Connection conexao = ConnectionFactory.conexaoSQLServer();
		String[] idRetornado = { "id" };

		try (PreparedStatement pstmt = conexao.prepareStatement(INSERT_PASSAGEM, idRetornado);) {
			pstmt.setInt(1, idItinerario);
			pstmt.setLong(2, numero);

			int linhasAfetadas = pstmt.executeUpdate();
			pstmt.getGeneratedKeys();

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

	public PassagemValueObject obterPorId(int id) {

		Connection conexao = ConnectionFactory.conexaoSQLServer();
		try (PreparedStatement pstmt = conexao.prepareStatement(PASSAGEM_POR_ID);) {
			PassagemValueObject passagem = new PassagemValueObject();
			pstmt.setInt(1, id);
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					passagem.setNumero(rs.getLong("numero"));
					passagem.setEstacaoEmbarque(rs.getString("estEmbarque"));
					passagem.setEstacaoDesembarque(rs.getString("estDesembarque"));
					passagem.setHorarioEmbarque(rs.getTime("Hora").toString());
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
