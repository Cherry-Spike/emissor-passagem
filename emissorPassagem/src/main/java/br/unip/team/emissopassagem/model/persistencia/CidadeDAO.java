package br.unip.team.emissopassagem.model.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Logger;

import br.unip.team.emissopassagem.model.entidade.Cidade;
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
		List<Cidade> cidades = null;
		ResultSet rset = null;
		String sql = "select id, nome from Cidade";
		try (Connection conexao = ConnectionFactory.conexaoSQLServer();
				PreparedStatement pstm = conexao.prepareStatement(sql);) {
			rset = pstm.executeQuery();
			while (rset.next()) {
				rset.getString("Nome");
				Cidade cidade = new Cidade(rset.getString("Nome"), rset.getInt("Id"));
				cidades.add(cidade);
				rset.close();
			}
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

}
