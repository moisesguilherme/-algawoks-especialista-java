import com.algaworks.comercial.entidade.Venda;
import com.algaworks.comercial.repositorio.FabricaDeRepositorio;
import com.algaworks.comercial.repositorio.VendaRepositorio;
import com.algaworks.comercial.servico.CadastroVendaServico;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;

public class Principal {

    public static void main(String[] args) throws SQLException {
        // Evitar usar o MemoriaFabricaDeRepositorio() em outro local, na interface
        try(FabricaDeRepositorio fabriacaDeRepositorio = FabricaDeRepositorio.obterIntancia()) {
            VendaRepositorio vendaRepositorio = fabriacaDeRepositorio.criarVendaRepositorio();
            var cadastroVendaServico = new CadastroVendaServico(vendaRepositorio);
            Venda vendaCadastrada = cadastroVendaServico.cadastrar("Moisés Paschoalick",
                    new BigDecimal("12300.87"), LocalDate.parse("2023-04-19"));

            System.out.println("Venda cadastrada: " + vendaCadastrada);

            System.out.println("Listando todas as vendas:");
            var todasVendas = vendaRepositorio.consultar();
            todasVendas.forEach(System.out::println);
        }
    }
}
