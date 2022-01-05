import java.io.Console;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int choice = 0;
        boolean init = false;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("---- MENU ----");
            System.out.print("1. Quan ly nhan vien\n2. Quan ly du an\n3. Thoat\nBan chon: ");
            choice = sc.nextByte();
            switch (choice) {
                case 1:
                    System.out.println("---- MENU QUAN LY NHAN VIEN ----");
                    break;
                case 2:
                    System.out.println("---- MENU QUAN LY DU AN ----");
                    System.out.println("1. ");
                    break;
                default:
                    System.out.println("Ban chon thoat!");
            }
        } while (choice > 0);
    }
}
