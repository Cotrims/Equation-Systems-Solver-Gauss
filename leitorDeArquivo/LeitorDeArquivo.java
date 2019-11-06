package leitorDeArquivo;
import java.util.StringTokenizer;
import java.io.*;

public class LeitorDeArquivo
{
	private BufferedReader arquivo;

	public LeitorDeArquivo(String arq) throws Exception
	{
		if(arq.equals("") || arq == null)
			throw new Exception("Arquivo invalido");

		this.arquivo = new BufferedReader( new FileReader(arq));
	}

	public double[][] getUmaMatriz() throws Exception
	{
		double[][] ret = null;

		int dim = Integer.parseInt(getUmaLinha());
		ret = new double[dim][dim + 1];

		for (int i=0; i<dim; i++)
		{
			StringTokenizer quebrador = new StringTokenizer (getUmaLinha());

			for(int j = 0; quebrador.hasMoreTokens(); j++)
				ret[i][j] = Double.parseDouble(quebrador.nextToken());
        }

        return ret;
	}

	public String getUmaLinha() throws Exception
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

	public boolean equals(Object obj)
	{
		return this.arquivo.equals(obj);
	}
}


