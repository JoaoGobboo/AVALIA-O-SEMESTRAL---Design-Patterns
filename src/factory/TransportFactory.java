package factory;

import transportes.*;
import clientes.*;

public class TransportFactory {
    public String criarTransporte(String tipo, Encomenda encomenda, Cliente cliente) {
        if ("terrestre".equalsIgnoreCase(tipo)) {
            TransporteTerrestre transporte = new TransporteTerrestre();
            return transporte.selecionarTransporte(encomenda, cliente);
        } else if ("aereo".equalsIgnoreCase(tipo)) {
            TransporteAereo transporte = new TransporteAereo();
            return transporte.selecionarTransporte(encomenda, cliente);
        } else if ("maritimo".equalsIgnoreCase(tipo)) {
            TransporteMaritimo transporte = new TransporteMaritimo();
            return transporte.selecionarTransporte(encomenda, cliente);
        } else if ("drone".equalsIgnoreCase(tipo)) {
            TransporteDrone transporte = new TransporteDrone();
            return transporte.selecionarTransporte(encomenda, cliente);
        } else {
            throw new IllegalArgumentException("Tipo de transporte " + tipo + " não disponível.");
        }
    }
}
