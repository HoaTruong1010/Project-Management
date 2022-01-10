import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ProjectManagement {
    private static final SimpleDateFormat F = new SimpleDateFormat("dd/MM/yyyy");
    private List<Project> listProjects = new ArrayList();

    public void add(Project x) {
        this.listProjects.add(x);
    }

    public void add(){
        Project x = new Project();
        System.out.println("Nhap du an so: " + x.getId());
        x.inputProject();
        this.listProjects.add(x);
    }

    public void delete (Project x) {
        this.listProjects.remove(x);
    }

    public void showList() {
        System.out.println("----DANH SACH DU AN----");
        this.listProjects.forEach( x -> x.showSingle() );
    }

    public List<Project> findNameAndStart (String name, Date start) {
        return this.listProjects.stream().filter(x -> x.getName().equalsIgnoreCase(name) && x.getStartDate()
                .equals(start)).collect(Collectors.toList());
    }

    public int findId( String id ) {
        for (int i = 0; i < this.listProjects.size(); i++) {
            if( this.listProjects.get(i).getId().equals(id))
                return i;
        }
        return -1;
    }

    public boolean isLike(int posProject, String idStaff) {
        for (Staff p: this.listProjects.get(posProject).getStaffs().getListStaffs()) {
            if (p.getId().equals(idStaff))
                return true;
        }
        return false;
    }

    public boolean isLikeManager(int posProject) {
        for (Staff p: this.listProjects.get(posProject).getStaffs().getListStaffs()) {
            if (p.getId().equals(this.listProjects.get(posProject).getManager().getId()))
                return true;
        }
        return false;
    }

    public void sortInvestment() {
        this.listProjects.sort((x1, x2) -> {return x1.compareTo(x2);});
    }

    public List<Project> getListProjects() {
        return listProjects;
    }

    public void setListProjects(List<Project> listProjects) {
        this.listProjects = listProjects;
    }
}
