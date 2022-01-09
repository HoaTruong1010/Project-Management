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
        int choice, choice2, choice2_3, choice2_5, choice2_8;
        int choice1, choice1_4, choose, choice1_6;
        boolean init = false;
        String idProjects, idStaff, inName, inTypeStaff = null;
        int posProject, posStaff, size = 0;
        do {
            System.out.println("---- MENU ----");
            System.out.print("1. Quan ly nhan vien\n2. Quan ly du an\n3. Thoat\nBan chon: ");
            choice = sc.nextByte();
            sc.nextLine();
            switch (choice) {
                case 1:
                    do {
                        System.out.println("---- MENU QUAN LY NHAN VIEN ----");
                        System.out.print("1. Them nhan vien\n2. Xem danh sach nhan vien\n" +
                                "3. Xoa nhan vien\n4. Sua thong tin nhan vien\n" +
                                "5. Tinh luong nhan vien\n6. Tim kiem nhan vien\n" +
                                "7. Xem danh sach du an cua nhan vien can xem\n" +
                                "ESC: Nhap phim bat ky de thoat\n\nBan chon: ");
                        choice1 = sc.nextByte();
                        sc.nextLine();
                        switch (choice1) {
                            case 1:
                                int n = 0;
                                System.out.print("Nhap so luong nhan vien can them: ");
                                do {
                                    n = sc.nextInt();
                                    sc.nextLine();
                                    if (n <= 0) System.out.println("Vui long nhap lai so hop le!");
                                    else {
                                        for (int i = 0; i < n; i++) {
                                            do {
                                                System.out.println("Loai nhan vien:\n1. Manager\t2. NormalStaff\t3. Designer\t" +
                                                        "4. Programmer\t5. Tester");
                                                System.out.print("Chon loai nhan vien thu " + (i + 1) + " can them: ");
                                                choose = sc.nextInt();
                                                if (choose < 1 || choose > 5)
                                                    System.out.println("Vui long nhap dung huong dan!");
                                            } while (choose < 1 || choose > 5);
                                            if (choose == 1) inTypeStaff = "Manager";
                                            if (choose == 2) inTypeStaff = "NormalStaff";
                                            if (choose == 3) inTypeStaff = "Designer";
                                            if (choose == 4) inTypeStaff = "Programmer";
                                            if (choose == 5) inTypeStaff = "Tester";
                                            staffs.add(inTypeStaff);
                                        }
                                        System.out.println("Da them thanh cong!");
                                    }
                                } while (n <= 0);
                                init = true;
                                break;
                            case 2:
                                if (init && (staffs.getListStaffs().size() != 0))
                                    staffs.showList();
                                else
                                    System.out.println("Danh sach rong! Vui long them nhan vien");
                                break;
                            case 3:
                                if (init) {
                                    System.out.println("Nhap ma nhan vien can xoa: ");
                                    idStaff = sc.nextLine();
                                    posStaff = staffs.findId(idStaff);
                                    if (posStaff >= 0) {
                                        staffs.delete(staffs.getListStaffs().get(posStaff));
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
                                    posStaff = staffs.findId(idStaff);
                                    if (posStaff >= 0) {
                                        do {
                                            System.out.println("CAC THONG TIN CO THE CHINH SUA\n" +
                                                    "1. Ho ten\n2. Email\n3. Gioi tinh\n" +
                                                    "4. Ngay sinh\n5. Phong ban\n6. Ngay nham chuc quan ly" +
                                                    "ESC: Nhap phim bat ky de thoat\n\nBan chon: ");
                                            choice1_4 = sc.nextInt();
                                            sc.nextLine();
                                            switch (choice1_4) {
                                                case 1:
                                                    System.out.println("Sua ho ten nhan vien: ");
                                                    staffs.getListStaffs().get(posStaff).setFullName(sc.nextLine());
                                                    break;
                                                case 2:
                                                    System.out.println("Sua email nhan vien: ");
                                                    staffs.getListStaffs().get(posStaff).setEmail(sc.nextLine());
                                                    break;
                                                case 3:
                                                    System.out.println("Sua gioi tinh nhan vien: ");
                                                    staffs.getListStaffs().get(posStaff).setGender(sc.nextLine());
                                                    break;
                                                case 4:
                                                    System.out.println("Sua ngay sinh nhan vien: ");
                                                    staffs.getListStaffs().get(posStaff).setDateOfBirth(Staff.F.parse(sc.nextLine()));
                                                    break;
                                                case 5:
                                                    System.out.println("Sua phong ban nhan vien: ");
                                                    staffs.getListStaffs().get(posStaff).getDepartment().setName(sc.nextLine());
                                                    break;
                                                case 6:
                                                    System.out.println("Sua ngay nham chuc quan ly: ");
                                                    if (staffs.getListStaffs().get(posStaff).getClass().getSimpleName().equals("Manager") == true) {
                                                        //staffs.getListStaffs().get(posStaff).
                                                        System.out.println("Chua cap nhat case nay!");
                                                    }
                                                    else
                                                        System.out.println("Nhan vien này khong phai quan ly! Khong the sua!\n");
                                                    break;
                                                default:
                                                    System.out.println("Ban chon thoat!\n");
                                            }
                                        } while (choice1_4 > 0 && choice1_4 < 7);
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
                                    posStaff = staffs.findId(idStaff);
                                    if (posStaff >= 0) {
                                        double payroll;
                                        staffs.getListStaffs().get(posStaff).inputFactor();
                                        staffs.getListStaffs().get(posStaff).inputGrant();
                                        payroll = staffs.getListStaffs().get(posStaff).payroll();
                                        System.out.printf("Luong: %.1f " + "VND\n", payroll);
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
                                                        "2. Tim nhan vien theo phong ban\n" +
                                                        "ESC: Nhap phim bat ky de thoat\n\nBan chon: ");
                                    choice1_6 = sc.nextInt();
                                    sc.nextLine();
                                    switch (choice1_6) {
                                        case 1:
                                            System.out.println("Nhap ho ten: ");
                                            inName = sc.nextLine();
                                            System.out.print("Nhap ngay sinh: ");
                                            d = df.parse(sc.nextLine());
                                            staffFind = staffs.findNameAndDate(inName, d);
                                            if (staffFind.size() > 0) {
                                                System.out.println("Co " + staffFind.size() + " nhan vien duoc tim thay");
                                                System.out.println("---Danh sach nhan vien---");
                                                for (int i = 0; i < staffFind.size(); i++) {
                                                    for (Staff p: staffFind) {
                                                        System.out.println("=====Nhan vien " + (i+1) + "=====");
                                                        p.showSingle();
                                                    }
                                                }
//                                                staffFind.forEach(p -> p.showSingle());
                                            }
                                            else
                                                System.out.println("Khong tim thay nhan vien!");
                                            break;
                                        case 2:
                                            System.out.println("Nhap phong ban: ");
                                            staffFind = staffs.findDepartment(sc.nextLine());
                                            if (staffFind.size() > 0) {
                                                System.out.println("Co " + staffFind.size() + " nhan vien duoc tim thay");
                                                System.out.println("---Danh sach nhan vien---");
                                                for (int i = 0; i < staffFind.size(); i++) {
                                                    for (Staff p: staffFind) {
                                                        System.out.println("=====Nhan vien " + (i+1) + "=====");
                                                        p.showSingle();
                                                    }
                                                }
//                                                staffFind.forEach(p -> p.showSingle());
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
                                    posStaff = staffs.findId(idStaff);
                                    if (posStaff >= 0) {
                                        staffs.getListStaffs().get(posStaff).getProjects().showList();
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
                                size = projects.getListProjects().size();
                                if (init && size > 0)
                                    projects.showList();
                                else
                                    System.out.println("Chua co du an nao!");
                                break;
                            case 3:
                                if (init) {
                                    System.out.print("Nhap ma du an can xem: ");
                                    idProjects = sc.nextLine();
                                    posProject = projects.findId(idProjects);
                                    System.out.println("---- KET QUA ----");
                                    if(posProject >= 0) {
                                        size = projects.getListProjects().get(posProject).getStaffs().getListStaffs().size();
                                        if (size > 0) {
                                            projects.getListProjects().get(posProject).getStaffs().showList();
                                            System.out.println("Xem danh sach du an cua mot nhan vien dang thuc hien?\n" +
                                                    "Neu co bam so 1, nguoc lai bam so 0!\n");
                                            choice2_3 = sc.nextByte();
                                            sc.nextLine();
                                            if(choice2_3 == 1) {
                                                do {
                                                    System.out.print("Nhap ma nhan vien: ");
                                                    idStaff = sc.nextLine();
                                                    posStaff = projects.getListProjects().get(posProject).getStaffs().findId(idStaff);
                                                    if(posStaff >= 0) {
                                                        size = staffs.getListStaffs().get(posStaff).getProjects().getListProjects().size();
                                                        if(size > 0)
                                                            staffs.getListStaffs().get(posStaff).getProjects().showList();
                                                        else
                                                            System.out.println("Nhan vien khong thuc hien du an nao!");
                                                    } else
                                                        System.out.println("KHONG tim thay nhan vien!");
                                                    System.out.println("Ban co muon tiep tuc?\n" + "Neu co bam so 1, nguoc lai bam so 0!\n");
                                                    choice2_3 = sc.nextByte();
                                                    sc.nextLine();
                                                } while (choice2_3 == 1);
                                            } else
                                                System.out.println("Ban chon khong!");
                                        }
                                        else
                                            System.out.println("Du an chua co nhan vien!");
                                    }
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
                                    posProject = projects.findId(idProjects);
                                    System.out.println("---- KET QUA ----");
                                    if ( posProject >= 0) {
                                        projects.delete(projects.getListProjects().get(posProject));
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
                                    posProject = projects.findId(idProjects);
                                    if(posProject >= 0) {
                                        do {
                                            System.out.print("Chon muc can sua:\n1. Sua ten du an\n2. Sua ngay\n3. Sua phi dau tu\n" +
                                                    "4. Xoa nhan vien khoi du an\n5. Thoat\nBan chon:");
                                            choice2_5 = sc.nextByte();
                                            sc.nextLine();
                                            switch (choice2_5) {
                                                case 1:
                                                    System.out.print("- Nhap ten moi: ");
                                                    projects.getListProjects().get(posProject).setName(sc.nextLine());
                                                    System.out.println("Sua thanh cong!");
                                                    break;
                                                case 2:
                                                    System.out.print("- Nhap ngay bat dau moi: ");
                                                    projects.getListProjects().get(posProject).setStartDate(df.parse(sc.nextLine()));
                                                    System.out.print("- Nhap ngay ket thuc moi: ");
                                                    projects.getListProjects().get(posProject).setEndDate(df.parse(sc.nextLine()));
                                                    System.out.println("Sua thanh cong!");
                                                    break;
                                                case 3:
                                                    System.out.print("- Nhap phi dau tu moi: ");
                                                    projects.getListProjects().get(posProject).setInvestment(sc.nextDouble());
                                                    sc.nextLine();
                                                    System.out.println("Sua thanh cong!");
                                                    break;
                                                case 4:
                                                    if(projects.getListProjects().get(posProject).getStaffs().getListStaffs().size() > 5) {
                                                        System.out.print("Nhap ma nhan vien can xoa: ");
                                                        idStaff = sc.nextLine();
                                                        posStaff = projects.getListProjects().get(posProject).getStaffs().findId(idStaff);
                                                        if (posStaff >= 0) {
                                                            projects.getListProjects().get(posProject).getStaffs().delete(
                                                                    projects.getListProjects().get(posProject).getStaffs().getListStaffs().get(posProject));
                                                            System.out.println("Xoa thanh cong!");
                                                        } else
                                                            System.out.println("KHONG tim thay nhan vien!");
                                                    }
                                                    else
                                                        System.out.println("So luong nhan vien da dat muc toi thieu!");
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
                                    if (projectsFound.size() > 0)
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
                                    posProject = projects.findId(idProjects);
                                    if(posProject >= 0) {
                                        do {
                                            System.out.print("1. Gan nhan vien\n2. Gan nguoi quan ly\n3. Thoat\nBan chon: ");
                                            choice2_8 = sc.nextByte();
                                            sc.nextLine();
                                            switch (choice2_8) {
                                                case 1:
                                                    size = projects.getListProjects().get(posProject).getStaffs().getListStaffs().size();
                                                    if(size < 10) {
                                                        System.out.print("Nhap ma nhan vien: ");
                                                        idStaff = sc.nextLine();
                                                        posStaff = staffs.findId(idStaff);
                                                        if(posStaff >= 0) {
                                                            projects.getListProjects().get(posProject).getStaffs().add(staffs.getListStaffs().get(posStaff));
                                                            System.out.println("Them thanh cong!");
                                                        } else
                                                            System.out.println("KHONG tim thay nhan vien!");
                                                    } else
                                                        System.out.println("So luong nhan vien da dat toi da");
                                                    break;
                                                case 2:
                                                    System.out.print("Nhap ma nhan vien: ");
                                                    idStaff = sc.nextLine();
                                                    posStaff = staffs.findId(idStaff);
                                                    if(posStaff >= 0) {
                                                        projects.getListProjects().get(posProject).setManager(staffs.getListStaffs().get(posStaff));
                                                        if(projects.getListProjects().get(posProject).getManager() != null)
                                                            System.out.println("Them thanh cong!");
                                                        else
                                                            System.out.println("Them khong thanh cong!");
                                                    } else
                                                        System.out.println("KHONG tim thay nhan vien!");
                                                    break;
                                                default:
                                                    if (size < 5)
                                                        System.out.println("So luong nhan vien chua dat toi thieu! Hay them nhan vien!");
                                                    else
                                                        System.out.println("Ban chon thoat!");
                                            }
                                        } while (choice2_8 > 0 && choice2_8 < 3 || size < 5);
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
