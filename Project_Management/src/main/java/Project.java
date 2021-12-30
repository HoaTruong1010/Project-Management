import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Project {
    private static final SimpleDateFormat F = new SimpleDateFormat("dd/MM/yyyy");
    private static int count = 0;
    private String id, name;
    private GregorianCalendar startDate, endDate;
    private double investment;
    private NormalStaff manager;

    {
        this.id = String.format("%03d", ++count);
        startDate = new GregorianCalendar();
        endDate = new GregorianCalendar();
    }

    public Project() {
        this.name = null;
        this.startDate = null;
        this.endDate = null;
        this.investment = 0.0;
    }

    public Project(String n, String start, String end, double inv) throws ParseException {
        this.name = n;
        this.startDate.setTime(F.parse(start));
        this.endDate.setTime(F.parse(end));
        this.investment = inv;
//        this.manager = new NormalStaff(m.getFullName(), m.getEmail(), m.getGender(),
//                m.getDateOfBirth(), m.getFactor());
    }

    public Project (Project x) {
        this.name = x.name;
        this.startDate = x.startDate;
        this.endDate = x.endDate;
        this.investment = x.investment;
    }

    public void showSingle() {
        System.out.printf("- Ma du an: %s\n- Ten du an: %s\n- Thoi gian: %s - %s\n" +
                        "- Phi dau tu: %.1f\n\n", this.id, this.name, F.format(this.startDate.getTime()),
                F.format(this.endDate.getTime()), this.investment);
    }

    public int compareTo(Project x) {
        return (this.investment < x.investment) ? -1 : (this.investment > x.investment ? 1 : 0);
    }

    public static int getCount() {
        return count;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GregorianCalendar getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) throws ParseException {
        this.startDate.setTime(F.parse(startDate));
    }

    public GregorianCalendar getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) throws ParseException {
        this.endDate.setTime(F.parse(endDate));
    }

    public double getInvestment() {
        return investment;
    }

    public void setInvestment(double investment) {
        this.investment = investment;
    }

    public static void main(String[] args) throws ParseException {
//        NormalStaff A = new NormalStaff("Nguyen Van A", "abc@gmail.com", "nam",)
        Project p1 = new Project("lập trình java", "1/1/2022", "1/2/2022", 1000.0);
        Project p2 = new Project("lập trình C", "7/1/2022", "7/2/2022", 3000.0);
        p1.showSingle();
        p2.showSingle();
    }
}
