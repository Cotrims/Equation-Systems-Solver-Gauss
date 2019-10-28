import java.util.StringTokenizer;
import java.io.*;

public class Programa {
    public static void main(String[] args) {
        int[][] matriz;

        try {
            BufferedReader arquivo = new BufferedReader(new FileReader("gauss.txt"));

            int qtdEquacoes = Integer.parseInt(arquivo.readLine());
            matriz = new int[qtdEquacoes][qtdEquacoes + 1];

            for (int i = 0; i < qtdEquacoes; i++) {
                StringTokenizer quebrador = new StringTokenizer(arquivo.readLine());

                for (int j = 0; quebrador.hasMoreTokens(); j++)
                    matriz[i][j] = Integer.parseInt(quebrador.nextToken());
            }
        } catch (Exception erro) {
            // ...
        }
    }
}