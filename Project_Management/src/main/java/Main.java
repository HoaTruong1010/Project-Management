import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args){
        final int MINSTAFF = 5;
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        StaffManagement staffs = new StaffManagement();
        List<Staff> staffFind = new ArrayList<>();
        ProjectManagement projects = new ProjectManagement();
        List<Project> projectsFound = new ArrayList<>();
        Date d, inDate = null;
        int choice = 1, choice2 = 1, choice2_3, choice2_5 = 1, choice2_8 = 1;
        int choice1 = 1, choice1_4 = 1, choose = 1 , choose1 = 1, choice1_6;
        boolean init1 = false, init2 = false,  checkParse;
        String idProjects, idStaff, inName, inTypeStaff = null, inEmail = null;
        int posProject, posStaff = 0, size = 0;
        do {
            try {
                System.out.println("\n---- MENU ----");
                System.out.print("1. Quan ly nhan vien\n2. Quan ly du an\n3. Thoat\nBan chon: ");
                choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        do {
                            try {
                                System.out.println("\n---- MENU QUAN LY NHAN VIEN ----");
                                System.out.print("1. Them nhan vien\n2. Xem danh sach nhan vien\n" +
                                        "3. Xoa nhan vien\n4. Sua thong tin nhan vien\n" +
                                        "5. Tinh luong nhan vien\n6. Tim kiem nhan vien\n" +
                                        "7. Xem danh sach du an cua nhan vien can xem\n" +
                                        "ESC: Nhap so bat ky de thoat\nBan chon: ");
                                choice1 = Integer.parseInt(sc.nextLine());
                                switch (choice1) {
                                    case 1:
                                        int n = 0;
                                        size = staffs.getListStaffs().size();
                                        do {
                                            System.out.print("Nhap so luong nhan vien can them: ");
                                            n = Integer.parseInt(sc.nextLine());
                                            if (n <= 0) System.out.println("Vui long nhap lai so hop le!");
                                            else {
                                                for (int i = 0; i < n; i++) {
                                                    do {
                                                        try {
                                                            System.out.println("Loai nhan vien: 1. Manager\t2. NormalStaff\t3. Designer\t" +
                                                                    "4. Programmer\t5. Tester");
                                                            System.out.print("Chon loai nhan vien thu " + (i + 1) + " can them: ");
                                                            choose = Integer.parseInt(sc.nextLine());
                                                            if (choose < 1 || choose > 5)
                                                                System.out.println("Vui long nhap dung huong dan!");
                                                        } catch (NumberFormatException e) {
                                                            System.out.println("Vui long nhap dung huong dan!");
                                                        }
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
                                                for (Project p : projects.getListProjects()) {
                                                    p.getStaffs().delete(p.getStaffs().getListStaffs().get(p.getStaffs().findId(idStaff)));
                                                }
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
                                                do {
                                                    try {
                                                        System.out.print("\n===CAC THONG TIN CO THE CHINH SUA===\n" +
                                                                "1. Ho ten\n2. Email\n3. Gioi tinh\n" +
                                                                "4. Ngay sinh\n5. Phong ban\n6. Ngay nham chuc quan ly\n" +
                                                                "ESC: Nhap so bat ky de thoat\n\nBan chon: ");
                                                        choice1_4 = Integer.parseInt(sc.nextLine());
                                                        switch (choice1_4) {
                                                            case 1:
                                                                System.out.println("Sua ho ten nhan vien: ");
                                                                staffs.getListStaffs().get(posStaff).setFullName(sc.nextLine());
                                                                break;
                                                            case 2:
                                                                System.out.println("Sua email nhan vien: ");
                                                                do {
                                                                    System.out.print("Nhap email (vd:abc123@mail.com): ");
                                                                    inEmail = Staff.scanner.nextLine();
                                                                    if (!Pattern.compile(Staff.email_pattern).matcher(inEmail).matches())
                                                                        System.out.println("Nhap sai format email! Vui long nhap lai");
                                                                } while (!Pattern.compile(Staff.email_pattern).matcher(inEmail).matches());
                                                                staffs.getListStaffs().get(posStaff).setEmail(inEmail);
                                                                break;
                                                            case 3:
                                                                System.out.println("Sua gioi tinh nhan vien: ");
                                                                do {
                                                                    try {
                                                                        System.out.print("Gioi tinh: 1. Nu\t2. Nam\t3. Khac\nChon gioi tinh: ");
                                                                        choose1 = Integer.parseInt(sc.nextLine());
                                                                        if (choose1 < 1 || choose1 > 3)
                                                                            System.out.println("Vui long nhap dung huong dan!");
                                                                    } catch (NumberFormatException e) {
                                                                        System.out.println("Vui long nhap dung huong dan!");
                                                                    }
                                                                } while (choose1 < 1 || choose1 > 3);
                                                                if (choose1 == 1) staffs.getListStaffs().get(posStaff).setGender("Nu");
                                                                if (choose1 == 2) staffs.getListStaffs().get(posStaff).setGender("Nam");
                                                                if (choose1 == 3) staffs.getListStaffs().get(posStaff).setGender("Khac");
                                                                break;
                                                            case 4:
                                                                System.out.println("Sua ngay sinh nhan vien: ");
                                                                do {
                                                                    try {
                                                                        System.out.printf("Nhap ngay sinh theo format (%s): ", df.toPattern());
                                                                        inDate = df.parse(sc.nextLine());
                                                                    } catch (ParseException ex ) {
                                                                        System.out.println("Nhap sai! Nhap lai!");
                                                                    }
                                                                } while (inDate.getTime() == 0);
                                                                staffs.getListStaffs().get(posStaff).setDateOfBirth(inDate);
                                                                break;
                                                            case 5:
                                                                System.out.println("Sua phong ban nhan vien: ");
                                                                staffs.getListStaffs().get(posStaff).getDepartment().setName(sc.nextLine());
                                                                break;
                                                            case 6:
                                                                System.out.println("Sua ngay nham chuc quan ly: ");
                                                                if (staffs.isManager(posStaff)) {
                                                                    do {
                                                                        try {
                                                                            System.out.printf("Nhap ngay nham chuc theo format (%s): ", Staff.F.toPattern());
                                                                            d = df.parse(sc.nextLine());
                                                                            ((Manager) staffs.getListStaffs().get(posStaff)).setInauguralDay(d);
                                                                            checkParse = true;
                                                                        } catch (ParseException ex ) {
                                                                            checkParse = false;
                                                                            System.out.println("Nhap sai! Nhap lai!");
                                                                        }
                                                                    } while (!checkParse);
                                                                }
                                                                else
                                                                    System.out.println("Nhan vien nay khong phai quan ly! Khong the sua!\n");
                                                                break;
                                                            default:
                                                                System.out.println("Ban chon thoat!\n");
                                                        }
                                                    } catch (NumberFormatException e) {
                                                        System.out.println("Nhap sai!Nhap lai!");
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
                                        if (init1) {
                                            System.out.print("Nhap ma nhan vien can tinh luong: ");
                                            idStaff = sc.nextLine();
                                            posStaff = staffs.findId(idStaff);
                                            if (posStaff >= 0) {
                                                double payroll;
                                                staffs.getListStaffs().get(posStaff).inputFactor();
                                                staffs.getListStaffs().get(posStaff).inputGrant();
                                                payroll = staffs.getListStaffs().get(posStaff).payroll();
                                                System.out.printf("Luong: %.1f VND\n", payroll);
                                            }
                                            else
                                                System.out.println("Khong tim thay nhan vien!");
                                        }
                                        else
                                            System.out.println("Danh sach rong! Vui long them nhan vien");
                                        break;
                                    case 6:
                                        if (init1) {
                                            try {
                                                System.out.println("===THONG TIN CAN TIM KIEM===");
                                                System.out.print("\n1. Tim nhan vien theo ho ten, ngay sinh\n" +
                                                        "2. Tim nhan vien theo phong ban\n" +
                                                        "ESC: Nhap so bat ky de thoat\n\nBan chon: ");
                                                choice1_6 = Integer.parseInt(sc.nextLine());
                                                switch (choice1_6) {
                                                    case 1:
                                                        System.out.print("Nhap ho ten nhan vien can tim: ");
                                                        inName = sc.nextLine();
                                                        do {
                                                            try {
                                                                System.out.print("Nhap ngay sinh nhan vien can tim: ");
                                                                d = df.parse(sc.nextLine());
                                                                staffFind = staffs.findNameAndDate(inName, d);
                                                                checkParse = true;
                                                            } catch (ParseException e) {
                                                                checkParse = false;
                                                                System.out.println("Nhap sai! Nhap lai!");
                                                            }
                                                        } while (!checkParse);
                                                        if (staffFind.size() > 0) {
                                                            System.out.println("Co " + staffFind.size() + " nhan vien duoc tim thay");
                                                            System.out.println("---Danh sach nhan vien---");
                                                            for (int i = 0; i < staffFind.size(); i++) {
                                                                for (Staff p: staffFind) {
                                                                    if (i == 0) {
                                                                        System.out.println("=====Nhan vien=====");
                                                                        p.showSingle();
                                                                    }
                                                                    else {
                                                                        System.out.println("=====Nhan vien " + (i + 1) + "=====");
                                                                        p.showSingle();
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        else
                                                            System.out.println("Khong tim thay nhan vien!");
                                                        break;
                                                    case 2:
                                                        System.out.print("Nhap ten phong ban: ");
                                                        staffFind = staffs.findDepartment(sc.nextLine());
                                                        if (staffFind.size() > 0) {
                                                            System.out.println("Co " + staffFind.size() + " nhan vien duoc tim thay");
                                                            System.out.println("---Danh sach nhan vien---");
                                                            for (int i = 0; i < staffFind.size(); i++) {
                                                                for (Staff p: staffFind) {
                                                                    if (i == 0) {
                                                                        System.out.println("=====Nhan vien=====");
                                                                        p.showSingle();
                                                                    }
                                                                    else {
                                                                        System.out.println("=====Nhan vien " + (i + 1) + "=====");
                                                                        p.showSingle();
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        else
                                                            System.out.println("Khong tim thay nhan vien!");
                                                        break;
                                                    default:
                                                        System.out.println("Ban nhap sai lua chon!");
                                                }
                                            } catch (NumberFormatException e) {
                                                System.out.println("Nhap sai! Nhap lai!");
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
                            } catch (NumberFormatException e) {
                                System.out.println("Nhap sai! Nhap lai!");
                            }
                        } while (choice1 > 0 && choice1 < 8);
                        break;
                    case 2:
                        do {
                            try {
                                System.out.println("\n---- MENU QUAN LY DU AN ----");
                                System.out.println("1. Them du an\n2. Xem danh sach du an\n3. Xem danh sach nhan vien cua mot du an\n" +
                                        "4. Xoa du an\n5. Sua du an\n6. Tim du an\n7. Sap xep theo kinh phi dau tu\n8. Gan nhan vien cho du an" +
                                        "\n9. Thoat");
                                System.out.print("Ban chon: ");
                                choice2 = Integer.parseInt(sc.nextLine());
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
                                                    try {
                                                        System.out.print("\nXem danh sach du an cua mot nhan vien dang thuc hien?\n" +
                                                                "Neu co bam so 1, nguoc lai bam so 0!\nBan chon: ");
                                                        choice2_3 = Integer.parseInt(sc.nextLine());
                                                        while (choice2_3 == 1) {
                                                            System.out.print("Nhap ma nhan vien: ");
                                                            idStaff = sc.nextLine();
                                                            posStaff = projects.getListProjects().get(posProject).getStaffs().findId(idStaff);
                                                            if(posStaff >= 0)
                                                                staffs.getListStaffs().get(posStaff).getProjects().showList();
                                                            else if(projects.getListProjects().get(posProject).getManager().getId() == idStaff) {
                                                                posStaff = staffs.findId(idStaff);
                                                                staffs.getListStaffs().get(posStaff).getProjects().showList();
                                                            }
                                                            else
                                                                System.out.println("KHONG tim thay nhan vien!");
                                                            System.out.print("\nBan co muon tiep tuc?\n" + "Neu co bam so 1, nguoc lai bam so 0!\nBan chon: ");
                                                            choice2_3 = Integer.parseInt(sc.nextLine());
                                                        };
                                                    } catch (NumberFormatException e) {
                                                        System.out.println("Nhap sai! Nhap lai!");
                                                    }
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
                                                for (Staff s : staffs.getListStaffs()) {
                                                    s.getProjects().delete(s.getProjects().getListProjects().get(s.getProjects().findId(idProjects)));
                                                }
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
                                                    try {
                                                        System.out.print("\nChon muc can sua:\n1. Sua ten du an\n2. Sua ngay\n3. Sua phi dau tu\n" +
                                                                "4. Xoa nhan vien khoi du an\n5. Thoat\nBan chon: ");
                                                        choice2_5 = Integer.parseInt(sc.nextLine());
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
                                                                    System.out.println("Sua thanh cong!");
                                                                } catch (ParseException ex) {
                                                                    System.out.println("Sua KHONG thanh cong!");
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
                                                                        staffs.getListStaffs().get(posStaff).getProjects().delete(
                                                                                staffs.getListStaffs().get(posStaff).getProjects().getListProjects().get(posProject));
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
                                                    } catch (NumberFormatException e) {
                                                        System.out.println("Nhap sai! Nhap lai!");
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
                                            do {
                                                try {
                                                    System.out.print("Nhap ngay bat dau du an: ");
                                                    d = df.parse(sc.nextLine());
                                                    projectsFound = projects.findNameAndStart(inName, d);
                                                    checkParse = true;
                                                } catch (ParseException e) {
                                                    checkParse = false;
                                                    System.out.println("Nhap sai! Nhap lai!");
                                                }
                                            } while (!checkParse);
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
                                            if (staffs.getListStaffs().size() > MINSTAFF) {
                                                System.out.print("Nhap ma du an: ");
                                                idProjects = sc.nextLine();
                                                posProject = projects.findId(idProjects);
                                                if (posProject >= 0) {
                                                    do {
                                                        try {
                                                            System.out.print("\n---- MENU GAN NHAN VIEN ----\n" +
                                                                    "1. Gan nhan vien\n2. Gan nguoi quan ly\n3. Thoat\nBan chon: ");
                                                            choice2_8 = Integer.parseInt(sc.nextLine());
                                                            switch (choice2_8) {
                                                                case 1:
                                                                    size = projects.getListProjects().get(posProject).getStaffs().getListStaffs().size();
                                                                    if (size < 10) {
                                                                        System.out.print("Nhap ma nhan vien: ");
                                                                        idStaff = sc.nextLine();
                                                                        posStaff = staffs.findId(idStaff);
                                                                        if (posStaff >= 0) {
                                                                            if (staffs.getListStaffs().get(posStaff).getProjects().getListProjects().size() < 3
                                                                                    && !projects.isLike(posProject, idStaff)) {
                                                                                projects.getListProjects().get(posProject).getStaffs().add(staffs.getListStaffs().get(posStaff));
                                                                                staffs.getListStaffs().get(posStaff).getProjects().getListProjects().add(projects
                                                                                        .getListProjects().get(posProject));
                                                                                size += 1;
                                                                                System.out.println("Them thanh cong!");
                                                                            } else {
                                                                                System.out.println("Them KHONG thanh cong!");
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
                                                                    if (posStaff >= 0) {
                                                                        if (projects.isLikeManager(posProject)) {
                                                                            projects.getListProjects().get(posProject).setManager(staffs.getListStaffs().get(posStaff));
                                                                            System.out.println("Them thanh cong!");
                                                                        }
                                                                        else
                                                                            System.out.println("Nhan vien quan ly phai thuoc danh sach nhan vien cua du an!");
                                                                    } else
                                                                        System.out.println("KHONG tim thay nhan vien!");
                                                                    break;
                                                                default:
                                                                    if (size < MINSTAFF)
                                                                        System.out.println("So luong nhan vien chua dat toi thieu! Hay them nhan vien cho du an!");
                                                                    else if (projects.getListProjects().get(posProject).getManager() == null)
                                                                        System.out.println("Du an chua co NHAN VIEN QUAN LY!");
                                                                    else
                                                                        System.out.println("Ban chon thoat!");
                                                            }
                                                        } catch (NumberFormatException e) {
                                                            System.out.println("Nhap sai! Nhap lai!");
                                                        }
                                                    }
                                                    while (choice2_8 > 0 && choice2_8 < 3 || size < MINSTAFF || projects.getListProjects().get(posProject).getManager() == null);
                                                } else
                                                    System.out.println("KHONG tim thay du an");
                                            }
                                            else
                                                System.out.println("So luong nhan vien chua du de gan cho du an! Hay them nhan vien!");
                                        }
                                        else
                                            System.out.println("Chua co du an nao!");
                                        break;
                                    default:
                                        System.out.println("Ban chon thoat!");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Nhap sai! Nhap lai!");
                            }
                        } while (choice2 > 0 && choice2 < 9);
                        break;
                    default:
                        System.out.println("Ban chon thoat!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Nhap sai! Nhap lai!");
            }
        } while (choice > 0 && choice < 3);
    }
}
