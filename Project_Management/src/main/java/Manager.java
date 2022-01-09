import java.text.ParseException;
import java.util.Date;

public class Manager extends NormalStaff {
    private Date inauguralDay;

    {
        this.inauguralDay = new Date(0);
    }

    public Manager() {
        super();
    }

    public Manager(String name, String mail, String gen, Date date, Date inaugural){
        super(name, mail, gen, date);
        this.inauguralDay = inaugural;
    }

    public Manager(Manager m) {
        super(m);
        this.inauguralDay = m.inauguralDay;
    }

    //Nhập
    @Override
    public void inputStaff() {
        super.inputStaff();
        do {
            try {
                System.out.printf("Nhap ngay nham chuc theo format (%s): ", F.toPattern());
                this.inauguralDay = F.parse(scanner.nextLine());
            } catch (ParseException ex ) {
                System.out.println("Nhap sai! Nhap lai!");
            }
        } while (this.inauguralDay.getTime() == 0);
    }

    //Hiển thị
    @Override
    public void showSingle() {
        super.showSingle();
        System.out.printf("- Ngay nham chuc: %s\n", F.format(this.inauguralDay));
    }

    public Date getInauguralDay() {
        return inauguralDay;
    }

    public void setInauguralDay(Date inauguralDay) {
        this.inauguralDay = inauguralDay;
    }
}
