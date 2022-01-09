import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
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
            typeOfStaff = typeOfStaff.replaceAll(" ", "");
            Class c = Class.forName(typeOfStaff);
            Staff p = (Staff) c.getDeclaredConstructor(null).newInstance();
            p.inputStaff();
            this.listStaffs.add(p);
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            System.out.println("Vui long nhap dung loai nhan vien!");
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
        return (ArrayList<Staff>) this.listStaffs.stream().filter(p -> p.getFullName().equalsIgnoreCase(name) == true
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
        for (int i = 0; i < this.listStaffs.size(); i++) {
            System.out.println("=====Nhan vien " + (i+1) + "=====");
            this.listStaffs.get(i).showSingle();
        }
    }

    public List<Staff> getListStaffs() {
        return listStaffs;
    }

    public void setListStaffs(List<Staff> listStaffs) {
        this.listStaffs = listStaffs;
    }
}
