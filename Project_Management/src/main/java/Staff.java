import java.util.GregorianCalendar;
import java.util.Scanner;

public abstract class Staff {
    private String id;
    private String fullName;
    private String email;
    private String gender;
    private GregorianCalendar dateOfBirth;
    private static int count;
    protected static final double salary = 6000000;
    private double factor;
    protected ProjectManagement Projects;
//    protected Department department;
    public static final Scanner scanner = new Scanner(System.in);
//  gán giá trị tất cả thuộc tính bằng null + chưa có khối khởi động tăng mã nv
//    public Staff() {
//        super();
//    }

    public Staff(String name, String mail, String gen, GregorianCalendar date, double f) {
//        super();
        this.fullName = name;
        this.email = mail;
        this.gender = gen;
        this.dateOfBirth = date;
        this.factor = f;
    }

    //Nhập 1 nhân viên
    public void importStaff() {
        System.out.print("Nhập mã nhân viên: ");
        this.id = scanner.nextLine();
        System.out.print("Nhập họ tên nhân viên: ");
        this.fullName = scanner.nextLine();
        System.out.print("Nhập email: ");
        this.email = scanner.nextLine();
        System.out.print("Nhập giới tính: ");
        this.gender = scanner.nextLine();
        System.out.print("Nhập ngày sinh: ");
        this.dateOfBirth = scanner.next();
        System.out.print("Nhập hệ số lương: ");
        this.factor = scanner.nextDouble();
    }

    //Hiển thị 1 nhân viên
    public void showSingle() {
        System.out.printf("Mã nhân viên: %s\n", id);
        System.out.printf("Họ tên: %s\n", this.fullName);
        System.out.printf("Email: %s\n", this.email);
        System.out.printf("Giới tính: %s\n", this.gender);
        System.out.printf("Ngày sinh: %s\n", this.dateOfBirth);
        System.out.printf("Hệ số: %.2f\n", this.factor);
        //System.out.printf("Phòng ban: %s\n", this.department);
    }

    //Bảng lương
    public double payroll() {
        return salary * this.factor + getGrant();
    }

    //Tính lương phụ cấp
    public abstract double getGrant() {
        return 0;
    }

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

    public GregorianCalendar getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(GregorianCalendar dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public double getFactor() {
        return factor;
    }

    public void setFactor(double factor) {
        this.factor = factor;
    }
}
