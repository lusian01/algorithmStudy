package day2_problem1;

import java.io.*;
import java.util.*;

public class problem1_plo {
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

	static int N;
	static String S;
	static int check[][];
	static char arr[][];
	static int[] idx = { -1, 1, 0, 0 };
	static int[] idy = { 0, 0, -1, 1 };

	static int cnt = 0;
	static int reverse_cnt = 0;
	static int dfs(int x, int y)
	{
		char ret = arr[x][y];
		check[x][y] = 1;
		for (int i = 0; i < 4; i++)
		{
			int nx = x + idx[i];
			int ny = y + idy[i];

			
			if (nx <= N && ny <= N && nx > 0 && ny > 0 && check[nx][ny] == 0)
			{
				if (ret == arr[nx][ny])
				{
					dfs(nx, ny);
				}
			}
		}
		return ret;
	}
	static int reverse_dfs(int x, int y)
	{
		char ret = arr[x][y];
		check[x][y] = 1;
		for (int i = 0; i < 4; i++)
		{
			int nx = x + idx[i];
			int ny = y + idy[i];
			

			if (nx <= N && ny <= N && nx > 0 && ny > 0 && check[nx][ny] == 0)
			{
				if (ret == arr[nx][ny])	//색상 아예 같을때.
				{
					reverse_dfs(nx, ny);
				}
				else if ((ret == 'R' && arr[nx][ny] == 'G') || (ret == 'G' && arr[nx][ny] == 'R'))
				{
					reverse_dfs(nx, ny);
				}		//색상 R- G OR G-R 조합일때
			}
		}
		return ret;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		MyScanner sc = new MyScanner(System.in);
		N = sc.nextInt();

		arr = new char[N+1][N+1];
		check = new int[N+1][N+1];

		for (int i = 1; i <= N; i++) {
			String word = sc.nextToken();
			for (int j = 1; j <= N; j++) {
				arr[i][j] = (word.charAt(j-1));// 스트링을 한글자씩 끊어 배열에 저장
			}
		}

		for (int i = 1; i <= N; i++)
		{
			for (int j = 1; j <= N; j++)
			{
				if (check[i][j] == 0)
				{
					cnt++;
					dfs(i, j);
				}
			}
		}
		check = new int[N+1][N+1];
		
		for (int i = 1; i <= N; i++)
		{
			for (int j = 1; j <= N; j++)
			{
				if (check[i][j] == 0)
				{
					reverse_cnt++;
					reverse_dfs(i, j);
				}
			}
		}
System.out.println(cnt + " " + reverse_cnt);
		sc.close();

	}

}
