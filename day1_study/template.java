package javaFormat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class template {
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

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		MyScanner sc = new MyScanner(System.in);
		
		sc.close();

	}

}
