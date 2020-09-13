package com.cy.algorithm.Sep13;

/**
 * Created by Yang on 2020/9/13.
 */
public class WordExist {
    /**
     * 单词搜索
     * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。

     单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

      

     示例:

     board =
     [
     ['A','B','C','E'],
     ['S','F','C','S'],
     ['A','D','E','E']
     ]

     给定 word = "ABCCED", 返回 true
     给定 word = "SEE", 返回 true
     给定 word = "ABCB", 返回 false
      

     提示：

     board 和 word 中只包含大写和小写英文字母。
     1 <= board.length <= 200
     1 <= board[i].length <= 200
     1 <= word.length <= 10^3

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/word-search
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    int xLength;
    int yLength;
    public boolean exist(char[][] board, String word) {
        xLength = board.length;
        yLength = board[0].length;
        for (int i = 0; i < xLength; i++) {
            for (int j = 0; j < yLength; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int x, int y, int index) {
        //数组越界或者不相等或者已经访问过，直接false
        if (x > xLength -1 || x < 0 || y > yLength -1 || y < 0 || board[x][y] != word.charAt(index) || board[x][y] == '.') {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }
        char temp = board[x][y];
        board[x][y] = '.';
        boolean res = dfs(board, word, x + 1, y, index + 1) || dfs(board, word, x, y + 1, index + 1)
                || dfs(board, word, x - 1, y, index + 1) || dfs(board, word, x, y - 1, index + 1);
        board[x][y] = temp;
        return res;
    }
}
