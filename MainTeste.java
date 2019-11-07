import leitorDeArquivo.LeitorDeArquivo;
import matriz.Matriz;
import gauss.Gauss;

public class MainTeste {
	public static void main(String[] args)
	{
		try {
            LeitorDeArquivo leitor = new LeitorDeArquivo("gauss.txt");
            //Ver se o leitor conssegue ler linhas do arquivo
            if(!leitor.getUmaLinha().equals("") || leitor.getUmaLinha() != null)
                System.out.println("leitor funcionando");

            double[][] mat = new double[3][4];
            mat[0][0] = 1; 
            mat[0][1] = 4; 
            mat[0][2] = 5; 
            mat[0][3] = 4; 
            mat[1][0] = 1; 
            mat[1][1] = 9; 
            mat[1][2] = 7; 
            mat[1][3] = 8; 
            mat[2][0] = 3; 
            mat[2][1] = 11; 
            mat[2][2] = 3; 
            mat[2][3] = 2; 

            //Testes da matriz
            Matriz matriz = new Matriz(mat);
            //matriz.setCol(-1);
            //matriz.setLin(-1);
            //matriz.setMatriz(null);
            System.out.println(matriz.toString());
            Matriz matDois = (Matriz)matriz.clone();
            System.out.println(matDois.getClass());
            if(matriz.equals(matDois))
                System.out.println("Equals OK");

            //Testes do gauss
            if(Gauss.valida(mat));
                System.out.println("Validação funcionando");

            double[] teste = {0, 1, 2, 3, 0};
            if(Gauss.isColunaComZero(teste, 1));
                System.out.println("Coluna com zero OK");

            mat = Gauss.tornarZero(mat, 0);
            for(int i = 0; i < matriz.getLin(); i++)
                System.out.println(mat[i][0] + "");
        }
        catch(Exception err)
        {
            System.out.println(err.getMessage());
        }
    }
}