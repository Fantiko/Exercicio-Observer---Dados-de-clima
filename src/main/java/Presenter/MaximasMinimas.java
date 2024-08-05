package Presenter;

import dado.DadoClima;
import java.util.List;

public class MaximasMinimas {
    public List<DadoClima> dadosClima;


    public float maxTemp = Float.MIN_VALUE;
    public float minTemp = Float.MAX_VALUE;
    public float maxUmidade = Float.MIN_VALUE;
    public float minUmidade = Float.MAX_VALUE;
    public float maxPressao = Float.MIN_VALUE;
    public float minPressao = Float.MAX_VALUE;

    public MaximasMinimas(List<DadoClima> dadosClima) {
        this.dadosClima = dadosClima;
    }

    public void exibirMaximasMinimas() {
        if (dadosClima.isEmpty()){
            maxTemp = 0;
            minTemp =0;
            maxUmidade =0;
            minUmidade =0;
            maxPressao =0;
            minPressao =0;
        }

        for (DadoClima dadoClima : dadosClima) {
            if (dadoClima.getTemperatura() > maxTemp) maxTemp = dadoClima.getTemperatura();
            if (dadoClima.getTemperatura() < minTemp) minTemp = dadoClima.getTemperatura();
            if (dadoClima.getUmidade() > maxUmidade) maxUmidade = dadoClima.getUmidade();
            if (dadoClima.getUmidade() < minUmidade) minUmidade = dadoClima.getUmidade();
            if (dadoClima.getPressao() > maxPressao) maxPressao = dadoClima.getPressao();
            if (dadoClima.getPressao() < minPressao) minPressao = dadoClima.getPressao();
        }}

}
