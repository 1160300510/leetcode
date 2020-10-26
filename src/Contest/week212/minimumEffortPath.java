package Contest.week212;

public class minimumEffortPath {

    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        int[][] dp = new int[rows-1][cols-1];
        for(int i=rows+cols-1; i>=0; i--){
            for(int j=rows; j>=i-rows; j--){
                int x = j;
                int y = i-j;
                if(x == rows){
                    dp[x][y] = Math.max(dp[x][y+1], Math.abs(heights[x][y]-heights[x][y+1]));
                }
                if(y == cols){
                    dp[x][y] = Math.max(dp[x+1][y], Math.abs(heights[x][y]-heights[x+1][y]));
                }
                dp[x][y] = Math.min(dp[x+1][y], dp[x][y+1]);
                dp[x][y] = Math.max(Math.abs(heights[x][y]-heights[x+1][y]), dp[x][y]);
                dp[x][y] = Math.max(Math.abs(heights[x][y]-heights[x][y+1]), dp[x][y]);
            }
        }
        return dp[0][0];
    }

}
