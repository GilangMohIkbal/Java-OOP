public class Product {
    private String nama;
    private int stok;

    public Product(String nama, int stok) {
        this.nama = nama;
        this.stok = stok;
    }

    public String getNama() {
        return nama;
    }

    public int getStok() {
        return stok;
    }
    public void tambahStok(int jumlah) {
        stok += jumlah;
    }

    public void ambilStok(int jumlah) {
        stok -= jumlah;
    }
}