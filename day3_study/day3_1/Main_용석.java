package day3_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

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

	
	static boolean[] visit;
    static int[] dist;
    static int[][] ad;
    static int nE, nV;
    static final int inf = 100000;
    
    
    //priority queue를 위한 element class
   static class Element implements Comparable<Element>{
        private int index;
        private int distance;
        
        //생성
        Element(int index, int distance){
            this.index = index;
            this.distance = distance;
        }
        
        public int getIndex(){
            return index;
        }
        
        public int getDistance(){
            return distance;
        }
        
        //비
        public int compareTo(Element o){
            return distance <= o.distance ? -1 : 1;
        }
    }



    public static void prioritys(int start){
    	//priority queue 생
        PriorityQueue <Element> q = new <Element> PriorityQueue();
        //시작지점은 0으로 설
        dist[start] = 0;
        //queue에 새 element 추
        q.offer(new Element(start, dist[start]));
        
        //q가 빌때까지 반
        while(!q.isEmpty()){
            int cost = q.peek().getDistance();
            int here = q.peek().getIndex();
            q.poll();
            
            if(cost > dist[here])
                continue;
            
            System.out.print(here);

            for(int i = 0; i <= nV; i++){
                if(ad[here][i] != 0 && dist[i] > dist[here] + ad[here][i]){
                    dist[i] = dist[here] + ad[here][i];
                    q.offer(new Element(i, dist[i]));
                }
            }
                    
        }
        System.out.println();
        for(int i =1 ; i <= nV; i++){
            System.out.print(dist[i]);
        }
    }


	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		 MyScanner sc = new MyScanner(System.in);
	        
	        PriorityQueue<Element> q = new <Element> PriorityQueue();
	        
	        nV = sc.nextInt();
	        nE = sc.nextInt();
	        
	        visit = new boolean[nV+1];
	        dist = new int[nV+1];
	        ad = new int[nV+1][nV+1];
	        
	        
	        for(int i = 0; i <= nV; i++){
	            dist[i] = inf;
	        }
	        
	        
	        for(int i = 0; i < nE; i++){
	            int t1 = 0; //시작
	            int t2 = 0; //끝
	            int t3 = 0; //가중치
	            
	            t1 = sc.nextInt();
	            t2 = sc.nextInt();
	            t3 = sc.nextInt();
	            
	            ad[t1][t2] = t3;
	        }
	        
	        prioritys(1);
	    


	}

}
