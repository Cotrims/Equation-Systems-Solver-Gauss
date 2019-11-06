import leitorDeArquivo.LeitorDeArquivo;
import matriz.Matriz;
import teclado.Teclado;
import gauss.Gauss;

public class Programa {
	/*
	 * javadocs validar/senaoehresolvivel
	 */
	public static void main(String[] args) {
		try {
			System.out.println("=======================================================");
			System.out.println("              Bem-vindo || Metodo de Gauss             ");
			System.out.println("=======================================================");
			System.out.print("Digite o nome do arquivo (exemplo.txt): ");

			LeitorDeArquivo leitor;
			for (;;) {
				try {
					String nomeArq = Teclado.getUmString();
					leitor = new LeitorDeArquivo(nomeArq);
					break;
				} catch (Exception err) {
					System.out.print("Arquivo nao encontrado, digite novamente: ");
					continue;
				}
			}

			for (int n = 1;true;n++) {
				System.out.println("=======================================================");

				Matriz mat = null;
				try {
					mat = new Matriz(leitor.getUmaMatriz());
				} catch (Exception err) {
					throw new Exception("Sem sistemas disponiveis no arquivo, fim do programa!");
				}

				System.out.println();
				System.out.println("Seu " + n + "o sistema eh o seguinte:");
				System.out.println();
				System.out.println("   /");

				for (int i = 0; i < mat.getLin(); i++) {
					System.out.print("   | ");

					for (int j = 0; j < mat.getCol(); j++) {
						if (j < mat.getCol() - 1)
							System.out.print((mat.getMatriz()[i][j] >= 0 ? "+" : "") + mat.getMatriz()[i][j] + ""
									+ (char) (j + 97) + ' ');
						else
							System.out.print("= " + mat.getMatriz()[i][j]);
					}
					System.out.println();
				}

				System.out.println("   \\");
				System.out.println();

				while (Gauss.isDPComZero(mat.getMatriz()))
					mat.setMatriz(Gauss.retirarZeros(mat.getMatriz()));

				for (int i = 0; i < mat.getLin(); i++) {
					mat.setMatriz(Gauss.tornarUm(mat.getMatriz(), i));
					mat.setMatriz(Gauss.tornarZero(mat.getMatriz(), i));
				}

				System.out.println("Resultados:");
				System.out.println();

				for (int i = 0; i < mat.getLin(); i++)
					System.out.println("   " + (char) (i + 97) + " vale: " + mat.getMatriz()[i][mat.getLin()]);

				System.out.println();
				System.out.println("Deseja calcular mais um sistema?");
				System.out.println("Opcoes: 0 para sim || 1 para nao");
				System.out.print("Sua escolha: ");

				byte opcao;
				for (;;) {
					try {
						opcao = Teclado.getUmByte();
						if (opcao != 0 && opcao != 1)
							throw new Exception();
						break;
					} catch (Exception err) {
						System.out.print("Opcaoo invalida, digite novamente: ");
						continue;
					}
				}

				if (opcao == 0)
					continue;
				else
					break;
			}

			System.out.println("==========================Adeus!=======================");
			System.exit(1);
		} catch (Exception err) {
			System.out.println(err.getMessage());
		}
	}
}