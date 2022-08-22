import java.util.Scanner;

public class Floyds {
    static int v;
    public void Floyd(int[][]graph) {
    int[][]reach=new int [v][v];
    for(int i=0;i<v;i++) {
        for(int j=0;j<v;j++) {
            reach[i][j]=graph[i][j];
        }
    }
    for(int k=0;k<v;k++) {
        for(int i=0;i<v;i++) {
            for(int j=0;j<v;j++) {
                if((reach[i][k]+reach[k][j])<reach[i][j])
                {
                    reach[i][j]=reach[i][k]+reach[k][j];
                }
            }
        }
    }
    System.out.println("All Pair Shortest Path");
    for(int i=0;i<v;i++) {
        for(int j=0;j<v;j++) {
            System.out.println(reach[i][j]+" ");
            }
        System.out.println("\n");
        }
}

    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    Floyds obj =new Floyds();
    System.out.println("enter the no.vertices:");
    v=sc.nextInt();
    int[][]graph=new int[v][v];
    System.out.println("enter the elements of array:");
    for(int i=0;i<v;i++) {
        for(int j=0;j<v;j++) {
            graph[i][j]=sc.nextInt();
        }
}
    System.out.println("adjacency matrix is:");
    
    obj.Floyd(graph);
    }
}