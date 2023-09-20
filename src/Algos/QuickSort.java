package src.Algos;

public class QuickSort {
    public static void quicksort(int l, int h, int[] arr) {
        if(l < h) {
            int pi = partition(l, h, arr);

            quicksort(l, pi-1, arr);
            quicksort(pi+1, h, arr);
        }
    }

    public static int partition(int l, int h, int[] arr) {
        int i = (l-1), pivot = arr[h];

        for (int j = l; j <= h-1; j++) {
            if (arr[j] < pivot) {
                i++;

                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
    }
        int temp = arr[i+1];
        arr[i+1] = arr[h];
        arr[h] = temp;

        return (i+1);
    }
    public static void main(String[] args) {
       int[] arr = new int[] {10,80,30,90,40,50, 70};
       int l=0, h = arr.length-1;
       quicksort(l,h,arr);

       for(int i=0;i< arr.length ; i++) {
           System.out.println(arr[i]);
       }
    }
}
