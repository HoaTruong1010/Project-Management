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
    public void inputGrant() {
        do {
            System.out.print("Nhap so loi quan trong phat hien: ");
            this.error = scanner.nextInt();
            scanner.nextLine();
            if (this.error < 0) System.out.println("Vui long nhap so nguyen duong!");
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