
import java.util.Scanner;

public class meksus {

    public static void Proses1(String name, String roomcode, int classcode, int extra, int duration, String method) {
        String r = room(roomcode);
        String c = classname(classcode);
        int rp = roomPrice(roomcode, classcode, duration);
        extra = duration * 100000;
        int sum = rp + extra;
        int disc = discount(method,sum);
        int newsum = sum - disc;
        
        Output(name,r,c,rp,extra,duration,disc,newsum);
    }

    public static int discount(String method, int sum) {
        int disc = 0;
        if (method.equals("Credit")) {
            disc = (sum * 5) / 100;
        } else {
            disc = 0;
        }
        return disc;
    }

    public static int roomPrice(String roomcode, int classc, int duration) {
        int roomPrice = 0;
        if (roomcode.equals("A")) {
            if (classc == 1) {
                roomPrice = duration * 250000;
            } else {
                roomPrice = duration * 300000;
            }
        } else if (roomcode.equals("B")) {
            if (classc == 1) {
                roomPrice = duration * 400000;
            } else {
                roomPrice = duration * 500000;
            }
        } else if (roomcode.equals("C")) {
            if (classc == 1) {
                roomPrice = duration * 700000;
            } else {
                roomPrice = duration * 850000;
            }
        }
        return roomPrice;
    }

    public static String room(String roomcode) {
        if (roomcode.equals("A")) {
            roomcode = "Standard Room";
        } else if (roomcode.equals("B")) {
            roomcode = "Deluxe room";
        } else {
            roomcode = "Suit room";
        }
        return roomcode;
    }

    public static String classname(int classcode) {
        String classname;
        if (classcode == 1) {
            classname = "Single bed";
        } else {
            classname = "Twin bed";
        }
        return classname;
    }

    public static void Output(String name, String roomname, String classname,int rp, int extra, int duration,int disc, int newsum) {
        System.out.println("HOTEL ARIA");
        System.out.println("********************");
        System.out.println("Nama penyewa         = " + name);
        System.out.println("Nama kamar           = " + roomname);
        System.out.println("Kategori             = " + classname);
        System.out.println("Lama menginap        = " + duration + " hari");
        System.out.println("Biaya sewa           = "+rp);
        System.out.println("Biaya extra bed      = " + extra);
        System.out.println("Diskon               = "+disc);
        System.out.println("Total biaya sewa     = "+newsum);
        System.out.println("*********************************************");
    }

    public static void main(String[] args) {

        String name, roomcode, method;
        int classcode, extra, duration;
        Scanner Mike = new Scanner(System.in);

        System.out.println("*****HOTEL YRIA*****");
        System.out.println("********************");

        System.out.print("Nama penyewa         = ");
        name = Mike.next();

        System.out.print("Kode kamar[A/B/C]    = ");
        roomcode = Mike.next();

        System.out.print("Kode kelas[1/2]      = ");
        classcode = Mike.nextInt();

        System.out.print("Extra bed            = ");
        extra = Mike.nextInt();

        System.out.print("Lama menginap (hari) = ");
        duration = Mike.nextInt();

        System.out.print("Metode pembayaran    = ");
        method = Mike.next();

        System.out.println("********************");

        Proses1(name, roomcode, classcode, extra, duration, method);
    }

}
