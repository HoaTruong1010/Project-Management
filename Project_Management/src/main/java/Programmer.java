public class Programmer extends Staff {
    private static final double OTSalary = 25000;
    private int OT;
    private static final int MAXOT = 30;
//    sửa lại phương thức khởi tạo

    public Programmer() {
        super();
    }

    public Programmer(int OT) {
        super();
        this.OT = OT;
    }

    public void showSingle() {
        super.showSingle();
        System.out.printf("Số giờ làm thêm: %d\n", this.OT);
    }

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
