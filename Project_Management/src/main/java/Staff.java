import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public abstract class Staff {
    public static final SimpleDateFormat F = new SimpleDateFormat("dd/MM/yyyy");
    private String id, fullName, email, gender;
    private Date dateOfBirth;
    private static int count = 0;
    protected static final double salary = 6000000;
    private double factor;
    private ProjectManagement Projects;
    private Department department;
    public static final Scanner scanner = new Scanner(System.in);

    {
        this.id = String.format("%03d", ++count);
        dateOfBirth = new Date();
        Projects = new ProjectManagement();
        department = new Department();
    }

    public Staff(Staff p) {
        this.fullName = p.fullName;
        this.dateOfBirth = p.dateOfBirth;
        this.email = p.email;
        this.gender = p.gender;
        this.factor = p.factor;
    }

    public Staff(String name, String mail, String gen, Date date, double f){
        this.fullName = name;
        this.email = mail;
        this.gender = gen;
        this.dateOfBirth = date;
        this.factor = f;
    }

    public Staff(){
        this(null, null,null,null,0.0);
    }

    //Nhập 1 nhân viên
    public void importStaff() throws ParseException {
        System.out.print("Nhập họ tên nhân viên: ");
        this.fullName = scanner.nextLine();
        System.out.print("Nhập email: ");
        this.email = scanner.nextLine();
        System.out.print("Nhập giới tính: ");
        this.gender = scanner.nextLine();
        System.out.print("Nhập ngày sinh: ");
        this.dateOfBirth = F.parse(scanner.nextLine());
        System.out.print("Nhập hệ số lương: ");
        this.factor = scanner.nextDouble();
        System.out.print("Nhập phòng ban trực thuộc: ");
        this.department.setName(scanner.nextLine());
    }

    //Hiển thị 1 nhân viên
    public void showSingle() {
        System.out.printf("- Mã nhân viên: %s\n- Họ tên: %s\n- Email: %s\n" +
                "- Giới tính: %s\n- Ngày sinh: %s\n- Hệ số: %.2f\n" +
                "- Phòng ban: %s\n", this.id, this.fullName, this.email, this.gender,
                F.format(this.dateOfBirth), this.factor, this.department.getName());
    }

    //Bảng lương
    public double payroll() {
        return salary * this.factor + getGrant();
    }

    //Tính lương phụ cấp
    public abstract double getGrant();

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getFactor() {
        return factor;
    }

    public void setFactor(double factor) {
        this.factor = factor;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public ProjectManagement getProjects() {
        return Projects;
    }

    public void setProjects(ProjectManagement projects) {
        Projects = projects;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
