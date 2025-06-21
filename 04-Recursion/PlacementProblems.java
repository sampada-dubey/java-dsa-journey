import java.util.*;

public class PlacementProblems
{
    // 1. N-Queens Problem
    static List<List<String>> solveNQueens(int n)
    {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];

        for(char[] row : board) Arrays.fill(row, '.');

        solve(board, 0, result);
        return result;
    }

    static void solve(char[][] board, int row, List<List<String>> result)
    {
        if(row == board.length)
        {
            List<String> curr = new ArrayList<>();
            for(char[] chars : board)
            {
                curr.add(new String(chars));
            }
            result.add(curr);
            return;
        }

        for (int col = 0; col < board.length; col++)
        {
            if (isSafe(board, row, col))
            {
                board[row][col] = 'Q';
                solve(board, row + 1, result);
                board[row][col] = '.'; // backtrack
            }
        }
        
    }

    static boolean isSafe(char[][] board, int row, int col)
    {
        for (int i = 0; i < row; i++)
            if (board[i][col] == 'Q') return false;

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 'Q') return false;

        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++)
            if (board[i][j] == 'Q') return false;

        return true;
    }

    // 2. Word Search
    static boolean exist(char[][] board, String word)
    {
        int rows = board.length, cols = board[0].length;

        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                if(dfs(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }

    static boolean dfs(char[][] board, String word, int i, int j, int index)
    {
        if(index == word.length()) return true;
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(index)) return false;

        char temp = board[i][j];
        board[i][j] = '#';

        boolean found = dfs(board, word, i + 1, j, index + 1) ||
                        dfs(board, word, i - 1, j, index + 1) ||
                        dfs(board, word, i, j + 1, index + 1) ||
                        dfs(board, word, i, j - 1, index + 1);

        board[i][j] = temp;
        return found;
    }

    public static void main(String[] args) {
        // N-Queens
        int n = 4;
        List<List<String>> queens = solveNQueens(n);
        System.out.println("N-Queens Solutions for N = " + n);
        for (List<String> board : queens) {
            for (String row : board) System.out.println(row);
            System.out.println();
        }

        // Word Search
        char[][] board = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };
        String word = "ABCCED";
        System.out.println("Word Exists: " + exist(board, word));
    }
}
