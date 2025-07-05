class Solution {
    public int findLucky(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        int array[] = new int[max+1];
        
        for(int i : arr){
            array[i]++;
        }
        for(int i = max;i>=1;i--){
            if(array[i]==i) return i ;
        }
        return -1;
    }
}