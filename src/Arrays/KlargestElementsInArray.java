package src.Arrays;

import java.util.Iterator;
import java.util.PriorityQueue;

public class KlargestElementsInArray {

    static void kLargestElements(int[] arr, int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i=0;i<k;i++){
            minHeap.add(arr[i]);
        }

        for(int i=k;i< arr.length;i++){
            if(minHeap.peek() > arr[i]){
                continue;
            } else {
                minHeap.poll();
                minHeap.add(arr[i]);
            }
        }

        Iterator<Integer> it = minHeap.iterator();
        while(it.hasNext()) {
            System.out.print(it.next() + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = { 11, 3, 2, 1, 15, 5, 4, 45, 88, 96, 50, 45 };
        kLargestElements(arr,3);
    }
}
