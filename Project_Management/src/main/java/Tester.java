import java.text.ParseException;

public class Tester extends Staff {
    private int error;

    public Tester() {
        super();
    }

    public Tester(String name, String mail, String gen, String date, double f) throws ParseException {
        super(name, mail, gen, date, f);
    }

    public void importStaff() throws ParseException {
        super.importStaff();
        System.out.print("Nhập số lỗi quan trọng phát hiện: ");
        do {
            this.error = scanner.nextInt();
            if (this.error < 0) System.out.println("Vui lòng nhập số nguyên dương!");
        } while (this.error < 0);
    }

    public void showSingle() {
        super.showSingle();
        System.out.printf("Số lỗi quan trọng phát hiện: %d\n", this.getError());
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