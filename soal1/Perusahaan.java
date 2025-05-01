package soal1;

import java.util.*;

public class Perusahaan {
    private List<Karyawan> daftarKaryawan;

    public Perusahaan() {
        daftarKaryawan = new ArrayList<>();
    }

    // Tambah karyawan (validasi ID unik dan gaji tidak negatif)
    public boolean tambahKaryawan(Karyawan karyawan) {
        if (cariKaryawanById(karyawan.getId()) != null) {
            System.out.println("ID sudah digunakan!");
            return false;
        }
        if (karyawan.getGaji() < 0) {
            System.out.println("Gaji tidak boleh negatif!");
            return false;
        }
        daftarKaryawan.add(karyawan);
        System.out.println("Karyawan berhasil ditambahkan.");
        return true;
    }

    // Hapus karyawan
    public boolean hapusKaryawan(String id) {
        Karyawan k = cariKaryawanById(id);
        if (k != null) {
            daftarKaryawan.remove(k);
            System.out.println("Karyawan berhasil dihapus.");
            return true;
        } else {
            System.out.println("ID tidak ditemukan.");
            return false;
        }
    }

    // Ubah posisi
    public boolean ubahPosisi(String id, String posisiBaru) {
        Karyawan k = cariKaryawanById(id);
        if (k != null) {
            k.setPosisi(posisiBaru);
            System.out.println("Posisi berhasil diubah.");
            return true;
        } else {
            System.out.println("ID tidak ditemukan.");
            return false;
        }
    }

    // Ubah gaji
    public boolean ubahGaji(String id, double gajiBaru) {
        if (gajiBaru < 0) {
            System.out.println("Gaji tidak boleh negatif!");
            return false;
        }
        Karyawan k = cariKaryawanById(id);
        if (k != null) {
            k.setGaji(gajiBaru);
            System.out.println("Gaji berhasil diubah.");
            return true;
        } else {
            System.out.println("ID tidak ditemukan.");
            return false;
        }
    }

    // Cari berdasarkan ID
    public Karyawan cariKaryawanById(String id) {
        for (Karyawan k : daftarKaryawan) {
            if (k.getId().equalsIgnoreCase(id)) {
                return k;
            }
        }
        return null;
    }

    // Tampilkan semua karyawan
    public void tampilkanSemuaKaryawan() {
        if (daftarKaryawan.isEmpty()) {
            System.out.println("Belum ada data karyawan.");
        } else {
            for (Karyawan k : daftarKaryawan) {
                System.out.println(k);
            }
        }
    }

    // Filter berdasarkan posisi
    public void filterBerdasarkanPosisi(String posisi) {
        boolean ditemukan = false;
        for (Karyawan k : daftarKaryawan) {
            if (k.getPosisi().equalsIgnoreCase(posisi)) {
                System.out.println(k);
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Tidak ada karyawan dengan posisi: " + posisi);
        }
    }

    // Cari dan tampilkan karyawan berdasarkan ID
    public void cariDanTampilkanKaryawan(String id) {
        Karyawan k = cariKaryawanById(id);
        if (k != null) {
            System.out.println("Data ditemukan:");
            System.out.println(k);
        } else {
            System.out.println("Karyawan dengan ID tersebut tidak ditemukan.");
        }
    }

    // Total gaji seluruh karyawan
    public void tampilkanTotalGaji() {
        double total = 0;
        for (Karyawan k : daftarKaryawan) {
            total += k.getGaji();
        }
        System.out.println("Total Gaji Semua Karyawan: " + total);
    }
}
