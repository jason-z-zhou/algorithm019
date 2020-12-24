

class QuickSort{

    public void quickSort(int[] elems) {
        quickSort(elems, 0, elems.length-1);
    }


    private void quickSort(int[] elems, int begin, int end) {
        if(end <= begin) return;
        int pivot = partition(elems, begin, end);

        quickSort(elems, begin, pivot - 1);
        quickSort(elems, pivot+1, end);
    }

    private int partition(int[] elems, int begin, int end) {
        int pivot = end, counter = begin;

        for(int i=counter; i<=end; i++) {
            if(elems[i] < elems[pivot]) {
                swap(elems, i, counter);
                counter++
            }
        }

        swap(elems, counter, pivot);
        return counter;
    }

    private void swap(int[] elems, int left, int right) {
        int temp = elems[left];
        elems[left] = elems[right];
        elems[right] = temp;
    }


}
