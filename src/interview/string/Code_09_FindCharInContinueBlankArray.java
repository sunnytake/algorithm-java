package interview.string;

/**
 * 问题：在有序但含有空的数组中查找字符串
 * 题目：
 * 给定一个字符串数组strs，在 strs中有些位置为null，但在不为null的位置上，其字符串是按照字典顺序由小到大依次出现的。
 * 再给定一个字符串str, 请返回str在strs中出现的最左的位置。
 * 举例：
 * strs=[null,"a",null,"a",null,"b",null,"c"]，str="a"，返回 1。
 * strs=[null,"a",null,"a",null,"b",null,"c”]，str=null，只要 str 为 null，就返回-1。
 * strs=[null,"a",null,"a",null,"b",null",c”]，str="d"，返回-1
 */
public class Code_09_FindCharInContinueBlankArray {

    public static int getIndex(String[] strs, String str){
        if(strs == null || strs.length == 0 || str == null)
            return -1;
        int res = -1;
        int left = 0;
        int right = strs.length - 1;
        int mid;
        int i;
        while(left <= right){
            mid = (left + right) / 2;
            if(strs[mid] == null){
              i = mid;
              while(strs[i] == null && i >= left)
                  i -= 1;
              if(i < left || strs[i].compareTo(str) < 0){
                  left = mid+1;
              }else{
                  res = strs[i].equals(str) ? i : res;
                  right = i-1;
              }
            }else if(strs[mid].equals(str)){
                res = mid;
                right = mid - 1;
            }else{
                if(strs[mid].compareTo(str) < 0)
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return res;
    }

}
