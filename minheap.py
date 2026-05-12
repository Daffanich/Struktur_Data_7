def insert(heap, data):
    """
    data adalah tuple: (id, nama)
    Kita membandingkan berdasarkan ID (indeks 0).
    """
    heap.append(data)
    index = len(heap) - 1

    
    while index > 0 and heap[(index - 1) // 2][0] > heap[index][0]:
        heap[index], heap[(index - 1) // 2] = heap[(index - 1) // 2], heap[index]
        index = (index - 1) // 2

def extract_min(heap):
    """
    Menghapus dan mengambil elemen terkecil (root).
    """
    if not heap:
        return None
    if len(heap) == 1:
        return heap.pop()

    root = heap[0]
    heap[0] = heap.pop() 
    _min_heapify(heap, 0)
    return root

def _min_heapify(heap, i):
    """
    Menyeimbangkan kembali Min-Heap setelah root diambil.
    """
    smallest = i
    l = 2 * i + 1
    r = 2 * i + 2
    n = len(heap)

    if l < n and heap[l][0] < heap[smallest][0]: smallest = l
    if r < n and heap[r][0] < heap[smallest][0]: smallest = r

    if smallest != i:
        heap[i], heap[smallest] = heap[smallest], heap[i]
        _min_heapify(heap, smallest)


if __name__ == "__main__":
    arr = []
    
    sample_data = [(10, "Buku"), (2, "Pena"), (3, "Meja")]
    
    for item in sample_data:
        insert(arr, item)
        print(f"Inserted {item} -> Current Min-Heap: {arr}")