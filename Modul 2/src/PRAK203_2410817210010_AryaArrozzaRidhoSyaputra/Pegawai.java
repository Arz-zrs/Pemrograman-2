package PRAK203_2410817210010_AryaArrozzaRidhoSyaputra;

//terdapat error karena nama class tidak sesuai nama file
// public class Employees {
public class Pegawai {
    public String nama;
    //terdapat error pada Soal3Main karena nilai yang dimassukan berupa String
    //public char asal;
    public String asal;
    public String jabatan;
    public int umur;
    //pendefinisian attribute di atas bukan merupakan best practice,
    //seharusnya didefinisikan dengan accessor private

    public String getNama() {
        return nama;
    }

    public String getAsal() {
        return asal;
    }

    //pada method ini terdapat error karena method setter tidak ada parameter
    //public void setJabatan() {
    public void setJabatan(String j) {
        this.jabatan = j;
    }
    //penggunaan setter dengan attribute public kurang efisien
}