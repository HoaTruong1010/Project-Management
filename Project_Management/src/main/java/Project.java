import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Project {
    public static final SimpleDateFormat F = new SimpleDateFormat("dd/MM/yyyy");
    public static final Scanner SC = new Scanner(System.in);
    private static int count = 0;
    private String id, name;
    private Date startDate , endDate ;
    private double investment;
    private Staff manager;
    private List<Staff> staffs = new ArrayList<>();

    {
        this.id = String.format("%03d", ++count);
    }

    public Project(String n, Date start, Date end, double inv){
        this.name = n;
        this.startDate = start;
        this.endDate = end;
        this.investment = inv;
    }

    public Project (Project x) {
        this.name = x.name;
        this.startDate = x.startDate;
        this.endDate = x.endDate;
        this.investment = x.investment;
    }

    public Project() {
        this(null, null, null, 0.0);
    }

    public void inputProject(){
        this.startDate = new Date(0);
        this.endDate = new Date(0);
        System.out.print("- Nhap ten du an: ");
        this.name = SC.nextLine();
        do {
            try {
                System.out.printf("- Nhap ngay bat dau (%s): ", F.toPattern());
                this.startDate = F.parse(SC.nextLine());
                System.out.printf("- Nhap ngay ket thuc (%s): ", F.toPattern());
                this.endDate = F.parse(SC.nextLine()) ;
            } catch (ParseException ex ) {
                System.out.println("Nhap sai! Nhap lai!");
            }
            if(this.startDate.after(this.endDate) && this.startDate.getTime() != 0 && this.endDate.getTime() != 0)
                System.out.println("Nhap sai! Nhap lai!");
        }
        while (this.startDate.after(this.endDate) || this.startDate.getTime() == 0 || this.endDate.getTime() == 0);
        do {
            System.out.print("- Nhap phi dau tu: ");
            this.investment = SC.nextDouble();
            if (this.investment <= 0)
                System.out.println("Nhap so LON HON 0!");
        }
        while (this.investment <= 0);
        SC.nextLine();
    }

    public void showSingle() {
        System.out.printf("\n+ Ma du an: %s\n+ Ten du an: %s\n+ Thoi gian: %s - %s\n" +
                        "+ Phi dau tu: %.1f\n", this.id, this.name, F.format(this.startDate.getTime()),
                F.format(this.endDate.getTime()), this.investment);
        if (this.manager != null) {
            System.out.print("+ NHAN VIEN QUAN LY du an: \n");
            this.manager.showSingle();
        }
    }

    public int compareTo(Project x) {
        return (this.investment < x.investment) ? -1 : (this.investment > x.investment ? 1 : 0);
    }

    public void setManager(Staff manager) {
        this.manager = manager;
    }

    public int findId(String id) {
        for (int i = 0; i < this.staffs.size(); i++) {
            if(this.staffs.get(i).getId().equals(id))
                return i;
        }
        return -1;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate){
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate){
        this.endDate = endDate;
    }

    public double getInvestment() {
        return investment;
    }

    public void setInvestment(double investment) {
        this.investment = investment;
    }

    public static void setCount(int count) {
        Project.count = count;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Staff getManager() {
        return manager;
    }

    public List<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(List<Staff> staffs) {
        this.staffs = staffs;
    }
}
