package leitorDeArquivo;
import java.util.StringTokenizer;
import java.io.*;
/**Classe que lê o arquivo da matriz
 * @author Vinicius Cotrim 19040
 * @author Manuela Benassi 19184
 * @since 2019
 */
public class LeitorDeArquivo
{
	private BufferedReader arquivo;
/**
 * Lê os arquivo
 * @param arq uma string que contem o nome do arquivo a ser lido
 * @throws Exception se o nome do arquivo não conter caracteres, ou seja,foz vazia
 */
	public LeitorDeArquivo(String arq) throws Exception
	{
		if(arq.equals("") || arq == null)
			throw new Exception("Arquivo invalido");

		this.arquivo = new BufferedReader( new FileReader(arq));
	}
/**pega a matriz e preenche 
 * 
 * @return uma matriz preenchida pelo arquivo
 * @throws Exception método chamado(getUmaLinha)
 */
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
/**pega uma linha do arquivo e a lê
 * 
 * @returnuma string com os dados da linha
 * @throws Exception quando da erro na leitura
 */
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
/**transforma o arquivo em string
 * @return arquivo no formato de string
 */
	public String toString()
	{
		return this.arquivo.toString();
	}
/**faz o codigo do arquivo
 * @return um codigo que representa um arquivo
 */
	public int hashCode()
	{
		return this.arquivo.hashCode();
	}
/**verifica se é igual a um objeto
 * @param obj objeto que será comparado
 * @return true se for igual, false se for diferente
 */
	public boolean equals(Object obj)
	{
		return this.arquivo.equals(obj);
	}
}


