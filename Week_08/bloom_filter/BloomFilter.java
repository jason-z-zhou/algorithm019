class BloomFilter{
    private int size;
    private int hashNum;
    private BitSet bits;

    public BloomFilter(int size, int hashNum){
        this.hashNum = hashNum;
        this.size = size;
        this.bits = new BitSet(size);
    }

    public add(String elem) {
        for(int seed=0; seed<hashNum; seed++) {
            int hash = hash(elem, seed) % size;
            bits.set(hash, true);
        }
    }

    public lookup(String elem) {
        boolean ret = true;
        for(int seed=0; seed<hashNum; seed++) {
            int hash = hash(elem, seed) % size;
            ret = ret && bits.get(hash);
        }

        return ret;
    }

    public int hash(String elem, int seed) {
        //  FIXME: use better hash function
        return elem.hashCode ^ seed;
    }
}
