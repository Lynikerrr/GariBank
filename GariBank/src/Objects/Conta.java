package Objects;

public class Conta {
    private long numero;
    private double limite;
    private double saldo;
    Agencia agencia;

    public Conta(double saldo, double limite, long numero){
        this.saldo = saldo;
        this.limite = limite;
        this.numero = numero;
    }
    public void depositar(double deposito) {
        saldo += deposito;
        System.out.println("==========================");
        System.out.println("=== Depósito concluído ===");
        System.out.println("==========================");
    }

    public void sacar(double saque) {
        if (saldo >= saque) {
            saldo -= saque;
            System.out.println("==========================");
            System.out.println("=== Saque concluído ======");
            System.out.println("==========================");
        } else {
            System.out.println("==========================");
            System.out.println("= Saldo insuficiente! ====");
            System.out.println("==========================");
        }
    }

    public void transferir(double valor) {
                if (saldo >= valor) {
                    saldo -= valor;

                    System.out.println("==========================");
                    System.out.println("== Transferência feita ===");
                    System.out.println("==========================");
                } else {
                    System.out.println("==========================");
                    System.out.println("= Saldo insuficiente! ====");
                    System.out.println("==========================");
                }

    }




    public void exibirSaldo() {
        System.out.println("==========================");
        System.out.println("===== Seu saldo é: =======");
        System.out.println(saldo);
        System.out.println("==========================");
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public void setSaldo(double saldo){
        this.saldo = saldo;
    }

    public long getNumero() {
        return numero;
    }
}


