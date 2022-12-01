package interview.dp;

/**
 * 问题：表达式得到期望结果的组成种数
 * 题目：
 * 给定一个只由0(假)、1(真)、&(逻辑与)、|(逻辑或)和^(异或)五种字符组成的字符串express，
 * 再给定一个布尔值 desired。返回express能有多少种组合方式可以达到desired的结果。
 * 举例：
 * express="1^0|0|1"，desired=false
 * 只有 1^((00)1)和 1(0(01))的组合可以得到false，返回2
 * express="1"，desired=false。
 * 无组合则可以得到 false，返回0。
 */
public class Code_12_ExpressionResult {
}
