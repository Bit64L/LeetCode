package summary.sort;

import common.TreeNode;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MergeSort {

    public static void merge(double[] aux, double[] a, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) // 复制至辅助数组aux
            aux[i] = a[i];
        int p = lo, q = mid + 1;
        for (int i = lo; i <= hi; i++) {
            if (p > mid)
                a[i] = aux[q++];
            else if (q > hi)
                a[i] = aux[p++];
            else if (aux[q] <= aux[p])
                a[i] = aux[q++];
            else
                a[i] = aux[p++];
        }
    }

    public static void sort(double[] aux, double[] a, int lo, int hi) {
        if (lo >= hi)
            return;
        int mid = (lo + hi) / 2;
        sort(aux, a, lo, mid);
        sort(aux, a, mid + 1, hi);
        merge(aux, a, lo, mid, hi);
    }

    @Test
    public void test() {
        double[] a = {6, 5, 4, 1, 2, 3, 9};
        double[] aux = new double[a.length];
        sort(aux, a, 0, a.length - 1);
        System.out.println(a);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        TreeNode curr = root;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while(curr != null || !stack.isEmpty()){
            if (curr != null) {
                list.add(curr.val);
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                curr = curr.right;
            }
        }
        return list;
    }


}
