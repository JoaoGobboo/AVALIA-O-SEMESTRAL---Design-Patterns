import clientes.Cliente;
import clientes.Encomenda;
import service.TransportService;

public class App {
    public static void main(String[] args) {
        TransportService transportService = new TransportService();

        // Teste 1: Transporte por Drone - Validação bem-sucedida
        Encomenda encomenda1 = new Encomenda(1, 50);  // Peso: 1 kg, Dimensão: 50 cm
        Cliente cliente1 = new Cliente("área metropolitana");
        testarTransporte("drone", encomenda1, cliente1, transportService);

        // Teste 2: Transporte por Drone - Exceção (peso maior que 2 kg)
        Encomenda encomenda2 = new Encomenda(3, 50);  // Peso: 3 kg
        Cliente cliente2 = new Cliente("área metropolitana");
        testarTransporte("drone", encomenda2, cliente2, transportService);

        // Teste 3: Transporte por Drone - Exceção (não está na área metropolitana)
        Encomenda encomenda3 = new Encomenda(1, 50);  // Peso: 1 kg
        Cliente cliente3 = new Cliente("nacional");
        testarTransporte("drone", encomenda3, cliente3, transportService);

        // Teste 4: Transporte Marítimo - Exceção (não é internacional)
        Encomenda encomenda4 = new Encomenda(10, 100);  // Peso: 10 kg
        Cliente cliente4 = new Cliente("nacional");
        testarTransporte("maritimo", encomenda4, cliente4, transportService);

        // Teste 5: Transporte Marítimo - Validação bem-sucedida
        Encomenda encomenda5 = new Encomenda(10, 100);  // Peso: 10 kg
        Cliente cliente5 = new Cliente("internacional");
        testarTransporte("maritimo", encomenda5, cliente5, transportService);
    }

    private static void testarTransporte(String tipoTransporte, Encomenda encomenda, Cliente cliente, TransportService transportService) {
        try {
            String resultado = transportService.selecionarTransporte(tipoTransporte, encomenda, cliente);
            System.out.println("Transporte selecionado: " + resultado);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}


