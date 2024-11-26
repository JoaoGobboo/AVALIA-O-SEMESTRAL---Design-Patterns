package transportes;

import clientes.Cliente;
import clientes.Encomenda;

public class TransporteDrone {
    public String selecionarTransporte(Encomenda encomenda, Cliente cliente) {
        if ("área metropolitana".equals(cliente.getLocalizacao()) && encomenda.getPeso() <= 2) {
            return "Escolhido transporte por drone para entrega na área metropolitana em " + cliente.getLocalizacao() + ".";
        } else {
            throw new IllegalArgumentException("Entrega por drones é limitada a áreas metropolitanas e pequenos pacotes.");
        }
    }
}
