import java.util.ArrayList;

public class Placar {
    private ArrayList<Jogador> ranking;

    public Placar() {
        this.ranking = new ArrayList<>();
    }

    public void adicionarJogador(Jogador j) {
        ranking.add(j);
    }

    public void mostrarRanking() {
        System.out.println("\nRanking de Jogadores:");
        for (Jogador j : ranking) {
            System.out.println(j.getNome() + " - Pontuação: " + j.getPontuacao());
        }
    }
}
