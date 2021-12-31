import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class StaffManagement {
    private List<Staff> listStaffs = new ArrayList<>();

    public void add(Staff p) {
        this.listStaffs.add(p);
    }

    public void add(String typeOfStaff) throws ClassNotFoundException {
        Class c = Class.forName(typeOfStaff);
        try {
            Staff p = (Staff) c.getDeclaredConstructor(null).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
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
