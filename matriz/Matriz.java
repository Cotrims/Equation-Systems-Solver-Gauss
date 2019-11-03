package matriz;
/* DEUS ABENÇOE SUA CLASSE AMEM */

//Eu coloquei linhas e colunas pq a dimensao da matriz é simpre linha x linha + 1
// \--E coloquei aqui pq faz mais sentido ser atributo de matriz

public class Matriz 
{
    private double[][] matriz;
    private int lin, col;

    public Matriz(double[][] matriz) throws Exception 
    {
        setMatriz(matriz);
        setLin(matriz.length);
        setCol(matriz[0].length);
    }

    public void setMatriz(double[][] matriz) throws Exception 
    {
        if (matriz == null)
            throw new Exception("matriz inválida");

        this.matriz = matriz;
    }

    public void setLin(int lin) throws Exception 
    {
        if (lin <= 0)
            throw new Exception("Linha inválida");

        this.lin = lin;
    }

    public void setCol(int col) throws Exception 
    {
        if (col <= 0)
            throw new Exception("Coluna inválida");

        this.col = col;
    }

    public double[][] getMatriz() 
    {
        return this.matriz;
    }

    public int getLin() 
    {
        return this.lin;
    }

    public int getCol() 
    {
        return this.col;
    }

    public double[] Escalona() 
    { 
        String arq; 
        
        for(int linha = 0;linha<lin;linha++) 
        { 
            int coluna = 0;// coluna sempre será 0, pois é ela que determina o resto do escalonamento 
            int dimensoes = lin;
        
            if(matriz[linha][coluna] > matriz[dimensoes - linha][coluna]) 
            {
                if(matriz[linha][coluna] %matriz[dimensoes - linha][coluna]) 
                { 
                    double divisor = matriz[linha][coluna]/matriz[dimensoes - linha][coluna]; 
                    matriz[dimensoes - linha][coluna] = matriz[dimensoes - linha][coluna] - divisor;
                }
            }
        }
    }

    public boolean isColunaComZero(double[] col, int lin) throws Exception 
    {
        if (col == null)
            throw new Exception("coluna para validar inexistente");

        for (int i = 0; i < col.length; i++) {
            if (i == lin)
                i++;

            if(i == col.length)
                return true;

            if (col[i] != 0)
                return false;
        }

        return true;
    }

    public boolean isDPComZero(double[][] matriz) throws Exception 
    {
        if (matriz == null)
            throw new Exception("matriz para validar inexistente");

        for (int i = 0; i < this.lin; i++)
            if (matriz[i][i] == 0)
                return true;

        return false;
    }

    public void retirarZeros() //Muda a ordem das linhas para tirar os zeros da DP
    {
        double[] aux = matriz[0]; //Guarda a primeira em uma auxiliar

        for(int i = 0; i < this.lin-1; i++) //A de baixo recebe a de cima
            matriz[i] = matriz[i+1];

        matriz[this.lin-1] = aux; //A ultima recebe a primeira
    }

    public void tornarUm(int lin) //Tona um o elemento da diagonal principal de uma linha
    {
        double divisor = matriz[lin][lin]; //O divisor sera o elemento a ser tornado 1

        for(int i = 0; i < this.col; i++) //Divide toda a linha pelo divisor
            this.matriz[lin][i] /= divisor;
    }

    public void tornarZero(int coluna) throws Exception
    {
        double[] lin = matriz[coluna].clone();
        double[] col = new double[this.lin];

        for(int i = 0; i < this.lin; i++)
            col[i] = matriz[i][coluna];

        double elem = 0;
 
            for(int i = 0; !isColunaComZero(col, coluna); i++)
            {
                if(i == coluna)
                    i++;

                if(i == col.length)
                    break;

                if(col[i] != 0)
                {
                    elem = col[i];
                    
                    for(int j = 0; j < this.col; j++)
                        matriz[i][j] += lin[j] * (-elem);

                col[i] = 0;
            }
        }
    }
}