import java.util.StringTokenizer;
import java.io.*;

public class Programa
{
	public static void main(String[] args)
	{
		double [][]matriz;

		try
		{
			for(byte i = 0; i < 75; i++)
				System.out.print("=");

			System.out.println("");

		    BufferedReader arquivo = new BufferedReader (
		                             new FileReader (
		                             "gauss.txt"));

		    int qtdEquacoes = Integer.parseInt(arquivo.readLine());
		    matriz = new double[qtdEquacoes][qtdEquacoes + 1];

			for (int i=0; i<qtdEquacoes; i++)
			{
				StringTokenizer quebrador = new StringTokenizer (arquivo.readLine());//separa os conjuntos de numero por linha

	            for(int j = 0; quebrador.hasMoreTokens(); j++)
					 matriz[i][j] = Double.parseDouble(quebrador.nextToken());//pega o digito após o espaço
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