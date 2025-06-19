class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s.toCharArray(),0,new StringBuilder(),result);
        return result;
    }
    public void backtrack(char[] s,int index, StringBuilder path, List<String> result ){
        if(index==s.length){
            result.add(path.toString());
            return;
        }
        char ch = s[index];
        if(Character.isLetter(ch)){
            path.append(Character.toUpperCase(ch));
            backtrack(s,index+1,path,result);
            path.deleteCharAt(path.length()-1);

            path.append(Character.toLowerCase(ch));
            backtrack(s,index+1,path,result);
            path.deleteCharAt(path.length()-1);
        }
        else{
            path.append(ch);
            backtrack(s,index+1,path,result);
            path.deleteCharAt(path.length()-1);
        }
    }
}