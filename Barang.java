public class Barang {
    int id;
    String nama;

    public Barang(int id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    @Override
    public String toString() {
        return "[ID: " + id + ", Nama: " + nama + "]";
    }
}