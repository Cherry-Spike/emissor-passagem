package br.unip.team.emissopassagem.controller;

import java.util.List;

import br.unip.team.emissopassagem.model.entidade.Estacao;
import br.unip.team.emissopassagem.model.entidade.Horario;
import br.unip.team.emissopassagem.model.servico.EstacaoServico;

public class EstacaoController {
    private EstacaoServico servico;

    public EstacaoController(){
        servico = new EstacaoServico();
    }
    
    public Estacao obterEstacaoEmbarquePorId(int idEstacao) {
    	 return servico.obterPorId(idEstacao);
    }
    
    public List<Estacao> obterTodasEstacoes() {
    	return servico.obterTodas();
    }

	public List<Horario> obterEstacaoHorarios(int idEstacaoEmbarque, int idEstacaoDesembarque) {
		return servico.obterEstacaoHorarios(idEstacaoEmbarque, idEstacaoDesembarque);
	}
}
