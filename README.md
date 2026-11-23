# Java OOP — Stok Produk

Aplikasi terminal sederhana untuk mengelola stok **satu produk Keyboard**. Setiap kali program dimulai, stok awalnya **10 unit**. Data disimpan di memori, jadi tidak disimpan setelah program ditutup.

## Fitur

- **1. Lihat stok:** menampilkan nama produk dan stok aktual.
- **2. Tambah stok:** menambah stok jika jumlah lebih dari 0.
- **3. Ambil stok:** mengurangi stok jika jumlah lebih dari 0 dan stok mencukupi.
- **4. Simulasi stok harian:** mengurangi _salinan_ stok untuk setiap hari. Simulasi berhenti jika stok tidak cukup, tanpa mengubah stok aktual.
- **0. Keluar:** menghentikan aplikasi. Angka menu lain ditolak.

## Struktur program

- `Product.java`: menyimpan atribut `private` nama dan stok, constructor, method pembaca (`getNama`, `getStok`), serta operasi `tambahStok` dan `ambilStok`.
- `Main.java`: membuat objek Keyboard, menerima input menggunakan `Scanner`, menampilkan menu `while`, memilih aksi dengan `switch`, memvalidasi dengan `if/else`, dan menjalankan simulasi menggunakan `for`.

## Cara menjalankan

**Prasyarat:** Java JDK terpasang dan perintah `javac` serta `java` dapat dijalankan melalui terminal.

Buka terminal pada folder yang berisi `Main.java` dan `Product.java`, kemudian jalankan:

```bash
javac Main.java Product.java
java Main
```

Ikuti menu dengan mengetik angka pilihan. Untuk percobaan ini input menu, jumlah unit, dan jumlah hari menggunakan bilangan bulat (`Scanner.nextInt()`). Penanganan input teks/nonangka tidak termasuk dalam implementasi dasar ini.

## Bukti percobaan

Semua pengujian di bawah **dijalankan secara nyata** setelah kompilasi dengan JDK 21. Setiap skenario dijalankan ulang dari stok awal 10. Kolom input menunjukkan urutan angka yang diketik; output berisi **kutipan teks yang benar-benar muncul** pada hasil program (teks menu dan prompt berulang tidak ditampilkan agar ringkas).

| Skenario                       | Urutan input        | Kutipan output aktual                                                                                                                               |
| ------------------------------ | ------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------- |
| Lihat stok awal                | `1 → 0`             | `Produk: Keyboard`<br>`Stok aktual: 10 unit`                                                                                                        |
| Tambah 5 dari stok 10          | `2 → 5 → 1 → 0`     | `Stok sekarang: 15 unit`<br>`Stok aktual: 15 unit`                                                                                                  |
| Ambil 4 dari stok 10           | `3 → 4 → 1 → 0`     | `Stok sekarang: 6 unit`<br>`Stok aktual: 6 unit`                                                                                                    |
| Tambah 0 ditolak               | `2 → 0 → 1 → 0`     | `Jumlah harus lebih dari 0.`<br>`Stok aktual: 10 unit`                                                                                              |
| Ambil -2 ditolak               | `3 → -2 → 1 → 0`    | `Jumlah harus lebih dari 0.`<br>`Stok aktual: 10 unit`                                                                                              |
| Ambil 11 ditolak               | `3 → 11 → 1 → 0`    | `Stok tidak cukup.`<br>`Stok aktual: 10 unit`                                                                                                       |
| Simulasi 3 hari, keluar 2      | `4 → 3 → 2 → 1 → 0` | `Hari ke-1: 8 unit`<br>`Hari ke-2: 6 unit`<br>`Hari ke-3: 4 unit`<br>`Stok aktual tetap: 10 unit`<br>`Stok aktual: 10 unit`                         |
| Simulasi 4 hari, keluar 4      | `4 → 4 → 4 → 1 → 0` | `Hari ke-1: 6 unit`<br>`Hari ke-2: 2 unit`<br>`Stok simulasi tidak cukup pada hari ke-3.`<br>`Stok aktual tetap: 10 unit`<br>`Stok aktual: 10 unit` |
| Simulasi 0 hari ditolak        | `4 → 0 → 2 → 1 → 0` | `Jumlah hari dan unit keluar harus lebih dari 0.`<br>`Stok aktual: 10 unit`                                                                         |
| Simulasi unit keluar 0 ditolak | `4 → 2 → 0 → 1 → 0` | `Jumlah hari dan unit keluar harus lebih dari 0.`<br>`Stok aktual: 10 unit`                                                                         |
| Menu 9 ditolak lalu keluar 0   | `9 → 0`             | `Pilihan menu tidak valid.`<br>`Program selesai.`                                                                                                   |

**Hasil:** seluruh 11 skenario di atas berjalan sesuai hasil yang diharapkan. Saat input ditolak atau hanya dilakukan simulasi, stok aktual tetap 10. Setelah angka menu 9, menu muncul lagi dan angka 0 berhasil menghentikan program.
