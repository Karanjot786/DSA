//Codechef question
//Normal is Good 


import java.io.*;
import java.util.*;

class CodeChef3 {
    public static void main(String[] args) throws java.lang.Exception {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] arr = ai(n);
            if(n == 1){
                System.out.println(1);
                continue;
            }
            long sum = countValidSubArrays(arr);
            sum += count(arr);
            System.out.println(sum);
        }
    }

    static long count(int [] arr){
        long c = 1;
        long sum = 0;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] == arr[i-1]) c++;
            else {
                sum += ((c+1)*c)/2;
                c = 1;
            }
        }
        sum += ((c+1)*c)/2;
        return sum;
    }

    public static long countValidSubArrays(int[] arr) {
        int cnt = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(0, new ArrayList<>(List.of(-1)));
        int i = 0, n = arr.length;
        while (i < n){
            if(arr[i] == 1) cnt--;
            else if(arr[i] == 3) cnt++;
            map.putIfAbsent(cnt, new ArrayList<>());
            map.get(cnt).add(i);
            i++;
        }
        int [] f2 = new int [n];
        int [] f3 = new int [n];
        if(arr[0] == 2) f2[0]++;
        else if(arr[0] == 3) f3[0]++;
        for (int j = 1; j < n; j++) {
            f2[j] += f2[j-1];
            f3[j] += f3[j-1];
            if(arr[j] == 2) f2[j]++;
            else if(arr[j] == 3) f3[j]++;
        }
        long sum = 0;
        for(var list : map.values()){
            int left = 0, right = 1;
            while (right < list.size()){
                if(left == right){
                    right++;
                    continue;
                }
                int l = list.get(left);
                int r = list.get(right);
                int fr2 = f2[r];
                int fr3 = f3[r];
                if(l >= 0){
                    fr2 -= f2[l];
                    fr3 -= f3[l];
                }
                if(fr2 > 0 && fr3 > 0){
                    sum += list.size()-right;
                    left++;
                } else right++;
            }
        }
        return sum;
    }


    static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    static class  Triplet<T>{
        T x, y, z;

        public Triplet(T x, T y, T z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static Triplet<Long> extendedEuclid(long a, long b){ // a>b
        if(b == 0){
            return new Triplet<>(a, 0L, a);
        }

        Triplet<Long> smallAns = extendedEuclid(b, a%b);
        long y = smallAns.x - (a/b)*smallAns.y;
        return new Triplet<>(smallAns.y, y, smallAns.z);

    }

    static long modularMultiplicativeInverse(long a, long m){
        long gcd = gcd(a, m);
        if(gcd != 1){
            return -1;
        }
        long x = extendedEuclid(a, m).x;
        x = (x%m + m)%m;
        return x;
    }

    static long nCrModPFermat(int n, int r, int p, long [] fac) {
        if (n<r) return 0;
        if (r == 0) return 1;

        return ((fac[n] * modularMultiplicativeInverse(fac[r], p)) % p *
                (modularMultiplicativeInverse(fac[n - r], p)) % p) % p;
    }

    static class Pair<T, U> {
        T f;
        U s;

        public Pair(T first, U sec) {
            this.f = first;
            this.s = sec;
        }

        @Override
        public String toString() {
            return f + " " + s;
        }
    }

    static int mod = (int)1e9 + 7;

    static int [] ai(int n){
        int [] arr = new int [n];
        for(int i = 0; i<n; i++) arr[i] = in.nextInt();
        return arr;
    }

    static FastReader in = new FastReader();

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine().trim();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}