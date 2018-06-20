package day2_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;


// 인접 리스트 
public class day2_1 {
	static class MyScanner {
		BufferedReader reader;
		BufferedWriter writer;
		StringTokenizer tokenizer = null;

		public MyScanner(InputStream in) throws Exception {
			reader = new BufferedReader(new InputStreamReader(in));
			writer = new BufferedWriter(new OutputStreamWriter(System.out));
		}

		String nextToken() throws Exception {
			if (tokenizer == null || !tokenizer.hasMoreTokens()) {
				tokenizer = new StringTokenizer(reader.readLine());
			}
			return tokenizer.nextToken();

		}

		int nextInt() throws Exception {
			return Integer.parseInt(nextToken());
		}

		long nextLong() throws Exception {
			return Long.parseLong(nextToken());
		}

		void close() throws IOException {
			reader.close();
			writer.close();
		}

	}
	
	static int nV;  // 총 vertex 개수 
    static int nE;  // 총 edge 개


	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		MyScanner sc = new MyScanner(System.in);
		
		nV = sc.nextInt();
        nE = sc.nextInt();
        ArrayList<ArrayList<Integer>> ad = new <ArrayList<Integer>> ArrayList(); // 인접 리스트 초기화
        
        
        for(int i = 0; i < nV; i++){
            ad.add(new<Integer> ArrayList());  //ad 리스트에 담을 리스트 초기화
        }
        
        for(int i = 0; i < nE; i++){
            int t1, t2;         // vertex 두 개 입력 받기
            t1 = sc.nextInt();
            t2 = sc.nextInt();
            
            ad.get(t1).add(t2);   // 양방향 그래프이므로, vertex 1, 2 값 초기화 
            ad.get(t2).add(t1);
        }

		sc.close();

	}

}
