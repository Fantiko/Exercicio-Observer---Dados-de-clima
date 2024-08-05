package Presenter;

import dado.ConfigManager;
import dado.DadoClima;
import logging.JsonFileLogger;
import logging.Logger;
import logging.XmlFileLogger;
import Observer.Observer;

import java.util.ArrayList;
import java.util.List;
import View.*;

/*Model*/

public class EstacaoClimatica {
    private List<Observer> observers = new ArrayList<>();
    private List<DadoClima> dadosClima = new ArrayList<>();

    public TelaDadosTempo TelaDadosTempo;
    public TelaMaximasMinimas TelaMaximasMinimas;
    public TelaUltimaATT TelaUltimaATT;
    public TelaRegistros TelaRegistros;
    public TelaDadosMedios TelaDadosMedios;
    public TelaConfiguracoes TelaConfiguracoes;

    Logger logger;

    public EstacaoClimatica() {

        this.TelaDadosTempo = new TelaDadosTempo(this);
        this.TelaMaximasMinimas = new TelaMaximasMinimas();
        this.TelaUltimaATT = new TelaUltimaATT();
        this.TelaRegistros = new TelaRegistros(this);
        this.TelaDadosMedios = new TelaDadosMedios();
        this.TelaConfiguracoes = new TelaConfiguracoes();

        adicionarObserver(this.TelaDadosTempo);
        adicionarObserver(this.TelaMaximasMinimas);
        adicionarObserver(this.TelaUltimaATT);
        adicionarObserver(this.TelaRegistros);
        adicionarObserver(this.TelaDadosMedios);
        adicionarObserver(this.TelaConfiguracoes);

    }

    public void adicionarDado(DadoClima dadoClima) {
        dadosClima.add(dadoClima);
        notificarObservers();

        if(ConfigManager.getLogFormat() == "XML"){
            this.logger = new XmlFileLogger("log.xml");
        }else if(ConfigManager.getLogFormat() == "JSON"){
            this.logger = new JsonFileLogger("log.json");
        }
        logger.logOperacao("Inclusão");

    }

    public void removeDado(DadoClima dadoClima) {
        this.dadosClima.remove(dadoClima);
        notificarObservers();

    }

    public void adicionarObserver(Observer observer) {
        observers.add(observer);
    }

    public void notificarObservers() {
        for (Observer observer : observers) {
            observer.atualizar(dadosClima);
        }
    }

}
