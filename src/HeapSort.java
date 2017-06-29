/**
 * Created by PC on 2017/6/22.
 */

public class HeapSort {
    public static void adjust(int[] a,int i,int size){
        int lchild = 2 * i + 1;//左子树对应的数组下标
        int rchild = 2 * i + 2;
        int parent = i;//父节点对应数组下标
        //下标大于size/2的均为叶子节点，只有非叶子节点才需要调节
        if(i<size/2){
            //左子树的值大于父节点的值，交换两个在数组中的值
            if(lchild < size && a[lchild] > a[parent]){
                parent = lchild;
            }
            if(rchild < size && a[rchild] > a[parent]){
                parent = rchild;
            }
            if(parent != i){
                //交换两个的值
                Sort.swap(a, parent, i);
                //递归调节，此时parent=2*i+1或者2*i+2,
                //只需要把交换后的子树进行调整就行了，因为其他没有交换子树的原来就满足最小堆
                adjust(a,parent,size);
            }
        }
    }
    public static void sort(int[] a){
        //初始化堆，从第一个非叶子节点开始，调整父节点与孩子节点的关系，使之满足最小堆性质。
        //为什么要从叶子节点开始而不从根节点开始？
        //只有先让子树成为最小堆，才能调节根节点。
        for(int i=a.length/2;i>=0;i--){
            adjust(a,i,a.length);
            Sort.out(a);
        }
        for(int j=a.length-1;j>=0;j--){
            //因为初始化时已经是最小堆了（i=0)，所以可以直接把
            //最后位置和第一个位置的数交换，之后无序区j的数量就减1
            Sort.out(a);
            Sort.swap(a, j, 0);
            adjust(a,0,j);
        }
    }
}
