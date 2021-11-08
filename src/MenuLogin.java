import model.AccountAdmin;
import model.AccountUser;
import model.sirvice.ManagerAccountUser;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MenuLogin {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static boolean validate(String regex){
        Pattern pattern= Pattern.compile("[a-zA-Z0-9]{6,}");
        Matcher matcher=pattern.matcher(regex);
        return matcher.matches();
    }

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        int choice=88;
        while (choice!=0){
            try{
                System.out.println(ANSI_BLUE+"------Menu------"+ANSI_RESET);
                System.out.println(ANSI_PURPLE+" 1 :ĐĂNG KÍ");
                System.out.println(" 2 :ĐĂNG NHẬP");
                System.out.println(" 0 :THOÁT"+ANSI_RESET);
                choice=scanner.nextInt();
                switch (choice){
                    case 1:
                        createNewAccount(ManagerAccountUser.getManagerAcc(), scanner);
                        break;
                    case 2:
                        logIn(ManagerAccountUser.getManagerAcc(),AccountAdmin.getInstance(), scanner);
                        break;
                    case 0:
                        System.err.println("Cám ơn bạn đã sử chương trình \nChúc bạn có một ngày tốt đẹp ");
                        break;

                }
            }catch (Exception e){
                scanner.nextLine();
                System.err.println("Xin mời nhập lựa chọn tương ứng ");
            }
            if (choice < 0 || choice > 2) {
                System.out.println("Chưa phát triển chức năng này");}
        }
    }
    public static String newName;
    public static void logIn(ManagerAccountUser managerAccountUser, AccountAdmin admin, Scanner scanner) {
        System.err.println("Nhập tên tài khoản ");
        scanner.nextLine();
        String name= scanner.nextLine();
        System.err.println("Nhập mật khẩu tài khoản ");
        String pass= scanner.nextLine();
        int check=-1;
        if(AccountAdmin.getInstance().getAdminName().equals(name)&& AccountAdmin.getInstance().getPassword().equals(pass)){
            System.err.println("Đã đăng nhập thành công tài khoản Admin");
            MenuAdmin.main();
        }else {
        for (int i = 0; i < ManagerAccountUser.getManagerAcc().getListUserAccount().size(); i++) {
            boolean isName = ManagerAccountUser.getManagerAcc().getListUserAccount().get(i).getUserName().equals(name);
            boolean isPass = ManagerAccountUser.getManagerAcc().getListUserAccount().get(i).getPassword().equals(pass);
            if(isName && isPass){
                System.err.println("Đăng nhập thành công");
                newName=name;
                MenuUser.main();
                check=2;
                break;
            }
        }
        if(check==-1){
            System.err.println("Sai tài khoản hoặc mật khẩu");
        }
        }
    }

    static void createNewAccount(ManagerAccountUser managerAccountUser, Scanner scanner) {
        System.err.println("Tạo tên tài khoản");
        scanner.nextLine();
        String newName= scanner.nextLine();
        System.err.println("Tạo mật khẩu");
        String newPassword= scanner.nextLine();
        System.err.println("Nhập lại mật khẩu ");
        String newPassword2= scanner.nextLine();
        if(validate(newName)&&validate(newPassword)){
        if(newPassword.equals(newPassword2)){
            int check=-1;
            for (int i = 0; i < ManagerAccountUser.getManagerAcc().getListUserAccount().size(); i++) {
                if(!ManagerAccountUser.getManagerAcc().getListUserAccount().get(i).getUserName().equals(newName)){
                    ManagerAccountUser.getManagerAcc().add(new AccountUser(newName,newPassword));
                    System.err.println("Đăng kí thành công");
                    check=i;
                    break;
                }
            }
            if(check==-1){
                System.err.println("Tên Tài Khoản đã được tồn tại");
                return;
            }
        }else System.err.println("Mật khẩu không trùng khớp");
            return;
        }else System.err.println("Tên hoặc mật khẩu không hợp lệ (Chứa ít nhất 6 kí tự và ko có kí tự đặc biệt )");
        return;
    }
}
