package com.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by ibyeongmu on 2017. 5. 4..
 */
public class BJ_10999 {
    static int start, seg[],lazy[];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());


        int N, M, K;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        for (start = 1; start < N; start *= 2) ;
        seg = new int[start *2 ];
        lazy = new int[start*2];

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(bf.readLine());
            update(i,num);
//            seg[start + i] = Integer.parseInt(bf.readLine());
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(bf.readLine());
            int method = Integer.parseInt(st.nextToken());


            if (method == 1) {
                //update
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                int num = Integer.parseInt(st.nextToken());
                A--;B--;
                update_range(A,B,1,0,start-1,num);
            } else if (method == 2) {
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                A--;B--;
                sb.append(find(A,B,1,0,start-1)+"\n");


            }
        }
        System.out.println(sb);
    }
    static void update_range(int L,int R,int idx,int temp_L,int temp_R,int num){

        if(lazy[idx]!=0){
            seg[idx]+=(temp_R-temp_L+1)*lazy[idx];

            if(temp_R!=temp_L){
                lazy[idx*2] +=lazy[idx];
                lazy[idx*2+1]+=lazy[idx];
            }

            lazy[idx]=0;
        }
        if (L > temp_R || R < temp_L) return ;

        if(L<=temp_L&&temp_R<=R){
            seg[idx]+= (temp_R-temp_L+1)*num;

            if(temp_L!=temp_R){
                lazy[idx*2]+=num;
                lazy[idx*2+1]+=num;
            }
            return;

        }
        int mid = (temp_L+temp_R)/2;

        update_range(L,R,idx*2,temp_L,mid,num);
        update_range(L,R,idx*2+1,mid+1,temp_R,num);
        seg[idx] = seg[idx*2]+seg[idx*2+1];
    }

    static void update(int idx, int val) {
        int index = start + idx;
        seg[index] = val;

        while (index > 1) {
            index /= 2;
            seg[index] = seg[index * 2] + seg[index * 2 + 1];
        }
    }

    static int find(int L, int R, int idx, int temp_L, int temp_R) {

        if(lazy[idx]!=0){
            seg[idx]+=(temp_R-temp_L+1)*lazy[idx];

            if(temp_R!=temp_L){
                lazy[idx*2] +=lazy[idx];
                lazy[idx*2+1]+=lazy[idx];
            }

            lazy[idx]=0;
        }
        if (L > temp_R || R < temp_L) return 0;


        if (L <= temp_L && temp_R <= R) return seg[idx];
        int mid = (temp_L + temp_R) / 2;
        return find(L, R, idx * 2, temp_L, mid) + find(L, R, idx * 2+1, mid + 1, temp_R);
    }
}
