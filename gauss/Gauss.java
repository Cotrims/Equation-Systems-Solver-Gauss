package gauss;

public class Gauss {
    public static boolean isColunaComZero(double[] col, int lin) throws Exception {
        if (col == null)
            throw new Exception("coluna para validar inexistente");

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

    public static boolean isDPComZero(double[][] matriz) throws Exception {
        if (matriz == null)
            throw new Exception("matriz para validar inexistente");

        for (int i = 0; i < matriz.length; i++)
            if (matriz[i][i] == 0)
                return true;

        return false;
    }

    public static double[][] retirarZeros(double[][] matriz) // Muda a ordem das linhas para tirar os zeros da DP
    {
        double[][] ret = new double[matriz.length][matriz[0].length];

        for (int i = 0; i < matriz.length; i++)
            for (int j = 0; j < matriz[0].length; j++)
                ret[i][j] = matriz[i][j];

        double[] aux = ret[0]; // Guarda a primeira em uma auxiliar

        for (int i = 0; i < ret.length - 1; i++) // A de baixo recebe a de cima
            ret[i] = ret[i + 1];

        ret[ret.length - 1] = aux; // A ultima recebe a primeira

        return ret;
    }

    public static double[][] tornarUm(double[][] matriz, int lin) {
        double[][] ret = new double[matriz.length][matriz[0].length];

        for (int i = 0; i < matriz.length; i++)
            for (int j = 0; j < matriz[0].length; j++)
                ret[i][j] = matriz[i][j];

        double divisor = ret[lin][lin]; // O divisor sera o elemento a ser tornado 1

        for (int i = 0; i < ret[0].length; i++) // Divide toda a linha pelo divisor
            ret[lin][i] /= divisor;

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
}