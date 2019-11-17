package br.unip.team.emissopassagem.model.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import br.unip.team.emissopassagem.model.entidade.Horario;
import br.unip.team.emissopassagem.model.entidade.Itinerario;

public class ItinerarioDAO {
	private static final Logger LOGGER = Logger.getLogger(ItinerarioDAO.class.getName());
	private static final String INSERT_ITINERARIO = "insert into Itinerario(IdEstacaoEmbarque,IdHorarioEmbarque,IdEstacaoDesembarque,QtdPassagem,PrecoPassagem) values(?,?,?,?,?)";
	private static final String VALIDA_ESTACAOHORARIO = "select 1 as existe from EstacaoHorario where idEstacao = ? and idHorario = ?";
	private static final String UPDATE_ITENARARIO = "update Itinerario set IdEstacaoEmbarque= ?,IdHorarioEmbarque = ?,IdEstacaoDesembarque = ?,QtdPassagem = ? where id = ?";
	private static final String HORARIO_ID = "select id, Hora from Horario where Hora = ?";
	
	public int adicionar(Itinerario obj) {
		Connection conexao = ConnectionFactory.conexaoSQLServer();
		String[] idRetornado = { "id" };

		try (PreparedStatement pstmt = conexao.prepareStatement(INSERT_ITINERARIO, idRetornado);) {
			pstmt.setInt(1, obj.getIdEstacaoEmbarque());
			pstmt.setInt(2, obj.getIdEmbarqueHorario());
			pstmt.setInt(3, obj.getIdEstacaoDesembarque());
			pstmt.setInt(4, obj.getQtdPassagem());
			pstmt.setDouble(5, obj.getPrecoPassagem());
			pstmt.getGeneratedKeys();

			if (pstmt.executeUpdate() == 0) {
				throw new SQLException("Insert falhou, nenhuma linha afetada.");
			}

			try (ResultSet rs = pstmt.getGeneratedKeys()) {
				if (rs.next()) {
					return rs.getInt(1);
				}
			}
		} catch (SQLException e) {
			LOGGER.info("Erro na query SQL");
		}catch (Exception e) {
			LOGGER.severe(e.getMessage());
		}
		return 0;
	}

	public boolean validaRelacionamento(int idEstacao, int idHorario) {
		Connection conexao = ConnectionFactory.conexaoSQLServer();
		boolean existe = false;

		try (PreparedStatement pstmt = conexao.prepareStatement(VALIDA_ESTACAOHORARIO);) {
			pstmt.setInt(1, idEstacao);
			pstmt.setInt(2, idHorario);
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next())
					existe = true;
				return existe;
			}
		} catch (SQLException e) {
			LOGGER.info("Erro na query SQL");
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
		}
		return existe;
	}

	public boolean alterarItinerario(Itinerario obj) {
		Connection conexao = ConnectionFactory.conexaoSQLServer();

		try (PreparedStatement pstmt = conexao.prepareStatement(UPDATE_ITENARARIO);) {
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
	
	public int obterIdHorario(String string) {
		Connection conexao = ConnectionFactory.conexaoSQLServer();

		try (PreparedStatement pstmt = conexao.prepareStatement(HORARIO_ID);) {
			pstmt.setString(1, string);
			try (ResultSet rs = pstmt.executeQuery();) {
				Horario horario = new Horario("Hora");
				while (rs.next()) {					
					horario.setId(rs.getInt("Id"));
				}
				return horario.getId();
			}
		} catch (SQLException e) {
			LOGGER.info("Erro na query SQL");
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
		}
		return 0;
	}
	
}
