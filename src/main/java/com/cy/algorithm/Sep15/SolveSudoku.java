package com.cy.algorithm.Sep15;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yang on 2020/9/15.
 */
public class SolveSudoku {

    /**
     *
     *  解数独
     * 编写一个程序，通过已填充的空格来解决数独问题。

     一个数独的解法需遵循如下规则：

     数字 1-9 在每一行只能出现一次。
     数字 1-9 在每一列只能出现一次。
     数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
     空白格用 '.' 表示。
     给定的数独序列只包含数字 1-9 和字符 '.' 。
     你可以假设给定的数独只有唯一解。
     给定数独永远是 9x9 形式的。
     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/sudoku-solver
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    //记录每行的数字情况
    boolean[][] rowBol = new boolean[9][9];
    //记录每列的数字情况
    boolean[][] cellBol = new boolean[9][9];
    //记录每块的数字情况
    boolean[][][] blockBol = new boolean[3][3][9];
    //需要填入的位置
    List<int[]> needFill = new ArrayList<>();
    //是否已经成功遍历完
    boolean valid = false;
    public void solveSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j< board[i].length; j++) {
                if (board[i][j] == '.') {
                    needFill.add(new int[]{i, j});
                } else {
                    int num = board[i][j] - '0' - 1;
                    rowBol[i][num] = cellBol[j][num] = blockBol[i/3][j/3][num] = true;
                }
            }
        }
        dfs(board, 0);
    }

    public void dfs(char[][] board, int pos) {
        //所有需要填的都已经填完
        if (pos == needFill.size()) {
            valid = true;
            return;
        }
        int[] fills = needFill.get(pos);
        int i = fills[0], j = fills[1];
        for (int num = 0; num < 9 && !valid ; num ++) {
            if (!rowBol[i][num] && !cellBol[j][num] && !blockBol[i/3][j/3][num]) {
                rowBol[i][num] = cellBol[j][num] = blockBol[i/3][j/3][num] = true;
                board[i][j] = (char) (num + '0' + 1);
                dfs(board, pos + 1);
                rowBol[i][num] = cellBol[j][num] = blockBol[i/3][j/3][num] = false;
            }
        }
    }
}
