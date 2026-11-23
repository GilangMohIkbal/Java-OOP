import  java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Product product = new Product("Keyboard", 10);
        boolean berjalan = true;

       while (berjalan) {
            System.out.println("\n=== MENU STOK PRODUK ===");
            System.out.println("1. Lihat stok");
            System.out.println("2. Tambah stok");
            System.out.println("3. Ambil stok");
            System.out.println("4. Simulasi stok harian");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.println("Produk: " + product.getNama());
                    System.out.println("Stok aktual: " + product.getStok() + " unit");
                    break;

                case 2:
                    System.out.print("Jumlah stok yang ditambah: ");
                    int jumlahTambah = input.nextInt();

                    if (jumlahTambah <= 0) {
                        System.out.println("Jumlah harus lebih dari 0.");
                    } else {
                        product.tambahStok(jumlahTambah);
                        System.out.println("Stok sekarang: " + product.getStok() + " unit");
                    }
                    break;

                case 3:
                    System.out.print("Jumlah stok yang diambil: ");
                    int jumlahAmbil = input.nextInt();

                    if (jumlahAmbil <= 0) {
                        System.out.println("Jumlah harus lebih dari 0.");
                    } else if (jumlahAmbil > product.getStok()) {
                        System.out.println("Stok tidak cukup.");
                    } else {
                        product.ambilStok(jumlahAmbil);
                        System.out.println("Stok sekarang: " + product.getStok() + " unit");
                    }
                    break;

                case 4:
                    System.out.print("Jumlah hari: ");
                    int hari = input.nextInt();
                    System.out.print("Unit keluar per hari: ");
                    int keluarPerHari = input.nextInt();

                    if (hari <= 0 || keluarPerHari <= 0) {
                        System.out.println("Jumlah hari dan unit keluar harus lebih dari 0.");
                    } else {
                       
                        int stokSimulasi = product.getStok();

                        for (int i = 1; i <= hari; i++) {
                            if (keluarPerHari > stokSimulasi) {
                                System.out.println("Stok simulasi tidak cukup pada hari ke-" + i + ".");
                                break;
                            }

                            stokSimulasi -= keluarPerHari;
                            System.out.println("Hari ke-" + i + ": " + stokSimulasi + " unit");
                        }

                        System.out.println("Stok aktual tetap: " + product.getStok() + " unit");
                    }
                    break;

                case 0:
                    System.out.println("Program selesai.");
                    berjalan = false;
                    break;

                default:
                    System.out.println("Pilihan menu tidak valid.");
                    break;
            }
        }

        input.close();
    }
}