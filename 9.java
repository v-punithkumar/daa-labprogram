import java.util.Scanner;

public class GKnapsack {
static int n;
static float capacity, item[], weight[], profit[], ratio[];

public static void knapsack() {
float tp = 0;
float u = capacity;
int i;
float x[] = new float[n];
for (i = 0; i < n; i++) {
x[i] = 0;
}
for (i = 0; i < n; i++) {
if (weight[i] > u)
break;
else {
x[i] = 1;
tp = tp + profit[i];
u = (u - weight[i]);
}
}
if (i < n) {
x[i] = u / weight[i];
tp = tp + (x[i] * profit[i]);
}
System.out.println("\n The resultant vector is");
for (i = 0; i < n; i++) {
System.out.println("item" + item[i] + ":" + x[i]);
}
System.out.println("Maximum profit is " + tp);
}

public static void main(String args[]) {
int i, j;
float temp;
Scanner in = new Scanner(System.in);
System.out.println("\n Enter the number of objects ");
n = in.nextInt();
item = new float[n];
weight = new float[n];
profit = new float[n];
ratio = new float[n];
for (i = 0; i < n; i++) {
item[i] = (float) i;
}
System.out.println("\n Enter weights ");
for (i = 0; i < n; i++) {
weight[i] = in.nextFloat();

}
System.out.println("\n Enter profits ");
for (i = 0; i < n; i++) {
profit[i] = in.nextFloat();
}
System.out.println("\n Enter the capacity of knapsack ");
capacity = in.nextFloat();
for (i = 0; i < n; i++) {
ratio[i] = profit[i] / weight[i];
}
for (i = 0; i < n; i++)
for (j = i + 1; j < n; j++)
if (ratio[i] < ratio[j]) {
temp = ratio[j];
ratio[j] = ratio[i];
ratio[i] = temp;

temp = profit[j];
profit[j] = profit[i];
profit[i] = temp;

temp = weight[j];
weight[j] = weight[i];
weight[i] = temp;

temp = item[j];
item[j] = item[i];
item[i] = temp;
}
knapsack();
in.close();
}
}