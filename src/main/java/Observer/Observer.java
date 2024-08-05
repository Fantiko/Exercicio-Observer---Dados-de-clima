package Observer;

import dado.DadoClima;

import java.util.List;

public interface Observer {
    void atualizar(List<DadoClima> dadoClimaList);
}
