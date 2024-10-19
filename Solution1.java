package Lab2;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 *
 * 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以 字符串形式返回小数 。
 *
 * 如果小数部分为循环小数，则将循环的部分括在括号内。
 *
 * 如果存在多个答案，只需返回 任意一个 。
 *
 * 对于所有给定的输入，保证 答案字符串的长度小于 104 。
 *
 * 示例 1：
 *
 * 输入：numerator = 1, denominator = 2
 * 输出："0.5"
 * 示例 2：
 *
 * 输入：numerator = 2, denominator = 1
 * 输出："2"
 * 示例 3：
 *
 * 输入：numerator = 4, denominator = 333
 * 输出："0.(012)"
 *
 */
public class Solution1 {
    public String fractionToDecimal(int numerator, int denominator) {
        long numeratorLong = (long) numerator;
        long denominatorLong = (long) denominator;
        if (numeratorLong % denominatorLong == 0) {
            return String.valueOf(numeratorLong / denominatorLong);
        }

        StringBuffer sb = new StringBuffer();
        if (numeratorLong < 0 ^ denominatorLong < 0) {
            sb.append('-');
        }

        // 整数部分
        numeratorLong = Math.abs(numeratorLong);
        denominatorLong = Math.abs(denominatorLong);

        // 修正 1: 正确的整数部分计算，使用除法而不是加法
        long integerPart = numeratorLong / denominatorLong;
        sb.append(integerPart);
        // 修正 2: 添加小数点，整数部分和小数部分之间应该有小数点
        sb.append('.');

        // 小数部分
        StringBuffer fractionPart = new StringBuffer();
        Map<Long, Integer> remainderIndexMap = new HashMap<Long, Integer>();
        long remainder = numeratorLong % denominatorLong;
        int index = 0;
        // 进入小数部分的处理循环，直到余数为0（表示除尽）或找到循环小数

        // 修正 3：改变循环条件，保证小数部分正确输出
        while (remainder != 0) {
            // 如果当前余数已经出现过，说明开始循环，标记循环小数
            if (remainderIndexMap.containsKey(remainder)) {
                int insertIndex = remainderIndexMap.get(remainder);  // 获取循环开始的位置
                fractionPart.insert(insertIndex, '(');  // 在循环开始的位置插入左括号
                fractionPart.append(')');  // 在小数部分末尾添加右括号
                break;  // 退出循环
            }

            // 如果余数没有出现过，记录它和当前小数位置
            remainderIndexMap.put(remainder, fractionPart.length());
            remainder *= 10;  // 余数乘以10以获取下一位小数

            // 计算当前位的商，并将其附加到小数部分
            fractionPart.append(remainder / denominatorLong);

            // 更新余数，准备下一轮迭代
            remainder %= denominatorLong;
            index++;  // 更新小数部分的索引
        }

        sb.append(fractionPart.toString());

        return sb.toString();
    }
}
