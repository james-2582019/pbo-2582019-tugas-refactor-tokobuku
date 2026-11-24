public class TokoBukuSolid {
    public static void main(String[] args) {
        Keranjang keranjang = new Keranjang();

        BukuCetak buku1 = new BukuCetak("Pemrograman Java", "John Doe", 120000, 750);
        BukuCetak buku2 = new BukuCetak("Algoritma Dasar", "Jane Smith", 95000, 400);
        BukuDigital buku3 = new BukuDigital("Belajar OOP", "Ani Wijaya", 80000, 12.5);
        BukuAudio buku4 = new BukuAudio("Kisah Programmer", "Budi Santoso", 60000, 240);

        keranjang.tambah(buku1);
        keranjang.tambahKiriman(buku1);

        keranjang.tambah(buku2);
        keranjang.tambahKiriman(buku2);

        keranjang.tambah(buku3);
        keranjang.tambahUnduhan(buku3);

        keranjang.tambah(buku4);
        keranjang.tambahUnduhan(buku4);

        StrukPrinter printer = new StrukPrinter();
        PengirimNotifikasi notifikasi = new EmailSender();
        PenyimpanRiwayat riwayat = new FileRiwayat();
        MetodeBayar metode = new BayarEWallet();

        ProsesCheckout prosesCheckout = new ProsesCheckout(printer, riwayat, notifikasi);
        prosesCheckout.checkout("Sari", "sari@mail.com", keranjang, metode);
    }
}