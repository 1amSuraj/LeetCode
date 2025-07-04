class Pair{
    String s;
    int steps;
    Pair(String s, int steps){
        this.s = s;
        this.steps= steps;
    }
}
class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n = beginWord.length();
        // String word = "";
        HashSet<String> set = new HashSet<>();
        for(String sc : wordList) set.add(sc);
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(beginWord,1));
        wordList.remove(beginWord);
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            String word = pair.s;
            int steps = pair.steps;
            if(word.equals(endWord)) return steps;
            for(int i = 0 ;i<n;i++){
                for(char ch= 'a';ch<='z';ch++){
                    StringBuilder sb = new StringBuilder(word);
                    sb.setCharAt(i,ch);
                    String replacedWord = sb.toString();
                    if(set.contains(replacedWord)){
                        set.remove(replacedWord);
                        queue.offer(new Pair(replacedWord,steps+1));
                    }
                }
            }
        }
        return 0;
    }
}