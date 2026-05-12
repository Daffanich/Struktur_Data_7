def insert(heap, data):
    """
    data adalah tuple: (id, nama)
    Kita bandingkan berdasarkan data[0] yaitu ID-nya.
    """
    heap.append(data)
    index = len(heap) - 1

    
    while index > 0 and heap[(index - 1) // 2][0] < heap[index][0]:
        heap[index], heap[(index - 1) // 2] = heap[(index - 1) // 2], heap[index]
        index = (index - 1) // 2

def extract_max(heap):
    """
    Menghapus dan mengembalikan elemen dengan ID terbesar (root).
    """
    if not heap:
        return None
    if len(heap) == 1:
        return heap.pop()
    
    root = heap[0]
    heap[0] = heap.pop() 
    _max_heapify(heap, 0)
    return root

def _max_heapify(heap, i):
    """
    Menyeimbangkan kembali heap setelah root dihapus.
    """
    largest = i
    l = 2 * i + 1
    r = 2 * i + 2
    n = len(heap)

    if l < n and heap[l][0] > heap[largest][0]:
        largest = l
    if r < n and heap[r][0] > heap[largest][0]:
        largest = r

    if largest != i:
        heap[i], heap[largest] = heap[largest], heap[i]
        _max_heapify(heap, largest)


if __name__ == "__main__":
    arr = []
    
    values = [(10, "Buku"), (7, "Pena"), (11, "Meja"), (5, "Kursi"), (13, "Lampu")]

    print("--- Proses Insert ke Max-Heap ---")
    for val in values:
        insert(arr, val)
        print(f"Inserted {val} -> Current Heap: {arr}")

    print("\n--- Proses Hapus (Extract Max) ---")
    while arr:
        removed = extract_max(arr)
        print(f"Dihapus (Terbesar): {removed} | Sisa Heap: {arr}")