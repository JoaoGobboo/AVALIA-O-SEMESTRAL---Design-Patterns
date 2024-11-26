package transportes;

import clientes.Cliente;
import clientes.Encomenda;

public class TransporteTerrestre {
    public String selecionarTransporte(Encomenda encomenda, Cliente cliente) {
        if (encomenda.getPeso() <= 20) {  // Limite de peso
            return "Escolhido transporte terrestre com transportadora local para a entrega em " + cliente.getLocalizacao() + ".";
        } else {
            throw new IllegalArgumentException("O peso excede o limite para transporte terrestre.");
        }
    }
}
