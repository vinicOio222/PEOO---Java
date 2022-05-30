package Banco_PEOO;

public class ContaPoupanca extends Conta{
    private double taxaRendimento;

    public ContaPoupanca(String titular, int conta, double taxaRendimento){
        super(titular, conta);
        this.taxaRendimento = taxaRendimento;

    }
    public ContaPoupanca(String titular, int conta, double saldo, double taxaRendimento){
        this(titular, conta, taxaRendimento);
        this.saldo = saldo;
    }

    public double getTaxaRendimento(){
        return taxaRendimento;

    }
    
    public String toString(){
        return "Conta : Poupança"+"\n"
              +"-------------------\n"
              +"Nome: "+titular+"\n"
              +"Conta: "+conta+"\n"
              +"Saldo: R$"+String.format("%.2f",saldo)+"\n"
              +"Taxa de Rendimento: "+taxaRendimento+"%\n"
              +"Saldo Final(Aplicada a Taxa): R$"+String.format("%.2f",saldo+saldo*taxaRendimento*0.01);
    }
}
