public class BayarTunai implements MetodeBayar {
    @Override
    public String getNama() {
        return "Tunai";
    }

    @Override
    public int hitungTotalBayar(int totalBelanja) {
        return totalBelanja;
    }
}