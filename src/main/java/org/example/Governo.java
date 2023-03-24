package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Governo {
    //armazena uma lista de políticos por estado da federação

    private Map<String, List<Politico>> partidosPoliticos;

    public Governo() {
        this.partidosPoliticos = new HashMap<String,List<Politico>>();
    }

    public void adicionarPolitico(String partidoPolitico, Politico politico) {
    //recupera a lista de políticos para um partido
        List<Politico>politicos = this.partidosPoliticos.get(partidoPolitico);
    //se não existir uma lista de políticos para o partido informado,
    //devemos instanciar uma nova lista (pois é a primeira inclusão neste partido)
        if(politicos == null){
            politicos = new ArrayList<Politico>();
        }
    //adiciona o político recebido como parâmetro à lista de políticos
        politicos.add(politico);
    //adiciona a lista de políticos ao mapa de partidos usando como chave o nome do partido
        this.partidosPoliticos.put(partidoPolitico, politicos);
    }
    public BigDecimal calcularGastosComSalario(String partidoPolitico) {
        List<Politico>politicos = this.partidosPoliticos.get(partidoPolitico);
        BigDecimal gastosComSalario = new BigDecimal(0);
            for (int i = 0; i < politicos.size(); i++) {
                BigDecimal salarioDoPolitico  = politicos.get(i).getCargo().getSalario();
                gastosComSalario = gastosComSalario.add(salarioDoPolitico);
        }
         return gastosComSalario;
    }

    public BigDecimal calcularGastosComSalarioParaCargo(Cargo cargo, String partidoPolitico) {
        List<Politico>politicos = this.partidosPoliticos.get(partidoPolitico);
        BigDecimal gastosComSalarioParaCargo = new BigDecimal(0);
            for (int i = 0; i < politicos.size(); i++) {
                if (politicos.get(i).getCargo().getDescricao().equals(cargo.getDescricao()) ) {
                    BigDecimal salarioDoPolitico = politicos.get(i).getCargo().getSalario();
                    gastosComSalarioParaCargo = gastosComSalarioParaCargo.add(salarioDoPolitico);
                }
            }
        return gastosComSalarioParaCargo;
    }

}
