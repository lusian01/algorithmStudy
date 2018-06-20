package day2_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


//인접 행렬 예제 코드
public class day2_3 {
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
	static int nE;
    static int nV;
 
    public static void main(String[] args) throws Exception {
        MyScanner sc = new MyScanner(System.in);
        nV = sc.nextInt();
        nE = sc.nextInt();
        int[][] ad = new int[nV+1][nV+1]; // Vertex의 이름을 그대로 사용하기 위해 (nV+1)(nV+1)개만큼 배열 생성
        
        for(int i = 0; i < nE; i++){
            int t1 = sc.nextInt();
            int t2 = sc.nextInt();
            ad[t1][t2] = ad[t2][t1] = 1;  // 1대신 가중치를 넣으면 가중치 그래프 
        }
        
        sc.close();
    }
}
