package br.unip.team.emissopassagem.controller;

import br.unip.team.emissopassagem.model.entidade.Cartao;
import br.unip.team.emissopassagem.model.servico.LogServico;

public class LogController {
    private LogServico servico;

    public LogController(){
        servico = new LogServico();
    }
    
    public boolean  adicionarLog(int itinerario, Cartao cartao) {
    	return servico.adicionarLog(itinerario, cartao);
    }
}
