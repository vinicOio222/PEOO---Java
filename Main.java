package Banco_PEOO;

import java.util.Scanner;

public class Main {
    public static void main(String []args){
    System.out.println("\tBem-vindo ao Sistema Bancário\n");
    String nome, titular;
    int id,op,conta;
    double valor,limite, taxa;
    Scanner ler = new Scanner(System.in);
    System.out.println("Insira o nome de seu Banco: ");
    nome  = ler.next();
    System.out.println("Digite o ID de seu Banco: ");
    id = ler.nextInt();
    Banco b = new Banco(nome,id);
    int ativo = 1;

    while(ativo == 1){
        System.out.println("\n\tMenu do Banco "+ b.getNome()+"\n");
        System.out.println("1.Adicionar Conta;\n2.Listar Contas;\n3.Selecionar Conta;\n4.Remover Conta;\n5.Sair do Programa;");
        op = ler.nextInt();
        switch(op){
          case 1:
             System.out.println("Digite o tipo de conta:\n1.Conta Corrente\n2.Conta Poupança");
             op = ler.nextInt();
             if(op == 1){
                System.out.println("Digite o nome do titular e um número de conta válido:");
                System.out.printf("Nome de Titular: ");
                titular = ler.next();
                System.out.printf("Número da Conta: ");
                conta = ler.nextInt();
                System.out.println("Há depósito inicial na conta: 1.sim 2.não");
                op = ler.nextInt();
                if(op == 1){
                  System.out.println("Digite o depósito inicial: ");
                  valor = ler.nextDouble();
                System.out.println("Há limite específico ? 1.sim 2.não");
                op = ler.nextInt();
                if(op == 1){
                    System.out.println("Insira o limite: ");
                    limite = ler.nextDouble();
                if(b.adicionarContaCorrente(titular,conta,valor,limite)){
                    System.out.println("Conta criada com sucesso!");
                }else{
                    System.out.println("Operação inválida. Número de conta já existente!");
                 }
                }else{
                   if(b.adicionarContaCorrente(titular, conta, valor)){
                    System.out.println("Conta criada com sucesso!");
                   }else{
                    System.out.println("Operação inválida. Número de conta já existente!");

                   }
                }
             }else{
                System.out.println("Há um limite específico? 1.sim 2.não");
                op = ler.nextInt();
                if(op == 1){
                    System.out.println("Insira o limite: ");
                    limite = ler.nextDouble();
                    if(b.adicionarContaCorrente(titular, conta, limite)){
                        System.out.println("Conta criada com sucesso!"); 
                    }else{
                        System.out.println("Operação inválida. Número de conta já existente!");
                    }
                }else{
                    if(b.adicionarContaCorrente(titular, conta)){
                        System.out.println("Conta criada com sucesso!");
                }else{
                    System.out.println("Operação inválida. Número de conta já existente!");

                }
               }  
              }
         }else{
             System.out.println("Digite o nome do titular e um número de conta válido:");
             System.out.printf("Nome de Titular: ");
             titular = ler.next();
             System.out.printf("Número da Conta: ");
             conta = ler.nextInt();
             System.out.println("Há depósito inicial na conta: 1.sim 2.não");
                op = ler.nextInt();
                if(op == 1){
                  System.out.println("Digite o depósito inicial: ");
                  valor = ler.nextDouble();
                  System.out.println("Insira a taxa: ");
                  taxa = ler.nextDouble();
                  if(b.adicionarContaPoupanca(titular, conta, valor, taxa)){
                      System.out.println("Conta criada com sucesso!");
                  }else{
                      System.out.println("Operação inválida. Número de conta já existente!");
                  }

                }else{
                    System.out.println("Insira a taxa: ");
                    taxa = ler.nextDouble();
                    if(b.adicionarContaPoupanca(titular, conta, taxa)){
                        System.out.println("Conta criada com sucesso!");
                    }else{
                        System.out.println("Operação inválida. Número de conta já existente!");
                    }   
                }
             }
             
              break;
        case 2:
              System.out.println("\n\tExibindo todas as contas do Banco "+b.getNome()+"\n");
              b.mostrarContas();
              break;
        case 3:
              System.out.println("Digite o número da conta que deseja selecionar: ");
              conta = ler.nextInt();
              Conta c1 = b.procurar(conta);
            if(c1 != null ){
                int ativo2 = 1;
                while(ativo2 == 1){
                    System.out.println("\n\tConta do titular "+c1.getTitular()+" selecionada\n");
                    System.out.println("1.Depósito\n2.Saque\n3.Transferência\n4.Sair do menu conta");
                    op = ler.nextInt();
                    switch(op){
                        case 1:
                        System.out.println("Digite o valor a ser depositado: ");
                        valor = ler.nextDouble();
                        c1.depositar(valor);
                        System.out.println("Depósito realizado com sucesso.\nNovo saldo: R$"+c1.getSaldo());
                        break;
                        case 2:
                        System.out.println("Digite o valor a ser sacado: ");
                        valor  = ler.nextDouble();
                        if(c1.sacar(valor)){
                            System.out.println("Saque efetuado com sucesso!\n"
                            +"Saldo Atual: R$"+String.format("%.2f", c1.getSaldo()));

                        }else{
                            System.out.println("Saldo insuficiente!");
                        }
                        break;
                        case 3:
                        System.out.println("Insira o número da conta destino: ");
                        conta = ler.nextInt();
                        System.out.println("Digite o valor de transferência: ");
                        valor = ler.nextDouble();
                        Conta contaDestino = b.procurar(conta);
                        if(contaDestino !=null){
                            if(c1.transferir(contaDestino, valor)){
                                System.out.println("Transferência feita com sucesso!");
                                System.out.println("Saldo da Conta Emissora: R$"+String.format("%.2f",c1.getSaldo()));
                                System.out.println("Saldo da Conta Receptora: R$"+String.format("%.2f",contaDestino.getSaldo()));


                            }else{
                                System.out.println("Saldo insuficiente!");
                            }
                        }else{
                            System.out.println("Transferência inválida. Número de conta NÃO REGISTRADO!");
                        }
                        break;
                        case 4:
                        System.out.println("Saindo do menu conta.");
                        ativo2 = 0;
                        break;
                    }
                }

              }else{
                System.out.println("Número de conta NÃO REGISTRADO!");
              }break;
      case 4:
              System.out.println("Insira o número da conta que deseja deletar:");
              conta  = ler.nextInt();
              if(b.excluirConta(conta)){
              System.out.println("Conta removida com sucesso!");
               }else{
                System.out.println("Conta NÃO REGISTRADA!");
              }
              break;
        case 5: 
               System.out.println("Saindo do Programa. Até mais!");
               ativo = 0;
              break;
              default:
            System.out.println("Operação inválida!");
       }
     }
ler.close();
  }
}
