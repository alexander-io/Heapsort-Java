
/**
  * HeapSort in java
  * Alexander IO
  * circa 2015 - 2020
  */
class HeapSort {
  public static void main(String[] args) {
    HeapSort hs = new HeapSort();
    int[] arr = hs.generate_array(10000000);
    hs.print_array(arr);
    hs.heapify(arr, arr.length);

    System.out.println("\n----------------------------------------\n");
    // hs.print_array(arr);

    int end = arr.length-1;
    while (end > 0) {
      hs.swap(end, 0, arr);
      end--;
      hs.sift_down(arr, 0, end);
    }
    hs.print_array(arr);
  }
  int[] generate_array(int size) {
    int[] new_arr = new int[size];
    for (int i = 0; i < size; i++) {
      new_arr[i] = (int)(Math.random() * 10);
    }
    return new_arr;
  }
  void print_array(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + ", ");
    }
    System.out.println();
  }
  void swap(int a, int b, int[] arr) {
    int c = arr[a];
    arr[a] = arr[b];
    arr[b] = c;
  }

  void heapify(int[] arr, int count) {
    int start = get_parent(count-1);
    while (start >= 0) {
      sift_down(arr, start, count-1);
      start--;
    }
  }
  void sift_down(int[] arr, int start, int end) {
    int root = start;
    while (get_left_child(root) <= end) {
      int child = get_left_child(root);
      int swap = root;
      if (arr[swap] < arr[child]) swap = child;
      if (child+1 <= end && arr[swap] < arr[child+1]) swap = child+1;
      if (swap == root) { return; }
      else {
        swap(root, swap, arr);
        root = swap;
      }
    }
  }

  int get_parent(int child) {
    return (int)(child-1/2);
  }
  int get_left_child(int parent) {
    return 2*parent+1;
  }
  int get_right_child(int parent) {
    return 2*parent+2;
  }
}
