
import model.AccountAdmin;
import model.AccountUser;
import model.Character;
import model.service.ManagerAccountUser;
import model.service.ManagerCharacter;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuAdmin {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    public static void main() {
        Scanner scanner = new Scanner(System.in);
        int choice = 88;
        while (choice != 0) {
            try {
                System.out.println(ANSI_BLUE + "----------------------Menu----------------------" + ANSI_RESET);
                System.out.println(ANSI_PURPLE + " 1 : Quản lý nhân vật");
                System.out.println(" 2 : Quản lý tài khoản người dùng");
                System.out.println(" 3 : Đổi mật khẩu");
                System.out.println(" 4 : Đọc file danh sách nhân vật");
                System.out.println(" 5 : Đọc file danh sách tài khoản người dùng");
                System.out.println(" 6 : Hiển thị tài khoản");
                System.out.println(" 0 : Đăng xuất" + ANSI_RESET);
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        managerCharacter(scanner);
                        break;
                    case 2:
                        managerAccount(scanner);
                        break;
                    case 3:
                        changeThePassword(scanner);
                        break;
                    case 4:
                        readrCharacter();
                        break;
                    case 5:
                        readerAccount();
                        break;
                    case 6:
                        System.out.printf(ANSI_YELLOW + "%-22s%-22s", "Tên tài khoản", "Mật khẩu");
                        System.out.println();
                        System.out.println(AccountAdmin.getInstance().toString());
                        break;
                    case 0:
                        System.err.println("Cám ơn bạn đã sử chương trình \nChúc bạn có một ngày tốt đẹp ");
                        break;
                }
            } catch (Exception e) {
                scanner.nextLine();
                System.err.println("Xin mời nhập lựa chọn tương ứng ");
            }
            if (choice < 0 || choice > 6) {
                System.out.println("Chưa phát triển chức năng này");
            }
        }
    }

    private static void managerCharacter(Scanner scanner) throws IOException {
        int choice1 = 88;
        while (choice1 != 0) {
            System.out.println(ANSI_BLUE + "------------------Menu--------------------" + ANSI_RESET);
            System.out.println(ANSI_PURPLE + " 1 :Hiển thị danh sách nhân vật ");
            System.out.println(" 2 :Thêm  nhân vật  ");
            System.out.println(" 3 :Xóa nhân vật ");
            System.out.println(" 4 :Sửa sửa nhân vật ");
            System.out.println(" 5 :Sắp xếp nhân vật theo tiền truy nã");
            System.out.println(" 6 :Sắp xếp nhân vật theo tuổi");
            System.out.println(" 7 :Tìm kiếm ");
            System.out.println(" 8 :Lưu vào file ");
            System.out.println(" 0 : Trở về " + ANSI_RESET);
            choice1 = scanner.nextInt();
            switch (choice1) {
                case 1:
                    System.out.printf(ANSI_YELLOW + "%-22s %-8s %-20s %-20s %-20s", "Tên", "Tuổi", "Trái ác quỷ", "Băng nhóm", "Tiền truy nã ");
                    System.out.println();
                    getManagerCharacter().print();
                    break;
                case 2:
                    createNewCharacter(scanner);
                    break;
                case 3:
                    System.err.println("Nhập tên nhân vật muốn xóa");
                    scanner.nextLine();
                    String deleteName = scanner.nextLine();
                    boolean haveCharacter = getManagerCharacter().find(deleteName) != -1;
                    if (haveCharacter) {
                        getManagerCharacter().delete(deleteName);
                        System.err.println("Xóa thành công");
                        saveCharacterToFile();
                        readrCRT();
                    } else System.err.println("Không tìm thấy nhân vật bạn muốn xóa");
                    break;
                case 4:
                    editCharacter(scanner);
                    break;
                case 5:
                    System.out.printf(ANSI_YELLOW + "%-22s %-8s %-20s %-20s %-20s", "Tên", "Tuổi", "Trái ác quỷ", "Băng nhóm", "Tiền truy nã ");
                    System.out.println();
                    getManagerCharacter().sortByMoney();
                    break;
                case 6:
                    System.out.printf(ANSI_YELLOW + "%-22s %-8s %-20s %-20s %-20s", "Tên", "Tuổi", "Trái ác quỷ", "Băng nhóm", "Tiền truy nã ");
                    System.out.println();
                    getManagerCharacter().sortByAge();
                    break;
                case 7:
                    find(scanner);
                    break;
                case 8:
                    saveCharacterToFile();
                    break;
                case 0:
                    System.out.println("....................");
                    break;
            }
            if (choice1 < 0 || choice1 > 9) {
                System.out.println("Chưa phát triển chức năng này");
            }
        }
    }

    private static ManagerCharacter getManagerCharacter() {
        return ManagerCharacter.getInstance();
    }

    private static void editCharacter(Scanner scanner) throws IOException {
        System.err.println("Nhập tên nhân vật bạn muốn sửa ");
        scanner.nextLine();
        String editName = scanner.nextLine();
        boolean haveCharacter = getManagerCharacter().find(editName) != -1;
        if (haveCharacter) {
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
            getManagerCharacter().edit(editName, new Character(newName, newAge, newDevilFruit, newGangs, newMoneyRetrieval));
            System.err.println("Sửa đổi thành công");
            saveCharacterToFile();
            readrCRT();
            return;
        }
        System.err.println("Ko tìm thấy nhân vật bạn muốn sửa");
    }

    private static void find(Scanner scanner) {
        int choice2 = 88;
        while (choice2 != 0) {
            System.out.println(ANSI_BLUE + "------------------Menu-------------------" + ANSI_RESET);
            System.out.println(ANSI_PURPLE + " 1 :Tìm kiếm theo tên nhân vật ");
            System.out.println(" 2 :Tìm kiếm theo tên băng nhóm ");
            System.out.println(" 3 :Tìm kiếm theo tên số tiền truy nã ");
            System.out.println(" 0 : trở về " + ANSI_RESET);
            choice2 = scanner.nextInt();
            switch (choice2) {
                case 1:
                    findByName(scanner);
                    break;
                case 2:
                    findByGangs(scanner);
                    break;
                case 3:
                    findByMoney(scanner);
                    break;
                case 0:
                    System.out.println("....................");
                    break;
            }
            if (choice2 < 0 || choice2 > 4) {
                System.out.println("Chưa phát triển chức năng này");
            }
        }
    }

    private static void saveCharacterToFile() {
        try (FileWriter fileWriter = new FileWriter("onePiece.csv")) {
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            StringBuilder str = new StringBuilder("Tên,Tuổi,Trái ác quỷ,Băng nhóm,Tiền truy nã");
            for (int i = 0; i < getManagerCharacter().getListCharacter().size(); i++) {
                str.append("\n").append(getManagerCharacter().getListCharacter().get(i).getName()).append(",").append(getManagerCharacter().getListCharacter().get(i).getAge()).append(",").append(getManagerCharacter().getListCharacter().get(i).getDevilFruit()).append(",").append(getManagerCharacter().getListCharacter().get(i).getGangs()).append(",").append(getManagerCharacter().getListCharacter().get(i).getMoneyRetrieval());
            }
            bufferedWriter.write(str.toString());
            bufferedWriter.close();
        } catch (IOException ignored) {
        }
    }

    private static void managerAccount(Scanner scanner) {
        int choice3 = 88;
        while (choice3 != 0) {
            System.out.println(ANSI_BLUE + "---------------------Menu----------------------" + ANSI_RESET);
            System.out.println(ANSI_PURPLE + " 1 :Hiển thị danh sách tài khoản ");
            System.out.println(" 2 :Thêm tài khoản  ");
            System.out.println(" 3 :Xóa tài khoản ");
            System.out.println(" 4 :Sửa tài khoản ");
            System.out.println(" 5 :Sắp xếp tài khoản theo ngày đăng kí ");
            System.out.println(" 6 :Tìm kiếm tài khoản ");
            System.out.println(" 0 : Trở về " + ANSI_RESET);
            choice3 = scanner.nextInt();
            switch (choice3) {
                case 1:
                    System.out.printf(ANSI_YELLOW + "%-22s %-22s %-20s ", "Tên tài khoản", "Mật khẩu", "Ngày đăng kí");
                    System.out.println();
                    getManagerAccountUser().print();
                    break;
                case 2:
                    MenuLogin.createNewAccount(scanner);
                    MenuLogin.savaAccToFile();
                    readFileAcc();
                    break;
                case 3:
                    System.err.println("Nhập tên tài khoản muốn xóa");
                    scanner.nextLine();
                    String deleteName = scanner.nextLine();
                    getManagerAccountUser().delete(deleteName);
                    MenuLogin.savaAccToFile();
                    readFileAcc();
                    break;
                case 4:
                    editAccount(scanner);
                    MenuLogin.savaAccToFile();
                    readFileAcc();
                    break;
                case 5:
                    System.out.printf(ANSI_YELLOW + "%-22s %-22s %-20s ", "Tên tài khoản", "Mật khẩu", "Ngày đăng kí");
                    System.out.println();
                    getManagerAccountUser().sortDate();
                    break;
                case 6:
                    System.err.println("Nhập tên tài khoản muốn tìm");
                    scanner.nextLine();
                    String findName = scanner.nextLine();
                    getManagerAccountUser().findByName(findName);
                    break;
                case 0:
                    System.out.println(".....................");
                    break;
            }
            if (choice3 < 0 || choice3 > 6) {
                System.out.println("Chưa phát triển chức năng này");
            }
        }
    }

    private static ManagerAccountUser getManagerAccountUser() {
        return ManagerAccountUser.getInstance();
    }

    private static void changeThePassword(Scanner scanner) {
        System.err.println("Nhập lại mật khẩu :");
        scanner.nextLine();
        String pass = scanner.nextLine();
        boolean passTrue = AccountAdmin.getInstance().getPassword().equals(pass);
        if (passTrue) {
            System.err.println("Nhập mật khẩu mới");
            String newPass = scanner.nextLine();
            System.err.println("Nhập lại mật khẩu ");
            String newPass1 = scanner.nextLine();
            if (MenuLogin.validate(newPass)) {
                if (newPass.equals(newPass1)) {
                    AccountAdmin.getInstance().setPassword(newPass);
                    System.err.println("Đã đổi mật khẩu thành công");

                } else System.err.println("Mật khẩu không trùng khớp");

            } else
                System.err.println("Mật khẩu không hợp lệ (Chứa ít nhất 6 kí tự và ko có kí tự đặc biệt )");

        } else System.err.println("Mật khẩu không chính xác ");
    }

    private static void readrCharacter() throws IOException {
        FileReader fileReader = new FileReader("onePiece.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String str1;
        System.out.println("\n------------------------------------------------------------------------------------------------------------------------");
        while ((str1 = bufferedReader.readLine()) != null) {
            String[] str2 = str1.split(",");
            for (String s : str2) {
                System.out.printf(ANSI_YELLOW + "  %-25s|", s + ANSI_RESET);
            }
            System.out.println("\n------------------------------------------------------------------------------------------------------------------------");
        }
        bufferedReader.close();
    }

    public static void readrCRT() throws IOException {
        ArrayList<Character> listCharacter = new ArrayList<>();
        FileReader fileReader = new FileReader("onePiece.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String str1 = bufferedReader.readLine();
        while ((str1 = bufferedReader.readLine()) != null) {
            String[] str2 = str1.split(",");
            String name = str2[0];
            int age = Integer.parseInt(str2[1]);
            String devilFruit = str2[2];
            String gangs = str2[3];
            int money = Integer.parseInt(str2[4]);
            listCharacter.add(new Character(name, age, devilFruit, gangs, money));
        }
        getManagerCharacter().setListCharacter(listCharacter);
        bufferedReader.close();
    }


    private static void readerAccount() {
        try (FileReader fileReader2 = new FileReader("accountUser.csv")) {
            BufferedReader bufferedReader2 = new BufferedReader(fileReader2);
            String str3;
            System.out.println("\n------------------------------------------------------------------------------");
            while ((str3 = bufferedReader2.readLine()) != null) {
                String[] str2 = str3.split(",");

                for (String s : str2) {
                    System.out.printf(ANSI_YELLOW + "  %-27s|", s + ANSI_RESET);
                }
                System.out.println("\n------------------------------------------------------------------------------");
            }
            bufferedReader2.close();
        } catch (IOException i) {
            System.out.println("");
        }
    }

    public static void readFileAcc() {
        ArrayList<AccountUser> list = new ArrayList<>();
        try (FileReader fileReader2 = new FileReader("accountUser.csv")) {
            BufferedReader bufferedReader2 = new BufferedReader(fileReader2);
            String str3 = bufferedReader2.readLine();
            while ((str3 = bufferedReader2.readLine()) != null) {
                String[] str2 = str3.split(",");
                String name = str2[0];
                String pass = str2[1];
                list.add(new AccountUser(name, pass));
            }
            getManagerAccountUser().setListUserAccount(list);
            bufferedReader2.close();
        } catch (IOException i) {
            System.out.println("");
        }
    }

    private static void editAccount(Scanner scanner) {
        System.err.println("Nhập tên tài khoản muốn sửa");
        scanner.nextLine();
        String editName = scanner.nextLine();
        boolean haveAccount = getManagerAccountUser().find(editName) != -1;
        if (haveAccount) {
            System.err.println("Đổi tên tài khoản ");
            String newName = scanner.nextLine();
            System.err.println("Đổi mật khẩu ");
            String newPass = scanner.nextLine();
            System.err.println("Nhập lại mật khẩu ");
            String newPass2 = scanner.nextLine();
            boolean validAccount = MenuLogin.validate(newName) && MenuLogin.validate(newPass2);
            if (validAccount) {
                if (newPass.equals(newPass2)) {
                    getManagerAccountUser().edit(editName, new AccountUser(newName, newPass));
                    System.err.println("Sửa thành công");
                } else System.err.println("Mật khẩu không trùng khớp");
            } else System.err.println("Mật khẩu không hợp lệ (Chứa ít nhất 6 kí tự và ko có kí tự đặc biệt )");
        }else System.out.println("Tài khoản không tồn tại");
    }

    public static void createNewCharacter(Scanner scanner) throws IOException {
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
        getManagerCharacter().add(new Character(newName, newAge, newDevilFruit, newGangs, newMoneyRetrieval));
        saveCharacterToFile();
        readrCRT();
    }

    private static void findByName(Scanner scanner) {
        System.err.println("Nhập tên nhân vật bạn muốn tìm ");
        scanner.nextLine();
        String findName = scanner.nextLine();
        getManagerCharacter().findByName(findName);
    }

    private static void findByGangs(Scanner scanner) {
        System.out.println("Nhập băng nhóm bạn muốn tìm ");
        scanner.nextLine();
        String findGangs = scanner.nextLine();
        getManagerCharacter().findByGangs(findGangs);
    }

    private static void findByMoney(Scanner scanner) {
        System.out.println("Nhập tên nhân vật bạn muốn tìm ");
        scanner.nextLine();
        int findMoney = scanner.nextInt();
        getManagerCharacter().findByMoney(findMoney);
    }
}
