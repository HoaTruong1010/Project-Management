import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class StaffManagement {
    private List<Staff> listStaffs = new ArrayList<>();

    public void add(Staff p) {
        this.listStaffs.add(p);
    }

    public void add(String typeOfStaff){
        try {
            Class c = Class.forName(typeOfStaff);
            Staff p = (Staff) c.getDeclaredConstructor(null).newInstance();
            p.importStaff();
            this.listStaffs.add(p);
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException | ParseException e) {
            e.printStackTrace();
        }
    }

    //Edit nhân viên
    public void edit(Staff p) throws ParseException {
        System.out.println("CAC THONG TIN CO THE CHINH SUA\n" +
                "1. Ho ten\n2. Email\n3. Gioi tinh\n" +
                "4. Ngay sinh\n5. Phong ban\n6. Thoat\nBan chon: ");
        int temp = Integer.parseInt(Staff.scanner.nextLine());
        switch (temp) {
            case 1:
                System.out.println("Sua ho ten nhan vien: ");
                p.setFullName(Staff.scanner.nextLine());
                break;
            case 2:
                System.out.println("Sua email nhan vien: ");
                p.setEmail(Staff.scanner.nextLine());
                break;
            case 3:
                System.out.println("Sua gioi tinh nhan vien: ");
                p.setGender(Staff.scanner.nextLine());
                break;
            case 4:
                System.out.println("Sua ngay sinh nhan vien: ");
                p.setDateOfBirth(Staff.F.parse(Staff.scanner.nextLine()));
                break;
            case 5:
                System.out.println("Sua phong ban nhan vien: ");
                p.getDepartment().setName(Staff.scanner.nextLine());
                break;
            default:
                System.out.println("Ban nhap sai lua chon!\n");
        }
    }

    //Xoá nhân viên
    public void delete(Staff p) {
        this.listStaffs.remove(p);
    }

    //Tìm nhân viên theo phòng ban
    public ArrayList<Staff> findDepartment(String name) {
        return (ArrayList<Staff>) this.listStaffs.stream().filter(p -> p.getDepartment().getName().equalsIgnoreCase(name) == true).collect(Collectors.toList());
    }

    //Tìm nhân viên theo tên và ngày sinh
    public ArrayList<Staff> findNameAndDate(String name, Date dateOfBirth) {
        return (ArrayList<Staff>) this.listStaffs.stream().filter(p -> p.getFullName().contains(name) == true
                                                && p.getDateOfBirth().compareTo(dateOfBirth) == 0).collect(Collectors.toList());
    }

    public int findId(String id) {
        for (int i = 0; i < this.listStaffs.size(); i++) {
            if(this.listStaffs.get(i).getId().equals(id))
                return i;
        }
        return -1;
    }

    public void showList() {
        System.out.println("----DANH SACH NHAN VIEN----");
        this.listStaffs.forEach(p -> p.showSingle());
    }

    public List<Staff> getListStaffs() {
        return listStaffs;
    }

    public void setListStaffs(List<Staff> listStaffs) {
        this.listStaffs = listStaffs;
    }
}
