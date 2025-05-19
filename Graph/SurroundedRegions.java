package Graph;

public class SurroundedRegions {
    public static void dfs(int r, int c, int[][] visi, char[][] board) {
        int n = board.length;
        int m = board[0].length;
        visi[r][c] = 1;
        int[][] dirs = { { r - 1, c }, { r + 1, c }, { r, c - 1 }, { r, c + 1 } };
        for (int[] dir : dirs) {
            int nr = dir[0];
            int nc = dir[1];
            if (nr >= 0 && nr < n && nc >= 0 && nc < m && visi[nr][nc] == 0 && board[nr][nc] == 'O') {
                dfs(nr, nc, visi, board);
            }
        }
    }

    public static void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] visi = new int[n][m];
        for (int i = 0; i < n; i++) {
            if (visi[i][0] == 0 && board[i][0] == 'O') {
                dfs(i, 0, visi, board);
            }
            if (visi[i][m - 1] == 0 && board[i][m - 1] == 'O') {
                dfs(i, m - 1, visi, board);
            }
        }
        for (int j = 0; j < m; j++) {
            if (visi[0][j] == 0 && board[0][j] == 'O') {
                dfs(0, j, visi, board);
            }
            if (visi[n - 1][j] == 0 && board[n - 1][j] == 'O') {
                dfs(n - 1, j, visi, board);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visi[i][j] == 0 && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[][] baord = {
            {'X','X','X','X'},
            {'X','O','O','X'},
            {'X','X','O','X'},
            {'X','O','X','X'} 
        };
        solve(baord);
    }
}
