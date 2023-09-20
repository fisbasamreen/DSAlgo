package src.String;

public class PermutationsOfString {

    void permute(String str, int l, int r) {
        if(l==r){
            System.out.println(str);
        } else{
            for (int i = l; i <= r; i++)
            {
                str = swap(str,l,i);
                permute(str, l+1, r);
                str = swap(str,l,i);
            }
        }
    }

    String swap(String str, int l, int r) {
        char charArray[] = str.toCharArray();
        char temp = charArray[l] ;
        charArray[l] = charArray[r];
        charArray[r] = temp;
        return String.valueOf(charArray);

    }

    public static void main(String[] args) {
        String str = "ABC";
        PermutationsOfString permutation = new PermutationsOfString();
        permutation.permute(str,0,str.length()-1);
    }
}
