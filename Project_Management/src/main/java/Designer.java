import java.text.ParseException;

public class Designer extends Staff {
    private int numProject;
    private static final int MINPROJECT = 2;
    private static final int MAXPROJECT = 3;

    public Designer() {
        super();
    }

    public Designer(String name, String mail, String gen, String date, double f) throws ParseException {
        super(name, mail, gen, date, f);
    }

    public void importStaff() throws ParseException {
        super.importStaff();
        System.out.print("Nhập số lượng project tham gia: ");
        this.numProject = scanner.nextInt();
    }

    public void showSingle() {
        super.showSingle();
        System.out.printf("Số project tham gia: %d\n", this.numProject);
    }

    public double getGrant() {
        return (this.numProject == MINPROJECT || this.numProject == MAXPROJECT) ? 0 : this.numProject * 200000;
    }

    public int getNumProject() {
        return numProject;
    }

    public void setNumProject(int numProject) {
        this.numProject = numProject;
    }
}
