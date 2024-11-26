package service;

import clientes.Cliente;
import clientes.Encomenda;
import transportes.*;

public class TransportService {

    public String selecionarTransporte(String tipo, Encomenda encomenda, Cliente cliente) {
        // Lógica de validação e criação de transporte
        if ("terrestre".equalsIgnoreCase(tipo)) {
            return criarTransporteTerrestre(encomenda, cliente);
        } else if ("aereo".equalsIgnoreCase(tipo)) {
            return criarTransporteAereo(encomenda, cliente);
        } else if ("maritimo".equalsIgnoreCase(tipo)) {
            return criarTransporteMaritimo(encomenda, cliente);
        } else if ("drone".equalsIgnoreCase(tipo)) {
            return criarTransporteDrone(encomenda, cliente);
        } else {
            throw new IllegalArgumentException("Tipo de transporte " + tipo + " não disponível.");
        }
    }

    // Métodos específicos para criar os tipos de transporte
    private String criarTransporteTerrestre(Encomenda encomenda, Cliente cliente) {
        // Adicionar lógica de validação do transporte terrestre
        if (encomenda.getPeso() > 20) {
            throw new IllegalArgumentException("O peso excede o limite para transporte terrestre.");
        }
        TransporteTerrestre transporte = new TransporteTerrestre();
        return transporte.selecionarTransporte(encomenda, cliente);
    }

    private String criarTransporteAereo(Encomenda encomenda, Cliente cliente) {
        // Adicionar lógica de validação do transporte aéreo
        if (encomenda.getPeso() > 50 || encomenda.getDimensao() > 200) {
            throw new IllegalArgumentException("A encomenda excede os limites de peso ou dimensões para transporte aéreo.");
        }
        TransporteAereo transporte = new TransporteAereo();
        return transporte.selecionarTransporte(encomenda, cliente);
    }

    private String criarTransporteMaritimo(Encomenda encomenda, Cliente cliente) {
        // Lógica de validação do transporte marítimo
        // O transporte marítimo só pode ser feito para clientes internacionais
        String localizacao = cliente.getLocalizacao(); // A localização do cliente está em uma String
        if (!"internacional".equalsIgnoreCase(localizacao)) {
            throw new IllegalArgumentException("O transporte marítimo está disponível apenas para entregas internacionais.");
        }
        TransporteMaritimo transporte = new TransporteMaritimo();
        return transporte.selecionarTransporte(encomenda, cliente);
    }

    private String criarTransporteDrone(Encomenda encomenda, Cliente cliente) {
        // Lógica de validação do transporte por drone
        // O drone só pode ser usado para pacotes pequenos e para entregas em áreas metropolitanas
        String localizacao = cliente.getLocalizacao(); // A localização do cliente está em uma String
        if (encomenda.getPeso() > 2) {
            throw new IllegalArgumentException("Entrega por drones é limitada a pacotes com peso até 2 kg.");
        }
        if (!"área metropolitana".equalsIgnoreCase(localizacao)) {
            throw new IllegalArgumentException("Entrega por drones é limitada a áreas metropolitanas.");
        }
        TransporteDrone transporte = new TransporteDrone();
        return transporte.selecionarTransporte(encomenda, cliente);
    }
}
