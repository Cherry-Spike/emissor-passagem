package br.unip.team.emissorpassagem.controller;

import br.unip.team.emissorpassagem.model.entidade.Cartao;
import br.unip.team.emissorpassagem.model.servico.LogServico;

public class LogController {
    private LogServico servico;

    public LogController(){
        servico = new LogServico();
    }
    
    public boolean  adicionarLog(int itinerario, Cartao cartao) {
    	return servico.adicionarLog(itinerario, cartao);
    }
}
