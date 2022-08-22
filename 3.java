import java.util.Scanner;

public class Warshall
{
    static int v;
    public void transitive(int[][]graph)
    {
        int[][]reach=new int [v][v];
        for(int i=0;i<v;i++)
        {
            for(int j=0;j<v;j++)
            {
                reach[i][j]=graph[i][j];
        
            }
        }
    for(int k=0;k<v;k++)
    {
        for(int i=0;i<v;i++)
        {
            for(int j=0;j<v;j++)
            {
                if((reach[i][j]==1)||(reach[i][k]==1 && reach[k][j]==1))
                {
                    reach[i][j]=1;
                }
            }
        }
    }
    System.out.println("Transitive Closure Matrix is");
    display(reach);
    }
    
public void display(int[][]reach)
{
    for(int i=0;i<v;i++)
    {
        for(int j=0;j<v;j++)
        {
            System.out.println(reach[i][j]+" ");
        }
        System.out.println();
    }
}

public static void main(String [] args)
{
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter the no of Vertices:");
    v=sc.nextInt();
    int[][]graph=new int[v][v];
    System.out.println("Enter the Adjacency Matrix:");
    for(int i=0;i<v;i++)
    {
        for(int j=0;j<v;j++)
        {
            graph[i][j]=sc.nextInt();
            
        }
    }
    Warshall obj = new Warshall();
    System.out.println("Adjacency Matrix:");
    obj.display(graph);
    obj.transitive(graph);
}
}

