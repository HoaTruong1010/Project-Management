import java.text.ParseException;
import java.util.Date;

public class Designer extends Staff {
    private int numProject;
    private static final int MINPROJECT = 2;
    private static final int MAXPROJECT = 3;

    public Designer() {
        super();
    }

    public Designer(String name, String mail, String gen, Date date, double f){
        super(name, mail, gen, date, f);
    }

    @Override
    public void importStaff() throws ParseException {
        super.importStaff();
        System.out.print("Nhập số lượng project tham gia: ");
        do {
            this.numProject = scanner.nextInt();
            if (this.numProject < 0 || this.numProject > 3) System.out.println("Vui lòng nhập số nguyên dương!");
        } while (this.numProject < 0 || this.numProject > 3);

    }

    @Override
    public void showSingle() {
        super.showSingle();
        System.out.printf("- Số project tham gia: %d\n", this.numProject);
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
