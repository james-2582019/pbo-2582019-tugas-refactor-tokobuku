public class FormatRupiah {
    public static String format(int angka) {
        return String.format("Rp%,d", angka).replace(',', '.');
    }
}