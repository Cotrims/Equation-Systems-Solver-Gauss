package gauss;
/**A classe singleton Gauss resolve o escalonamento de matrizes, trabalhando
 * sempre com uma matriz de numeros double e métodos que representam cada 
 * parte do escalonamento.
 * @author Vinicius Cotrim 19040.
 * @author Manuela Benassi 19184.
 * @since 2019.
 */
public class Gauss {
    /**Verifica se a coluna da matriz possui zeros.
     * Para tanto, recebe um vetor coluna e uma linha
     * lançando exceções caso os parametros sejam inválidos.
     * Percorre a coluna passada como parâmetro e retorna 
     * algum boolean correspondente.
     * @param col Coluna que verifica se tem 0.
     * @param lin Linha correspondente ao elemento da diagonal principal.
     * @return true se a coluna possuir zeros, e false se não possuir.
     * @throws Exception Se a coluna não for fornecida, se a linha fornecida for menor que zero
     * ou se a linha for maior que os limites da coluna.
     */
    public static boolean isColunaComZero(double[] col, int lin) throws Exception {
        if (col == null)
            throw new Exception("coluna para validar inexistente");
        if(lin < 0)
            throw new Exception("linha menor que zero");

        for (int i = 0; i < col.length; i++) {
            if (i == lin)
                i++;

            if (i == col.length)
                return true;

            if (col[i] != 0)
                return false;
        }

        return true;
    }
    /**Verifica se a diagonal principal da matriz possui algum 0.
     * Com um for, percorre toda a diagonal principal da matriz 
     * passada como parâmetro e verifica se algum de seus elementos 
     * se iguala a zero.
     * @param matriz Matriz a ser verificada.
     * @return true se possuir zero, false se não possuir.
     * @throws Exception Quando a matriz passada pelo parâmetro é nula.
     */
    public static boolean isDPComZero(double[][] matriz) throws Exception {
        if (matriz == null)
            throw new Exception("matriz para validar inexistente");

        for (int i = 0; i < matriz.length; i++)
            if (matriz[i][i] == 0)
                return true;

        return false;
    }

    /**Muda a ordem das linhas para tirar os zeros da diagonal principal.
     * Move todas a linha de uma matriz uma casa para cima, colocando, 
     * consequentemente, o elemento da linha zero no final da matriz, 
     * a fim de que não sobrem zeros na diagonal principal da matriz.
     * @param matriz Matriz que deve tirar os possiveis zeros.
     * @return Uma matriz de doubles com o mesmo conteúdo da matriz passaca como parâmetro mas sem 0 na diagonal principal.
     * @throws Exception Quando a matriz é nula.
     */
    public static double[][] retirarZeros(double[][] matriz) throws Exception
    {
        if (matriz == null)
            throw new Exception("matriz para validar inexistente");

            double[][] ret = new double[matriz.length][matriz[0].length];

        for (int i = 0; i < matriz.length; i++)
            for (int j = 0; j < matriz[0].length; j++)
                ret[i][j] = matriz[i][j];

        double[] aux = ret[0]; 

        for (int i = 0; i < ret.length - 1; i++)
            ret[i] = ret[i + 1];

        ret[ret.length - 1] = aux; 

        return ret;
    }
    /**Torna um elemento da diagonal pricipal em 1.
     * A partir da linha passada como parâmetro, torna 1 o 
     * elemento correspondente na diagonial principal (matriz[lin][lin])
     * dividindo então toda a linha de onde está o elemento.
     * @param matriz Matriz onde se encontram os valores para serem trabalhados.
     * @param lin Linha em que iremos implementar o 1.
     * @return Retorna uma matriz de double com a linha (que foi passada como parâmetro)
     * dividida pelas operações do método.
     * @throws Exception Exceção lançada por métodos secundários
     */
    public static double[][] tornarUm(double[][] matriz, int lin) throws Exception
     {
        if (matriz == null)
        throw new Exception("matriz para validar inexistente");

        double[][] ret = new double[matriz.length][matriz[0].length];

        for (int i = 0; i < matriz.length; i++)
            for (int j = 0; j < matriz[0].length; j++)
                ret[i][j] = matriz[i][j];

        double divisor = ret[lin][lin];

        for (int i = 0; i < ret[0].length; i++) 
            ret[lin][i] /= divisor;

        return ret;
    }
/** Torna todos os elementos de uma coluna de uma matriz 0.
 *  Com exceção do elemento da diagonal principal, transforma
 *  todos os elementos em zero, adiquirindo a última linha de 
 *  um elemento transformado em um, multiplicando-a pelo
 *  oposto do numero a ser tornado zero e somando-a na linha
 *  da matriz que contêm o elemento a ser tornado zero
 * @param matriz A matriz para ter sua coluna alterada.
 * @param coluna Um int que indica o número da coluna a ser trabalhada.
 * @return Retorna uma matriz com a coluna passada como parâmetro com zeros em todas as células exceto na diagonal principal.
 * @throws Exception O método que verifica se ainda há zeros na coluna lança exceção.
 */
    public static double[][] tornarZero(double[][] matriz, int coluna) throws Exception {
        double[][] ret = new double[matriz.length][matriz[0].length];

        for (int i = 0; i < matriz.length; i++)
            for (int j = 0; j < matriz[0].length; j++)
                ret[i][j] = matriz[i][j];

        double[] lin = ret[coluna].clone();
        double[] col = new double[ret.length];

        for (int i = 0; i < ret.length; i++)
            col[i] = ret[i][coluna];

        double elem = 0;

        for (int i = 0; !isColunaComZero(col, coluna); i++) {
            if (i == coluna)
                i++;

            if (i == col.length)
                break;

            if (col[i] != 0) {
                elem = col[i];

                for (int j = 0; j < ret[0].length; j++)
                    ret[i][j] += lin[j] * (-elem);

                col[i] = 0;
            }
        }

        return ret;
    }

    /**Método para validar a matriz.
     * Verificando por:
     * <ol>
            <li>
                Seu tamanho, que sempre será linha × linha+1.
            </li>
            <li>
                Igualdade de duas equações na mesma matriz.
            </li>
            <li>
                Regras de divisão entre seus elementos, caso 
                em alguma linha todas as divisões resultem o mesmo valor.
            </li>
       </ol>
     * @param matriz A matriz a ser validada.
     * @return Uma matriz totalmente validada.
     * @throws Exception Lança exceção caso a matriz passada como parâmetro seja nula.
     */

    public static boolean valida(double[][] matriz) throws Exception
    {
        if(matriz == null)
        throw new Exception("Matriz nula para validar");

        boolean validade = true;

        if(matriz[0].length - matriz.length != 1)
            validade = false;

        for(int i = 0; i < matriz.length-1; i++)
            for(int j = i+1; j < matriz.length; j++)
                if(matriz[i] == matriz[j])
                    validade = false;

        double divisao;

        for(int i = 0; i < matriz.length-1; i++)
        {
            divisao = matriz[i][0] / matriz[i+1][0];
            for(int j = i+1; j < matriz.length; j++)
            {
                if(matriz[i][j] / matriz[i+1][j] == divisao)
                    validade = false;
                else
                    validade = true;
            }
        }

        return validade;
    }
}
