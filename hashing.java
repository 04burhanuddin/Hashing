import java.util.Scanner;
class formatBiodata {

    //Deklarasi and type data
    int nim;
    String nama;
    String alamat;
    int umur;
    char jekel;
    float ipk;
}

class hashing {
    public static int N = 0;
    public static int hitungNilaiHash(int nilaiAwal) {
        int hasil;
        hasil = nilaiAwal % 997;
        return (hasil);
    }

    public static void ngentriData(formatBiodata biodataMahasiswa[]) {
        N = 1000;
        int NH;

        Scanner masukan = new Scanner(System.in);
        int bacaTombol = 0;

        System.out.print("SELAMAT DATANG DI PROGRAM GUE\n");
        System.out.println(" ");
        //menentukan banyaknya data yang akan dientri
        System.out.print("Berapa data yang akan dientri ? : ");
        int banyakEntri = masukan.nextInt();

        //entri data mahasiswa
        formatBiodata biodataMahasiswaBaru;
        for (int i = 0; i <= banyakEntri - 1; i++) {
            biodataMahasiswaBaru = new formatBiodata();
            System.out.print("Silakan masukkan NIM anda : ");
            biodataMahasiswaBaru.nim = masukan.nextInt();
            System.out.print("Silakan masukkan nama anda : ");
            biodataMahasiswaBaru.nama = masukan.next();
            System.out.print("Silakan masukkan alamat anda : ");
            biodataMahasiswaBaru.alamat = masukan.next();
            System.out.print("Silakan masukkan umur anda : ");
            biodataMahasiswaBaru.umur = masukan.nextInt();
            System.out.print("Silakan masukkan Jenis Kelamin anda : ");
            try {
                bacaTombol = System.in.read();
            } catch (java.io.IOException e) {
            }
            biodataMahasiswaBaru.jekel = (char) bacaTombol;
            System.out.print("Silakan masukkan IPK anda : ");
            biodataMahasiswaBaru.ipk = masukan.nextFloat();

            //Add data ke larik baru sesuai dengan posisi hashing
            NH = hitungNilaiHash(biodataMahasiswaBaru.nim);
            System.out.println("Biodata " + biodataMahasiswaBaru.nama + " akan ditempatkan pada larik ke : " + NH);
            biodataMahasiswa[NH] = biodataMahasiswaBaru;
        }
    }

    public static void berhentiSebentar() {
        System.out.println("");
        System.out.println("Tekan tombol ENTER untuk melanjutkan...");
        Scanner masukan = new Scanner(System.in);
        int bacaTombol;
        do {
            bacaTombol = 0;
            try {
                bacaTombol = System.in.read();
            } catch (java.io.IOException e) {
            }
        } while (bacaTombol != 13);
    }

    public static void tampilkanData(formatBiodata biodataMahasiswa[]) {
        //bagian menampilkan isi struktur Larik
        System.out.println("-------------------------------------------------------");
        System.out.println("NO NAMA           ALAMAT          UMUR    JEKEL   IPK  ");
        System.out.println("-------------------------------------------------------");
        for (int i = 0; i <= N - 1; i++) {
            System.out.print(i + "  ");
            System.out.print(biodataMahasiswa[i].nama + "\t  ");
            System.out.print(biodataMahasiswa[i].alamat + "\t  ");
            System.out.print(biodataMahasiswa[i].umur + "\t  ");
            System.out.print(biodataMahasiswa[i].jekel + "\t  ");
            System.out.println(biodataMahasiswa[i].ipk);
            if (i % 100 == 0) {
                berhentiSebentar();
            }
        }
        System.out.println("-------------------------------------------------------");
    }

    public static void main(String[] args) {
        //deklarasi record berbasis LARIK
        formatBiodata biodataMahasiswa[] = new formatBiodata[1000];
        for (int i = 0; i <= 999; i++) {
            biodataMahasiswa[i] = new formatBiodata();
        }

        //pemanggilan fungsi-fungsi
        ngentriData(biodataMahasiswa);
        tampilkanData(biodataMahasiswa);
    }
}