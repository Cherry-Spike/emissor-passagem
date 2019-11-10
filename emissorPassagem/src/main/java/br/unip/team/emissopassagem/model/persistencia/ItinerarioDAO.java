package br.unip.team.emissopassagem.model.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import br.unip.team.emissopassagem.model.entidade.Estacao;
import br.unip.team.emissopassagem.model.entidade.Horario;
import br.unip.team.emissopassagem.model.entidade.Itinerario;
import br.unip.team.emissopassagem.model.interfaces.BaseDAO;

public class ItinerarioDAO implements BaseDAO<Itinerario> {
	private static final Logger LOGGER = Logger.getLogger(ConnectionFactory.class.getName());

	@Override
	public Itinerario obterPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Itinerario> obterTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean adicionar(Itinerario obj) {
		Connection conexao = ConnectionFactory.conexaoSQLServer();
		String query = "insert into Itinerario(IdEstacaoEmbarque,IdHorarioEmbarque,IdEstacaoDesembarque,IdHorarioDesembarque,QtdPassagem) values(?,?,?,?,?)";

		try (PreparedStatement pstmt = conexao.prepareStatement(query);) {
			pstmt.setInt(1, obj.getIdEstacaoEmbarque());
			pstmt.setInt(2, obj.getIdEmbarqueHorario());
			pstmt.setInt(3, obj.getIdEstacaoDesembarque());
			pstmt.setInt(4, obj.getIdDesembarqueHorario());
			pstmt.setInt(5, obj.getQtdPassagem());
			return pstmt.execute();
		} catch (SQLException e) {
			LOGGER.info("Erro na query SQL");
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
		}
		return false;
	}

	public boolean ValidaRelacao(int idEstacao, int idHorario) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Itinerario alterar(Itinerario obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remover(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
