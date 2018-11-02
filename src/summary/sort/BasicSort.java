package summary.sort;

public class BasicSort {

    protected int test;
    public static void exch(double[] a, int i,int j){
        double temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
