package factory;

import implement.imp_anggota;
import implement.imp_buku;
import implement.imp_peminjaman;
import implement.imp_peminjaman_detail;
import interfaces.int_anggota;
import interfaces.int_buku;
import interfaces.int_peminjaman;
import interfaces.int_peminjaman_detail;

public class factory {

    private static int_buku bukuDAO;
    private static int_anggota anggotaDAO;
    private static int_peminjaman peminjamanDAO;
    private static int_peminjaman_detail peminjamanDetailDAO;

    public static int_buku getBukuDA0() {
        bukuDAO = new imp_buku();
        return bukuDAO;
    }
    
    public static int_anggota getAnggotaDA0() {
        anggotaDAO = new imp_anggota();
        return anggotaDAO;
    }
    
    public static int_peminjaman getPeminjamanDA0() {
        peminjamanDAO = new imp_peminjaman();
        return peminjamanDAO;
    }
    
    public static int_peminjaman_detail getPeminjamanDetailDA0() {
        peminjamanDetailDAO = new imp_peminjaman_detail();
        return peminjamanDetailDAO;
    }
    

}
