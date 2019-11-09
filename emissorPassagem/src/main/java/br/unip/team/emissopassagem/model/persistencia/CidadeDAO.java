package br.unip.team.emissopassagem.model.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import br.unip.team.emissopassagem.model.entidade.Cidade;
import br.unip.team.emissopassagem.model.entidade.Horario;
import br.unip.team.emissopassagem.model.interfaces.BaseDAO;

public class CidadeDAO implements BaseDAO {
	private static final Logger LOGGER = Logger.getLogger(ConnectionFactory.class.getName());

	@Override
	public Object obterPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cidade> obterTodos() {
		List<Cidade> cidades = new ArrayList();
		Connection conexao = ConnectionFactory.conexaoSQLServer();
		String query = "select id, nome from Cidade";

		try (Statement stmt = conexao.createStatement();ResultSet rs = stmt.executeQuery(query);) {
			
			while (rs.next()) {
				Cidade cidade = new Cidade(rs.getString("Nome"));
				cidade.setId(rs.getInt("Id"));
				cidades.add(cidade);
			}
			return cidades;
		} catch (SQLException e) {
			LOGGER.info("Erro na query SQL");
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
		}
		return null;
	}

	@Override
	public boolean adicionar(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object alterar(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remover(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	public Cidade obterCidadeHorarios(int id) {
		Connection conexao = ConnectionFactory.conexaoSQLServer();
		String query = "select cd.id as idCidade, cd.nome as nomeCidade, hr.Hora,  hr.id as idHorario from CidadeHorario as ch "
				+ "inner join Horario as hr on ch.IdHorario = hr.Id "
				+ "inner join Cidade as cd on ch.IdCidade = cd.Id where ch.IdCidade = ?";

		try (PreparedStatement pstmt = conexao.prepareStatement(query);) {
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			Cidade cidade = new Cidade(rs.getString("nomeCidade"));
			cidade.setId(rs.getInt("idCidade"));
			while (rs.next()) {
				Horario horario = new Horario(rs.getString("Horario"));
				horario.setId(rs.getInt("idHorario"));
				cidade.setHorarios(horario);
			}
			rs.close();
			return cidade;
		} catch (SQLException e) {
			LOGGER.info("Erro na query SQL");
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
		}

		return null;
	}
}
