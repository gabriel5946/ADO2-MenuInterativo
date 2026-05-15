import java.util.Random;
import java.util.Scanner;

public class CampoMinado {

    static Scanner sc = new Scanner(System.in);

    static int[][] campo;

    static char[][] visual;

    static int linhas;
    static int colunas;
    static int bombas;

    static int pontos = 0;

    public static void main(String[] args) {

        configurarJogo();
        distribuirBombas();

        boolean jogoAtivo = true;

        while (jogoAtivo) {

            imprimirMatriz();

            System.out.println("Pontuação: " + pontos);

            System.out.print("Digite a linha: ");
            int linha = sc.nextInt();

            System.out.print("Digite a coluna: ");
            int coluna = sc.nextInt();

            if (linha < 0 || linha >= linhas || coluna < 0 || coluna >= colunas) {
                System.out.println("Posição inválida!");
                continue;
            }

            if (visual[linha][coluna] == 'x') {
                System.out.println("Essa posição já foi escolhida!");
                continue;
            }

            if (campo[linha][coluna] == -1) {

                visual[linha][coluna] = 'b';

                System.out.println("\nGAME OVER!");
                imprimirMatriz();

                System.out.println("Pontuação final: " + pontos);

                jogoAtivo = false;

            } else {

                visual[linha][coluna] = 'x';

                campo[linha][coluna] = 1;

                pontos++;

                if (haBombaAoRedor(linha, coluna)) {
                    System.out.println("Cuidado: bomba próxima!");
                }

                int maxPontos = (linhas * colunas) - bombas;

                if (pontos == maxPontos) {

                    System.out.println("\nParabéns, você ganhou o jogo!");

                    imprimirMatriz();

                    System.out.println("Pontuação final: " + pontos);

                    jogoAtivo = false;
                }
            }
        }
    }

    public static void configurarJogo() {

        do {
            System.out.print("Digite o número de linhas (mínimo 2): ");
            linhas = sc.nextInt();

            System.out.print("Digite o número de colunas (mínimo 2): ");
            colunas = sc.nextInt();

        } while (linhas < 2 || colunas < 2);

        int totalCelulas = linhas * colunas;

        do {
            System.out.print("Digite a quantidade de bombas: ");
            bombas = sc.nextInt();

        } while (bombas <= 0 || bombas >= totalCelulas);

        campo = new int[linhas][colunas];
        visual = new char[linhas][colunas];

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                visual[i][j] = '_';
            }
        }
    }

    public static void distribuirBombas() {

        Random random = new Random();

        int qtdBombas = 0;

        while (qtdBombas < bombas) {

            int i = random.nextInt(linhas);
            int j = random.nextInt(colunas);

            if (campo[i][j] != -1) {

                campo[i][j] = -1;
                qtdBombas++;
            }
        }
    }

    public static void imprimirMatriz() {

        System.out.println();

        for (int i = 0; i < linhas; i++) {

            System.out.print("[ ");

            for (int j = 0; j < colunas; j++) {
                System.out.print(visual[i][j] + " ");
            }

            System.out.println("]");
        }

        System.out.println();
    }

    public static boolean haBombaAoRedor(int linha, int coluna) {

        for (int i = linha - 1; i <= linha + 1; i++) {

            for (int j = coluna - 1; j <= coluna + 1; j++) {

                if (i >= 0 && i < linhas && j >= 0 && j < colunas) {

                    if (campo[i][j] == -1) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
