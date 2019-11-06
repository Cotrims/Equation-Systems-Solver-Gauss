import leitorDeArquivo.LeitorDeArquivo;
import matriz.Matriz;
import teclado.Teclado;
import gauss.Gauss;

public class Programa {
	public static void main(String[] args)
	{
		try {
			//Exibi��o do menu para o usu�rio
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
					System.out.print("Arquivo nao encontrado, digite novamente: "); //Caso o arquivo n�o seja encontrado
					continue; //Repete a inser��o do nome do arquivo
				}
			}

			for (int n = 1;true;n++) //Esse for executa o necess�rio para resolver um sistema n vezes
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
					//Caso n�o seja retornado nada, significa que acabou o arquivo ent
				}

				//Exibi��o da matriz lida
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

				boolean valida = Gauss.valida(mat.getMatriz()); //Verifica se a matriz eh ou n�o eh v�lida

				//Resolve a matriz
				while (Gauss.isDPComZero(mat.getMatriz())) //Caso tenha zeros
					mat.setMatriz(Gauss.retirarZeros(mat.getMatriz())); //Retira os poss�veis zeros da diagonal principal

				for (int i = 0; i < mat.getLin(); i++)
				{
					mat.setMatriz(Gauss.tornarUm(mat.getMatriz(), i)); //Divide a linha i de uma matriz
					mat.setMatriz(Gauss.tornarZero(mat.getMatriz(), i)); //Torna todos os demais elementos da coluna i em 0
				}

				//Exibi��o dos resultados
				System.out.println("Resultados:");
				System.out.println();

				if(valida)//Caso seja uma matriz v�lida teremos valores para exibir
					for (int i = 0; i < mat.getLin(); i++)
						System.out.println("   " + (char) (i + 97) + " vale: " + mat.getMatriz()[i][mat.getLin()]);
				else //Caso n�o, exibimos a menssagem nescess�ria para situa��o
				    System.out.println("   Esse sistema nao tem solucao!");

				//Caso o usu�rio queira ler mais sistemas no arquivo ele poderera escolher
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
						opcao = Teclado.getUmByte(); //Obt�m a op��o do usu�rio
						if (opcao != 0 && opcao != 1) //Verifica se a op��o est� dentro das op��es v�lidas
							throw new Exception();
						break;
					}
					catch (Exception err)
					{
						System.out.print("Opcao invalida, digite novamente: "); //Caso a op��o n�o seja v�lida
						continue; //Recomen�a a inser��o da op��o
					}
				}

				if (opcao == 0) //Se o usu�rio deseje recome�ar
					continue; //Voltamos ao inicio do forever
				else //Caso n�o
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