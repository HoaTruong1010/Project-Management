import java.text.ParseException;
import java.util.Date;

public class Programmer extends Staff {
    private static final double OTSalary = 25000;
    private int OT;
    private static final int MAXOT = 30;

    public Programmer() {
        super();
    }

    public Programmer(String name, String mail, String gen, Date date, int ot){
        super(name, mail, gen, date);
        this.OT = ot;
    }

    public Programmer(Programmer p) {
        super(p);
        this.OT = p.OT;
    }

    @Override
    public void importGrant() {
        do {
            System.out.print("Nhập số giờ làm thêm: ");
            this.OT = scanner.nextInt();
            scanner.nextLine();
            if (this.OT < 0) System.out.println("Vui lòng nhập số nguyên dương!");
        } while (this.OT < 0);
    }

    @Override
    public double getGrant() {
        return (this.OT > MAXOT) ? MAXOT * 25000 : this.OT * 25000;
    }

    public int getOT() {
        return OT;
    }

    public void setOT(int OT) {
        this.OT = OT;
    }
}