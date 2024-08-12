package desafiodesingpattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Classe Transacao representa a entidade do domínio
class Transacao {
    private List<Double> transacoes;

    public Transacao(List<Double> transacoes) {
        this.transacoes = transacoes;
    }

    public List<Double> getTransacoes() {
        return transacoes;
    }
}

// Classe AnaliseTransacoesUseCase contém a lógica do caso de uso
class AnaliseTransacoesUseCase {
    
	public String analisar(Transacao transacao) {
        List<Double> transacoes = transacao.getTransacoes();
        double saldoFinal = 0;
        double maiorDeposito = Double.MIN_VALUE;
        double maiorRetirada = Double.MAX_VALUE;

        // TODO: Implemente a condição para a análise das transações:
        double subSaldo = 0;
        for (Double transaction : transacoes){
        	
        	if(transaction > 0) {
        		if(transaction > maiorDeposito) {
        			maiorDeposito = transaction;
        		}  		
        	}else {
        		if(transaction < maiorRetirada) {
        			maiorRetirada = transaction;
        		}  	
        	}
        	subSaldo += transaction;
        }
        
        saldoFinal = subSaldo;
        
        String posNeg;
       posNeg = (saldoFinal >= 0) ? "Saldo positivo" : "Saldo Negativo";
        return String.format("Saldo: %.2f\nDeposito: %.2f\n"
        		+ "Retirada: %.2f\n%s", saldoFinal, maiorDeposito, maiorRetirada, posNeg);

        // TODO: Construa a saída de forma adequada e como solicitado na descrição do desafio:
        
            }
}

// Classe principal que funciona como interface de entrada/saída e execução do caso de uso
public class AnaliseTransacoes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leitura do número de transações
        int numeroTransacoes = scanner.nextInt();

        // Leitura das transações
        List<Double> transacoes = new ArrayList<>();
        for (int i = 0; i < numeroTransacoes; i++) {
            transacoes.add(scanner.nextDouble());
        }

        // Criação da entidade Transacao
        Transacao transacao = new Transacao(transacoes);

        // Criação e execução do caso de uso
        AnaliseTransacoesUseCase useCase = new AnaliseTransacoesUseCase();
        String resultado = useCase.analisar(transacao);

        // Saída do resultado
        System.out.println(resultado);

        scanner.close();
    }
}