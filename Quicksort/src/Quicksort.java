/**
 * Created by plato on 2/22/2016.
 */
public class Quicksort {

    static int partition(String[] s, int left, int right) {
        String t;
        int p = (left + right) / 2;
        int i = left;
        int j = right;

        while (i <= j) {
            while (s[i].compareTo(s[p]) < 0)
                i++;
            while (s[j].compareTo(s[p]) > 0)
                j--;
            if (i <= j) {
                t = s[i];
                s[i] = s[j];
                s[j] = t;
                i++;
                j--;
            }
        }
        return i;
    }

    static void quicksort(String[] s, int left, int right) {
        int l = partition(s, left, right);
        if (left < l - 1) {
            quicksort(s, left, l - 1);
        }
        if (l < right) {
            quicksort(s, l, right);
        }
    }

    public static void main(String[] args) {
        String[] a = { "ccc", "cde", "abc"};
        quicksort(a, 0, a.length - 1);
        for (int i = 0; i < a.length; ++i) {
            System.out.print(a[i] + " ");
        }
    }
}