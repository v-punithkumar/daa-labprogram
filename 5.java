import java.util.Scanner;
public class Prims {
    public static int i,j,n,ne,min,a,b,u,v,mincost=0;
    public void prims(int n,int cost[][]) {
        int visited[]=new int[n+1] ;
        for(i=2;i<=n;i++)
            visited[i]=0;
        visited[1]=1;
        ne=1;
        while(ne<n)
        {
            min=999;
            for(i=1;i<=n;i++)
            {
                for(j=1;j<=n;j++)
                {
                    if(cost[i][j]<min)
                    {
                        if(visited[i]!=0)
                        {
                            min=cost[i][j];
                            a=u=i;
                            b=v=j;
                        }
                    }
                }
            }
            if(visited[u]==0||visited[v]==0) {
                System.out.println((ne)+"edge("+a+","+b+")="+min);
                ne=ne+1;
                mincost= mincost+min;
                visited[v]=1;
            }
            cost[a][b]=cost[b][a]=999 ;
        }
        System.out.println("The min cost of the spanning tree is "+mincost);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of vertices");
        n=sc.nextInt();
        int cost[][]=new int[n+1][n+1];
        System.out.println("Enter thecost matrix");
        for(i=1;i<=n;i++) {
            for(j=1;j<=n;j++) {
                cost[i][j]=sc.nextInt();
                if(cost[i][j]==0)
                    cost[i][j]=999 ;
            }
        }
        Prims p=new Prims();
        p.prims(n, cost);
    }
}

