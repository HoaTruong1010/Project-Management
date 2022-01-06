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
            Class c = Class.forName(typeOfStaff);
            Staff p = (Staff) c.getDeclaredConstructor(null).newInstance();
            p.importStaff();
            this.listStaffs.add(p);
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException | ParseException e) {
            e.printStackTrace();
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
        return 0;
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
