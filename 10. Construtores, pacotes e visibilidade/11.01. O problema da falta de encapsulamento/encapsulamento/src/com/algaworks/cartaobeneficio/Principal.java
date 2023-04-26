package com.algaworks.cartaobeneficio;

import com.algaworks.cartaobeneficio.servico.ServicoDeDepositoPix;
import com.algaworks.cartaobeneficio.servico.ServicoDePagamentoOnline;

public class Principal {

    public static void main(String[] args) {
        var supermercado = new Estabelecimento("Supermercado do Zé");
        var cartao = new Cartao("João Souza Silva");


        // vc pode alterar diretamente, isso não é bom.
        // ainda consegue colocar saldo negativo.
        cartao.saldo = -700;
        /*
        var servicoDeDeposito = new ServicoDeDepositoPix();
        Recibo reciboDeposito = servicoDeDeposito.efetuarDeposito(cartao, 500);
        reciboDeposito.imprimir();
        */

        var servicoDePagamento = new ServicoDePagamentoOnline();
        Recibo reciboPagamento = servicoDePagamento.efetuarPagamento(supermercado, cartao, 100);
        reciboPagamento.imprimir();

        System.out.printf("Titular: %s%n", cartao.titular);
        System.out.printf("Saldo: %.2f%n", cartao.saldo);


    }

}
