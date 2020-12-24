class HeapSort{
    public void heapSort(int[] elems) {
        Queue<Integer> heap = new PriorityQueue<>();

        for(int elem: elems) {
            heap.push(elem)
        }

        for(int i=0; i<elems.length; i++) {
            elems[i] = heap.pop();
        }
    }
}
