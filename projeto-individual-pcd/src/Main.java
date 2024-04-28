public class Main {
    public static void main(String[] args) {

        Banco banco = new Banco();

        // Contas das lojas
        Conta contaLoja1 = new Conta("Casas Bahia", 0);
        Conta contaLoja2 = new Conta("Ricardo Eletro", 0);

        // Funcionários das lojas
        Funcionario[] funcionariosLoja1 = {
            new Funcionario("João Silva", contaLoja1, null),
            new Funcionario("Ana Souza", contaLoja1, null)
        };
        Funcionario[] funcionariosLoja2 = {
            new Funcionario("Carlos Oliveira", contaLoja2, null),
            new Funcionario("Mariana Costa", contaLoja2, null)
        };

        // Lojas
        Loja loja1 = new Loja("Casas Bahia", contaLoja1, funcionariosLoja1);
        Loja loja2 = new Loja("Ricardo Eletro", contaLoja2, funcionariosLoja2);

        // Contas e clientes
        Conta contaFuncionario1 = new Conta("João Silva - Salário", 0);
        Conta contaInvestimentoFuncionario1 = new Conta("João Silva - Investimento", 0);

        Conta contaFuncionario2 = new Conta("Ana Souza - Salário", 0);
        Conta contaInvestimentoFuncionario2 = new Conta("Ana Souza - Investimento", 0);

        Conta contaFuncionario3 = new Conta("Carlos Oliveira - Salário", 0);
        Conta contaInvestimentoFuncionario3 = new Conta("Carlos Oliveira - Investimento", 0);

        Conta contaFuncionario4 = new Conta("Mariana Costa - Salário", 0);
        Conta contaInvestimentoFuncionario4 = new Conta("Mariana Costa - Investimento", 0);

        Conta contaCliente1 = new Conta("Lúcia Mendes", 1000);
        Conta contaCliente2 = new Conta("Pedro Alves", 1000);
        Conta contaCliente3 = new Conta("Catarina Santos", 1000);
        Conta contaCliente4 = new Conta("Rafael Oliveira", 1000);
        Conta contaCliente5 = new Conta("Amanda Pereira", 1000);

        Cliente[] clientes = {
            new Cliente("Lúcia Mendes", contaCliente1, new Loja[]{loja1, loja2}, banco),
            new Cliente("Pedro Alves", contaCliente2, new Loja[]{loja1, loja2}, banco),
            new Cliente("Catarina Santos", contaCliente3, new Loja[]{loja1, loja2}, banco),
            new Cliente("Rafael Oliveira", contaCliente4, new Loja[]{loja1, loja2}, banco),
            new Cliente("Amanda Pereira", contaCliente5, new Loja[]{loja1, loja2}, banco)
        };

        for (Cliente cliente : clientes) {
            cliente.start();
        }

        try {
            for (Cliente cliente : clientes) {
                cliente.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        loja1.pagarFuncionarios();
        loja2.pagarFuncionarios();

        Conta[] contas = {
            contaLoja1, contaLoja2,
            contaFuncionario1, contaFuncionario2, contaFuncionario3, contaFuncionario4,
            contaInvestimentoFuncionario1, contaInvestimentoFuncionario2, contaInvestimentoFuncionario3,
            contaInvestimentoFuncionario4, contaCliente1, contaCliente2, contaCliente3, contaCliente4, contaCliente5
        };

        banco.exibirSaldosFinais(contas);
    }
}