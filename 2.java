import java.util.Scanner;
import java.util.Random;
public class MergeSort {
    static int MAX=10000;
    static int[] a= new int [MAX];
    
public void mergesort(int low,int high)
{
    int mid;
    if(low<high)
    {
        mid=(low+high)/2;
        mergesort(low,mid);
        mergesort(mid+1,high);
        merge(low,mid,high);
    }
}

public void merge(int low,int mid,int high)
{
    int i=low,j=mid+1,h=low,k;
    int[] b= new int[MAX];
    while((h<=mid)&&(j<=high))
    {
        if(a[h]<a[j])
            
            b[i++]=a[h++];
        else
            b[i++]=a[j++];
    }
        
    while(h<=mid)
        b[i++]=a[h++];
    
    while(j<=high)
        b[i++]=a[j++];
    
    for(k=low;k<=high;k++)
        a[k]=b[k];
        
    }

    public static void main(String[] args) {
        
        int n,i;
        Scanner sc=new Scanner(System.in);
        Random rd =new Random ();
        MergeSort obj=new MergeSort();
        System.out.println("Enter the no. of elelments:");
        n=sc.nextInt();
        for(i=0;i<n;i++)
        {
            a[i]=rd.nextInt(10000);
        }
        System.out.println("Array Before Sorting:");
        for(i=0;i<n;i++)
        {
            System.out.println(a[i]);
            
        }
        
        long start=System.nanoTime();
        obj.mergesort(0,n-1);
        long end=System.nanoTime();
        
        System.out.println("Array after Sorting:");
        for(i=0;i<n;i++)
        {
            System.out.println(a[i]);
        }
        double elapsed_time=(end-start)/1000000;
        System.out.println("The time complexity of n= "+ n + "is" + elapsed_time +"miliseconds");

    }

}