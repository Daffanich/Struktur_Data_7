import java.util.*;

public class maxHeap {
    private ArrayList<Barang> heap = new ArrayList<>();

    
    public void insert(Barang data) {
        heap.add(data);
        int index = heap.size() - 1;

        
        while (index > 0 && heap.get((index - 1) / 2).id < heap.get(index).id) {
            Collections.swap(heap, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    
    public Barang extractMax() {
        if (heap.isEmpty()) return null;
        
        Barang root = heap.get(0);
        Barang lastItem = heap.remove(heap.size() - 1);
        
        if (!heap.isEmpty()) {
            heap.set(0, lastItem);
            maxHeapify(0);
        }
        return root;
    }

    private void maxHeapify(int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < heap.size() && heap.get(l).id > heap.get(largest).id) largest = l;
        if (r < heap.size() && heap.get(r).id > heap.get(largest).id) largest = r;

        if (largest != i) {
            Collections.swap(heap, i, largest);
            maxHeapify(largest);
        }
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    
    public ArrayList<Barang> getHeapData() {
        return new ArrayList<>(heap);
    }
}