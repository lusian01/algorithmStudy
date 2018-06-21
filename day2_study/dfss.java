package dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class dfss {

	static class MyScanner {
		BufferedReader reader;
		BufferedWriter writer;
		StringTokenizer tokenizer = null;
		public MyScanner(InputStream in) throws Exception{
			reader = new BufferedReader(new InputStreamReader(in));
			writer = new BufferedWriter(new OutputStreamWriter(System.out));
		}
		
		String nextToken() throws Exception{
			if(tokenizer == null || !tokenizer.hasMoreTokens()){
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
		void close() throws IOException{
			reader.close();
			writer.close();
		}
		
	}

	static final int MAX_COUNT = 1001;
	static boolean[] isVisited = new boolean[MAX_COUNT];
	static boolean[][] arr = new boolean[MAX_COUNT][MAX_COUNT];
	
	static int N, M, V;
	
	static String result ="";
	
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		MyScanner sc = new MyScanner(System.in);
	
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();
		
		for(int i = 0; i<M; i++){
			int r = sc.nextInt();
			int c = sc.nextInt();
			
			arr[r][c] = arr[c][r] = true;
			
		}
		
		sc.close();
		
		dfs(V);
		
		System.out.println(result);
		

	}
	
	static void dfs(int v){
		
		//정점 방문 표
		isVisited[v] = true;
		
	//정점을 반복해서 돌면서 dfs check
		for(int j = 1; j< N; j++){
			if(arr[v][j] == true && isVisited[j] == false){
				dfs(j);
			}
		}
	}

}
