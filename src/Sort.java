/**
 * Created by PC on 2017/6/22.
 */
public class Sort {
        static int[] a = {10,5,2,4,3,1,6,7,0,8};
        public static void swap(int[] data,int a,int b){
            int t = data[a];
            data[a] = data[b];
            data[b] = t;
        }
        //插入排序就是把一个数组先分为左右两个部分，左边是有序部分，右边是待排序的部分。
        //每次向右扫描一个数，和左边有序部分比较，找到合适的位置插进去。
        public static void charuSort(int[] a){
            //第一个数默认是有序的部分，所以从i=1开始
            for(int i = 1;i < a.length;i++){
                int j = i;//j就是有序部分的个数，用于接下来新读入数字和有序部分比较
                //从最右边和有序区进行比较，如果左边比右边大就进行交换，之后继续比较，
                //直到左边的数比右边的小或者左边没数了
                while(j>0 && a[j-1]>a[j]){
                    swap(a,j-1,j);
                    out(a);
                    j--;
                }
            }
        }
        //	0 5 2 4 3 1 6 7 10 8
        //	0 2 5 4 3 1 6 7 10 8
        //	0 2 4 5 3 1 6 7 10 8
        //	0 2 4 3 5 1 6 7 10 8
        //	0 2 3 4 5 1 6 7 10 8
        //	0 2 3 4 1 5 6 7 10 8
        //	0 2 3 1 4 5 6 7 10 8
        //	0 2 1 3 4 5 6 7 10 8
        //	0 1 2 3 4 5 6 7 10 8
        //	0 1 2 3 4 5 6 7 8 10
        //希尔排序的基本思想是：
        //把记录按步长 gap 分组，对每组记录采用直接插入排序方法进行排序。
        // 随着步长逐渐减小，所分成的组包含的记录越来越多，当步长的值减小到 1 时，整个数据合成为一组，构成一组有序记录，则完成排序。
        public static void xierSort(int[] a){
            //初始参数设置为2（参数可变）
            int gap = a.length/2;
            //两个元素之间的距离等于1比较最后一次
            while(gap >= 1){
                //gap为5时需要比较5次，为2时要比较8次（暂且这么认为），所以是从gap到数组长度
                for(int i=gap;i<a.length;i++){
                    int j=i-gap;
                    //在这里遇到了一个问题，数组a[j-gap]会自动把j-gap赋值给j导致越界
                    while(j>=0 && a[j+gap]<a[j]){
                       swap(a,j+gap,j);
                       j -= gap;
                    }
                }
                gap = gap/2;
            }
        }
        //每次都比较左右两个数的大小然后交换
        public static void maopaoSort(int[] a){
            for(int i = 0;i<a.length;i++){
                //i每增加一次就有一个最大的数“冒”到最右边（已经有i个数找对位置），所以要减i
                for(int j=1;j<a.length-i;j++){
                    if(a[j]<a[j-1]){
                        swap(a,j-1,j);
                        out(a);
                    }
                }
            }
        }
        //每次都选择最小的数放在数组的左边
        public static void xuanzeSort(int[] a){
            for(int i=0;i<a.length;i++){
                //最小位置的坐标，每找到一个最小的就加一
                int min = i;
                //从最小位置右边第一个开始比较，如果小就交换两个数
                for(int j=i+1;j<a.length;j++){
                    if(a[j]<a[min]){
                        swap(a,min,j);
                        out(a);
                    }
                }
            }
        }
        public  static void quickSort(int[] a,int l,int r){
            if(l < r){
                //选取最左边的为开始节点
                int i = l, j = r, x = a[l];
                while(i < j){
                    //用两个指针分别从左右开始往中间扫，发现右边的数如果小于x，将这个数赋值给左边i指的位置
                    //然后开始从左往右扫，发现左边的数大于x，讲这个数赋值给右边j指的位置
                    //直到两个指针相遇，然后把两个指针指的位置赋值为x
                    while(i<j && x<=a[j])
                        j--;
                    a[i] = a[j];
                    while(i<j && x>=a[i])
                        i++;
                    a[j]=a[i];
                }
                a[i] = x;
                out(a);
                //然后把刚才调好的数组分为两个部分，左右分别进行快速排序
                quickSort(a,l,i-1);
                quickSort(a,i+1,r);
            }
        }
        public static void out(int[] a){
            for (int anA : a) System.out.print(anA + " ");
            System.out.println();
        }
        public static void main(String args[]){
            out(a);
            //charuSort(a);
            //maopaoSort(a);
            //xuanzeSort(a);
            quickSort(a,0,a.length-1);
            //HeapSort.sort(a);
            //MergeSort.sort(a);
            //xierSort(a);
            out(a);
        }
}

