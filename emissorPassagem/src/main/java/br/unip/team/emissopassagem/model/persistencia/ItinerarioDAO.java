package br.unip.team.emissopassagem.model.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import br.unip.team.emissopassagem.model.entidade.Itinerario;

public class ItinerarioDAO {
	private static final Logger LOGGER = Logger.getLogger(ConnectionFactory.class.getName());

	public int adicionar(Itinerario obj) {
		Connection conexao = ConnectionFactory.conexaoSQLServer();
		String query = "insert into Itinerario(IdEstacaoEmbarque,IdHorarioEmbarque,IdEstacaoDesembarque,QtdPassagem) values(?,?,?,?)";
		String idRetornado[] = { "id" };

		try (PreparedStatement pstmt = conexao.prepareStatement(query, idRetornado);) {
			pstmt.setInt(1, obj.getIdEstacaoEmbarque());
			pstmt.setInt(2, obj.getIdEmbarqueHorario());
			pstmt.setInt(3, obj.getIdEstacaoDesembarque());
			pstmt.setInt(4, obj.getQtdPassagem());
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

	public boolean validaRelacao(int idEstacao, int idHorario) {
		Connection conexao = ConnectionFactory.conexaoSQLServer();
		String query = "select 1 as existe from EstacaoHorario where idEstacao = ? and idHorario = ?";
		boolean existe = false;

		try (PreparedStatement pstmt = conexao.prepareStatement(query);) {
			pstmt.setInt(1, idEstacao);
			pstmt.setInt(2, idHorario);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next())
				existe = true;
			rs.close();
			return existe;
		} catch (SQLException e) {
			LOGGER.info("Erro na query SQL");
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
		}
		return existe;
	}

	public boolean alterarItinerario(Itinerario obj) {
		Connection conexao = ConnectionFactory.conexaoSQLServer();
		String query = "update Itinerario"
				+ "set IdEstacaoEmbarque= ?,IdHorarioEmbarque = ?,IdEstacaoDesembarque = ?,QtdPassagem = ? where id = ?";

		try (PreparedStatement pstmt = conexao.prepareStatement(query);) {
			pstmt.setInt(1, obj.getIdEstacaoEmbarque());
			pstmt.setInt(2, obj.getIdEmbarqueHorario());
			pstmt.setInt(3, obj.getIdEstacaoDesembarque());
			pstmt.setInt(4, obj.getQtdPassagem());
			pstmt.setInt(5, obj.getQtdPassagem());
			return pstmt.execute();
		} catch (SQLException e) {
			LOGGER.info("Erro na query SQL");
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
		}
		return false;
	}

}
