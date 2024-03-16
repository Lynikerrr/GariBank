package Objects;

public class Cliente {

    String nome;
    String documento;
    Conta conta;
    Cartao cartao;
    Cartao nubank = new Cartao();

    public Cliente(String nome, String documento, long numeroConta, long saldo,
                   long limite, int numeroAgencia) {
        this.nome = nome;
        this.documento = documento;
        this.conta = new Conta(saldo,limite,numeroConta);
        this.conta.setNumero(numeroConta);
        this.conta.setSaldo(saldo);
        this.conta.setLimite(limite);
        this.conta.agencia = new Agencia();
        this.conta.agencia.numero = numeroAgencia;
    }


    public Cartao getNubank() {
        return nubank;
    }

    public void setNubank(Cartao nubank) {
        this.nubank = nubank;
    }


    public long getNumeroConta() {
        return conta.getNumero();
    }
    public Conta getConta(){
        return conta;
    }
}
