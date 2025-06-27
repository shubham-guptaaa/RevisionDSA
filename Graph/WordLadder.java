import java.util.*;
class WordLadder{
    public static List<String> getNeg(String word, HashSet<String> set){
        List<String> neg = new ArrayList<>();
        for(int i = 0; i<word.length(); i++){
            for(char ch = 'a'; ch<='z'; ch++){
                if(ch==word.charAt(i)) continue;
                String newWord = word.substring(0, i)+ch+word.substring(i+1, word.length());
                if(set.contains(newWord)){
                    neg.add(newWord);
                }
            }
        }
        return neg;
    }
    public static int ladderLength(String beginWord, String endWord, List<String> wordList){
        HashSet<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)) return 0;
        Queue<String> q = new ArrayDeque<>();
        q.add(beginWord);
        if(set.contains(beginWord)){
            set.remove(beginWord);
        }
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i<size; i++){
                String node = q.poll();
                if(node.equals(endWord)) return level+1;
                List<String> neg = getNeg(node, set);
                for(String word : neg){
                    if(set.contains(word)){
                        q.add(word);
                        set.remove(word);
                    }
                }
            }
            level++;
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String beginWord = sc.nextLine();
        String endWord = sc.nextLine();
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");

        System.out.println(ladderLength(beginWord, endWord, wordList));
        sc.close();
    }
}
