import leitorDeArquivo.LeitorDeArquivo;
import matriz.Matriz;
import teclado.Teclado;
import gauss.Gauss;

public class Programa {
	public static void main(String[] args)
	{
		try {
			//Exibição do menu para o usuário
			System.out.println("=======================================================");
			System.out.println("              Bem-vindo || Metodo de Gauss             ");
			System.out.println("=======================================================");
			System.out.print("Digite o nome do arquivo (exemplo.txt): ");

			LeitorDeArquivo leitor;
			for (;;)
			{
				try
				{
					String nomeArq = Teclado.getUmString(); //Tenta ler o arquivo inserido
					leitor = new LeitorDeArquivo(nomeArq);  //Cria um leitor com o arquivo desejado
					break; //Sai do forever
				}
				catch (Exception err)
				{
					System.out.print("Arquivo nao encontrado, digite novamente: "); //Caso o arquivo não seja encontrado
					continue; //Repete a inserção do nome do arquivo
				}
			}

			for (int n = 1;true;n++) //Esse for executa o necessário para resolver um sistema n vezes
			{
				System.out.println("=======================================================");

				Matriz mat = null;
				try
				{
					mat = new Matriz(leitor.getUmaMatriz()); //Tenta pegar uma matriz do arquivo
				}
				catch (Exception err)
				{
					throw new Exception("Sem sistemas disponiveis no arquivo, fim do programa!");
					//Caso não seja retornado nada, significa que acabou o arquivo ent
				}

				//Exibição da matriz lida
				System.out.println();
				System.out.println("Seu " + n + "o sistema eh o seguinte:");
				System.out.println();
				System.out.println("   /");

				for (int i = 0; i < mat.getLin(); i++)
				{
					System.out.print("   | ");

					for (int j = 0; j < mat.getCol(); j++)
					{
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

				boolean valida = Gauss.valida(mat.getMatriz()); //Verifica se a matriz eh ou não eh válida

				//Resolve a matriz
				while (Gauss.isDPComZero(mat.getMatriz())) //Caso tenha zeros
					mat.setMatriz(Gauss.retirarZeros(mat.getMatriz())); //Retira os possíveis zeros da diagonal principal

				for (int i = 0; i < mat.getLin(); i++)
				{
					mat.setMatriz(Gauss.tornarUm(mat.getMatriz(), i)); //Divide a linha i de uma matriz
					mat.setMatriz(Gauss.tornarZero(mat.getMatriz(), i)); //Torna todos os demais elementos da coluna i em 0
				}

				//Exibição dos resultados
				System.out.println("Resultados:");
				System.out.println();

				if(valida)//Caso seja uma matriz válida teremos valores para exibir
					for (int i = 0; i < mat.getLin(); i++)
						System.out.println("   " + (char) (i + 97) + " vale: " + mat.getMatriz()[i][mat.getLin()]);
				else //Caso não, exibimos a menssagem nescessária para situação
				    System.out.println("   Esse sistema nao tem solucao!");

				//Caso o usuário queira ler mais sistemas no arquivo ele poderera escolher
				//entre ler mais um ou sair do programa
				System.out.println();
				System.out.println("Deseja calcular mais um sistema?");
				System.out.println("Opcoes: 0 para sim || 1 para nao");
				System.out.print("Sua escolha: ");

				byte opcao;
				for (;;)
				{
					try
					{
						opcao = Teclado.getUmByte(); //Obtêm a opção do usuário
						if (opcao != 0 && opcao != 1) //Verifica se a opção está dentro das opções válidas
							throw new Exception();
						break;
					}
					catch (Exception err)
					{
						System.out.print("Opcao invalida, digite novamente: "); //Caso a opção não seja válida
						continue; //Recomença a inserção da opção
					}
				}

				if (opcao == 0) //Se o usuário deseje recomeçar
					continue; //Voltamos ao inicio do forever
				else //Caso não
					break; //Encerramos o programa
			}

			System.out.println("==========================Adeus!=======================");
			System.exit(1);  //Termina o programa
		}
		catch (Exception err)
		{
			System.out.println(err.getMessage());
		}
	}
}