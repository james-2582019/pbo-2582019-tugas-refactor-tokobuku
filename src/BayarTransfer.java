public class BayarTransfer implements MetodeBayar {
    @Override
    public String getNama() {
        return "Transfer (+Rp2.500)";
    }

    @Override
    public int hitungTotalBayar(int totalBelanja) {
        return totalBelanja + 2500;
    }
}