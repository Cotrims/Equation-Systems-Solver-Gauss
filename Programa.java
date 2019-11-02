import leitorDeArquivo.LeitorDeArquivo;
import matriz.Matriz;
import teclado.Teclado;
import java.util.StringTokenizer;
import java.io.*;

public class Programa
{
	public static void main(String[] args)
	{
		double [][]matriz;

		try
		{

			System.out.println("=======================================================");
			System.out.println("              Bem-vindo || M�todo de Gauss             ");
			System.out.println("=======================================================");
			System.out.print("Digite o nome do arquivo (exemplo.txt): ");
			String nomeArq = Teclado.getUmString();
			LeitorDeArquivo leitor = new LeitorDeArquivo("gauss.txt");
			matriz = leitor.getMatriz();


		    for(int i = 0; i < matriz[0].length; i++)
		    {
				for(int j = 0; j < 4; j++)
				{
					System.out.print(" " + matriz[i][j]);
				}
				System.out.println("");
			}
		 }
		 catch (Exception erro)
		 {
				//...
		 }
	}
}