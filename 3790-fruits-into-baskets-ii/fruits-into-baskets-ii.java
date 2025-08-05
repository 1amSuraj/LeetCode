class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        boolean[] use = new boolean[n];
        int count = 0;
        for(int a : fruits){
            boolean fill = false;
            for(int i = 0 ; i<n;++i){
                if(!use[i] && baskets[i] >= a){
                    use[i] = true;
                    fill = true;
                    break;
                }
            }
            if(!fill) count++;
        }
        return count;
    }
}