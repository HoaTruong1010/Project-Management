import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProjectManagement {
    private static final SimpleDateFormat F = new SimpleDateFormat("dd/MM/yyyy");
    protected List<Project> listProjects = new ArrayList();

    public void add(Project x) {
        this.listProjects.add(x);
    }

    public void add() throws ParseException {
        Project x = new Project();
        System.out.println("Nhap du an so: " + x.getId());
        x.importProject();
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
        return (List<Project>) this.listProjects.stream().filter(x -> x.getName().equalsIgnoreCase(name) && x.getStartDate().equals(start));
    }

    public int findId( String id ) {
        for (int i = 0; i < this.listProjects.size(); i++) {
            if( this.listProjects.get(i).getId().equals(id))
                return i;
        }
        return -1;
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
