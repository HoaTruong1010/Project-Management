import java.text.ParseException;
import java.util.Date;

public class NormalStaff extends Staff {
    public NormalStaff() {
        super();
    }

    public NormalStaff(String name, String mail, String gen, Date date, double f) {
        super(name, mail, gen, date, f);
    }

    public NormalStaff(NormalStaff p) {
        super(p);
    }

    @Override
    public double getGrant() {
        return 0;
    }
}
