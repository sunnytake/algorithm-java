package basic_class.class06;

/**
 * 母牛每年生一只母牛，新出生的母牛成长三年后也能每年生一只母牛，假设不会死。
 * 求N年后，母牛的数量。
 */
public class Code_05_Cow {

    public static int cowNumber(int n){
        if(n < 1)
            return 0;
        if(n == 1 || n == 2 || n == 3)
            return 1;
        return cowNumber(n-1) +cowNumber(n-3);
    }

}
