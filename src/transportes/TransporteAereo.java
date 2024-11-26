package transportes;

import clientes.Cliente;
import clientes.Encomenda;

public class TransporteAereo {
    public String selecionarTransporte(Encomenda encomenda, Cliente cliente) {
        if (encomenda.getPeso() <= 50 && encomenda.getDimensao() <= 200) {  // Limites de peso e dimensões
            return "Escolhido transporte aéreo para a entrega em " + cliente.getLocalizacao() + ".";
        } else {
            throw new IllegalArgumentException("A encomenda excede os limites de peso ou dimensões para transporte aéreo.");
        }
    }
}
