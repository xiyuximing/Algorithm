package com.cy.algorithm.day10;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yang on 2020/9/2.
 */
public class IsNumber {

    /**
     * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串'+100'、'5e2'、'-123'、'3.1416'、'-1E-16'、'0123'都表示数值，但'12e'、'1a3.14'、'1.2.3'、'+-5'及'12e+5.4'都不是。

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    /**
     * 解题思路：
     本题使用有限状态自动机。根据字符类型和合法数值的特点，先定义状态，再画出状态转移图，最后编写代码即可。

     在 C++ 文档 中，描述了一个合法的数值字符串应当具有的格式。具体而言，它包含以下部分：

     符号位，即 ++、-− 两种符号
     整数部分，即由若干字符 0-90−9 组成的字符串
     小数点
     小数部分，其构成与整数部分相同
     指数部分，其中包含开头的字符 \text{e}e（大写小写均可）、可选的符号位，和整数部分
     相比于 C++ 文档而言，本题还有一点额外的不同，即允许字符串首末两端有一些额外的空格。

     在上面描述的五个部分中，每个部分都不是必需的，但也受一些额外规则的制约，如：

     如果符号位存在，其后面必须跟着数字或小数点。
     小数点的前后两侧，至少有一侧是数字。
     思路与算法

     根据上面的描述，现在可以定义自动机的「状态集合」了。那么怎么挖掘出所有可能的状态呢？一个常用的技巧是，用「当前处理到字符串的哪个部分」当作状态的表述。根据这一技巧，不难挖掘出所有状态：

     起始的空格
     符号位
     整数部分
     左侧有整数的小数点
     左侧无整数的小数点（根据前面的第二条额外规则，需要对左侧有无整数的两种小数点做区分）
     小数部分
     字符 \text{e}e
     指数部分的符号位
     指数部分的整数部分
     末尾的空格
     下一步是找出「初始状态」和「接受状态」的集合。根据题意，「初始状态」应当为状态 1，而「接受状态」的集合则为状态 3、状态 4、状态 6、状态 9 以及状态 10。换言之，字符串的末尾要么是空格，要么是数字，要么是小数点，但前提是小数点的前面有数字。

     最后，需要定义「转移规则」。结合数值字符串应当具备的格式，将自动机转移的过程以图解的方式表示出来：



     比较上图与「预备知识」一节中对自动机的描述，可以看出有一点不同：

     我们没有单独地考虑每种字符，而是划分为若干类。由于全部 1010 个数字字符彼此之间都等价，因此只需定义一种统一的「数字」类型即可。对于正负号也是同理。
     在实际代码中，我们需要处理转移失败的情况。例如当位于状态 1（起始空格）时，没有对应字符 \text{e}e 的状态。为了处理这种情况，我们可以创建一个特殊的拒绝状态。如果当前状态下没有对应读入字符的「转移规则」，我们就转移到这个特殊的拒绝状态。一旦自动机转移到这个特殊状态，我们就可以立即判定该字符串不「被接受」。


     */

    public boolean isNumber(String s) {
        Map<Character, Integer> state0 = new HashMap<>();//起始空格
        state0.put(' ', 0);
        state0.put('s', 1);
        state0.put('d', 4);
        state0.put('n', 2);
        Map<Character, Integer> state1 = new HashMap<>();
        state1.put('n', 2);
        state1.put('d', 4);
        Map<Character, Integer> state2 = new HashMap<>();
        state2.put('n', 2);
        state2.put('d', 3);
        state2.put(' ', 9);
        state2.put('e', 6);
        Map<Character, Integer> state3 = new HashMap<>();
        state3.put('n', 5);
        state3.put('e', 6);
        state3.put(' ', 9);
        Map<Character, Integer> state4 = new HashMap<>();
        state4.put('n', 5);
        Map<Character, Integer> state5 = new HashMap<>();
        state5.put('n', 5);
        state5.put('e', 6);
        state5.put(' ', 9);
        Map<Character, Integer> state6 = new HashMap<>();
        state6.put('s', 7);
        state6.put('n', 8);
        Map<Character, Integer> state7 = new HashMap<>();
        state7.put('n', 8);
        Map<Character, Integer> state8 = new HashMap<>();
        state8.put('n', 8);
        state8.put(' ', 9);
        Map<Character, Integer> state9 = new HashMap<>();
        state9.put(' ', 9);
        Map[] states = {state0, state1, state2, state3, state4, state5, state6, state7, state8, state9};
        int state = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char t = 0;
            if (c >= '0' && c <= '9') {
                t = 'n';
            } else if (c == 'e' || c == 'E'){
                t = 'e';
            } else if (c == '.') {
                t = 'd';
            } else if (c == '+' || c == '-') {
                t = 's';
            } else if (c == ' ') {
                t = ' ';
            }
            if (!states[state].containsKey(t)) {
                return false;
            }
            state = (int) states[state].get(t);
        }
        return state == 2 || state == 3 || state == 5 || state == 8 || state == 9;
    }

    public static void main(String[] args) {
        IsNumber i = new IsNumber();
        boolean is = i.isNumber("3.");
        System.out.println(is);
    }
}
