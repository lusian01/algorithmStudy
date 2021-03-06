package nqueen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class nqueen {

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

	static int ans, n;
	static int[] col;

	public static void dfs(int row) {
		if (row == n) {
			++ans;
		} else {
			for (int i = 1; i <= n; i++) {
				col[row + 1] = i;
				if (isPossible(row + 1)) {
					dfs(row + 1);
				} else {
					col[row + 1] = 0;
				}
			}
		}
		col[row] = 0;
	}

	public static boolean isPossible(int c) {
		// col[1]의 의미는 1행 *열이다.
		// col[1] = 1 => 1행 1열, col[2] = 3 => 2행 3열

		// 이전 열들을 탐색하면서 배치 가능 여부 확인
		for (int i = 1; i < c; i++) {
			// 같은 행, 열
			if (col[i] == col[c]) {
				return false;
			}
			// 대각선
			if (Math.abs(col[i] - col[c]) == Math.abs(i - c)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		MyScanner sc = new MyScanner(System.in);
		n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			col = new int[15];
			col[1] = i;
			// 정점은 행을 기준. (i = 1) => 1행(1열), (i = 2) => 2행(1열), (i = 3) =>
			// 3행(1열)
			dfs(1);
		}
		System.out.println(ans);

	}

}
