import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;

public class StaffManagement {
    private ArrayList<Staff> listStaffs = new ArrayList<>();

    //Hiển thị danh sách
    public void showList() {
        this.listStaffs.forEach(Staff::showSingle);
    }

    //Thêm nhân viên
    public void add(Staff p) {
        this.listStaffs.add(p);
    }

    //Xoá nhân viên
    public void delete(Staff p) {
        this.listStaffs.remove(p);
    }

    //Chỉnh sửa nhân viên
//    public void change(Staff p) {
//
//    }

    //Tìm nhân viên theo phòng ban
    public ArrayList<Staff> findDepartment(String name) {
        return (ArrayList<Staff>) this.listStaffs.stream().filter(p -> p.getDepartment().equals(name) == true).collect(Collectors.toList());
    }

    //Tìm nhân viên theo tên và ngày sinh
    public ArrayList<Staff> findNameAndDate(String name, Date dateOfBirth) {
        return (ArrayList<Staff>) this.listStaffs.stream().filter(p -> p.getFullName().contains(name) == true
                                                || p.getDateOfBirth().compareTo(dateOfBirth) == 0).collect(Collectors.toList());
    }

    public ArrayList<Staff> getListStaffs() {
        return listStaffs;
    }

    public void setListStaffs(ArrayList<Staff> listStaffs) {
        this.listStaffs = listStaffs;
    }
}
