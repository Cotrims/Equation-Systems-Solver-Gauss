import leitorDeArquivo.LeitorDeArquivo;
import matriz.Matriz;
import teclado.Teclado;

public class Programa
{
	public static void main(String[] args)
	{
		try
		{
			/*System.out.println("=======================================================");
			System.out.println("              Bem-vindo || Método de Gauss             ");
			System.out.println("=======================================================");
			System.out.print("Digite o nome do arquivo (exemplo.txt): ");
			String nomeArq = Teclado.getUmString();

			LeitorDeArquivo leitor = new LeitorDeArquivo(nomeArq);
			Matriz mat = new Matriz(leitor.getMatriz());
			double[][] matriz = mat.getMatriz();

			System.out.println("");
			System.out.println("Sua matriz eh a seguinte:");
			System.out.println("");
			System.out.println("   /");

			for(int i = 0; i < mat.getLin();i ++)
			{
				System.out.print("   | ");

				for(int j = 0; j < mat.getCol(); j++)
				{
					if(j < mat.getCol()-1)
						System.out.print(matriz[i][j] + "" + (char)(j + 97) + ' ');
					else
						System.out.print(" = " + matriz[i][j]);
				}
				System.out.println("");
			}

			System.out.println("   \\");
			System.out.println("");
			*/

			double[][] matriz = new double[3][4];
			matriz[0][0] = 0;
			matriz[0][1] = 3;
			matriz[0][2] = 2;
			matriz[0][3] = 28;
			matriz[1][0] = 4;
			matriz[1][1] = 0;
			matriz[1][2] = 2;
			matriz[1][3] = 24;
			matriz[2][0] = 2;
			matriz[2][1] = 3;
			matriz[2][2] = 0;
			matriz[2][3] = 16;

			Matriz mat = new Matriz(matriz);

			while(mat.isDPComZero(mat.getMatriz())) //Retira todos os zeros da digonal principal
				mat.retirarZeros();

			for(int i = 0; i < mat.getLin(); i++)
			{
				mat.tornarUm(i);
				mat.tornarZero(i);
			}

			System.out.println("Resultados:");
			System.out.println("");

		    for(int i = 0; i < matriz.length; i++)
		    {
				System.out.println("   " + (char)(i + 97) + " vale: " + matriz[i][matriz[0].length-1]);
			}

			System.out.println("");
		 }
		 catch (Exception erro)
		 {
				System.out.println(erro.getMessage());
		 }
	}
}