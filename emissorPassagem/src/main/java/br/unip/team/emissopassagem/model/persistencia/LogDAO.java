package br.unip.team.emissopassagem.model.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

import br.unip.team.emissopassagem.model.entidade.Cartao;
import br.unip.team.emissopassagem.model.entidade.Itinerario;

public class LogDAO {
	private static final Logger LOGGER = Logger.getLogger(LogDAO.class.getName());
	private static final String INSERT_LOG = "inser into Log(horacompra,nmcartao,pin,idestacaoembarque,idestacaodesembarque,idhorarioembarque)values(Sysdate(),?,?,?,?,?)";

	public boolean adicionar(Itinerario itinerario, Cartao cartao) {
		Connection conexao = ConnectionFactory.conexaoSQLServer();

		try (PreparedStatement pstmt = conexao.prepareStatement(INSERT_LOG);) {
			pstmt.setString(1, cartao.getNumero());
			pstmt.setInt(2, cartao.getPin());
			pstmt.setInt(3, itinerario.getIdEstacaoEmbarque());
			pstmt.setInt(4, itinerario.getIdEstacaoDesembarque());
			pstmt.setInt(5, itinerario.getIdEmbarqueHorario());
			if (pstmt.executeUpdate() == 0) {
				throw new SQLException("Insert falhou, nenhuma linha afetada.");
			}
			return true;
		} catch (SQLException e) {
			LOGGER.info("Erro na query SQL");
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
		}
		return false;
	}

}
