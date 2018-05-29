package factory;

import implement.imp_buku;
import interfaces.int_buku;

public class factory {
    private static int_buku bukuDAO;
        
        public static int_buku getBukuDA0(){
            bukuDAO = new imp_buku();
            return bukuDAO;
        }
}
