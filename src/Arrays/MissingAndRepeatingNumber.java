package src.Arrays;

public class MissingAndRepeatingNumber {

    public static void main(String[] args) {
        int arr[] = new int[]{1, 2, 3, 3, 5, 6};
        boolean temp[] = new boolean[arr.length+1];

        for(int i=0;i<temp.length;i++) {
            temp[i] = false;
        }

        for(int i=0;i<arr.length;i++) {
            if(temp[arr[i]] == true) {
                System.out.println("repeating number " + arr[i]);
            }
            temp[arr[i]] = true;
        }

        for(int i=1;i<=arr.length;i++) {
            if(temp[i] == false){
                System.out.println("missing number " + arr[i]);
            }
        }
    }
}
