public class Loja {
    private final String nome;
    private final Conta conta;
    private final Funcionario[] funcionarios;
    public Loja(String nome, Conta conta, Funcionario[] funcionarios) {
        this.nome = nome;
        this.conta = conta;
        this.funcionarios = funcionarios;
    }

    public String getNome() {
        return nome;
    }
    public Conta getConta() {
        return conta;
    }
    void pagarFuncionarios() {
        System.out.println("Pagar funcionários da loja " + nome);
        synchronized (conta) {
            for (Funcionario funcionario : funcionarios) {
                if (conta.getSaldo() >= Funcionario.getSalario()) {
                    conta.debitar(Funcionario.getSalario());
                    System.out.println("Funcionário " + funcionario.getNome() + " da loja " + nome +
                            " recebeu salário de R$" + Funcionario.getSalario());
                } else {
                    System.out.println("Saldo insuficiente para pagar o funcionário " + funcionario.getNome() +
                            " da loja " + nome);
                }
            }
        }
    }

}
