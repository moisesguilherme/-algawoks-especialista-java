import com.algaworks.banco.*;

public class Principal {

    public static void main(String[] args) {
        CaixaEletronico caixaEletronico = new CaixaEletronico();

        ContaEspecial conta1 = new ContaEspecial( new Titular("João da Silva", "12312312300"),
                1234, 999999,90);
        conta1.setLimiteChequeEspecial(1000);


        ContaInvestimento conta2 = new ContaInvestimento( new Titular("João da Silva", "12312312300"),
                1234, 999999);
        conta2.depositar(100);
        conta2.creditarRendimentos(10);


        ContaSalario conta3 = new ContaSalario(new Titular("João da Silva", "12312312300"),
                1234, 999999, 18_000);
        conta3.depositar(100);

        //caixaEletronico.imprimirDemostrativo(conta2);
        //caixaEletronico.imprimirDemostrativo(conta1); //ContaEspecial é um tipo de conta Investimento
        //Conta salário vai ter problema.
        caixaEletronico.imprimirDemostrativo(conta3); //Erro -> ClassCastException. na hora de fazer a coersão.


    }

}
