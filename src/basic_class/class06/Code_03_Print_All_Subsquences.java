package basic_class.class06;

/**
 * 打印所有字符串的子串
 */
public class Code_03_Print_All_Subsquences {

    public static void printAllSub(String str){
        if(str == null)
            return;
        printAllSub(str.toCharArray(), 0, "");
    }
    public static void printAllSub(char[] str, int i, String res){
        if(i == str.length) {
            System.out.println(res);
            return;
        }
        printAllSub(str, i+1, res);
        printAllSub(str, i+1, res+str[i]);
    }

    public static void main(String[] args) {
        String test = "test";
        printAllSub(test);
    }
}
