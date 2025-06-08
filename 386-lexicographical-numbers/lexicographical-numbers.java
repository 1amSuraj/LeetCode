class Solution {
    public List<Integer> lexicalOrder(int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 1;i<=9;i++){
            solve(i,arr,n);
        }
        return arr;
    }
    public void solve(int curr , ArrayList<Integer> arr , int n){
        if(curr>n) return;
        arr.add(curr);
        for(int i = 0;i<=9;i++){
            int t = curr*10 + i;
            if(curr>n) return;
            solve(t,arr,n);
        }
    }
}