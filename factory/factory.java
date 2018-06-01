package factory;

import implement.imp_anggota;
import implement.imp_buku;
import interfaces.int_anggota;
import interfaces.int_buku;

public class factory {

    private static int_buku bukuDAO;
    private static int_anggota anggotaDAO;

    public static int_buku getBukuDA0() {
        bukuDAO = new imp_buku();
        return bukuDAO;
    }
    
    public static int_anggota getAnggotaDA0() {
        anggotaDAO = new imp_anggota();
        return anggotaDAO;
    }
    

}
