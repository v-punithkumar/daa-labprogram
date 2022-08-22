import java.util.Scanner;
import java.util.Random;
public class QuickSort {
    static int a[];
    static void Quicksort (int low,int high) {
        if(low<high) {
        int j =Partition(low,high);
        Quicksort(low,j-1);
        Quicksort(j+1,high);
        }
    }
static int Partition (int low,int high) {
    int pivot =a[low];
    int i=low;
    int j=high;
    while(i<j)
    {
        while(i<high && a[i]<=pivot  )
             i++;
        while( j>low && a[j]>=pivot)
             j--;
             if(i<j)
             {
                int temp;
                temp=a[i];
                a[i]=a[j];
                a[j]=temp;
                }
     }
    a[low]= a[j];
    a[j]= pivot;
    return j;
    }
        public static void main(String[] args) {
        int i,n;
        int ch;
        Scanner sc=new Scanner(System.in);
        Random rd=new Random();
        System.out.println("enter the no. of elements");
        n=sc.nextInt();
        a=new int[n];
        System.out.println("enter the choice");
        System.out.println("1 for best/ average case ");
        System.out.println("2 for worst case");
        ch=sc.nextInt();
        switch(ch) {
        case 1:for( i=0; i<n;i++)
            a[i]=rd.nextInt(1000);
            break;
        case 2:for( i=0;i<n;i++)
            a[i]=i+1;
        break;}
        
        System.out.println("array elements before sorting");
        for( i=0;i<n;i++)
        System.out.println(a[i]);
        long start= System.nanoTime();
        Quicksort(0,n-1);
        long end=System.nanoTime();
        System.out.println("array elements after sorting");
        for(i=0;i<n;i++)
            System.out.println(a[i]);
        float time=(end-start);
        System.out.println("the time taken by algorithm ="+time+"ns");
        
        }

}

