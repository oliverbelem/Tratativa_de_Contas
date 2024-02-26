package Aplication;

import Model.Entities.Conta;
import Model.Exceptions.BusinessException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double limiteSaque = 300.00;


            System.out.println("Dados da conta:");
            System.out.println("---------------");

            System.out.print("Numero da conta: ");
            int numeroConta = sc.nextInt();
            sc.nextLine();
            System.out.print("Titular da conta: ");
            String titularConta = sc.nextLine();
            System.out.print("Saldo da Inicial: R$");
            double saldoConta = sc.nextDouble();
            System.out.println("Limite de Saque: R$" + limiteSaque);

            Conta conta = new Conta(numeroConta, titularConta, saldoConta, limiteSaque);

            System.out.println("--------------------------------");
            System.out.print("Quantia para saque: R$");
            double valor = sc.nextDouble();

        try {
            conta.saque(valor);
            System.out.println(conta);
        }
        catch (BusinessException e){
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}
