import com.algaworks.entidade.Venda;
import com.algaworks.servico.CadastroVendaServico;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Principal {

    public static void main(String[] args) {
        var cadastroVendaServico = new CadastroVendaServico();
        Venda vendaCadastrada = cadastroVendaServico.cadastrar("Moisés Paschoalick",
                new BigDecimal("12300.87"), LocalDate.parse("2023-04-19"));

        System.out.println(vendaCadastrada);
    }

}
