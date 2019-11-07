package leitorDeArquivo;

import java.util.StringTokenizer;
import java.io.*;

/**
 * Classe leitora de arquivo texto, com sua estância é possivel retornar, por
 * exemplo, uma matriz lida de um determinado arquivo.
 * 
 * @author Vinicius Cotrim 19040
 * @author Manuela Benassi 19184
 * @since 2019
 */
public class LeitorDeArquivo {
	/**
	 * Um tipo de BufferedReader que será instanciado como um leitor de aquivo de um
	 * determinado arquivo.
	 */
	protected BufferedReader arquivo;

	/**
	 * Constroi uma nova instância da classe LeitorDeArquivo. Passando então, para
	 * essa instânciação, o nome do arquivo a ser lido.
	 * 
	 * @param arq uma string que contem o nome do arquivo a ser lido.
	 * @throws Exception se o nome do arquivo não conter caracteres, ou seja,foz
	 *                   vazia.
	 */
	public LeitorDeArquivo(String arq) throws Exception {
		if (arq.equals("") || arq == null)
			throw new Exception("Arquivo invalido");

		this.arquivo = new BufferedReader(new FileReader(arq));
	}

	/**
	 * Lê o arquivo e retorna uma matriz de double. Para que a leitura ocorra sem
	 * falhas o arquivo deve estar formatado em: 1ª linha é a dimensão da matriz;
	 * 2ª e demais linhas o conteudo da matriz.
	 * 
	 * @return Uma matriz preenchida pelo arquivo
	 * @throws Exception Método chamado(getUmaLinha) é passível de lanças exceções
	 */
	public double[][] getUmaMatriz() throws Exception {
		double[][] ret = null;

		int dim = Integer.parseInt(getUmaLinha());
		ret = new double[dim][dim + 1];

		for (int i = 0; i < dim; i++) {
			StringTokenizer quebrador = new StringTokenizer(getUmaLinha());

			for (int j = 0; quebrador.hasMoreTokens(); j++)
				ret[i][j] = Double.parseDouble(quebrador.nextToken());
		}

		return ret;
	}

	/**
	 * Lê uma linha da arquivo. Após ler uma linha do aquivo, se a leitura for bem
	 * sucedida, esta será retornada como uma String.
	 * 
	 * @return Uma String com os dados da linha.
	 * @throws Exception Quando da erro na leitura.
	 */
	public String getUmaLinha() throws Exception {
		String ret = "";

		try {
			ret = this.arquivo.readLine();
		} catch (Exception err) {
			throw new Exception("Erro na leitura");
		}

		return ret;
	}

	/**
	 * Gera uma representaçãoo textual de todo conteúdo 
	 * do LeitorDeArquivo.
	 * @return um String contendo todo o conteúdo do LeitorDeArquivo.
	 */
	public String toString() {
		return this.arquivo.toString();
	}

	/**
	 * Calcula e resulta o código de espalhamento (ou código de hash) de um
	 * LeitorDeArquivo.
	 * 
	 * @return O código de hash do LeitorDeArquivo chamante do método.
	 */
	public int hashCode() {
		return this.arquivo.hashCode();
	}

	/**
	 * Verifica a igualdade entre dois LeitorDeArquivo.
	 * 
	 * @param obj Objeto que será comparado com a instância.
	 * @return true se for igual, false se for diferente.
	 */
	public boolean equals(Object obj) {
		return this.arquivo.equals(obj);
	}
}
