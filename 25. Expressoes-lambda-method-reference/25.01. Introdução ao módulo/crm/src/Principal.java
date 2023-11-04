import com.algaworks.crm.CadastroCliente;
import com.algaworks.crm.Cliente;
import com.algaworks.crm.Filtro;

import java.util.List;

public class Principal {

    public static void main(String[] args) {
        var cadastroCliente = new CadastroCliente();
        cadastroCliente.adicionar(new Cliente("João", 30));
        cadastroCliente.adicionar(new Cliente("Maria", 90));
        cadastroCliente.adicionar(new Cliente("Sebastião", 50));
        cadastroCliente.adicionar(new Cliente("Joaquina", 45));
        cadastroCliente.adicionar(new Cliente("Josefina", 25));

        //Java 8 Lambda expression

        /*Filtro<Cliente> filtro = new Filtro<Cliente>() {
            @Override
            public boolean avaliar(Cliente cliente) {
                return cliente.getIdade() > 40;
            }
        };*/
        // Lambda é dividida em 2 partes, esquerda e direita.
        // diretia é as acões que vai ser executada
        // Esquerda: (Cliente cliente) parâmetros da instrucão

        Filtro<Cliente> filtro = (Cliente cliente) -> {
            boolean resultado = cliente.getIdade() > 40;
            return resultado;
        };

        List<Cliente> clientes = cadastroCliente.consultar(filtro);

        for (Cliente cliente : clientes) {
            System.out.printf("%s - %d%n", cliente.getNome(), cliente.getIdade());
        }
    }

}