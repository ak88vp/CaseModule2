
import model.AccountAdmin;
import model.AccountUser;
import model.Character;
import model.sirvice.ManagerAccountUser;
import model.sirvice.ManagerCharacter;

import java.io.*;
import java.util.Scanner;

public class MenuAdmin {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static void main() {
        ManagerAccountUser managerAccountUser = new ManagerAccountUser();
        ManagerCharacter managerCharacter = new ManagerCharacter();
        AccountAdmin admin = new AccountAdmin();
        Scanner scanner = new Scanner(System.in);
        int choice = 88;
        while (choice != 0) {
            try {
                System.out.println(ANSI_BLUE+"----------------------Menu----------------------"+ANSI_RESET);
                System.out.println(ANSI_PURPLE+" 1 : Quản lý nhân vật");
                System.out.println(" 2 : Quản lý tài khoản người dùng");
                System.out.println(" 3 : Đổi mật khẩu");
                System.out.println(" 4 : Đọc file danh sách nhân vật");
                System.out.println(" 5 : Đọc file danh sách tài khoản người dùng");
                System.out.println(" 0 : Đăng xuất"+ANSI_RESET);
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        int choice1 = 88;
                        while (choice1 != 0) {
                            System.out.println(ANSI_BLUE+"------------------Menu--------------------"+ANSI_RESET);
                            System.out.println(ANSI_PURPLE+" 1 :Hiển thị danh sách nhân vật ");
                            System.out.println(" 2 :Thêm  nhân vật  ");
                            System.out.println(" 3 :Xóa nhân vật ");
                            System.out.println(" 4 :Sửa sửa nhân vật ");
                            System.out.println(" 5 :Sắp xếp nhân vật theo tiền truy nã");
                            System.out.println(" 6 :Sắp xếp nhân vật theo tuổi");
                            System.out.println(" 7 :Tìm kiếm ");
                            System.out.println(" 8 :Lưu vào file ");
                            System.out.println(" 0 : Trở về "+ANSI_RESET);
                            choice1 = scanner.nextInt();
                            switch (choice1) {
                                case 1:
                                    System.out.printf(ANSI_YELLOW+"%-22s %-8s %-20s %-20s %-20s","Tên","Tuổi","Trái ác quỷ","Băng nhóm","Tiền truy nã ");
                                    System.out.println("");
                                    managerCharacter.print();
                                    break;
                                case 2:
                                    createNewCharacter(managerCharacter, scanner);
                                    break;
                                case 3:
                                    System.err.println("Nhập tên nhân vật muốn xóa");
                                    scanner.nextLine();
                                    String deleteName = scanner.nextLine();
                                    if (managerCharacter.find(deleteName) != -1) {
                                        managerCharacter.delete(deleteName);
                                        System.err.println("Xóa thành công");
                                    } else System.err.println("Không tìm thấy nhân vật bạn muốn xóa");
                                    break;
                                case 4:
                                    System.err.println("Nhập tên nhân vật bạn muốn sửa ");
                                    scanner.nextLine();
                                    String editName = scanner.nextLine();
                                    if (managerCharacter.find(editName) != -1) {
                                        System.err.println("Tạo mới tên nhân vật");
                                        String newName = scanner.nextLine();
                                        System.err.println("Tạo mới tuổi nhân vật");
                                        int newAge = scanner.nextInt();
                                        System.err.println("Tạo mới trái ác quỷ nhân vật");
                                        String newDevilFruit = scanner.nextLine();
                                        System.err.println("Tạo mới băng nhóm  nhân vật");
                                        String newGangs = scanner.nextLine();
                                        System.err.println("Tạo mới số tiền truy nã nhân vật");
                                        int newMoneyRetrieval = scanner.nextInt();
                                        managerCharacter.edit(editName, new Character(newName, newAge, newDevilFruit, newGangs, newMoneyRetrieval));
                                        System.err.println("Sửa đổi thành công");
                                        break;
                                    }
                                    System.err.println("Ko tìm thấy nhân vật bạn muốn sửa");
                                    break;
                                case 5:
                                    System.out.printf(ANSI_YELLOW+"%-22s %-8s %-20s %-20s %-20s","Tên","Tuổi","Trái ác quỷ","Băng nhóm","Tiền truy nã ");
                                    System.out.println("");
                                    managerCharacter.sortByMoney();
                                    break;
                                case 6:
                                    System.out.printf(ANSI_YELLOW+"%-22s %-8s %-20s %-20s %-20s","Tên","Tuổi","Trái ác quỷ","Băng nhóm","Tiền truy nã ");
                                    System.out.println("");
                                    managerCharacter.sortByAge();
                                    break;
                                case 7:
                                    int choice2 = 88;
                                    while (choice2 != 0) {
                                        System.out.println(ANSI_BLUE+"------------------Menu-------------------"+ANSI_RESET);
                                        System.out.println(ANSI_PURPLE+" 1 :Tìm kiếm theo tên nhân vật ");
                                        System.out.println(" 2 :Tìm kiếm theo tên băng nhóm ");
                                        System.out.println(" 3 :Tìm kiếm theo tên số tiền truy nã ");
                                        System.out.println(" 0 : trở về "+ANSI_RESET);
                                        choice2 = scanner.nextInt();
                                        switch (choice2) {
                                            case 1:
                                                findByName(managerCharacter, scanner);
                                                break;
                                            case 2:
                                                findByGangs(managerCharacter, scanner);
                                                break;
                                            case 3:
                                                findByMoney(managerCharacter, scanner);
                                                break;
                                            case 0:
                                                System.out.println("....................");
                                                break;
                                        }
                                    }
                                case 8:
                                    System.err.println("Nhập đường dẫn ");
                                    scanner.nextLine();
                                    String link = scanner.nextLine();
                                    try (FileWriter fileWriter = new FileWriter(link)) {
                                        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                                        String str = "Tên,Tuổi,Trái ác quỷ,Băng nhóm,Tiền truy nã";
                                        for (int i = 0; i < managerCharacter.getListCharacter().size(); i++) {
                                            str += "\n" + managerCharacter.getListCharacter().get(i).getName()
                                                    + "," + managerCharacter.getListCharacter().get(i).getAge() +
                                                    "," + managerCharacter.getListCharacter().get(i).getDevilFruit() +
                                                    "," + managerCharacter.getListCharacter().get(i).getGangs() +
                                                    "," + managerCharacter.getListCharacter().get(i).getMoneyRetrieval();
                                        }
                                        bufferedWriter.write(str);
                                        bufferedWriter.close();
                                    } catch (IOException ignored) {
                                    }
                                    break;
                                case 0:
                                    System.out.println("....................");
                                    break;
                            }
                        }
                        break;
                    case 2:
                        int choice3 = 88;
                        while (choice3 != 0) {
                            System.out.println(ANSI_BLUE+"---------------------Menu----------------------"+ANSI_RESET);
                            System.out.println(ANSI_PURPLE+" 1 :Hiển thị danh sách tài khoản ");
                            System.out.println(" 2 :Thêm tài khoản  ");
                            System.out.println(" 3 :Xóa tài khoản ");
                            System.out.println(" 4 :Sửa tài khoản ");
                            System.out.println(" 5 :Sắp xếp tài khoản theo ngày đăng kí ");
                            System.out.println(" 6 :Tìm kiếm tài khoản ");
                            System.out.println(" 7 :Lưu danh sách tài khoản vào file ");
                            System.out.println(" 0 : Trở về "+ANSI_RESET);
                            choice3 = scanner.nextInt();
                            switch (choice3) {
                                case 1:
                                    System.out.printf(ANSI_YELLOW+"%-22s %-22s %-20s ","Tên tài khoản","Mật khẩu","Ngày đăng kí");
                                    System.out.println("");
                                    managerAccountUser.print();
                                    break;
                                case 2:
                                    MenuLogin.createNewAccount(managerAccountUser, scanner);

                                    break;
                                case 3:
                                    System.err.println("Nhập tên tài khoản muốn xóa");
                                    scanner.nextLine();
                                    String deleteName = scanner.nextLine();
                                    managerAccountUser.delete(deleteName);
                                    break;
                                case 4:
                                    editAccount(managerAccountUser, scanner);
                                    break;
                                case 5:
                                    System.out.printf(ANSI_YELLOW+"%-22s %-22s %-20s ","Tên tài khoản","Mật khẩu","Ngày đăng kí");
                                    System.out.println("");
                                    managerAccountUser.sortDate();
                                    break;
                                case 6:
                                    System.err.println("Nhập tên tài khoản muốn tìm");
                                    scanner.nextLine();
                                    String findName = scanner.nextLine();
                                    managerAccountUser.findByName(findName);
                                    break;
                                case 7:
                                    System.err.println("Nhập đường dẫn ");
                                    scanner.nextLine();
                                    String link = scanner.nextLine();
                                    try (FileWriter fileWriter = new FileWriter(link)) {
                                        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                                        String str = "Tên tài khoản, Mật khẩu,Ngày đăng kí";
                                        for (int i = 0; i < managerAccountUser.getListUserAccount().size(); i++) {
                                            str += "\n" + managerAccountUser.getListUserAccount().get(i).getUserName() + ","
                                                    + managerAccountUser.getListUserAccount().get(i).getPassword() + "," +
                                                    managerAccountUser.getListUserAccount().get(i).getDateTime()
                                            ;
                                        }
                                        bufferedWriter.write(str);
                                        bufferedWriter.close();
                                    } catch (IOException ignored) {
                                    }
                                    break;
                                case 0:
                                    System.out.println(".....................");
                                    break;
                            }
                        }
                        break;
                    case 3:
                        System.err.println("Nhập lại mật khẩu :");
                        scanner.nextLine();
                        String pass = scanner.nextLine();
                        if (admin.getPassword().equals(pass)) {
                            System.err.println("Nhập mật khẩu mới");
                            String newPass = scanner.nextLine();
                            System.err.println("Nhập lại mật khẩu ");
                            String newPass1 = scanner.nextLine();
                            if (MenuLogin.validate(newPass)) {
                                if (newPass.equals(newPass1)) {
                                    admin.setPassword(newPass);
                                    System.err.println("Đã đổi mật khẩu thành công");
                                    break;
                                } else System.err.println("Mật khẩu không trùng khớp");
                                break;
                            } else
                                System.err.println("Mật khẩu không hợp lệ (Chứa ít nhất 6 kí tự và ko có kí tự đặc biệt )");
                            break;
                        } else System.err.println("Mật khẩu không chính xác ");
                        break;
                    case 4:
                        System.err.println("Nhập đường dẫn mà bạn muốn đọc");
                        scanner.nextLine();
                        String link1 = scanner.nextLine();
                        FileReader fileReader = new FileReader(link1);
                        BufferedReader bufferedReader = new BufferedReader(fileReader);
                        String str1;
                        System.out.println("\n------------------------------------------------------------------------------------------------------------------------");
                        while ((str1 = bufferedReader.readLine()) != null) {
                            String[] str2 = str1.split(",");
                            for (int i = 0; i < str2.length; i++) {
                                System.out.printf(ANSI_YELLOW+"  %-25s|", str2[i]+ANSI_RESET);
                            }
                            System.out.println("\n------------------------------------------------------------------------------------------------------------------------");
                        }
                        bufferedReader.close();
                        break;
                    case 5:
                        System.err.println("Nhập đường dẫn mà bạn muốn đọc");
                        scanner.nextLine();
                        String link2 = scanner.nextLine();
                        try (FileReader fileReader2 = new FileReader(link2)) {
                            BufferedReader bufferedReader2 = new BufferedReader(fileReader2);
                            String str3;
                            System.out.println("\n------------------------------------------------------------------------------");
                            while ((str3 = bufferedReader2.readLine()) != null) {
                                String[] str2 = str3.split(",");
                                for (int i = 0; i < str2.length; i++) {
                                    System.out.printf(ANSI_YELLOW+"  %-27s|", str2[i]+ANSI_RESET);
                                }
                                System.out.println("\n------------------------------------------------------------------------------");
                            }
                            bufferedReader2.close();
                        } catch (IOException i) {
                            System.out.println("");
                        }
                        break;
                    case 0:
                        System.err.println("Cám ơn bạn đã sử chương trình \nChúc bạn có một ngày tốt đẹp ");
                        break;
                }
            } catch (Exception e) {
                scanner.nextLine();
                System.err.println("Xin mời nhập lựa chọn tương ứng ");
            }
        }
    }

    private static void editAccount(ManagerAccountUser managerAccountUser, Scanner scanner) {
        System.err.println("Nhập tên tài khoản muốn sửa");
        scanner.nextLine();
        String editName = scanner.nextLine();
        if (managerAccountUser.find(editName) != -1) {
            System.err.println("Đổi tên tài khoản ");
            String newName = scanner.nextLine();
            System.err.println("Đổi mật khẩu ");
            String newPass = scanner.nextLine();
            System.err.println("Nhập lại mật khẩu ");
            String newPass2 = scanner.nextLine();
            if (MenuLogin.validate(newName) && MenuLogin.validate(newPass2)) {
                if (newPass.equals(newPass2)) {
                    managerAccountUser.edit(editName, new AccountUser(newName, newPass));
                    System.err.println("Sửa thành công");
                    return;
                } else System.err.println("Mật khẩu không trùng khớp");
                return;
            } else System.err.println("Mật khẩu không hợp lệ (Chứa ít nhất 6 kí tự và ko có kí tự đặc biệt )");
            return;
        }
    }

    static void createNewCharacter(ManagerCharacter managerCharacter, Scanner scanner) {
        System.err.println("Tạo tên nhân vật ");
        scanner.nextLine();
        String newName = scanner.nextLine();
        System.err.println("Tuổi " + newName + " :");
        int newAge = scanner.nextInt();
        System.err.println(newName + " sở hữu trái ác quỷ :");
        scanner.nextLine();
        String newDevilFruit = scanner.nextLine();
        System.err.println(newName + " thuộc băng nhóm :");
        String newGangs = scanner.nextLine();
        System.err.println(newName + " có số tiền truy nã :");
        int newMoneyRetrieval = scanner.nextInt();
        managerCharacter.add(new Character(newName, newAge, newDevilFruit, newGangs, newMoneyRetrieval));

    }

    static void findByName(ManagerCharacter managerCharacter, Scanner scanner) {
        System.err.println("Nhập tên nhân vật bạn muốn tìm ");
        scanner.nextLine();
        String findName = scanner.nextLine();
        managerCharacter.findByName(findName);
    }

    static void findByGangs(ManagerCharacter managerCharacter, Scanner scanner) {
        System.out.println("Nhập băng nhóm bạn muốn tìm ");
        scanner.nextLine();
        String findGangs = scanner.nextLine();
        managerCharacter.findByGangs(findGangs);
    }

    static void findByMoney(ManagerCharacter managerCharacter, Scanner scanner) {
        System.out.println("Nhập tên nhân vật bạn muốn tìm ");
        scanner.nextLine();
        int findMoney = scanner.nextInt();
        managerCharacter.findByMoney(findMoney);
    }
}
