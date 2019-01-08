import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII212 {
    class TrieNode {
        String word;
        TrieNode[] links;

        public TrieNode() {
            word = "";
            links = new TrieNode[26];
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || board.length == 0) return new ArrayList<>();
        TrieNode root = generate(words);
        Set<String> res = new HashSet<>(); // avoid repeating words
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char tmp = board[i][j];
                boolean[][] visited = new boolean[board.length][board[0].length];
                visited[i][j] = true; // avoid accessing a char more than once
                dfs(i, j, root.links[tmp - 'a'], visited,board, res);
                visited[i][j] = false;
            }
        }
        return new ArrayList<>(res);
    }

    public void dfs(int x, int y, TrieNode node, boolean[][] visited, char[][] board, Set<String> res) {// backtracing
        if (node == null) return;
        if (!node.word.equals("")) res.add(node.word);

        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int i = 0; i < dir.length; i++) {
            int new_x = x + dir[i][0];
            int new_y = y + dir[i][1];
            if (new_x >= 0 && new_x < board.length && new_y >= 0 && new_y < board[0].length && !visited[new_x][new_y]) {
                char tmp = board[new_x][new_y];
                visited[new_x][new_y] = true;
                dfs(new_x, new_y, node.links[tmp - 'a'], visited, board, res);
                visited[new_x][new_y] = false;
            }

        }

    }

    public TrieNode generate(String[] words) {//Generate Tire
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode curr = root;
            for (int j = 0; j < word.length(); j++) {
                char tmp = word.charAt(j);
                if (curr.links[tmp - 'a'] == null) {
                    curr.links[tmp - 'a'] = new TrieNode();
                }
                curr = curr.links[tmp - 'a'];
            }
            curr.word = word;
        }
        return root;
    }


// 本题偶遇两个corner case
// 1. 重复word
// 2. 多次访问路径上的字符


// 解法： 字典树 + backtracing

    @Test
    public void test() {
        char[][] board = {{'a'}, {'a'}};
        String[] words = {"aaa"};
        findWords(board, words);
    }
}
