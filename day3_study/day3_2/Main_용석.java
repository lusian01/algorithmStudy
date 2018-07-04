package day3_2;

import java.io.*;
import java.util.*;

public class Main {

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

	static int N; // 택배 종류
	static int W; // 배낭의 무게 (용량)
	static int[] Wi; // 택배 무게
	static int[] Pi; // 택배 가치
	static int[][] arr; // 다이나믹 배열

	static int max(int a, int b) {
		return (a > b) ? a : b;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		MyScanner sc = new MyScanner(System.in);

		N = sc.nextInt();
		W = sc.nextInt();

		Wi = new int[N + 1];
		Pi = new int[N + 1];
		arr = new int[N + 1][W + 1];

		for (int i = 1; i <= N; i++) {
			Wi[i] = sc.nextInt();
			Pi[i] = sc.nextInt();
		}

	
		for (int i = 1; i <= N; i++) {
	
			for (int j = 1; j <= W; j++) {
				
				//
				if (j - Wi[i] < 0) {
					// 이전에 구한 
					arr[i][j] = arr[i - 1][j];
				} else {
					//이전에 내려온 값 +  내꺼 더한 거 vs 이전에 구한  
					arr[i][j] = max(arr[i][j - Wi[i]] + Pi[i], arr[i - 1][j]);
				}
			}
		}

		System.out.println(arr[N][W]);

		sc.close();

	}

}
