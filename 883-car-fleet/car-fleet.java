class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = position.length;
        for(int i= 0 ;i<n;i++){
            map.put(position[i],speed[i]);
        } 
        Arrays.sort(position);
        double[] time = new double[n];

        for(int i = 0;i<n;i++){
            int dis =target- position[i];
            time[i] = (double)dis/(double)map.get(position[i]);
        }
        int c = 1;
        double maxtillnow = time[n-1];
        for(int i = n-1;i>0;i--){
            if(time[i-1]>maxtillnow){
                c++;
                maxtillnow = time[i-1];
            }
            else{

            }
        }
        return c;
    }
}