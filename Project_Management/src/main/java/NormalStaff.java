import java.text.ParseException;

public class NormalStaff extends Staff {
    public NormalStaff() {
        super();
    }

    public NormalStaff(String name, String mail, String gen, String date, double f) throws ParseException {
        super(name,mail,gen,date,f);
    }

    public void importStaff() throws ParseException {
        super.importStaff();
    }

    public void showSingle() {
        super.showSingle();
    }

    public double getGrant() {return 0;};
}
