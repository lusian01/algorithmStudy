import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {

   static int N;
   static int K;
   static long[] arr;

   static long[] tree;
   static long[] lazy;

   class SegmentTree {

       SegmentTree() {
           tree = new long[4 * N];
           lazy = new long[4 * N];
       }

       void propa(int node, int start, int end) {
           tree[node] *= lazy[node]* (end - start + 1);
           if (lazy[node] != 0) {
               lazy[node * 2] = lazy[node] * 2;
               lazy[node * 2 + 1] = lazy[node] * 2;

           }
           lazy[node] = 1;
       }

   }

   public static void main(String[] args) throws Exception {

       MyScanner sc = new MyScanner(System.in);

       while (true) {
           N = sc.nextInt();
           K = sc.nextInt();
           arr = new long[N + 1];

           for (int i = 0; i < K; i++) {
               String text = sc.nextToken();

               if (text.equals("C")) {
                   int number = sc.nextInt();
                   long val = sc.nextLong();

               } else if (text.equals("P")) {
                   int startnumber = sc.nextInt();
                   int endnumber = sc.nextInt();

                   System.out.print("aa");

               }
           }
           System.out.println();
       }
   }

   static class MyScanner {
       final BufferedReader reader;
       final BufferedWriter writer;
       StringTokenizer tokenizer = null;

       MyScanner(InputStream in) {
           reader = new BufferedReader(new InputStreamReader(in));
           writer = new BufferedWriter(new OutputStreamWriter(System.out));
       }

       String nextToken() throws IOException {
           if (tokenizer == null || !tokenizer.hasMoreTokens()) {
               tokenizer = new StringTokenizer(reader.readLine());
           }
           return tokenizer.nextToken();
       }

       int nextInt() throws NumberFormatException, IOException {
           return Integer.parseInt(nextToken());
       }

       long nextLong() throws NumberFormatException, IOException {
           return Long.parseLong(nextToken());
       }

       void close() throws IOException {
           reader.close();
           writer.close();
       }
   }

}
