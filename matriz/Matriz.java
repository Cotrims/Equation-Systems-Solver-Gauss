package matriz;
/** Classe que preenche a matriz e da acesso seguro a ela
 * @author Vinicius Cotrim 19040
 * @author Manuela Benassi 19184
*  @since 2019
 */
public class Matriz implements Comparable<Matriz>, Cloneable
{
    private double[][] matriz;
    private int lin, col;
/**Construtor de matriz
 * @param matriz uma matriz de doubles
 * @throws Exception os métodos chamados "jogam excessão"
 */
    public Matriz(double[][] matriz) throws Exception
    {
        setMatriz(matriz);
        setLin(matriz.length);
        setCol(matriz[0].length);
    }
/** Dá a matriz da classe a matriz que o usuário pede
 * @param matrizuma matriz de doubles
 * @throws Exception caso a matriz seja nula
 */
    public void setMatriz(double[][] matriz) throws Exception
    {
        if (matriz == null)
            throw new Exception("matriz inválida");

        this.matriz = matriz;
    }
/**Dá a linha o valor que o usuário quer
 * 
 * @param lin inteiro que corresponde a linha
 * @throws Exception caso a linha seja menor que 0
 */
    public void setLin(int lin) throws Exception
    {
        if (lin <= 0)
            throw new Exception("Linha inválida");

        this.lin = lin;
    }
/**Dá a coluna o valor que o usuário quer
 *  
 * @param col int que corresponde a coluna
 * @throws Exception se coluna for negativa
 */
    public void setCol(int col) throws Exception
    {
        if (col <= 0)
            throw new Exception("Coluna inválida");

        this.col = col;
    }
/**pega a matriz
 * @return a matriz
 */
    public double[][] getMatriz()
    {
        return this.matriz;
    }
/**pega a quantidade de linhas
 * 
 * @return int quantidade de linhas
 */
    public int getLin()
    {
        return this.lin;
    }
/**
 * pega a quantidade de linhas da matriz
 * @return quantidade de linhas da matriz
 */
    public int getCol()
    {
        return this.col;
    }
/**transforma a matriz em uma string
 * @return ums string da matriz
 */
    public String toString()
    {
        String ret = "";

        for (int i = 0; i < getLin(); i++)
        {
            ret += '\n';
            for (int j = 0; j < matriz[0].length; j++)
                ret += matriz[i][j] + " ";
        }

        return ret;
    }
/**compara a matriz com o objeto passado como parametro
 * @param obj um objeto
 * @return true se for igual, false se não
 */
    public boolean equals(Object obj)
    {
        if (this==obj)
            return true;

        if (obj==null)
            return false;

        if (this.getClass()!=obj.getClass())
            return false;

        Matriz mat = (Matriz)obj; 

        if(this.lin != mat.lin)
            return false;

        if(this.col != mat.col)
            return false;

        for (int i = 0; i < getLin(); i++)
            for (int j = 0; j < matriz[0].length; j++)
                if(this.matriz[i][j] != mat.matriz[i][j])
                    return false;

        return true;
    }
    /**Faz o código da matriz
     * 
     * @return um inteiro que representa o codigo
     */

    public int hashcode()
    {
        int ret = 1;
        final int PRIMO = 3;

        ret = ret * PRIMO * new Integer(this.col);
        ret = ret * PRIMO * new Integer(this.lin);

        for (int i = 0; i < getLin(); i++)
            for (int j = 0; j < matriz[0].length; j++)
                ret = ret * PRIMO + new Double(this.matriz[i][j]).hashCode();

        if(ret < 0)
            ret = -ret;

        return ret;
    }
/**compara a matriz com outra matriz
 * @param mat uma matriz que vai ser comparada
 * @return 1 se for maior, -1 se for menor e 0 se for igual
 * 
 */
    public int compareTo(Matriz mat)
    {
        if(this.col*this.lin > mat.col*mat.lin)
            return 1;
        
        if(this.col*this.lin < mat.col*mat.lin)
            return -1;

        return 0;
    }
/**
 * Construtor de cópia de matriz 
 * @param modelo um objeto da classe matriz que sera clonado
 * @throws Exception se o modelo não existir
 */
    public Matriz(Matriz modelo) throws Exception
    {
        if(modelo == null)
            throw new Exception("Modelo ausente");

        this.col = modelo.col;
        this.lin = modelo.lin;
        this.matriz = modelo.matriz;
    }
/**Clona a matriz dessa classe
 * @return uma matriz
 */
    public Object clone()
    {
        Matriz ret = null;

        try
        {
            ret = new Matriz(this);
        }
        catch(Exception err)
        {}
        return ret;
    }
}