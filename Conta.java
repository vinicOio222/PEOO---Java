package Banco_PEOO;

public class Conta {
  protected String titular;
  protected int conta;
  protected double saldo;

  public Conta(String titular, int conta, double saldo){
      this.titular = titular;
      this.conta = conta;
      this.saldo = saldo;
  }

  public Conta(String titular, int conta){
      this.titular = titular;
      this.conta = conta;
  }

  public void depositar(double valor){
      saldo+=valor;
  }
  public boolean sacar(double valor){
      if(verificarSaque(valor)){
          saldo-=valor;
          return true;
      }
      return false;
  }
  public boolean transferir(Conta outra, double valor){
      if(sacar(valor)){
          outra.depositar(valor);
          return true;
      }
      return false;

  }
  public boolean verificarSaque(double valor){
      if(saldo>=valor){
          return true;
      }
      return false;
   }
  public void debitarAnuidade(){

   }
  
   public String getTitular(){
       return titular;
   }
   public void setTitular(String titular){
       this.titular = titular;

   }
   public int getConta(){
       return conta;
   }
   public void setConta(int conta){
       this.conta = conta;
   }
   public double getSaldo(){
       return saldo;
   }
   public void setSaldo(double saldo){
       this.saldo = saldo;
   }

   public String toString(){
       return "Nome: "+titular+"\n" 
            + "ID de Conta: "+conta+"\n"
            + "Saldo disponível: R$"+saldo+"\n";
   }
    
}
