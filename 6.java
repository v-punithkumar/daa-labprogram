import java.util.Scanner;
public class Kruskals {
    static int i,j,a,b,u,v,n,ne,min=999,mincost=0;
    static int[] parent;
    public void Kruskal(int n, int[][] cost) {
        parent=new int[n+1];
        ne=1;
        while(ne<n) {
            min=999;
            for(i=1;i<=n;i++) {
                for(j=1;j<=n;j++) {
                    if(cost[i][j]<min && i!=j) {
                        min=cost[i][j];
                        a=u=i;
                        b=v=j;
                    }
                }
            }
            u=find(u);
            v=find(v);
            if(u!=v) {
                System.out.println((ne)+"("+a+","+b+")="+min);
                mincost=mincost+min;
                uni(u,v);
                ne=ne+1;
            }
            cost[a][b]=cost[b][a]=999;
        }
        System.out.println("the minimum cost of a spanning tree obtained:"+mincost);
    }
    public int find(int i) {
        while(parent[i]!=0)
            i=parent[i];
        return i;
    }
    public void uni(int i,int j) {
        parent[j]=i;
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the number of vertices:");
        n=s.nextInt();
        int[][] cost=new int[n+1][n+1];
        Kruskals k=new Kruskals();
        System.out.println("Enter the cost matrix:");
        for(i=1;i<=n;i++) {
            for(j=1;j<=n;j++) {
                cost[i][j]=s.nextInt();
                
            }
        }
        System.out.println("The spanning tree is:");
        k.Kruskal(n,cost);
            }
    }