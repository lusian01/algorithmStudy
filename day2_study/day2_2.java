package day2_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;


//가중치가 있는 인접 리스트
public class day2_2 {

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



	static class Graph {
		int weight;
		int end;
		
		Graph(int end, int weight){
			this.weight = weight;
			this.end = end;
		}
	}
	

	public static void main(String[] args) throws Exception {
		int N, M;
		ArrayList<ArrayList<Graph>> test = new ArrayList<ArrayList<Graph>>();		
		
		// TODO Auto-generated method stub
		MyScanner sc = new MyScanner(System.in);

		N =sc.nextInt();
		M = sc.nextInt();
		
		for(int i=0; i<101; i++){
			test.add(new ArrayList<Graph>());
		}
		
		for(int i=0; i<M; i++){
			int start, end, weight;
			start = sc.nextInt();
			end = sc.nextInt();	
			weight = sc.nextInt();
			
			
			Graph element = new Graph(end, weight);			//리스트에 넣어줄 element
			test.get(start).add(element);
			Graph element2 = new Graph(start, weight);
			test.get(end).add(element2);
		}

		//출
		for(int i=0; i<test.size(); i++){
			System.out.print(i + " : ");
			for(int j=0; j<test.get(i).size(); j++){
				System.out.print(test.get(i).get(j).end + " / " + test.get(i).get(j).weight + " ");
			}
			System.out.println();
		}


		sc.close();
	}

}
