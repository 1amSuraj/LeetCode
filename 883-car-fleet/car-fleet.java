class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(position[i], speed[i]);
        }
        Arrays.sort(position); 
        Stack<Double> stk = new Stack<>();
        
        for (int i = n - 1; i >= 0; i--) {
            double time = (double)(target - position[i]) / map.get(position[i]); 
            if (!stk.isEmpty() && time <= stk.peek()) {
                // joins the fleet ahead → do nothing
            } else {
                stk.push(time); // new fleet
            }
        }
        return stk.size();
    }
}
