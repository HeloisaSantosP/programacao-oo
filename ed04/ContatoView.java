import java.util.List;
import java.util.Scanner;

class ContatoView {
    private Scanner sc = new Scanner(System.in);

    public void exibirMenu(ContatoController controller) {
        int opcao;
        do {
            System.out.println("\n=== AGENDA DE CONTATOS ===");
            System.out.println("1. Adicionar Contato");
            System.out.println("2. Remover Contato");
            System.out.println("3. Listar Contatos");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1: adicionarContato(controller); break;
                case 2: removerContato(controller); break;
                case 3: mostrarContatos(controller.listar()); break;
                case 0: System.out.println("Saindo..."); break;
                default: System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private void adicionarContato(ContatoController controller) {
        System.out.print("Tipo (1 - Pessoa Física, 2 - Pessoa Jurídica): ");
        int tipo = sc.nextInt(); sc.nextLine();

        System.out.print("Nome: ");
        String nome = sc.nextLine();
        if (nome.length() < 3) {
            System.out.println("Nome deve conter pelo menos 3 caracteres.");
            return;
        }

        System.out.print("Telefone: ");
        String telefone = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();

        if (tipo == 1) {
            System.out.print("CPF (11 dígitos): ");
            String cpf = sc.nextLine();
            if (!cpf.matches("\\d{11}")) {
                System.out.println("CPF inválido.");
                return;
            }
            controller.adicionar(new PessoaFisica(nome, telefone, email, cpf));
        } else if (tipo == 2) {
            System.out.print("CNPJ (14 dígitos): ");
            String cnpj = sc.nextLine();
            if (!cnpj.matches("\\d{14}")) {
                System.out.println("CNPJ inválido.");
                return;
            }
            controller.adicionar(new PessoaJuridica(nome, telefone, email, cnpj));
        } else {
            System.out.println("Tipo inválido.");
        }
    }

    private void removerContato(ContatoController controller) {
        System.out.print("Digite o CPF ou CNPJ para remover: ");
        String id = sc.nextLine();
        controller.remover(id);
    }

    public void mostrarContatos(List<Contato> contatos) {
        System.out.println("\n--- CONTATOS ---");
        for (Contato c : contatos) {
            System.out.println("-----------------------------");
            System.out.println("Nome: " + c.getNome());
            System.out.println("Telefone: " + c.getTelefone());
            System.out.println("Email: " + c.getEmail());
            if (c instanceof PessoaFisica) {
                System.out.println("CPF: " + ((PessoaFisica) c).getCpf());
            } else if (c instanceof PessoaJuridica) {
                System.out.println("CNPJ: " + ((PessoaJuridica) c).getCnpj());
            }
        }
    }
}
