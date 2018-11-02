package summary.sort;

public class Selection extends BasicSort{
    public static void sort(double[] a) {
        double temp;
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[min] > a[j]) {
                    min = j;
                }
            }
            exch(a,i,min);
        }
    }


}
