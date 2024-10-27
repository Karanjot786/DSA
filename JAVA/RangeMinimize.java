// Codechef Question
//Range Minimize


import java.util.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            int N = sc.nextInt();
            int[] A = new int[N];
            
            for (int i = 0; i < N; i++) {
                A[i] = sc.nextInt();
            }
            
            if (N <= 3) {
                System.out.println(0);
                continue;
            }
            
            Arrays.sort(A);
            
            int minRange = Integer.MAX_VALUE;
            
            minRange = Math.min(minRange, A[N-1] - A[2]);
            minRange = Math.min(minRange, A[N-3] - A[0]);
            minRange = Math.min(minRange, A[N-2] - A[1]);
            
            System.out.println(minRange);
        }

	}
}
