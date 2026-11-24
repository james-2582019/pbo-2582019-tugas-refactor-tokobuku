import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Keranjang {
    private final List<Buku> daftarBuku = new ArrayList<>();
    private final List<BisaDikirim> daftarKiriman = new ArrayList<>();
    private final List<BisaDiunduh> daftarUnduhan = new ArrayList<>();

    public void tambah(Buku buku) {
        daftarBuku.add(buku);
    }

    public void tambahKiriman(BisaDikirim item) {
        daftarKiriman.add(item);
    }

    public void tambahUnduhan(BisaDiunduh item) {
        daftarUnduhan.add(item);
    }

    public List<Buku> getDaftarBuku() {
        return Collections.unmodifiableList(daftarBuku);
    }

    public List<BisaDiunduh> getDaftarUnduhan() {
        return Collections.unmodifiableList(daftarUnduhan);
    }

    public int jumlahBuku() {
        return daftarBuku.size();
    }

    public int totalBelanja() {
        int total = 0;
        for (Buku buku : daftarBuku) {
            total += buku.hargaAkhir();
        }
        return total;
    }

    public int totalBeratGram() {
        int totalBerat = 0;
        for (BisaDikirim item : daftarKiriman) {
            totalBerat += item.getBeratGram();
        }
        return totalBerat;
    }
}