//36. Valid Sudoku - https://leetcode.com/problems/valid-sudoku/description/
//Time Complexity: O(9^(m*n))
//Space Complexity: O(n)

class Solution {

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (check(board, i, j, c)) {
                            board[i][j] = c;
                            if (isValidSudoku(board)){
                                return true;
                            }else{
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean check(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c)
                return false;

            if (board[row][i] == c)
                return false;

            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c)
                return false;
        }
        return true;
    }
}

//Time Complexity: O(9^(m*n))
//Space Complexity: O(n)
//Right
class Solution {

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                char ch=board[i][j];
                if(ch!='.'){//if ch is apart from '.'we need to check whether the given number is verifiable

                    board[i][j]='.';//change it to . so that it cannot consider itself
                    if(!isValid(board,ch,i,j)){//if not verifiable
                        return false;//invalid sudoku
                    }
                    board[i][j]=ch;//after checking change it to its initial value
                }
            }
        }
        return true;
    }

    public static boolean isValid(char[][] board, char c, int row, int col) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c)
                return false;

            if (board[row][i] == c)
                return false;

            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c)
                return false;
        }
        return true;
    }
}