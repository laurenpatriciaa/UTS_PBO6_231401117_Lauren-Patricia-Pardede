package soal2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Kendaraan> daftar = new ArrayList<>();

        System.out.println("======= Selamat Datang di ParkingChan =======");

        String lanjut = "y";

        do {
            System.out.print("\nMasukkan jenis kendaraan (Motor/Mobil/Truk) : ");
            String jenis = input.nextLine();

            System.out.print("Masukkan durasi (Manual/Waktu) : ");
            String metode = input.nextLine();

            Kendaraan kendaraan = new Kendaraan(jenis);
            if (metode.equalsIgnoreCase("Manual")) {
                System.out.print("Masukkan durasi (dalam jam) : ");
                int jam = Integer.parseInt(input.nextLine());
                kendaraan.hitungBiayaParkir(jam);
            } else if (metode.equalsIgnoreCase("Waktu")) {
                System.out.print("Masukkan jam masuk  : ");
                int masuk = Integer.parseInt(input.nextLine());
                System.out.print("Masukkan jam keluar : ");
                int keluar = Integer.parseInt(input.nextLine());
                kendaraan.hitungBiayaParkir(masuk, keluar);
            } else {
                System.out.println("Metode tidak valid, data tidak diproses.");
                continue;
            }

            kendaraan.tampilRingkasan();
            daftar.add(kendaraan);

            System.out.print("\nTambah kendaraan lagi? (y/n): ");
            lanjut = input.nextLine();

        } while (lanjut.equalsIgnoreCase("y"));

        int totalBiaya = 0;
        for (Kendaraan k : daftar) {
            totalBiaya += k.getBiaya();
        }

        System.out.println("\n======= RINGKASAN AKHIR =======");
        System.out.println("Total Kendaraan     : " + daftar.size());
        System.out.println("Total Biaya Parkir  : Rp" + totalBiaya + ".0");
        System.out.println("Terima kasih.....");
    }
}
