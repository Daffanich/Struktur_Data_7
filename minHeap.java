import java.util.*;

public class minHeap {
    
    private ArrayList<Barang> heap = new ArrayList<>();

    
    public void insert(Barang data) {
        heap.add(data);
        int index = heap.size() - 1;

        
        while (index > 0 && heap.get((index - 1) / 2).id > heap.get(index).id) {
            Collections.swap(heap, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    
    public Barang extractMin() {
        if (heap.isEmpty()) return null;
        
        Barang root = heap.get(0);
        
        Barang lastItem = heap.remove(heap.size() - 1);
        
        if (!heap.isEmpty()) {
            heap.set(0, lastItem);
            minHeapify(0);
        }
        return root;
    }

    private void minHeapify(int i) {
        int smallest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        
        if (l < heap.size() && heap.get(l).id < heap.get(smallest).id) smallest = l;
        if (r < heap.size() && heap.get(r).id < heap.get(smallest).id) smallest = r;

        if (smallest != i) {
            Collections.swap(heap, i, smallest);
            minHeapify(smallest);
        }
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    
    public ArrayList<Barang> getHeapData() {
        return new ArrayList<>(heap);
    }
}