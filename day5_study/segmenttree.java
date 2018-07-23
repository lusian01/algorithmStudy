import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        int[] arr = {5, 3, 7, 9, 6, 4, 1, 2, 1};

        SegmentTree segmentTree = new SegmentTree(arr, 9);

        System.out.println(Arrays.toString(segmentTree.segmentArr));
    }
}

class SegmentTree {

    int[] segmentArr; // The array that stores segment tree nodes

    SegmentTree(int[] arr, int n) {

        //int x = (int) Math.ceil(Math.log(n) / Math.log(2));

        //int segmentSize = (int) Math.pow(2, x) * 2 - 1;

        //segmentArr = new int[segmentSize];
        segmentArr = new int[n * 4];

        init(arr, 0, n - 1, 1);
    }

    // node를 root로 하는 서브트리를 초기화하고, 이 구간의 최소치를 반환한다
    int init(int[] arr, int left, int right, int node) {

        if (left == right) {

            return segmentArr[node] = arr[left];
        }

        int mid = (left + right) / 2;

        segmentArr[node] += init(arr, left, mid, node * 2);
        segmentArr[node] += init(arr, mid + 1, right, node * 2 + 1);

        return segmentArr[node];
    }
}
