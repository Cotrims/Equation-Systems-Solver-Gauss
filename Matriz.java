/**
 * Classe que representa a matriz e da acesso seguro a ela, contendo a matriz,
 * sua quantidade de linhas e colunas.
 * 
 * @author Vinicius Cotrim 19040
 * @author Manuela Benassi 19184
 * @since 2019
 */
public class Matriz implements Comparable<Matriz>, Cloneable {
    /**
     * Mantém armazenado a matriz que a classe representará
     */
    private double[][] matriz;

    /**
     * Mantém armazenado a quantidade de linhas que a matriz da classe possui.
     */
    private int lin;

    /**
     * Mantém armazenado a quantidade de colunas que a matriz da classe possui.
     */
    private int col;

    /**
     * Constroi uma nova instância da classe Matriz. Passando como parâmetro a
     * matriz que a classe armazenará.
     * 
     * @param matriz A matriz que será armazenada.
     * @throws Exception Se a matriz passada como parâmetro for nula.
     */
    public Matriz(double[][] matriz) throws Exception {
        setMatriz(matriz);
        setLin(matriz.length);
        setCol(matriz[0].length);
    }

    /**
     * Seta uma matriz em this. Validando para se ela for passada antes de
     * inserirmos ela na classe.
     * 
     * @param matriz Uma matriz de doubles.
     * @throws Exception Caso a matriz passada como parâmetro seja nula.
     */
    public void setMatriz(double[][] matriz) throws Exception {
        if (matriz == null)
            throw new Exception("matriz inválida");

        this.matriz = matriz;
    }

    /**
     * Seta o valor do atributo lin em this. Validando para se ela for um tamanho de
     * linha válido, ou seja, maior que zero.
     * 
     * @param lin Inteiro que corresponde a quantidade de linhas.
     * @throws Exception Caso a linha seja menor ou igual que 0.
     */
    public void setLin(int lin) throws Exception {
        if (lin <= 0 || lin > matriz.length)
            throw new Exception("Linha inválida");

        this.lin = lin;
    }

    /**
     * Seta o valor do atributo col em this. Validando para se ela for um tamanho de
     * colunas válido, ou seja, maior que zero.
     * 
     * @param col Inteiro que corresponde a quantidade de colunas.
     * @throws Exception Caso a coluna seja menor ou igaul que 0.
     */
    public void setCol(int col) throws Exception {
        if (col <= 0 || col > matriz[0].length)
            throw new Exception("Coluna inválida");

        this.col = col;
    }

    /**
     * Obtêm a matriz armazenada em this.
     * 
     * @return A matriz presente em this.
     */
    public double[][] getMatriz() {
        return this.matriz;
    }

    /**
     * Obtêm a quantidade de linhas.
     *
     * @return int quantidade de linhas da matriz de this.
     */
    public int getLin() {
        return this.lin;
    }

    /**
     * Obtêm a quantidade de colunas;
     * 
     * @return int quantidade de colunas da matriz de this.
     */
    public int getCol() {
        return this.col;
    }

    /**
     * Gera uma representação textual de todo conteudo da Matriz. Produz e resulta
     * um String com todos os valores das linhas i e colunas j.
     * 
     * @return um String contendo todo o conteúdo da Matriz.
     */
    public String toString() {
        String ret = "";

        for (int i = 0; i < getLin(); i++) {
            ret += '\n';
            for (int j = 0; j < matriz[0].length; j++)
                ret += matriz[i][j] + " ";
        }

        return ret;
    }

    /**
     * Verifica a igualdade entre duas Matrizes. Verifica se o Object fornecido como
     * parâmetro representa uma Matriz igual a representada pela instância onde este
     * método for aplicado, resultando true em caso afirmativo, ou false, caso
     * contrário.
     * 
     * @param obj O objeto a ser comparado com a instância a qual esse método for
     *            aplicado.
     * @return true, caso o Object fornecido ao método e a instância chamante do
     *         método representarem Matrizes iguais, ou false, caso contrário.
     */
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (this.getClass() != obj.getClass())
            return false;

        Matriz mat = (Matriz) obj;

        if (this.lin != mat.lin)
            return false;

        if (this.col != mat.col)
            return false;

        for (int i = 0; i < getLin(); i++)
            for (int j = 0; j < getCol(); j++)
                if (this.matriz[i][j] != mat.matriz[i][j])
                    return false;

        return true;
    }

    /**
     * Calcula e resulta o código de espalhamento (ou código de hash) de uma Matriz.
     * Acumula os valores de seus atributos 'lin', 'col' e os valores dentro da
     * matris de this.
     * 
     * @return O código de hash da Matriz chamante do método.
     */

    public int hashcode() {
        int ret = 1;
        final int PRIMO = 3;

        ret = ret * PRIMO * new Integer(this.col);
        ret = ret * PRIMO * new Integer(this.lin);

        for (int i = 0; i < getLin(); i++)
            for (int j = 0; j < getCol(); j++)
                ret = ret * PRIMO + new Double(this.matriz[i][j]).hashCode();

        if (ret < 0)
            ret = -ret;

        return ret;
    }

    /**
     * Compara a matriz com outra matriz. Compara as dimensões das matrizes
     * multiplicando sua linha por sua colina.
     * 
     * @param mat Uma matriz que vai ser comparada.
     * @return Um inteiro seguindo a seguinte ordem:
     *         <ol>
     *         <li>Um inteiro i negativo é retornado quando a dimensão de this é
     *         menor que a de mat</li>
     *         <li>Um inteiro i positivo é retornado quando a dimensão de this é
     *         maior que a de mat</li>
     *         </ol>
     */
    public int compareTo(Matriz mat) {
        if (this.col * this.lin > mat.col * mat.lin)
            return 1;

        if (this.col * this.lin < mat.col * mat.lin)
            return -1;

        return 0;
    }

    /**
     * Constroi uma cópia da instância da classe Matriz dada.
     * Passando então um modelo de Matriz, que é uma instancia
     * da classe, para construir a nova instância
     * @param modelo um objeto da classe matriz que será usado como modelo
     * @throws Exception Se o modelo passado como parâmetro não existir
     */
    public Matriz(Matriz modelo) throws Exception {
        if (modelo == null)
            throw new Exception("Modelo ausente");

        this.col = modelo.col;
        this.lin = modelo.lin;
        this.matriz = modelo.matriz;
    }

    /**
     * Clona uma Matriz. Produz e resulta uma cópia da agenda representada pela
     * instância a qual o método for aplicado.
     * 
     * @return a cópia da Matriz representada pela instância a qual o metodo for
     * aplicado.
     */
    public Object clone() {
        Matriz ret = null;

        try {
            ret = new Matriz(this);
        } catch (Exception err) {
        }
        return ret;
    }
}