Sistem Struktur Data Heap (Java & Python)
Proyek ini berisi implementasi manual struktur data Min-Heap dan Max-Heap menggunakan bahasa pemrograman Java dan Python. Program ini dirancang untuk mengelola data barang atau mahasiswa (ID dan Nama) dengan fitur pengurutan dan pembacaan data eksternal.

Fitur Utama
Tambah Data: Menambahkan data (ID dan Nama) ke Min-Heap dan Max-Heap secara bersamaan.

Tampilkan Ascending: Menampilkan data urut berdasarkan ID terkecil menggunakan Min-Heap.

Tampilkan Descending: Menampilkan data urut berdasarkan ID terbesar menggunakan Max-Heap.

Hapus Min: Menghapus data dengan ID terkecil dari Min-Heap.

Hapus Max: Menghapus data dengan ID terbesar dari Max-Heap.

Load Data: Memasukkan data awal secara massal dari file CSV (Java) atau Excel/CSV (Python).

Struktur File
JavaHeap.java : Kode utama program dalam bahasa Java.

pyheap.py : Kode utama program dalam bahasa Python.

data100.xlsx / data100.csv : File sumber data awal.

Persiapan Instalasi
1. Java
Pastikan kamu sudah menginstal JDK (Java Development Kit). Tidak diperlukan library tambahan karena program menggunakan library standar Java.

2. Python
Program Python menggunakan library Pandas untuk membaca file Excel. Instal library yang dibutuhkan melalui terminal:

Bash
pip install pandas openpyxl
Cara Menjalankan
Menjalankan Versi Java
Buka terminal atau Command Prompt di folder proyek.

Compile file Java:

Bash
javac JavaHeap.java
Jalankan program:

Bash
java JavaHeap
Menjalankan Versi Python
Buka terminal di folder proyek.

Jalankan perintah:

Bash
python pyheap.py
Format Data (CSV/Excel)
Pastikan file data kamu memiliki kolom dengan header berikut:

id: Berisi angka unik.

nama: Berisi teks nama barang atau mahasiswa.

Catatan: Untuk Java, simpan file Excel kamu sebagai format CSV (Comma Delimited) agar bisa dibaca dengan benar.

Penjelasan Logika Heap
Program ini tidak menggunakan library heap bawaan, melainkan mengimplementasikan logika:

Bubble Up: Menyeimbangkan pohon ke atas saat data baru dimasukkan.

Heapify (Down): Menyeimbangkan pohon ke bawah saat elemen root dihapus.