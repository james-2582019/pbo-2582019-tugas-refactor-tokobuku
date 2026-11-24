public class ProsesCheckout {
    private final StrukPrinter printer;
    private final PenyimpanRiwayat riwayat;
    private final PengirimNotifikasi notifikasi;

    public ProsesCheckout(StrukPrinter printer,
                          PenyimpanRiwayat riwayat,
                          PengirimNotifikasi notifikasi) {
        this.printer = printer;
        this.riwayat = riwayat;
        this.notifikasi = notifikasi;
    }

    public void checkout(String pelanggan, String tujuanNotifikasi,
                         Keranjang keranjang, MetodeBayar metode) {
        int totalBelanja = keranjang.totalBelanja();
        int totalBayar = metode.hitungTotalBayar(totalBelanja);

        printer.cetak(pelanggan, keranjang, metode, totalBayar);

        riwayat.simpan(pelanggan + ";" + keranjang.jumlahBuku() + " buku;" + FormatRupiah.format(totalBayar));
        notifikasi.kirim(tujuanNotifikasi, "Terima kasih " + pelanggan + ", total bayar " + FormatRupiah.format(totalBayar));
    }
}