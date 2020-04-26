public class WordSearch {
    public static void main(String[] args){
        char[][] board = {{'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}};
        String word = "ABCCEF";

        System.out.println(exist(board,word));

    }

    private static boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length;i++)
            for(int j=0;j<board[0].length;j++)
                if(dfs(board,word,i,j,0))
                    return true;
                return false;
    }

    private static boolean dfs(char[][] board, String word, int i, int j, int index) {
        if (index == word.length())
            return true;
        if(i<0||j<0||i>=board.length||j>=board[0].length)
            return false;
        if (word.charAt(index) == board[i][j]){
            board[i][j]^=256;
            int[] dirs={-1,0,1,0,-1};
            for(int d=0;d<dirs.length-1;d++){
                if(dfs(board,word,i+dirs[d],j+dirs[d+1],index+1))
                    return true;
            }
            board[i][j]^=256;
        }
        return false;
    }
}
