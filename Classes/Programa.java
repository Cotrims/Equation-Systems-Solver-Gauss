import java.util.StringTokenizer;
import java.io.*;

public class Programa 
{
	public static void main(String[] args)
	{
		int [][]matriz;

		try
		{
			for(byte i = 0; i < 75; i++)
				System.out.print("=");

			System.out.println("");

		    BufferedReader arquivo = new BufferedReader (
		                             new FileReader (
		                             "teste.txt"));

		    int qtdEquacoes = Integer.parseInt (arquivo.readLine());
		    matriz = new int[qtdEquacoes][qtdEquacoes + 1];

			for (int i=0; i<qtdEquacoes; i++)
			{
				StringTokenizer quebrador = new StringTokenizer (arquivo.readLine());

	            for(int j = 0; quebrador.hasMoreTokens(); j++)
					 matriz[i][j] = Integer.parseInt(quebrador.nextToken());
            }

		    for(int i = 0; i < qtdEquacoes; i++)
		    {
				for(int j = 0; j < qtdEquacoes + 1; j++)
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