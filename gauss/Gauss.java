package gauss;
/** Classe singleton que resolve o escalonamento de matrizes
 * @author Vinicius Cotrim 19040
 * @author Manuela Benassi 19184
*  @since 2019
 */
public class Gauss {
    /**Verifica se a coluna da matriz possui zeros
     * Para tanto, recebe uma matriz coluna e uma qt int de linhas
     * @param col coluna que verifica se tem 0
     * @param lin quantas linhas essa coluna tem
     * @return true se a coluna possuir zeros, e false se não possuir
     * @throws Exception se a coluna for nula ou o valor da linha menor que 0
     */
    public static boolean isColunaComZero(double[] col, int lin) throws Exception {
        if (col == null)
            throw new Exception("coluna para validar inexistente");
        if(lin < 0)
        {
            throw new Exception("as linhas da matriz precisam ser valores positivos");
        }

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
    /**Verifica se a diagonal principal da matriz possui algum 0
     * 
     * @param matriz
     * @return true se possuir 0, false se não possuir
     * @throws Exception quando a matriz é nula
     */
    public static boolean isDPComZero(double[][] matriz) throws Exception {
        if (matriz == null)
            throw new Exception("matriz para validar inexistente");

        for (int i = 0; i < matriz.length; i++)
            if (matriz[i][i] == 0)
                return true;

        return false;
    }
    /**Muda a ordem das linhas para tirar os zeros da diagonal principal
     * 
     * @param matriz matriz que deve tirar os 0 
     * @return uma matriz de doubles sem 0 na maatriz principal
     * @throws Exception quando a matriz é nula
     */

    public static double[][] retirarZeros(double[][] matriz) throws Exception  
    {
        if (matriz == null)
            throw new Exception("matriz para validar inexistente");
        try{
            double[][] ret = new double[matriz.length][matriz[0].length];

        for (int i = 0; i < matriz.length; i++)
            for (int j = 0; j < matriz[0].length; j++)
                ret[i][j] = matriz[i][j];

        double[] aux = ret[0]; // Guarda a primeira em uma auxiliar

        for (int i = 0; i < ret.length - 1; i++) // A de baixo recebe a de cima
            ret[i] = ret[i + 1];

        ret[ret.length - 1] = aux; // A ultima recebe a primeira
        }
        catch(Exception e)
        {}
        return ret;
    }
    /**
     * 
     * @param matriz
     * @param lin
     * @return
     */
    public static double[][] tornarUm(double[][] matriz, int lin) {
        if (matriz == null)
        throw new Exception("matriz para validar inexistente");
       
        try{
        double[][] ret = new double[matriz.length][matriz[0].length];

        for (int i = 0; i < matriz.length; i++)
            for (int j = 0; j < matriz[0].length; j++)
                ret[i][j] = matriz[i][j];

        double divisor = ret[lin][lin]; // O divisor sera o elemento a ser tornado 1

        for (int i = 0; i < ret[0].length; i++) // Divide toda a linha pelo divisor
            ret[lin][i] /= divisor;
        }
        catch(Exception e)
        {}
        return ret;
    }

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

    public static boolean valida(double[][] matriz) throws Exception
    {
        if(matriz == null)
            throw new Exception("Matriz nula para validar");

        for(int i = 0; i < matriz.length; i++)
            for(int j = 0; j < matriz[0].length; j++)
                if(true)
                {
                    
                }

        return true;
    }
}