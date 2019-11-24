package br.unip.team.emissopassagem.model.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import br.unip.team.emissopassagem.model.entidade.Estacao;
import br.unip.team.emissopassagem.model.entidade.Horario;

public class EstacaoDAO {
	private static final Logger LOGGER = Logger.getLogger(EstacaoDAO.class.getName());
	private static final String ESTACAO_HORARIOS = "select hr.Hora,  hr.id as idHorario from EstacaoHorario as eh "
			+ "inner join Horario as hr on eh.IdHorario = hr.Id inner join Estacao as cd on eh.IdEstacao = cd.Id where eh.IdEstacao = ? and eh.IdSentido = ? order by hr.Hora";
	private static final String ESTACAO_POR_ID = "select id, nome from Estacao where id = ?";
	private static final String TODAS_ESTACOES = "select id, nome from Estacao order by nome";

	public List<Estacao> obterTodas() {
		List<Estacao> estacoes = new ArrayList<>();

		try (Connection conexao = ConnectionFactory.conexaoSQLServer();
				Statement stmt = conexao.createStatement();
				ResultSet rs = stmt.executeQuery(TODAS_ESTACOES);) {

			while (rs.next()) {
				Estacao estacao = new Estacao();
				estacao.setNome(rs.getString("Nome"));
				estacao.setId(rs.getInt("Id"));
				estacoes.add(estacao);
			}
			return estacoes;
		} catch (SQLException e) {
			LOGGER.info("Erro na query SQL " + TODAS_ESTACOES);
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
		}
		return Collections.emptyList();
	}

	public List<Horario> obterEstacaoHorarios(int id, int sentido) {
		List<Horario> horarios = new ArrayList<>();

		try (Connection conexao = ConnectionFactory.conexaoSQLServer();
				PreparedStatement pstmt = conexao.prepareStatement(ESTACAO_HORARIOS);) {
			pstmt.setInt(1, id);
			pstmt.setInt(2, sentido);
			try (ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {
					Horario horario = new Horario(rs.getTime("Hora").toString());
					horario.setId(rs.getInt("idHorario"));
					horarios.add(horario);
				}
				return horarios;
			}
		} catch (SQLException e) {
			LOGGER.info("Erro na query SQL " + ESTACAO_HORARIOS);
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
		}
		return Collections.emptyList();
	}

	public Estacao obterPorId(int id) {
		try (Connection conexao = ConnectionFactory.conexaoSQLServer();
				PreparedStatement pstmt = conexao.prepareStatement(ESTACAO_POR_ID);) {
			pstmt.setInt(1, id);
			try (ResultSet rs = pstmt.executeQuery()) {
				Estacao estacao = new Estacao();

				while (rs.next()) {
					estacao.setNome(rs.getString("nome"));
					estacao.setId(rs.getInt("id"));
				}
				return estacao;
			}
		} catch (SQLException e) {
			LOGGER.info("Erro na query SQL " + ESTACAO_POR_ID);
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
		}
		return null;
	}
}
