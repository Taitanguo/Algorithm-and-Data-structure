public class Solution {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0].length == 0){
            return false;
        }
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(dfs(board, visited, i, j, word, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, boolean[][] visited, int i, int j, String word, int index){
        if(index == word.length()){
            return true;
        }
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || word.charAt(index) != board[i][j]){
            return false;
        }
        visited[i][j] = true;
        if(dfs(board, visited, i - 1, j, word, index + 1) || dfs(board, visited, i + 1, j, word, index + 1) || dfs(board, visited, i, j - 1, word, index + 1)|| dfs(board, visited, i, j + 1, word, index + 1))  return true;
        visited[i][j] = false;
        return false;
    }
}