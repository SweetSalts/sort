/**
 * Created by PC on 2017/6/29.
 */
public class RadisSort {
    //求出第d+1位的数字
    public static int getNum(int num,int d){
        int []a = {1,10,100,1000};
        return (num/a[d])%10;
    }
    //找到数组中最大的位数
    public static int getmaxweishu(int[] a){
        int maxlength = String.valueOf(a[0]).length();
        for(int i = 1; i < a.length; i++){
            if(String.valueOf(a[i]).length() > maxlength){
                maxlength = String.valueOf(a[i]).length();
            }
        }
        return maxlength;
    }
    public static void sort(int[] a){
        //桶中放入数字的个数
        int[] count = new int[10];
        //临时存放个位、十位排序后的结果
        int[] temp = new int [a.length];
        for(int d = 0; d < getmaxweishu(a); d++){
            //置零，初始化基数器
            for(int i = 0; i < 10; i++){
                count[i] = 0;
            }
            //计数，如果的到某位的数字为x，则count[x]++
            for(int j = 0; j < a.length; j++){
                count[getNum(a[j],d)]++;
            }
            //第k个桶之前共存了几个数
            for(int k = 1; k < 10; k++){
                count[k] = count[k] + count[k-1];
            }
            //根据某一位调整顺序并放到临时桶中去,从左到右扫会出错
            for(int m = a.length-1; m >= 0; m--){
                int s = getNum(a[m],d);
                temp[count[s]-1] = a[m];
                count[s]--;
            }
            for(int n = 0; n < a.length; n++){
                a[n] = temp[n];
            }
        }
    }
    public static void main(String args[]){
        int[] b ={100,25,44,111,7777,666,2,1};
        sort(b);
        Sort.out(b);
    }
}
