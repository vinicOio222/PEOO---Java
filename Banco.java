package Banco_PEOO;

import java.util.ArrayList;

public class Banco {
    private String nome;
    private int id;
    private ArrayList<Conta>contas;

    public Banco(String nome, int id){
        this.nome = nome;
        this.id = id;
        contas = new ArrayList<Conta>();
    }
    public boolean notEquals(int conta){
        for(Conta i:contas){
            if(i.getConta()== conta)
            return false;
            }
            return true;
        }
    public boolean adicionarConta(String titular, int conta){
        if(notEquals(conta)){
            contas.add(new Conta(titular, conta));
            return false;
        }
        return false;
    }
    public boolean adicionarConta(String titular, int conta, double saldo){
        if(notEquals(conta)){
            contas.add(new Conta(titular, conta, saldo));
            return true;
        }
        return false;
    }
    public boolean adicionarContaCorrente(String titular, int conta){
        if(notEquals(conta)){
            Conta a = new ContaCorrente(titular, conta);
            contas.add(a);
            return true;
        }
        return false;
    }
    public boolean adicionarContaCorrente(String titular, int conta, double saldo){
        if(notEquals(conta)){
            Conta a  = new ContaCorrente(titular, conta, saldo);
            contas.add(a);
            return true;
        }
        return false;
    }
    public boolean adicionarContaCorrente(String titular, int conta, double saldo, double limite){
        if(notEquals(conta)){
           Conta a = new ContaCorrente(titular, conta, saldo, limite);
           contas.add(a);
           return true;
        }
        return false;
        }

        public boolean adicionarContaPoupanca(String titular, int conta, double saldo, double taxaRendimento){
            if(notEquals(conta)){
            Conta a  = new ContaPoupanca(titular, conta, saldo, taxaRendimento);
            contas.add(a);
            return true;
        }
        return false;
       }
        public boolean adicionarContaPoupanca(String titular, int conta, double taxaRendimento){
            if(notEquals(conta)){
                Conta  a = new ContaPoupanca(titular, conta, taxaRendimento);
                contas.add(a);
                return true;
            }
            return false;
        }
        
        public boolean adicionarConta(Conta c ){
            if(notEquals(c.getConta())){
                contas.add(c);
                return true;
            }
            return false;
        }

        public void mostrarContas(){
            for(Conta i :contas){
           System.out.println(i+"\n");  
          }
        }

     public Conta procurar(int conta){
         for(Conta i:contas){
             if(i.getConta()==conta)
             return i;
         }
         return null;
     }

     public boolean excluirConta(int conta){
         Conta a = procurar(conta);
         if(a!=null){
             contas.remove(a);
             return true;
         }
         return false;
     }

     public String getNome(){
         return nome;
     }

    public void setNome(String nome){
        this.nome = nome;
    }

    public int getId(){
        return id;

    }
    public void setId(int id){
        this.id = id;
    }

    public String toString(){
        return "Banco: "+nome+"\n"+"Id do Banco: "+id+"\n";
    }

}