package dataStructure;

/**
 * 字符串移位包含问题
 *
 * 问题描述：
 * 给定两个字符串s1和s2
 * 判断s2是否能被s1经过循环移位(rotate)得到的字符串所包含
 *
 * 例如,给定 s1=AABCD  s2=CDAA,返回true;
 * 给定 s1=ABCD s2=ACBD,返回false
 *
 * Created by wenlong.zhang on 18/5/14.
 */
public class StringRotate {

    public static String array2Str(char[] charArray){
        StringBuffer strBuf = new StringBuffer();
        for(int i=0; i<charArray.length; i++){
            strBuf.append(charArray[i]);
        }
        return strBuf.toString();
    }

    // method 1——穷举法
    // 直接遍历字符串长度，做移位，判断移位后的字符串是否包含目标字符串
    // 时间复杂度：O(N^2) N为字符串长度
    public static boolean stringRotate(char[] s1, char[] s2){
        boolean flag = false;
        int len = s1.length;
        for(int i=0; i<len; i++){
            char tempChar = s1[0];
            for(int j=0; j<len-1; j++){
                s1[j] = s1[j+1];
            }
            s1[len-1] = tempChar;
            if(array2Str(s1).contains(array2Str(s2))){
                flag=true;
                break;
            }
        }

        return flag;
    }

    // method 2
    // 直接穷举会发现，字符串1的循环位移有规律：
    // 比如 ABCD - BCDA - CDAB -DABC - ABCD
    // 如果在位移的同时保留原位置的字符
    // 比如 ABCD - ABCDA - ABCDAB -ABCDABC - ABCDABCD
    // 那么，直接将字符串s1拼接起来形成新字符串s1s1, 直接来判断s1s1是否包含s2即可
    public static boolean  stringRotate2(char[] s1, char[] s2) {
        boolean flag = false;
        String s1s1 = array2Str(s1) + array2Str(s1) ;
        if(s1s1.contains(array2Str(s2))){
            flag=true;
        }
        return flag;
    }

    public static void main(String args[]){
        char[] s1 = {'A','A','B','C','D'};
        char[] s2 = {'C','D','A','A'};

        char[] s3 = {'A','B','C','D'};
        char[] s4 = {'A','C','B','D'};


        System.out.println(stringRotate(s1,s2));
        System.out.println(stringRotate(s3,s4));

        System.out.println(stringRotate2(s1,s2));
        System.out.println(stringRotate2(s3,s4));

    }

}
