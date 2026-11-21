/*
        문제 링크: https://acmicpc.net/problem/1926
        핵심 아이디어: 맵에서 연결된 1을 탐색해야됨, bfs채택
        시간 복잡도: O(n*m) ->  500*500 =250000
 */
package sungheon.y2026.m11;

import java.util.*;
import java.io.*;

public class boj_1926_2026_11_21 {
    private static int[][] map;
    private static int n,m;
    private static boolean[][] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        map=new int[n][m];
        visited=new boolean[n][m];

        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        int cnt=0;
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j]==1&&!visited[i][j]){
                    cnt++;
                    int size=bfs(i,j);
                    max=Math.max(size,max);
                }
            }
        }
        System.out.println(cnt);
        System.out.println(max);
    }
    private static int bfs(int x,int y){
        int[] dx={1,-1,0,0};
        int[] dy={0,0,-1,1};

        int size=1;
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{x,y});
        visited[x][y]=true;

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i];
                int ny=curr[1]+dy[i];
                if(nx>=0&&nx<n&&ny>=0&&ny<m&&!visited[nx][ny]&&map[nx][ny]==1){
                    q.add(new int[]{nx,ny});
                    visited[nx][ny]=true;
                    size++;
                }
            }
        }
        return size;
    }
}
