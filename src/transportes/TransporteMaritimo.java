package transportes;

import clientes.Cliente;
import clientes.Encomenda;

public class TransporteMaritimo {
    public String selecionarTransporte(Encomenda encomenda, Cliente cliente) {
        if ("internacional".equals(cliente.getLocalizacao())) {
            return "Escolhido transporte marítimo para a entrega internacional em " + cliente.getLocalizacao() + ".";
        } else {
            throw new IllegalArgumentException("O transporte marítimo está disponível apenas para entregas internacionais.");
        }
    }
}
