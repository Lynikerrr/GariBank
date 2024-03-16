package Objects;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        Cliente lyniker = new Cliente("Lyniker Santos", "451849553", 11111, 5000000, 100000000, 10);
        Cliente ricardo = new Cliente("Ricardo Furlanetto","465879135",22222,500000,5000000,20);
        Cliente marcos = new Cliente("Elvio Marcos", "136444898",33333,250000,5000000,30);
        Cliente felipe = new Cliente("Felipe Silva","798898944",44444,987954,5000000,40);
        Cliente ana = new Cliente("Ana Luisa", "455892774",55555,4987684,5000000,50);
        mensagemInicial();

        Cliente clienteLogado = autenticarCliente(entrada, lyniker, ricardo, marcos, felipe, ana);

        if (clienteLogado != null) {
            exibirMenuOperacoes(clienteLogado, entrada);
        } else {
            System.out.println("Usuário não autenticado. Encerrando programa.");
        }
    }

    public static void mensagemInicial() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("==========================");
        System.out.println("===== Seja Bem-Vindo =====");
        System.out.println("=========== Ao ===========");
        System.out.println("======== GariBank ========");
        System.out.println("==========================");
        System.out.println();
        System.out.println();
    }

    private static Cliente autenticarCliente(Scanner entrada, Cliente... clientes) {
        System.out.println("==========================");
        System.out.println("===== Insira a Conta =====");
        System.out.println("==========================");
        System.out.println();
        long contaEnt = entrada.nextLong();

        System.out.println("==========================");
        System.out.println("==== Insira a Agência ====");
        System.out.println("==========================");
        System.out.println();
        long agenciaEnt = entrada.nextLong();
        for (Cliente cliente : clientes) {
            if (cliente.getNumeroConta() == contaEnt) {
                return cliente;
            }
        }
        return null;
    }

    private static void exibirMenuOperacoes(Cliente cliente, Scanner entrada, Cliente... clientes) {

        boolean sair = false;

        while (!sair) {
            System.out.println("==========================");
            System.out.println(cliente.nome);
            System.out.println("==========================");
            System.out.println("========= Opções =========");
            System.out.println("====== 1 - Depósito ======");
            System.out.println("====== 2 - Sacar =========");
            System.out.println("====== 3 - Transferir ====");
            System.out.println("====== 4 - Extrato =======");
            System.out.println("====== 5 - Sair===========");
            System.out.println("==========================");
            System.out.print("Escolha uma opção: ");

            int opcao = entrada.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("==========================");
                    System.out.println("===== Digite o valor =====");
                    System.out.println("====== do depósito =======");
                    System.out.println("==========================");
                    long deposito = entrada.nextLong();
                    cliente.getConta().depositar(deposito);
                    break;
                case 2:
                    System.out.println("==========================");
                    System.out.println("=== Qual valor deseja ====");
                    System.out.println("===== fazer o saque? =====");
                    System.out.println("==========================");
                    long saque = entrada.nextLong();
                    cliente.getConta().sacar(saque);
                    break;
                case 3:
                    System.out.println("==========================");
                    System.out.println("=== Qual valor deseja ====");
                    System.out.println("====== transferir? =======");
                    System.out.println("==========================");
                    long transf = entrada.nextLong();
                    System.out.println("==========================");
                    System.out.println("===== Qual conta vai =====");
                    System.out.println("======== receber? ========");
                    System.out.println("==========================");
                    long contaDestino = entrada.nextLong();
                    cliente.getConta().transferir(transf);
                    break;

                case 4:
                    cliente.getConta().exibirSaldo();
                    break;
                case 5:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    break;

            }
        }
    }

    private static Cliente encontrarClientePorNumeroConta(long numeroConta, Cliente... clientes) {
        for (Cliente cliente : clientes) {
            if (cliente.getNumeroConta() == numeroConta) {
                return cliente;
            }
        }
        return null;
    }
}
