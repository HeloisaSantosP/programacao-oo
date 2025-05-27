public class Main {
    public static void main(String[] args) {
        Funcionario funcionario1 = new FuncionarioCLT("Carlos", 2000.00);
        Funcionario funcionario2 = new FuncionarioTemporario("Ana", 2000.00);

        System.out.println("Funcionário 1:");
        funcionario1.exibirDados();
        System.out.println("Salário Final: R$ " + funcionario1.calcularSalario());
        System.out.println();

        System.out.println("Funcionário 2:");
        funcionario2.exibirDados();
        System.out.println("Salário Final: R$ " + funcionario2.calcularSalario());
    }
}
