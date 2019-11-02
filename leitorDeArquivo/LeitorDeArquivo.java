package leitorDeArquivo;
import java.util.StringTokenizer;
import java.io.*;

public class LeitorDeArquivo
{
	private BufferedReader arquivo;
	private dim;//dimensões da matriz

	public LeitorDeArquivo(String arq) throws Exception
	{
		if(arq.equals("") || arq == null)
			throw new Exception("Arquivo inv�lido");

		this.arquivo = new BufferedReader( new FileReader(arq));
	}
	public int getDim()
	{
		return dim;


	}
	this.getMatriz[0][0];

	public double[][] getMatriz() throws Exception
	{
		double[][] ret;

		int dim = Integer.parseInt(getLinha());
		ret = new double[dim][dim + 1];

		for (int i=1; i<dim; i++)
		{
			StringTokenizer quebrador = new StringTokenizer (getLinha());

			for(int j = 0; quebrador.hasMoreTokens(); j++)
			{
				ret[i][j] = Double.parseDouble(quebrador.nextToken());
			}
        }

        return ret;
	}

	public String getLinha() throws Exception
	{
		String ret = "";

		try
		{
			ret =  this.arquivo.readLine();
		}
		catch(Exception err)
		{
			throw new Exception("Erro na leitura");
		}

		return ret;
	}

	public String toString()
	{
		return this.arquivo.toString();
	}

	public int hashCode()
	{
		return this.arquivo.hashCode();
	}


	/*equals
	compareto
	clone
	construtor de clone
	HashCide*/
}


