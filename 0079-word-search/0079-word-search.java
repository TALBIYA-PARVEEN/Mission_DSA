class Solution {
    public boolean exist(char[][] board, String word) {

        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {

                if (board[i][j] == word.charAt(0)) {

                    StringBuilder sb = new StringBuilder();
                    sb.append(board[i][j]);
                    visited[i][j] = true;

                    if (backtrack(i, j, 1, board, word, sb, visited)) {
                        return true;
                    }

                    visited[i][j] = false;
                }
            }
        }

        return false;
    }

    public boolean backtrack(int row, int col, int index,
                             char[][] board, String word,
                             StringBuilder temp,
                             boolean[][] visited) {

        if (temp.length() == word.length()) {
            return true;
        }

        if (col + 1 < board[row].length &&
            !visited[row][col + 1] &&
            board[row][col + 1] == word.charAt(index)) {

            temp.append(board[row][col + 1]);
            visited[row][col + 1] = true;

            if (backtrack(row, col + 1, index + 1,
                          board, word, temp, visited)) {
                return true;
            }

            visited[row][col + 1] = false;
            temp.deleteCharAt(temp.length() - 1);
        }

        if (row + 1 < board.length &&
            !visited[row + 1][col] &&
            board[row + 1][col] == word.charAt(index)) {

            temp.append(board[row + 1][col]);
            visited[row + 1][col] = true;

            if (backtrack(row + 1, col, index + 1,
                          board, word, temp, visited)) {
                return true;
            }

            visited[row + 1][col] = false;
            temp.deleteCharAt(temp.length() - 1);
        }

        if (row - 1 >= 0 &&
            !visited[row - 1][col] &&
            board[row - 1][col] == word.charAt(index)) {

            temp.append(board[row - 1][col]);
            visited[row - 1][col] = true;

            if (backtrack(row - 1, col, index + 1,
                          board, word, temp, visited)) {
                return true;
            }

            visited[row - 1][col] = false;
            temp.deleteCharAt(temp.length() - 1);
        }

        if (col - 1 >= 0 &&
            !visited[row][col - 1] &&
            board[row][col - 1] == word.charAt(index)) {

            temp.append(board[row][col - 1]);
            visited[row][col - 1] = true;

            if (backtrack(row, col - 1, index + 1,
                          board, word, temp, visited)) {
                return true;
            }

            visited[row][col - 1] = false;
            temp.deleteCharAt(temp.length() - 1);
        }

        return false;
    }
}