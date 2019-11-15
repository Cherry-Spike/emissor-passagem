package br.unip.team.emissopassagem.controller;

import java.util.List;

import br.unip.team.emissopassagem.model.entidade.Estacao;
import br.unip.team.emissopassagem.model.servico.EstacaoServico;
import br.unip.team.emissopassagem.view.tela.TelaEstacaoDb;

public class EstacaoDesembarqueController {
    private TelaEstacaoDb view;
    private EstacaoServico servico;

    public EstacaoDesembarqueController(TelaEstacaoDb view){
        this.view = view;
        servico = new EstacaoServico();
    }
    
    public Estacao obterEstacaoEmbarquePorId(int idEstacao) {
    	 return servico.obterPorId(idEstacao);
    }
    
    public List<Estacao> obterTodasEstacoes() {
    	return servico.obterTodas();
    }
}
