import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        StaffManagement staffs = new StaffManagement();
        List<Staff> staffFind;
        ProjectManagement projects = new ProjectManagement();
        List<Project> projectsFound;
        Date d;
        int choice, choice2, choice2_5, choice2_8;
        int choice1, choice1_5, choice1_6;
        boolean init = false;
        String idProjects, idStaff, inName;
        int temp, tempStaff;
        do {
            System.out.println("---- MENU ----");
            System.out.println("1. Quan ly nhan vien\n2. Quan ly du an\n3. Thoat\nBan chon: ");
            choice = sc.nextByte();
            switch (choice) {
                case 1:
                    do {
                        System.out.println("---- MENU QUAN LY NHAN VIEN ----");
                        System.out.println("1. Them nhan vien\n2. Xem danh sach nhan vien\n" +
                                "3. Xoa nhan vien\n4. Sua thong tin nhan vien\n" +
                                "5. Tinh luong nhan vien\n6. Tim kiem nhan vien\n" +
                                "7. Xem danh sach du an cua nhan vien can xem\n" +
                                "Thoat\nBan chon: ");
                        choice1 = sc.nextByte();
                        switch (choice1) {
                            case 1:
                                int n = 0;
                                System.out.println("Nhap so luong nhan vien can them: ");
                                do {
                                    n = sc.nextInt();
                                    if (n <= 0) System.out.println("Vui long nhap lai so hop le!");
                                    else {
                                        for (int i = 0; i < n; i++) {
                                            System.out.println("Nhap loai nhan vien can them: ");
                                            staffs.add(sc.nextLine());
                                        }
                                        System.out.println("Da them thanh cong!");
                                    }
                                } while (n <= 0);
                                init = true;
                                break;
                            case 2:
                                if (init)
                                    staffs.showList();
                                else
                                    System.out.println("Danh sach rong! Vui long them nhan vien");
                                break;
                            case 3:
                                if (init) {
                                    System.out.println("Nhap ma nhan vien can xoa: ");
                                    idStaff = sc.nextLine();
                                    tempStaff = staffs.findId(idStaff);
                                    if (tempStaff >= 0) {
                                        staffs.delete(staffs.getListStaffs().get(tempStaff));
                                        System.out.println("Da xoa nhan vien thanh cong!");
                                    }
                                    else
                                        System.out.println("Khong tim thay nhan vien!!");
                                }
                                else
                                    System.out.println("Danh sach rong! Vui long them nhan vien");
                                break;
                            case 4:
                                if (init) {
                                    System.out.println("Nhap ma nhan vien can chinh sua: ");
                                    idStaff = sc.nextLine();
                                    tempStaff = staffs.findId(idStaff);
                                    if (tempStaff >= 0) {
                                        staffs.edit(staffs.getListStaffs().get(tempStaff));
                                        System.out.println("Chinh sua thanh cong!");
                                    }
                                    else
                                        System.out.println("Khong tim thay nhan vien!");
                                }
                                else
                                    System.out.println("Danh sach rong! Vui long them nhan vien");
                                break;
                            case 5:
                                if (init) {
                                    System.out.println("Nhap ma nhan vien can tinh luong: ");
                                    idStaff = sc.nextLine();
                                    tempStaff = staffs.findId(idStaff);
                                    if (tempStaff >= 0) {
                                        staffs.getListStaffs().get(tempStaff).importGrant();
                                        staffs.getListStaffs().get(tempStaff).importFactor();
                                        System.out.println("Luong: ");
                                        staffs.getListStaffs().get(tempStaff).payroll();
                                    }
                                    else
                                        System.out.println("Khong tim thay nhan vien!");
                                }
                                else
                                    System.out.println("Danh sach rong! Vui long them nhan vien");
                                break;
                            case 6:
                                if (init) {
                                    System.out.println("THONG TIN CAN TIM KIEM:");
                                    System.out.println("1. Tim nhan vien theo ho ten, ngay sinh\n" +
                                                        "2. Tim nhan vien theo phong ban\nBan chon: ");
                                    choice1_6 = sc.nextInt();
                                    switch (choice1_6) {
                                        case 1:
                                            System.out.println("Nhap ho ten: ");
                                            inName = sc.nextLine();
                                            System.out.print("Nhap ngay sinh: ");
                                            d = df.parse(sc.nextLine());
                                            staffFind = staffs.findNameAndDate(inName, d);
                                            if (staffFind.size() > 0) {
                                                System.out.println("Danh sach nhan vien:");
                                                staffFind.forEach(p -> p.showSingle());
                                            }
                                            else
                                                System.out.println("Khong tim thay nhan vien!");
                                            break;
                                        case 2:
                                            System.out.println("Nhap phong ban: ");
                                            staffFind = staffs.findDepartment(sc.nextLine());
                                            if (staffFind.size() > 0) {
                                                System.out.println("Danh sach nhan vien:");
                                                staffFind.forEach(p -> p.showSingle());
                                            }
                                            else
                                                System.out.println("Khong tim thay nhan vien!");
                                            break;
                                        default:
                                            System.out.println("Ban nhap sai lua chon!");
                                    }
                                }
                                else
                                    System.out.println("Danh sach rong! Vui long them nhan vien");
                                break;
                            case 7:
                                if (init) {
                                    System.out.println("Nhap ma nhan vien can xem: ");
                                    idStaff = sc.nextLine();
                                    tempStaff = staffs.findId(idStaff);
                                    if (tempStaff >= 0) {
                                        System.out.println("Danh sach du an:");
                                        staffs.getListStaffs().get(tempStaff).getProjects().showList();
                                    }
                                    else
                                        System.out.println("Khong tim thay nhan vien!");
                                }
                                else
                                    System.out.println("Danh sach rong! Vui long them nhan vien");
                                break;
                            default:
                                System.out.println("Ban chon thoat!");
                        }
                    } while (choice1 > 0 && choice1 < 8);
                    break;
                case 2:
                    do {
                        System.out.println("---- MENU QUAN LY DU AN ----");
                        System.out.println("1. Them du an\n2. Xem danh sach du an\n3. Xem danh sach nhan vien cua mot du an\n" +
                                "4. Xoa du an\n5. Sua du an\n6. Tim du an\n7. Sap xep theo kinh phi dau tu\n8. Gan nhan vien cho du an" +
                                "\n9. Thoat");
                        System.out.print("Ban chon: ");
                        choice2 = sc.nextByte();
                        sc.nextLine();
                        switch (choice2) {
                            case 1:
                                projects.add();
                                System.out.println("Them thanh cong!");
                                init = true;
                                break;
                            case 2:
                                if (init)
                                    projects.showList();
                                else
                                    System.out.println("Chua co du an nao!");
                                break;
                            case 3:
                                if (init) {
                                    System.out.print("Nhap ma du an can xem: ");
                                    idProjects = sc.nextLine();
                                    temp = projects.findId(idProjects);
                                    System.out.println("---- KET QUA ----");
                                    if(temp >= 0)
                                        projects.getListProjects().get(temp).getStaffs().showList();
                                    else
                                        System.out.println("KHONG tim thay du an!");
                                }
                                else
                                    System.out.println("Chua co du an nao!");
                                break;
                            case 4:
                                if ( init ) {
                                    System.out.print("Nhap ma du an can xoa: ");
                                    idProjects = sc.nextLine();
                                    temp = projects.findId(idProjects);
                                    System.out.println("---- KET QUA ----");
                                    if ( temp >= 0) {
                                        projects.delete(projects.getListProjects().get(temp));
                                        System.out.println("Xoa thanh cong!");
                                    } else {
                                        System.out.println("Xoa KHONG thanh cong!");
                                    }
                                }
                                else
                                    System.out.println("Chua co du an nao!");
                                break;
                            case 5:
                                if (init) {
                                    System.out.print("Nhap ma du an can sua: ");
                                    idProjects = sc.nextLine();
                                    temp = projects.findId(idProjects);
                                    if(temp >= 0) {
                                        do {
                                            System.out.print("Chon muc can sua:\n1. Sua ten du an\n2. Sua ngay\n3. Sua phi dau tu\n" +
                                                    "4. Xoa nhan vien khoi du an\n5. Thoat\nBan chon:");
                                            choice2_5 = sc.nextByte();
                                            sc.nextLine();
                                            switch (choice2_5) {
                                                case 1:
                                                    System.out.print("- Nhap ten moi: ");
                                                    projects.getListProjects().get(temp).setName(sc.nextLine());
                                                    System.out.println("Sua thanh cong!");
                                                    break;
                                                case 2:
                                                    System.out.print("- Nhap ngay bat dau moi: ");
                                                    projects.getListProjects().get(temp).setStartDate(df.parse(sc.nextLine()));
                                                    System.out.print("- Nhap ngay ket thuc moi: ");
                                                    projects.getListProjects().get(temp).setEndDate(df.parse(sc.nextLine()));
                                                    System.out.println("Sua thanh cong!");
                                                    break;
                                                case 3:
                                                    System.out.print("- Nhap phi dau tu moi: ");
                                                    projects.getListProjects().get(temp).setInvestment(sc.nextDouble());
                                                    sc.nextLine();
                                                    System.out.println("Sua thanh cong!");
                                                    break;
                                                case 4:
                                                    System.out.print("Nhap ma nhan vien can xoa: ");
                                                    idStaff = sc.nextLine();
                                                    tempStaff = projects.getListProjects().get(temp).getStaffs().findId(idStaff);
                                                    if (tempStaff >= 0) {
                                                        projects.getListProjects().get(temp).getStaffs().delete(
                                                                projects.getListProjects().get(temp).getStaffs().getListStaffs().get(tempStaff));
                                                        System.out.println("Xoa thanh cong!");
                                                    } else
                                                        System.out.println("KHONG tim thay nhan vien!");
                                                    break;
                                                default:
                                                    System.out.println("Ban chon thoat!");
                                            }
                                        } while (choice2_5 > 0 && choice2_5 < 5);
                                    }
                                    else
                                        System.out.println("KHONG tim thay du an!");
                                }
                                else
                                    System.out.println("Chua co du an nao!");
                                break;
                            case 6:
                                if(init) {
                                    System.out.print("Nhap ten du an can tim: ");
                                    inName = sc.nextLine();
                                    System.out.print("Nhap ngay bat dau du an: ");
                                    d = df.parse(sc.nextLine());
                                    projectsFound = projects.findNameAndStart(inName, d);
                                    System.out.println("---- KET QUA ----");
                                    if (projectsFound.size() != 0)
                                        projectsFound.forEach(p -> p.showSingle());
                                    else
                                        System.out.println("KHONG tim thay du an!");
                                }
                                else
                                    System.out.println("Chua co du an nao!");
                                break;
                            case 7:
                                if (init) {
                                    projects.sortInvestment();
                                    System.out.println("Sap xep thanh cong!");
                                }
                                else
                                    System.out.println("Chua co du an nao!");
                                break;
                            case 8:
                                if (init) {
                                    System.out.print("Nhap ma du an: ");
                                    idProjects = sc.nextLine();
                                    temp = projects.findId(idProjects);
                                    if(temp >= 0) {
                                        do {
                                            System.out.print("1. Gan nhan vien\n2. Gan nguoi quan ly\n3. Thoat\nBan chon: ");
                                            choice2_8 = sc.nextByte();
                                            sc.nextLine();
                                            switch (choice2_8) {
                                                case 1:
                                                    System.out.print("Nhap ma nhan vien: ");
                                                    idStaff = sc.nextLine();
                                                    break;
                                                case 2:
                                                    break;
                                                default:
                                                    System.out.println("Ban chon thoat!");
                                            }
                                        } while (choice2_8 > 0 && choice2_8 < 3);
                                    }
                                    else
                                        System.out.println("KHONG tim thay du an");
                                }
                                else
                                    System.out.println("Chua co du an nao!");
                                break;
                            default:
                                System.out.println("Ban chon thoat!");
                        }
                    } while (choice2 > 0 && choice2 < 9);
                    break;
                default:
                    System.out.println("Ban chon thoat!");
            }
        } while (choice > 0 && choice < 3);
    }
}
