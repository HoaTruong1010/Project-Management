import java.text.ParseException;
import java.util.Date;

public class Tester extends Staff {
    private int error;

    public Tester() {
        super();
    }

    public Tester(String name, String mail, String gen, Date date, int e){
        super(name, mail, gen, date);
        this.error = e;
    }

    public Tester(Tester p) {
        super(p);
        this.error = p.error;
    }

    @Override
    public void importGrant() {
        do {
            System.out.print("Nhập số lỗi quan trọng phát hiện: ");
            this.error = scanner.nextInt();
            scanner.nextLine();
            if (this.error < 0) System.out.println("Vui lòng nhập số nguyên dương!");
        } while (this.error < 0);
    }

    @Override
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