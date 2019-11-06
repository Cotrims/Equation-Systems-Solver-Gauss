package matriz;

public class Matriz implements Comparable<Matriz>, Cloneable
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

    public String toString()
    {
        String ret = "";

        for (int i = 0; i < matriz.length; i++)
        {
            ret += '\n';
            for (int j = 0; j < matriz[0].length; j++)
                ret += matriz[i][j] + " ";
        }

        return ret;
    }

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

        for (int i = 0; i < matriz.length; i++)
            for (int j = 0; j < matriz[0].length; j++)
                if(this.matriz[i][j] != mat.matriz[i][j])
                    return false;

        return true;
    }

    public int hashcode()
    {
        int ret = 1;
        final int PRIMO = 3;

        ret = ret * PRIMO * new Integer(this.col);
        ret = ret * PRIMO * new Integer(this.lin);

        for (int i = 0; i < matriz.length; i++)
            for (int j = 0; j < matriz[0].length; j++)
                ret = ret * PRIMO + new Double(this.matriz[i][j]).hashCode();

        if(ret < 0)
            ret = -ret;

        return ret;
    }

    public int compareTo(Matriz mat)
    {
        if(this.col*this.lin > mat.col*mat.lin)
            return 1;
        
        if(this.col*this.lin < mat.col*mat.lin)
            return -1;

        return 0;
    }

    public Matriz(Matriz modelo) throws Exception
    {
        if(modelo == null)
            throw new Exception("Modelo ausente");

        this.col = modelo.col;
        this.lin = modelo.lin;
        this.matriz = modelo.matriz;
    }

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