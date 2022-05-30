package Banco_PEOO;

public class ContaCorrente extends Conta {
    private double limite;

    public ContaCorrente(String titular,int conta){
        super(titular,conta);
        this.limite = 1000;
    }
    public ContaCorrente(String titular,int conta, double saldo){
        super(titular, conta, saldo);
        this.limite = 1000;
    }

    public ContaCorrente(String titular, int conta, double saldo, double limite){
        super(titular, conta,saldo);
        this.limite = limite;
    }
    public void debitarAnuidade(){  
        saldo-=50;  
    }
    
    public boolean verificarSaque(double valor){
        if(saldo + limite >= valor){
            return true;
        }
        return false;
    }

    public String toString(){
        return "Conta : Corrente\n"
              +"-------------------\n"
              +"Nome: "+titular+"\n"
              +"ID de Conta: "+conta+"\n"
              +"Saldo: R$"+String.format("%.2f",saldo)+"\n"
              +"Limite de Saldo: R$ -"+String.format("%.2f",limite)+"\n";
    }
}
