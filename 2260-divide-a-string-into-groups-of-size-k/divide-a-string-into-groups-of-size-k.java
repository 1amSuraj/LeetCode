class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        int nn =0;
        int dif = n/k;
        if(n%k!=0) nn=n/k +1;
        else nn=n/k;
        String arr[] = new String[nn];
        int c = 0;
        int kk =k;
        System.out.println(nn);
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<n;i++){
            sb.append(s.charAt(i));
            if(i==n-1){
                // sb.append(s.charAt(i));
                if(sb.length()!=k){
                    while(sb.length()!=k) sb.append(fill);
                    arr[c] = sb.toString();
                    break;
                }
            }
            if(sb.length()==k){
                arr[c++]=sb.toString();
                System.out.println(arr[c-1]);
                sb.setLength(0);
            }
        }
    return arr;
    }
}