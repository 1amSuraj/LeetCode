class Solution {
    public int MOD = 1000000007;
    public int countGoodNumbers(long n) {
        long a = (fun(5,(n+1)/2)*fun(4,n/2))%MOD;
        return (int)a; 
    }
    public long fun(long a, long b){
        if(b==0) return 1;
        long half = fun(a,b/2);
        long res = (half*half)%MOD;
        if(b%2!=0) res = (res*a)%MOD;
        return res;
    }
}