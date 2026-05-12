import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


class Barang {
    int id;
    String nama;

    Barang(int id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    @Override
    public String toString() {
        return String.format("[ID: %-4d | Nama: %-15s]", id, nama);
    }
}


class HeapSystem {
    private List<Barang> minHeap = new ArrayList<>();
    private List<Barang> maxHeap = new ArrayList<>();

    
    public void insertData(int id, String nama) {
        Barang baru = new Barang(id, nama);
        
        minHeap.add(baru);
        bubbleUpMin(minHeap.size() - 1);

        maxHeap.add(baru);
        bubbleUpMax(maxHeap.size() - 1);
    }

    
    private void bubbleUpMin(int idx) {
        while (idx > 0 && minHeap.get(idx).id < minHeap.get((idx - 1) / 2).id) {
            Collections.swap(minHeap, idx, (idx - 1) / 2);
            idx = (idx - 1) / 2;
        }
    }

    public Barang removeMin() {
        if (minHeap.isEmpty()) return null;
        Barang root = minHeap.get(0);
        
        
        Barang lastItem = minHeap.remove(minHeap.size() - 1);
        if (!minHeap.isEmpty()) {
            minHeap.set(0, lastItem);
            minHeapify(0);
        }
        return root;
    }

    private void minHeapify(int i) {
        int smallest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < minHeap.size() && minHeap.get(l).id < minHeap.get(smallest).id) smallest = l;
        if (r < minHeap.size() && minHeap.get(r).id < minHeap.get(smallest).id) smallest = r;
        if (smallest != i) {
            Collections.swap(minHeap, i, smallest);
            minHeapify(smallest);
        }
    }

    
    private void bubbleUpMax(int idx) {
        while (idx > 0 && maxHeap.get(idx).id > maxHeap.get((idx - 1) / 2).id) {
            Collections.swap(maxHeap, idx, (idx - 1) / 2);
            idx = (idx - 1) / 2;
        }
    }

    public Barang removeMax() {
        if (maxHeap.isEmpty()) return null;
        Barang root = maxHeap.get(0);
        
        Barang lastItem = maxHeap.remove(maxHeap.size() - 1);
        if (!maxHeap.isEmpty()) {
            maxHeap.set(0, lastItem);
            maxHeapify(0);
        }
        return root;
    }

    private void maxHeapify(int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < maxHeap.size() && maxHeap.get(l).id > maxHeap.get(largest).id) largest = l;
        if (r < maxHeap.size() && maxHeap.get(r).id > maxHeap.get(largest).id) largest = r;
        if (largest != i) {
            Collections.swap(maxHeap, i, largest);
            maxHeapify(largest);
        }
    }

    
    public void displayAscending() {
        if (minHeap.isEmpty()) {
            System.out.println("Data kosong.");
            return;
        }
        
        List<Barang> original = new ArrayList<>(minHeap);
        System.out.println("\n--- Data Urut Ascending (Heapsort via Min-Heap) ---");
        while (!minHeap.isEmpty()) {
            System.out.println(removeMin());
        }
        minHeap = original; 
    }

   
    public void displayDescending() {
        if (maxHeap.isEmpty()) {
            System.out.println("Data kosong.");
            return;
        }
        List<Barang> original = new ArrayList<>(maxHeap);
        System.out.println("\n--- Data Urut Descending (Heapsort via Max-Heap) ---");
        while (!maxHeap.isEmpty()) {
            System.out.println(removeMax());
        }
        maxHeap = original; 
    }

    
    public void loadFromCSV(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            br.readLine(); 
            int count = 0;
            while ((line = br.readLine()) != null) {
                
                String[] data = line.split("[,;]"); 
                if (data.length >= 2) {
                    try {
                        int id = Integer.parseInt(data[0].trim());
                        String nama = data[1].trim();
                        insertData(id, nama);
                        count++;
                    } catch (NumberFormatException e) {
                        
                    }
                }
            }
            System.out.println("Berhasil memuat " + count + " data.");
        } catch (IOException e) {
            System.out.println("Gagal membaca file: " + e.getMessage());
        }
    }
}

public class JavaHeap {
    public static void main(String[] args) {
        HeapSystem sys = new HeapSystem();
        Scanner sc = new Scanner(System.in);
        int pilihan = -1;

        do {
            System.out.println("\n========= MENU SISTEM HEAP =========");
            System.out.println("1. Tambah Data (Manual)");
            System.out.println("2. Tampilkan Ascending (Min-Heap)");
            System.out.println("3. Tampilkan Descending (Max-Heap)");
            System.out.println("4. Hapus Root Min-Heap (ID Terkecil)");
            System.out.println("5. Hapus Root Max-Heap (ID Terbesar)");
            System.out.println("6. Load Data dari CSV (data100.csv)");
            System.out.println("0. Keluar");
            System.out.print("Pilihan Anda: ");

            try {
                pilihan = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                pilihan = -1;
            }

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan ID: ");
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.print("Masukkan Nama: ");
                    String nama = sc.nextLine();
                    sys.insertData(id, nama);
                    System.out.println("Data berhasil ditambahkan.");
                    break;
                case 2:
                    sys.displayAscending();
                    break;
                case 3:
                    sys.displayDescending();
                    break;
                case 4:
                    Barang rMin = sys.removeMin();
                    System.out.println(rMin != null ? "Dihapus: " + rMin : "Heap kosong.");
                    break;
                case 5:
                    Barang rMax = sys.removeMax();
                    System.out.println(rMax != null ? "Dihapus: " + rMax : "Heap kosong.");
                    break;
                case 6:
                    System.out.print("Masukkan nama file CSV (contoh: data100.csv): ");
                    String fileName = sc.nextLine();
                    sys.loadFromCSV(fileName);
                    break;
                case 0:
                    System.out.println("Selesai. Sampai jumpa!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 0);

        sc.close();
    }
}