import javax.crypto.spec.PSource;
import java.math.BigDecimal;
import java.sql.*;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.printf("Pesquisa por nome: ");
        String nomePesquisa = scanner.nextLine();

        //Connection é um AutoCloseble
        //try-with-research
        try (Connection conexao = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/ej_comercial", "root", "Root@123");
             Statement comando = conexao.createStatement();
             // ResultSet é fechado automaticamente, quando o Statement é fechado
             // não é uma boa prática concatenar a string com select, problema com ' e SQL Injection
             ResultSet resultado = comando.executeQuery(
                     "select * from venda where nome_cliente like '%"
                             + nomePesquisa + "%'");
        ) {
            // Ideal no try
            //Statement comando = conexao.createStatement();
            //ResultSet resultado = comando.executeQuery("select * from venda");

            while(resultado.next()) {
                Long id = resultado.getLong("id");
                String nomeCliente = resultado.getString("nome_cliente");
                BigDecimal valorTotal = resultado.getBigDecimal("valor_total");
                // Não é o Date do Java, sim do java.sql
                Date dataPagamento = resultado.getDate("data_pagamento");

                System.out.printf("%d - %s R$%.2f %s%n",
                        id, nomeCliente, valorTotal, dataPagamento);
            }

            // ideal é no try
            //comando.close();
            //resultado.close();
            /*
            System.out.println(conexao.getClass());
            System.out.println(comando.getClass());
            System.out.println(resultado.getClass());
             */
        } catch (SQLException e) {
            System.out.println("Erro de banco de dados");
            e.printStackTrace();
            //throw new RuntimeException(e);
        }



    }

}
