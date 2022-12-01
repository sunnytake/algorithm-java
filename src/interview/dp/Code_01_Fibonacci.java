package interview.dp;

/**
 * 题目：斐波那契系列问题的递归和动态规划
 * 问题：给定整数N，返回斐波那契数列的第N项。
 * 补充题目1：给定整数 N，代表台阶数，一次可以跨 2个或者1个台阶，返回有多少种走法
 * 举例：N=3，可以三次都跨 1个台阶:也可以先跨 2 个台阶，再跨 1 个台阶:还可以先跨1个台阶，再跨 2个台阶。所以有三种走法，返回 3。
 * 补充题目2：假设农场中成熟的母牛每年只会生1头小母牛，并且永远不会死。第一年农场有 1只成熟的母牛，从第二年开始，母牛开始生小母牛。每只小母牛 3 年之后成熟又可以生小母牛。给定整数N，求出N年后牛的数量
 * 举例：N=6，第1年1头成熟母牛记为 a:第2年a生了新的小母牛，记为b，总牛数为 2
 */
public class Code_01_Fibonacci {

    // 斐波那契-递归
    public int fibonacciRecur(int n){
        if(n < 1)
            return 0;
        if(n == 1 || n == 2)
            return 1;
        return fibonacciRecur(n-1) + fibonacciRecur(n-2);
    }

    // 斐波那契-非递归
    public int fibonacci(int n){
        if(n < 1)
            return 0;
        if(n == 1 || n == 2)
            return 1;
        int res = 1;
        int pre = 1;
        int tmp = 0;
        for(int i=3; i<=n; i++){
            tmp = res;
            res += pre;
            res = pre;
        }
        return res;
    }

    // 青蛙跳台阶-递归
    public int frogWithRecur(int n){
        if(n < 1)
            return 0;
        if(n == 1 || n == 2)
            return n;
        return frogWithRecur(n-1) + frogWithRecur(n-2);
    }

    // 青蛙跳台阶-非递归
    public int frog(int n){
        if(n < 1)
            return 0;
        if(n == 1 || n == 2)
            return n;
        int res = 2;
        int pre = 1;
        int tmp = 0;
        for(int i=0; i<=n; i++){
            tmp = res;
            res += pre;
            pre = res;
        }
        return res;
    }

    // 母牛问题-递归
    public int cowWihtRecur(int n){
        if(n < 1)
            return 0;
        if(n == 1 || n == 2 || n == 3)
            return n;
        return cowWihtRecur(n-1) + cowWihtRecur(n-3);
    }

    // 母牛问题-非递归
    public int cow(int n){
        if(n < 1)
            return 0;
        if(n == 1 || n == 2 || n == 3)
            return n;
        int res = 3;
        int pre = 2;
        int prepre = 1;
        int tmp1 = 0;
        int tmp2 = 0;
        for(int i=4; i<=n; i++){
            tmp1 = res;
            tmp2 = pre;
            res += prepre;
            pre = tmp1;
            prepre = tmp2;
        }
        return res;
    }

}
