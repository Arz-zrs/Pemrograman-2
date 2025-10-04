package PRAK203_2410817210010_AryaArrozzaRidhoSyaputra;

public class Soal3Main {
    public static void main(String[] args) {
        Pegawai p1 = new Pegawai();
        //Pada baris ini terjadi error karena tidak ada titik koma
        //p1.nama = "Roi"
        p1.nama = "Roi";
        p1.asal = "Kingdom of Orvel";
        p1.umur = 17;
        //pemasukkan nilai di atas bukan merupakan best practice
        // karena nilai attribute dapat dimodifikasi secara sembarang
        p1.setJabatan("Assasin");
        System.out.println("Nama Pegawai: " + p1.getNama());
        System.out.println("Asal: " + p1.getAsal());
        System.out.println("Jabatan: " + p1.jabatan);
        //nilai umur dicetak nol jika tidak ada pendefinisian nilai
        System.out.println("Umur: " + p1.umur);
    }
}