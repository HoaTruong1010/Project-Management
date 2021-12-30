package StaffManagement;

public class Programmer extends Staff {
    private static final double OTSalary = 25000;
    private int OT;
    private static final int MAXOT = 30;

    public Programmer() {
        super();
    }

    public Programmer(int OT) {
        super();
        this.setOT(OT);
    }

    public void showSingle() {
        super.showSingle();
        System.out.printf("Số giờ làm thêm: %d\n", this.OT);
    }

    public double getGrant() {
        if (this.OT <= MAXOT)
            return this.OT * 25000;
        else
            return MAXOT * 25000;
    }

    public int getOT() {
        return OT;
    }

    public void setOT(int OT) {
        this.OT = OT;
    }
}
