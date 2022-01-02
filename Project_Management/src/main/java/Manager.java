import java.text.ParseException;
import java.util.Date;

public class Manager extends NormalStaff {
    private Date inauguralDay;

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
    public void importStaff() throws ParseException {
        super.importStaff();
        System.out.print("Nhập ngày nhậm chức: ");
        this.inauguralDay = F.parse(scanner.nextLine());
    }

    //Hiển thị
    @Override
    public void showSingle() {
        super.showSingle();
        System.out.printf("- Ngày nhậm chức: %s\n", F.format(this.inauguralDay));
    }

    public Date getInauguralDay() {
        return inauguralDay;
    }

    public void setInauguralDay(Date inauguralDay) {
        this.inauguralDay = inauguralDay;
    }
}
