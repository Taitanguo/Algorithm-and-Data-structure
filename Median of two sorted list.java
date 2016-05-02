public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int len = A.length + B.length;
        if (len % 2 == 1) {
            return findKth(A, 0, B, 0, len / 2 + 1);
        }
        return (
            findKth(A, 0, B, 0, len / 2) + findKth(A, 0, B, 0, len / 2 + 1)
        ) / 2.0;
    }

    // find kth number of two sorted array
    public static int findKth(int[] A, int A_start,
                              int[] B, int B_start,
                              int k){
        if (A_start >= A.length) {       //如果把A扔完了 B的第k位就是第k小
            return B[B_start + k - 1];
        }
        if (B_start >= B.length) {        //同理
            return A[A_start + k - 1];
        }

        if (k == 1) {                   //最后都没扔完 但是k已经成为找第一个 则直接return较小的那个即可
            return Math.min(A[A_start], B[B_start]);
        }
        //看看A或者B的元素是不是够用 够的话 直接用 不够的话 就用无穷大补上 以为补上无穷大队结果没有影响 由merge的算法决定的 每次出列的都是小的
        int A_key = A_start + k / 2 - 1 < A.length
                    ? A[A_start + k / 2 - 1]
                    : Integer.MAX_VALUE;
        int B_key = B_start + k / 2 - 1 < B.length
                    ? B[B_start + k / 2 - 1]
                    : Integer.MAX_VALUE;
        //谁小的话就将谁扔出去
        if (A_key < B_key) {
            return findKth(A, A_start + k / 2, B, B_start, k - k / 2);
        } else {
            return findKth(A, A_start, B, B_start + k / 2, k - k / 2);
        }
    }
}