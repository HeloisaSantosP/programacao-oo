import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Placar placar = new Placar();
        String continuar;

        do {
            System.out.print("Digite o nome do jogador: ");
            String nome = teclado.nextLine();
            Jogador jogador = new Jogador(nome);
            Jogo jogo = new Jogo(jogador);

            boolean acertou = false;

            while (!acertou) {
                System.out.print("Tente adivinhar o número (1 a 100): ");
                int tentativa = teclado.nextInt();
                teclado.nextLine();

                String resultado = jogo.jogar(tentativa);
                System.out.println(resultado);

                if (resultado.contains("Acertou")) {
                    acertou = true;
                    System.out.println("Tentativas: " + jogador.getTentativas());
                    System.out.println("Pontuação: " + jogador.getPontuacao());
                    placar.adicionarJogador(jogador);
                }
            }

            System.out.print("\nDeseja adicionar outro jogador? (s/n): ");
            continuar = teclado.nextLine().toLowerCase();

        } while (continuar.equals("s"));

        placar.mostrarRanking();
        teclado.close();
    }
}
