import java.util.ArrayList;
import java.util.List;

public class ProjectManagement {
    protected List<Project> listProjects = new ArrayList();

    public void add(Project x) {
        this.listProjects.add(x);
    }

    public void delete (Project x) {
        this.listProjects.remove(x);
    }

    public void change (Project x) {

    }
}
