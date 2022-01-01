import java.util.ArrayList;
import java.util.Date;

public class StaffManagement {
    private ArrayList<Staff> listStaffs = new ArrayList<>();

    //Hiển thị danh sách
    public void showList() {
        this.getListStaffs().forEach(Staff::showSingle);
    }

    //Thêm nhân viên
    public void add(Staff p) {
        this.getListStaffs().add(p);
    }

    //Xoá nhân viên
    public void delete(Staff p) {

    }

    //Thay đổi nhân viên
    public void change(Staff p) {

    }

    //Tìm phòng ban
    public ArrayList<Staff> findDepartment(String name) {
        return null; //x
    }

    //Tìm nhân viên theo tên và ngày sinh
    public ArrayList<Staff> findNameAndDate(String name, Date dateOfBirth) {
        return null; //x
    }

    public ArrayList<Staff> getListStaffs() {
        return listStaffs;
    }

    public void setListStaffs(ArrayList<Staff> listStaffs) {
        this.listStaffs = listStaffs;
    }
}
