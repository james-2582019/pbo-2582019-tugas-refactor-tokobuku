# Laporan Refactor Toko Buku (Prinsip SOLID)

- **Nama:** James Smith Simbolon
- **NIM:** 2582019
- **Project:** `pbo-2582019-tugas-refactor-tokobuku`

Laporan ini menjelaskan pelanggaran kelima prinsip SOLID pada program awal `TokoBukuKotor.java` serta perbaikan yang dilakukan agar desain kode lebih bersih, mudah dirawat, dan tetap menghasilkan keluaran yang sama persis.


## 1. Single Responsibility Principle (SRP)

### a. Kode Awal yang Melanggar

```java
class Toko {
    ArrayList<Buku> keranjang = new ArrayList<>();
    PengirimNotifikasi email = new PengirimNotifikasi();
    PenyimpanRiwayat riwayat = new PenyimpanRiwayat();

    void tambah(Buku buku) { ...}

    int hitungOngkir(Buku b) { ...}

    int hargaAkhir(Buku b) { ...}

    String keterangan(Buku b) { ...}

    String namaMetode(String metode) { ...}

    int totalBayar(String metode, int totalBelanja) { ...}

    void checkout(String pelanggan, String alamatEmail, String metode) { ...}

    String formatRupiah(int angka) { ...}
}
```

### b. Penjelasan Masalah
Class `Toko` memikul terlalu banyak tanggung jawab sekaligus dalam satu tempat: mengelola keranjang belanja, menghitung ongkir dan diskon buku, menghitung biaya metode pembayaran, memformat angka Rupiah, mencetak struk ke konsol, menyimpan riwayat transaksi, hingga mengirim email. Akibatnya, jika suatu saat ada perubahan kecil—misalnya mengubah format struk atau aturan ongkir—kita terpaksa mengubah class `Toko` yang besar dan berisiko merusak bagian lain.

### c. Class/Interface Hasil Refactor
Tanggung jawab dipecah ke beberapa class sesuai perannya masing-masing:
- `Keranjang`: mengelola daftar buku, total belanja, dan total berat kiriman.
- `StrukPrinter`: khusus mencetak struk ke layar.
- `FormatRupiah`: khusus mengubah angka menjadi format mata uang Rupiah.
- `ProsesCheckout`: mengatur alur proses checkout dari awal sampai akhir.
- Turunan `Buku` (`BukuCetak`, `BukuDigital`, `BukuAudio`) dan implementasi `MetodeBayar`: menghitung harga akhir, keterangan, dan total bayar masing-masing.

## 2. Open/Closed Principle (OCP)

### a. Kode Awal yang Melanggar
```java
int hargaAkhir(Buku b) {
    switch (b.jenis) {
        case "CETAK":
            return b.getHarga() + hitungOngkir(b);
        case "DIGITAL":
            return b.getHarga() * 80 / 100;
        case "AUDIO":
            return b.getHarga() * 90 / 100;
        default:
            return b.getHarga();
    }
}

int totalBayar(String metode, int totalBelanja) {
    if (metode.equals("TUNAI")) {
        return totalBelanja;
    } else if (metode.equals("TRANSFER")) {
        return totalBelanja + 2500;
    } else if (metode.equals("EWALLET")) {
        return totalBelanja * 98 / 100;
    }
    return totalBelanja;
}

### b. Penjelasan Masalah
Setiap kali toko ingin menambah jenis buku baru (misalnya Majalah) atau metode pembayaran baru (misalnya QR