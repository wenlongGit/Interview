package dataStructure;

/**
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

    //    method 1
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
            }
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


    }

}
