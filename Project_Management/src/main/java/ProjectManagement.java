import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class ProjectManagement {
    private static final SimpleDateFormat F = new SimpleDateFormat("dd/MM/yyyy");
    protected List<Project> listProjects = new ArrayList();

    public void add(Project x) {
        this.listProjects.add(x);
    }

    public void add() throws ParseException {
        Project x = new Project();
        x.add();
        this.listProjects.add(x);
    }

    public void delete (Project x) {
        this.listProjects.remove(x);
    }

    public void showList() {
        System.out.println("----Danh sach du an----");
        this.listProjects.forEach( x -> x.showSingle() );
    }

    public Project findNameAndStart (String name, Date start) {
        return this.listProjects.stream().filter(x -> x.getName().equals(name) && x.getStartDate().equals(start)).findFirst().map(Project::new).orElse(null);
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

    public static void main(String[] args) throws ParseException {
        ProjectManagement list = new ProjectManagement();
        list.add(new Project("lập trình java", "1/1/2022", "1/2/2022", 3000.0));
        list.add( new Project("lập trình C", "7/1/2022", "7/2/2022", 2000.0));
        list.add();
        list.showList();
        list.sortInvestment();
        list.showList();
    }
}
