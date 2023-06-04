import java.io.*;
import java.util.*;
class Recursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();//total testcases
        while (T-- > 0) {
            Hanoi obj = new Hanoi();
            int N;
            
            //taking input N
            N = sc.nextInt();

            //calling toh() method 
            System.out.println(obj.toh(N, 1, 3, 2));
        }
    }
}


class Hanoi {
    static int ans;
    public long toh(int N, int from, int to, int aux) {
        ans=0;
        return helper(N, from, to, aux);
    }
    private long helper(int N, int from, int to, int aux){
        if(N==0){
            return ans;
        }
        helper(N-1, from, aux, to);
        
        System.out.println("move disk "+N+" from rod "+from+" to rod "+to);
        ans++;
        helper(N-1, aux, to, from);
        return ans;
    }
}