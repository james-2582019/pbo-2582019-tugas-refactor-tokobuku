public abstract class Buku {
    private final String judul;
    private final String penulis;
    private final int harga;

    public Buku(String judul, String penulis, int harga) {
        this.judul = judul;
        this.penulis = penulis;
        this.harga = harga;
    }

    public String getJudul() {
        return judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public int getHarga() {
        return harga;
    }

    protected String buatSlug() {
        return judul.toLowerCase().replace(' ', '-');
    }

    public abstract int hargaAkhir();
    public abstract String keterangan();
}