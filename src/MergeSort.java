/**
 * Created by PC on 2017/6/22.
 */
    //比较二个数列的第一个数，谁小就先取谁，取了后就在对应数列中删除这个数。然后再进行比较，如果有数列为空，那直接将另一个数列的数据依次取出即可。
    //基本思路就是将数组分成二组A，B，如果这二组组内的数据都是有序的，那么就可以很方便的将这二组数据进行排序。如何让这二组组内数据有序了？
    //可以将A，B组各自再分成二组。依次类推，当分出来的小组只有一个数据时，可以认为这个小组组内已经达到了有序，然后再合并相邻的二个小组就可以了。
    // 这样通过先递归的分解数列，再合并数列就完成了归并排序。
public class MergeSort {
    //合并两个排序好的数组
    public static void mergeArray(int[] a,int first,int mid,int last,int[] temp){
        int i = first,j = mid +1;
        int m = mid,n = last;
        int k = 0;
        while(i<=m && j<=n){
            //比较两个数组最左边的值，谁小就把谁赋给temp
            //如果谁把值赋给了temp，谁的数组下标就加一，直到其中一个数组为空
            if(a[i] < a[j]){
                temp[k++] = a[i++];
            }else{
                temp[k++] = a[j++];
            }
        }
        //跳出上个循环后，如果哪个数组不为空，就将该数组的其他元素直接赋给temp
        while(i<=m){
            temp[k++] = a[i++];
        }
        while(j<=n){
            temp[k++] = a[j++];
        }
        //把调整好的temp赋给对应的数组（这一步必须有）
        for (int l = 0; l < k; l++) {
            a[first + l] = temp[l];
            System.out.print(first+l+":"+a[first+l]+" ");
        }
        System.out.println();
    }
    public static void mergeSort(int[] a,int first,int last,int[] temp){
        if(first < last) {
            int mid = (first + last) / 2;
            mergeSort(a, first, mid, temp);
            mergeSort(a, mid + 1, last, temp);
            mergeArray(a, first, mid, last, temp);
        }
    }
    public static void sort(int[] a){
        int n = a.length;
        int[] temp = new int[n];
        mergeSort(a,0,n-1,temp);
        Sort.out(temp);
    }
}
