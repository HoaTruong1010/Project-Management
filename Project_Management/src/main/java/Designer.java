import java.text.ParseException;
import java.util.Date;

public class Designer extends Staff {

    private int numProject = 0;

    private static final int MAXPROJECT = 3;

    public Designer() {
        super();
    }

    public Designer(String name, String mail, String gen, Date date, int num){
        super(name, mail, gen, date);
        this.numProject = num;
    }

    public Designer(Designer p) {
        super(p);
        this.numProject = p.numProject;
    }

    @Override
    public void importGrant() {
        do {
            System.out.print("Nhập số lượng project tham gia: ");
            this.numProject = scanner.nextInt();
            scanner.nextLine();
            if (this.numProject <= 0 || this.numProject > MAXPROJECT) System.out.println("Nhập sai! Nhập lại!");
        } while (this.numProject <= 0 || this.numProject > MAXPROJECT);
    }

    @Override
    public double getGrant() {
        return (this.numProject - 1) * 200000;
    }

    public int getNumProject() {
        return numProject;
    }

    public void setNumProject(int numProject) {
        this.numProject = numProject;
    }
}
