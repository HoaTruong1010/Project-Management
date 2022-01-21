import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Staff> list = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Staff> getList() {
        return list;
    }

    public void setList(List<Staff> list) {
        this.list = list;
    }
}
