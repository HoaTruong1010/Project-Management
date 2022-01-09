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
        int choice1, choice1_6;
        boolean init1 = false, init2 = false;
        String idProjects, idStaff, inName;
        int posProject, posStaff, size = 0;
        do {
            System.out.println("\n---- MENU ----");
            System.out.print("1. Quan ly nhan vien\n2. Quan ly du an\n3. Thoat\nBan chon: ");
            choice = sc.nextByte();
            sc.nextLine();
            switch (choice) {
                case 1:
                    do {
                        System.out.println("\n---- MENU QUAN LY NHAN VIEN ----");
                        System.out.print("1. Them nhan vien\n2. Xem danh sach nhan vien\n" +
                                "3. Xoa nhan vien\n4. Sua thong tin nhan vien\n" +
                                "5. Tinh luong nhan vien\n6. Tim kiem nhan vien\n" +
                                "7. Xem danh sach du an cua nhan vien can xem\n" +
                                "8. Thoat\nBan chon: ");
                        choice1 = sc.nextByte();
                        sc.nextLine();
                        switch (choice1) {
                            case 1:
                                int n = 0;
                                size = staffs.getListStaffs().size();
                                do {
                                    System.out.print("Nhap so luong nhan vien can them: ");
                                    n = sc.nextInt();
                                    sc.nextLine();
                                    if (n <= 0) System.out.println("Vui long nhap lai so hop le!");
                                    else {
                                        for (int i = 0; i < n; i++) {
                                            System.out.print("Nhap loai nhan vien thu " + (i + 1) + " can them.\n" +
                                                    "(Goi y: NormalStaff, Designer, Programmer, Tester, Manager)\nBan chon: ");
                                            staffs.add(sc.nextLine());
                                            if (staffs.getListStaffs().size() > size)
                                                System.out.println("Da them thanh cong!");
                                            else
                                                System.out.println("Them KHONG thanh cong!");
                                        }
                                    }
                                } while (n <= 0);
                                init1 = true;
                                break;
                            case 2:
                                if (init1)
                                    staffs.showList();
                                else
                                    System.out.println("Danh sach rong! Vui long them nhan vien");
                                break;
                            case 3:
                                if (init1) {
                                    System.out.print("Nhap ma nhan vien can xoa: ");
                                    idStaff = sc.nextLine();
                                    posStaff = staffs.findId(idStaff);
                                    if (posStaff >= 0) {
                                        staffs.delete(staffs.getListStaffs().get(posStaff));
                                        System.out.println("Da xoa nhan vien thanh cong!");
                                        if (projects.getListProjects().size() == 0)
                                            init1 = false;
                                    }
                                    else
                                        System.out.println("Khong tim thay nhan vien!!");
                                }
                                else
                                    System.out.println("Danh sach rong! Vui long them nhan vien");
                                break;
                            case 4:
                                if (init1) {
                                    System.out.print("Nhap ma nhan vien can chinh sua: ");
                                    idStaff = sc.nextLine();
                                    posStaff = staffs.findId(idStaff);
                                    if (posStaff >= 0) {
                                        staffs.edit(staffs.getListStaffs().get(posStaff));
                                        System.out.println("Chinh sua thanh cong!");
                                    }
                                    else
                                        System.out.println("Khong tim thay nhan vien!");
                                }
                                else
                                    System.out.println("Danh sach rong! Vui long them nhan vien");
                                break;
                            case 5:
                                if (init1) {
                                    System.out.print("Nhap ma nhan vien can tinh luong: ");
                                    idStaff = sc.nextLine();
                                    posStaff = staffs.findId(idStaff);
                                    if (posStaff >= 0) {
                                        double payroll;
                                        staffs.getListStaffs().get(posStaff).inputFactor();
                                        staffs.getListStaffs().get(posStaff).inputGrant();
                                        payroll = staffs.getListStaffs().get(posStaff).payroll();
                                        System.out.printf("Luong: %.1f\n", payroll);
                                    }
                                    else
                                        System.out.println("Khong tim thay nhan vien!");
                                }
                                else
                                    System.out.println("Danh sach rong! Vui long them nhan vien");
                                break;
                            case 6:
                                if (init1) {
                                    System.out.println("THONG TIN CAN TIM KIEM:");
                                    System.out.print("1. Tim nhan vien theo ho ten, ngay sinh\n" +
                                                        "2. Tim nhan vien theo phong ban\nBan chon: ");
                                    choice1_6 = sc.nextInt();
                                    sc.nextLine();
                                    switch (choice1_6) {
                                        case 1:
                                            System.out.print("Nhap ho ten: ");
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
                                            System.out.print("Nhap phong ban: ");
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
                                if (init1) {
                                    System.out.print("Nhap ma nhan vien can xem: ");
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
                        System.out.println("\n---- MENU QUAN LY DU AN ----");
                        System.out.println("1. Them du an\n2. Xem danh sach du an\n3. Xem danh sach nhan vien cua mot du an\n" +
                                "4. Xoa du an\n5. Sua du an\n6. Tim du an\n7. Sap xep theo kinh phi dau tu\n8. Gan nhan vien cho du an" +
                                "\n9. Thoat");
                        System.out.print("Ban chon: ");
                        choice2 = sc.nextByte();
                        sc.nextLine();
                        switch (choice2) {
                            case 1:
                                size = projects.getListProjects().size();
                                projects.add();
                                if(projects.getListProjects().size() > size)
                                    System.out.println("Them thanh cong!");
                                else
                                    System.out.println("Them KHONG thanh cong!");
                                init2 = true;
                                break;
                            case 2:
                                if (init2)
                                    projects.showList();
                                else
                                    System.out.println("Chua co du an nao!");
                                break;
                            case 3:
                                if (init2) {
                                    System.out.print("Nhap ma du an can xem: ");
                                    idProjects = sc.nextLine();
                                    posProject = projects.findId(idProjects);
                                    System.out.println("---- KET QUA ----");
                                    if(posProject >= 0) {
                                        size = projects.getListProjects().get(posProject).getStaffs().getListStaffs().size();
                                        if (size > 0) {
                                            projects.getListProjects().get(posProject).getStaffs().showList();
                                            System.out.print("Xem danh sach du an cua mot nhan vien dang thuc hien?\n" +
                                                    "Neu co bam so 1, nguoc lai bam so 0!\nBan chon: ");
                                            choice2_3 = sc.nextByte();
                                            sc.nextLine();
                                            while (choice2_3 == 1) {
                                                System.out.print("Nhap ma nhan vien: ");
                                                idStaff = sc.nextLine();
                                                posStaff = projects.getListProjects().get(posProject).getStaffs().findId(idStaff);
                                                if(posStaff >= 0)
                                                    staffs.getListStaffs().get(posStaff).getProjects().showList();
                                                else
                                                    System.out.println("KHONG tim thay nhan vien!");
                                                System.out.print("Ban co muon tiep tuc?\n" + "Neu co bam so 1, nguoc lai bam so 0!\nBan chon: ");
                                                choice2_3 = sc.nextByte();
                                                sc.nextLine();
                                            };
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
                                if (init2) {
                                    System.out.print("Nhap ma du an can xoa: ");
                                    idProjects = sc.nextLine();
                                    posProject = projects.findId(idProjects);
                                    System.out.println("---- KET QUA ----");
                                    if (posProject >= 0) {
                                        projects.delete(projects.getListProjects().get(posProject));
                                        System.out.println("Xoa thanh cong!");
                                        if (projects.getListProjects().size() == 0)
                                            init2 = false;
                                    }
                                    else
                                        System.out.println("Xoa KHONG thanh cong!");
                                }
                                else
                                    System.out.println("Chua co du an nao!");
                                break;
                            case 5:
                                if (init2) {
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
                                                    try {
                                                        System.out.printf("- Nhap ngay bat dau moi (%s): ", Project.F.toPattern());
                                                        projects.getListProjects().get(posProject).setStartDate(df.parse(sc.nextLine()));
                                                        System.out.printf("- Nhap ngay ket thuc moi (%s): ", Project.F.toPattern());
                                                        projects.getListProjects().get(posProject).setEndDate(df.parse(sc.nextLine()));
                                                    } catch (ParseException ex) {
                                                        System.out.println("Sua KHONG thanh cong!");
                                                    } finally {
                                                        System.out.println("Sua thanh cong!");
                                                    }
                                                    break;
                                                case 3:
                                                    do {
                                                        System.out.print("- Nhap phi dau tu moi: ");
                                                        projects.getListProjects().get(posProject).setInvestment(sc.nextDouble());
                                                        sc.nextLine();
                                                        if (projects.getListProjects().get(posProject).getInvestment() <= 0)
                                                            System.out.println("Nhap sai! Nhap lai!");
                                                    }
                                                    while (projects.getListProjects().get(posProject).getInvestment() <= 0);
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
                                if(init2) {
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
                                if (init2) {
                                    projects.sortInvestment();
                                    System.out.println("Sap xep thanh cong!");
                                }
                                else
                                    System.out.println("Chua co du an nao!");
                                break;
                            case 8:
                                if (init2) {
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
                                                            if (staffs.getListStaffs().get(posStaff).getProjects().getListProjects().size() < 3) {
                                                                projects.getListProjects().get(posProject).getStaffs().add(staffs.getListStaffs().get(posStaff));
                                                                staffs.getListStaffs().get(posStaff).getProjects().getListProjects().add(projects
                                                                        .getListProjects().get(posProject));
                                                                System.out.println("Them thanh cong!");
                                                            } else {
                                                                System.out.println("Nhan vien da lam toi da 3 du an!");
                                                            }
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
                                                    if (size < 4)
                                                        System.out.println("So luong nhan vien chua dat toi thieu! Hay them nhan vien!");
                                                    else
                                                        System.out.println("Ban chon thoat!");
                                            }
                                        } while (choice2_8 > 0 && choice2_8 < 3 || size < 4);
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
