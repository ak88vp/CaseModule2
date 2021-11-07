import model.AccountAdmin;
import model.AccountUser;
import model.sirvice.ManagerAccountUser;
import model.sirvice.ManagerCharacter;

import java.util.Scanner;

public class MenuUser {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static void main() {
        Scanner scanner=new Scanner(System.in);
        AccountUser accountUser=new AccountUser();
        ManagerAccountUser managerAccountUser=new ManagerAccountUser();
        ManagerCharacter managerCharacter=new ManagerCharacter();
        int choice=88;
        while (choice!=0){
            try{
                System.out.println(ANSI_BLUE+"----------------------Menu-------------------------"+ANSI_RESET);
                System.out.println(ANSI_PURPLE+" 1 : Hiển thị danh sách nhân vật ");
                System.out.println(" 2 : Tìm kiếm nhân vật ");
                System.out.println(" 3 : Sắp xếp danh sách theo mức tiền truy nã ");
                System.out.println(" 4 : Sắp xếp danh sách theo tuổi ");
                System.out.println(" 5 : Đổi mật khẩu ");
                System.out.println(" 0 : Đăng xuất "+ANSI_RESET);
                choice=scanner.nextInt();
                switch (choice){
                    case 1:
                        System.out.printf(ANSI_YELLOW+"%-22s %-8s %-20s %-20s %-20s","Tên","Tuổi","Trái ác quỷ","Băng nhóm","Tiền truy nã ");
                        System.out.println("");
                        managerCharacter.print();
                        break;
                    case 2:
                        int choice2=88;
                        while (choice2!=0){
                            System.out.println(ANSI_BLUE+"-------------------Menu-------------------"+ANSI_RESET);
                            System.out.println(ANSI_PURPLE+" 1 :Tìm kiếm theo tên nhân vật");
                            System.out.println(" 2 :Tìm kiếm theo tên số tiền thưởng");
                            System.out.println(" 3 :Tìm kiếm theo tên băng nhóm");
                            System.out.println(" 0 :Thoát "+ANSI_RESET);
                            choice2=scanner.nextInt();
                            switch (choice2){
                                case 1:
                                    System.err.println("Nhập tên nhân vật mà bạn muốn tìm");
                                    scanner.nextLine();
                                    String findName=scanner.nextLine();
                                    managerCharacter.findByName(findName);
                                    break;
                                case 2:
                                    System.err.println("Nhập số tiền truy nã ");
                                    scanner.nextLine();
                                   int findMoney=scanner.nextInt();
                                    managerCharacter.findByMoney(findMoney);
                                    break;
                                case 3:
                                    System.err.println("Nhập băng nhóm bạn muốn tìm");
                                    scanner.nextLine();
                                    String findGangs=scanner.nextLine();
                                    managerCharacter.findByGangs(findGangs);
                                    break;
                                case 0:
                                    break;
                            }
                        }
                        break;
                    case 3:
                        System.out.printf(ANSI_YELLOW+"%-22s %-8s %-20s %-20s %-20s","Tên","Tuổi","Trái ác quỷ","Băng nhóm","Tiền truy nã ");
                        System.out.println("");
                        managerCharacter.sortByMoney();
                        break;
                    case 4:
                        System.out.printf(ANSI_YELLOW+"%-22s %-8s %-20s %-20s %-20s","Tên","Tuổi","Trái ác quỷ","Băng nhóm","Tiền truy nã ");
                        System.out.println("");
                        managerCharacter.sortByAge();
                        break;
                    case 5:
                        System.err.println("Nhập mật khẩu mới");
                        scanner.nextLine();
                        String pass=scanner.nextLine();
                        managerAccountUser.editPassWord(MenuLogin.index,pass);
                        break;
                }
            }catch (Exception e){
                scanner.nextLine();
                System.err.println("Xin mời nhập lựa chọn tương ứng ");
            }
        }
    }


}
