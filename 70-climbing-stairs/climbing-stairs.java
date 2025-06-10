class Solution {
    // int count(int i,int[] dp){
    //     if(i==0 || i==1) return 1;
    //     if (dp[i]!= -1) return dp[i];
    
    //     return dp[i]=count(i-1,dp)+count(i-2,dp);
    // }
    // public int climbStairs(int n) {
    //     int dp[]=new int[n+1];
    //     Arrays.fill(dp,-1);
    //     return count(n,dp);
    // }

//     public int climbStairs(int n){
//     if (n==0 || n==1 || n==3){
//         return n;
//     }
//     int arr[] = new int[n+1];
//     arr[0]=0;
//     arr[1]=1;
//     arr[2]=2;
//     for (int i = 3; i<= n; i++){
//         arr[i]= arr[i-1] + arr[i-2];
//     }
//     return arr[n];
// }
    public int climbStairs(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        return f(dp,n);
    }
    public int f(int[] dp,int i){
        if(i==0|| i ==1) return 1;
        if(dp[i]!=-1) return dp[i];
        return dp[i]= f(dp,i-1)+f(dp,i-2);
    }
}

