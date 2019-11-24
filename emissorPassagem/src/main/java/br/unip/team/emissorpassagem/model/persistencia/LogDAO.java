package br.unip.team.emissorpassagem.model.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

import br.unip.team.emissorpassagem.model.entidade.Cartao;
import br.unip.team.emissorpassagem.model.entidade.Itinerario;

public class LogDAO {
	private static final Logger LOGGER = Logger.getLogger(LogDAO.class.getName());
	private static final String INSERT_LOG = "insert into Log(horacompra,nmcartao,pin,idestacaoembarque,idestacaodesembarque,idhorarioembarque)values(getdate(),?,?,?,?,?)";

	public boolean adicionar(Itinerario itinerario, Cartao cartao) {
		try (Connection conexao = ConnectionFactory.conexaoSQLServer();
				PreparedStatement pstmt = conexao.prepareStatement(INSERT_LOG);) {
			pstmt.setString(1, cartao.getNumero());
			pstmt.setInt(2, cartao.getPin());
			pstmt.setInt(3, itinerario.getEstacaoEmbarque().getId());
			pstmt.setInt(4, itinerario.getEstacaoDesembarque().getId());
			pstmt.setInt(5, itinerario.getEmbarqueHorario().getId());
			if (pstmt.executeUpdate() == 0) {
				throw new SQLException("Insert falhou, nenhuma linha afetada.");
			}
			return true;
		} catch (SQLException e) {
			LOGGER.info("Erro na query SQL " + INSERT_LOG);
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
		}
		return false;
	}

}
