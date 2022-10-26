package basic_class.class06;

public class Code_01_Factorial {

    public static long getFactorial1(int n){
        if(n == 1)
            return 1L;
        return (long)n * getFactorial1(n-1);
    }

    public static long getFactorial2(int n){
        long result = 1L;
        for(int i=2; i<=n; i++)
            result *= i;
        return result;
    }

}
