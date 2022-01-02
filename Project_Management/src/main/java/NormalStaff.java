import java.text.ParseException;
import java.util.GregorianCalendar;


public class NormalStaff extends Staff {
    public NormalStaff() {
        super();
    }

    public NormalStaff(String name, String mail, String gen, String date, double f) throws ParseException {
        super(name,mail,gen,date,f);
    }

    @Override
    public void importStaff() throws ParseException {
        super.importStaff();
    }

    @Override
    public void showSingle() {
        super.showSingle();
    }

    public double getGrant() {return 0;};
=======
    public NormalStaff(String name, String mail, String gen, GregorianCalendar date, double f) {
        super(name, mail, gen, date, f);
    }

    @Override
    public double getGrant() {
        return 0;
    }
}
