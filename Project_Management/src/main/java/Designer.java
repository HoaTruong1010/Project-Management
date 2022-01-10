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
    public void inputGrant() {
        do {
            System.out.print("Nhap so luong project tham gia: ");
            this.numProject = scanner.nextInt();
            scanner.nextLine();
            if (this.numProject <= 0 || this.numProject > MAXPROJECT) System.out.println("Nhap sai! Nhap lai!");
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
