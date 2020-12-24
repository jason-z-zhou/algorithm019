class MergeSort{
    public void mergeSort(int[] elems) {
        mergeSort(elems, 0, elems.length - 1);
    }

    private void mergeSort(int[] elems, int left, int right) {
        if(right <= left) return;
        int mid = (left - right) / 2 + right;

        mergeSort(elems, left, mid);
        mergeSort(elems, mid+1, right);
        merge(elems, left, mid, right);
    }

    private void merge(int elems, int left, int mid, int rigth) {
        int[] temp = new int[rigth - left + 1];

        int i = left, j = mid + 1, k = 0;

        while(i <= mid && j<=right ) {
            temp[k++] = elems[i] > elems[j] ? elems[i++] : elems[j++];
        }
        while( i <= mid) temp[k++] = elems[i++];
        while( j <= right) temp[k++] = elems[j++];

        for(int p=0; p<temp.length; p++) {
            elems[left + p] = temp[p];
        }
    }

}
