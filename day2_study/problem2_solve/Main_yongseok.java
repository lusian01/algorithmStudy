package probelm2_sol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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

    static int r,c,cnt=0,max=0,ax,ay;
    static int dx[]={1,-1,0,0};
    static int dy[]={0,0,1,-1};
    static int map[][]=new int[21][21];
    static boolean check[]=new boolean[26];
    
    public static void main(String args[]) throws Exception
    {
    MyScanner sc = new MyScanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        
        for(int i = 1 ; i <= r ; i++){
        	String word = sc.nextToken();
            for(int j = 1 ; j<= c ; j++){
				map[i][j] = (word.charAt(j-1))-'A';// 스트링을 한글자씩 끊어 배열에 저
            }
        }
        
        dfs(1,1);
        System.out.println(max);
        
        sc.close();
    }
    //백트래킹
    public static void dfs(int a, int b){
        cnt++;
        if(max<cnt){
            max = cnt;
        }
        //방문한 알파벳 체크 
        check[map[a][b]]=true;
        
        for(int i = 0 ; i < 4 ; i++){
            ax = a+dx[i];
            ay = b+dy[i];
            if(ax>0&&ay>0&&ax<=r&&ay<=c){
                if(!check[map[ax][ay]]){
                    dfs(ax,ay);
                }
            }
        }
        
        //탐색 끝났으면 카운트감소/알파벳체크해제
        cnt--;
        check[map[a][b]]=false;
    }
}