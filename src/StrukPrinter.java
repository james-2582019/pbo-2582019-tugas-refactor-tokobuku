public class StrukPrinter {
    public void cetak(String pelanggan, Keranjang keranjang, MetodeBayar metode, int totalBayar) {
        System.out.println("================ STRUK =================");
        System.out.println("Pelanggan : " + pelanggan);

        for (Buku buku : keranjang.getDaftarBuku()) {
            System.out.println(buku.getJudul() + " (" + buku.getPenulis() + ")");
            System.out.println("  Harga       : " + FormatRupiah.format(buku.getHarga()));
            System.out.println("  Keterangan  : " + buku.keterangan());
            System.out.println("  Harga akhir : " + FormatRupiah.format(buku.hargaAkhir()));
        }

        System.out.println("-----------------------------------------");
        System.out.println("Total belanja : " + FormatRupiah.format(keranjang.totalBelanja()));
        System.out.println("Metode bayar  : " + metode.getNama());
        System.out.println("Total bayar   : " + FormatRupiah.format(totalBayar));
        System.out.println("Berat kiriman : " + keranjang.totalBeratGram() + " gram");
        System.out.println("-------------- LINK UNDUH ---------------");

        for (BisaDiunduh item : keranjang.getDaftarUnduhan()) {
            System.out.println(item.linkUnduh());
        }

        System.out.println("-----------------------------------------");
    }
}