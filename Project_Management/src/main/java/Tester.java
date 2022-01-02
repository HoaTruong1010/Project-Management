import java.text.ParseException;
import java.util.Date;

public class Tester extends Staff {
    private int error;

    public Tester() {
        super();
    }

    public Tester(String name, String mail, String gen, Date date, double f, int e){
        super(name, mail, gen, date, f);
        this.error = e;
    }

    public Tester(Tester p) {
        super(p);
        this.error = p.error;
    }

    @Override
    public void importStaff() throws ParseException {
        super.importStaff();
        System.out.print("Nhập số lỗi quan trọng phát hiện: ");
        do {
            this.error = scanner.nextInt();
            if (this.error < 0) System.out.println("Vui lòng nhập số nguyên dương!");
        } while (this.error < 0);
    }

    @Override
    public void showSingle() {
        super.showSingle();
        System.out.printf("- Số lỗi quan trọng phát hiện: %d\n", this.getError());
    }

    public double getGrant() {
        return this.error * 200000;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }
}