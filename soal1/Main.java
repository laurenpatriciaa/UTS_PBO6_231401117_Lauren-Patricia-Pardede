package soal1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Perusahaan perusahaan = new Perusahaan();
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n=== MENU MANAJEMEN KARYAWAN ===");
            System.out.println("1. Tambah Karyawan");
            System.out.println("2. Hapus Karyawan");
            System.out.println("3. Ubah Posisi Karyawan");
            System.out.println("4. Ubah Gaji Karyawan");
            System.out.println("5. Tampilkan Semua Karyawan");
            System.out.println("6. Filter Berdasarkan Posisi");
            System.out.println("7. Cari Karyawan Berdasarkan ID");
            System.out.println("8. Laporan Total Gaji Karyawan");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Buang newline

            switch (pilihan) {
                case 1:
                    System.out.print("ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Nama: ");
                    String nama = scanner.nextLine();
                    System.out.print("Posisi: ");
                    String posisi = scanner.nextLine();
                    System.out.print("Gaji: ");
                    double gaji = scanner.nextDouble();
                    scanner.nextLine();
                    perusahaan.tambahKaryawan(new Karyawan(id, nama, posisi, gaji));
                    break;
                case 2:
                    System.out.print("Masukkan ID karyawan yang akan dihapus: ");
                    String idHapus = scanner.nextLine();
                    perusahaan.hapusKaryawan(idHapus);
                    break;
                case 3:
                    System.out.print("Masukkan ID karyawan: ");
                    String idPosisi = scanner.nextLine();
                    System.out.print("Masukkan posisi baru: ");
                    String posisiBaru = scanner.nextLine();
                    perusahaan.ubahPosisi(idPosisi, posisiBaru);
                    break;
                case 4:
                    System.out.print("Masukkan ID karyawan: ");
                    String idGaji = scanner.nextLine();
                    System.out.print("Masukkan gaji baru: ");
                    double gajiBaru = scanner.nextDouble();
                    scanner.nextLine();
                    perusahaan.ubahGaji(idGaji, gajiBaru);
                    break;
                case 5:
                    perusahaan.tampilkanSemuaKaryawan();
                    break;
                case 6:
                    System.out.print("Masukkan posisi yang ingin dicari: ");
                    String posisiCari = scanner.nextLine();
                    perusahaan.filterBerdasarkanPosisi(posisiCari);
                    break;
                case 7:
                    System.out.print("Masukkan ID karyawan yang ingin dicari: ");
                    String idCari = scanner.nextLine();
                    perusahaan.cariDanTampilkanKaryawan(idCari);
                    break;
                case 8:
                    perusahaan.tampilkanTotalGaji();
                    break;
                case 0:
                    System.out.println("Terima kasih telah menggunakan sistem ini.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }

        } while (pilihan != 0);

        scanner.close();
    }
}
