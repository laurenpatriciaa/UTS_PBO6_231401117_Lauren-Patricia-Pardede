package soal2;

public class Kendaraan {
    private String jenis;
    private int lamaParkir;
    private final int tarifPerJam;

    public Kendaraan(String jenis) {
        this.jenis = jenis.toLowerCase();
        switch (this.jenis) {
            case "motor":
                tarifPerJam = 2000;
                break;
            case "mobil":
                tarifPerJam = 5000;
                break;
            case "truk":
                tarifPerJam = 9000;
                break;
            default:
                tarifPerJam = 0;
        }
    }

    public int hitungBiayaParkir(int jam) {
        this.lamaParkir = jam;
        return hitungTotalBiaya();
    }

    public int hitungBiayaParkir(int jamMasuk, int jamKeluar) {
        this.lamaParkir = jamKeluar - jamMasuk;
        return hitungTotalBiaya();
    }

    private int hitungTotalBiaya() {
        int biaya = lamaParkir * tarifPerJam;
        if (lamaParkir > 5) {
            biaya *= 0.9; // Diskon 10%
        }
        return biaya;
    }

    public void tampilRingkasan() {
        System.out.println("\n---- RINGKASAN PARKIR ----");
        System.out.println("Jenis Kendaraan : " + jenis.substring(0, 1).toUpperCase() + jenis.substring(1));
        System.out.println("Lama Parkir     : " + lamaParkir + " jam");
        System.out.println("Total Biaya     : Rp" + hitungTotalBiaya() + ".0");
    }

    public int getBiaya() {
        return hitungTotalBiaya();
    }
}
