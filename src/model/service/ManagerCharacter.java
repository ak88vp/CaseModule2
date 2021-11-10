package model.service;

import model.Character;
import model.service.myInterface.CharacterManager;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Locale;

public class ManagerCharacter implements CharacterManager<Character> {
    ArrayList<Character> listCharacter = new ArrayList<>();
    private static final ManagerCharacter instance = new ManagerCharacter();
    private ManagerCharacter() {
        listCharacter.add(new Character("Công Chúa Shirahoshi", 16, "Không", "Không", 0));
        listCharacter.add(new Character("Chopper", 17, "Hito Hito no mi", "Mũ rơm", 100));
        listCharacter.add(new Character("Công Chúa Vivi", 18, "Không", "Không", 0));
        listCharacter.add(new Character("VinSmoke Sanji", 21, "Không", "Mũ rơm", 330000000));
        listCharacter.add(new Character("Brook", 90, "Yomi Yomi no Mi", "Mũ rơm", 83000000));
        listCharacter.add(new Character("Tashigi", 23, "Không", "Hải Quân G5", 0));
        listCharacter.add(new Character("Smoke", 35, "Không", "Hải Quân G5", 0));
        listCharacter.add(new Character("Bartolomeo", 24, "Kabe Kabe no Mi", "Fan Mũ Rơm", 200000000));
        listCharacter.add(new Character("Law", 26, "Ope Ope no Mi", "Trái Tim", 500000000));
        listCharacter.add(new Character("Boa Hancock", 31, "Mero Mero no Mi", "Kuja", 80000000));
        listCharacter.add(new Character("Teach", 40, "Yami Yami no Mi", "Blackbeard", 224760000));
        listCharacter.add(new Character("Doflamingo", 41, "Hira Hira no Mi", "Donquixote", 340000000));
        listCharacter.add(new Character("Công chúa Rebeca", 16, "Không", "Không", 0));
    }

    public static ManagerCharacter getInstance() {
        return instance;
    }


    public ManagerCharacter(ArrayList<Character> listCharacter) {
        this.listCharacter = listCharacter;
    }

    public ArrayList<Character> getListCharacter() {
        return listCharacter;
    }

    public void setListCharacter(ArrayList<Character> listCharacter) {
        this.listCharacter = listCharacter;
    }

    @Override
    public void sortByMoney() {
        listCharacter.sort(Comparator.comparingInt(Character::getMoneyRetrieval));
        print();
    }

    @Override
    public void sortByAge() {
        listCharacter.sort(Comparator.comparingInt(Character::getAge));
        print();
    }

    @Override
    public void findByGangs(String gangs) {
        for (Character character : listCharacter) {
            boolean isGangs = character.getGangs().trim().toLowerCase(Locale.ROOT).equals(gangs.trim().toLowerCase(Locale.ROOT));
            if (isGangs)
                System.out.println(character);
        }
    }

    @Override
    public void findByMoney(int money) {
        for (Character character : listCharacter) {
            if (character.getMoneyRetrieval() == money)
                System.out.println(character);
        }
    }

    @Override
    public void findByName(String name) {
        int index = -11;
        for (Character character : listCharacter) {
            boolean isName = character.getName().trim().toLowerCase(Locale.ROOT).contains(name.trim().toLowerCase(Locale.ROOT));
            if (isName) {
                System.out.println(character);
                index = 10;
            }
        }
        if (index == -11) {
            System.out.println("Không tìm thấy nhân vật này");
        }

    }

    public int find(String name) {
        for (int i = 0; i < listCharacter.size(); i++) {
            if (listCharacter.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void add(Character character) {
        listCharacter.add(character);
    }

    @Override
    public void print() {
        for (Character character : listCharacter) {
            System.out.println(character);
        }
    }

    @Override
    public void edit(String name, Character character) {
        listCharacter.set(find(name), character);
        print();
    }

    @Override
    public void delete(String name) {
        listCharacter.remove(find(name));
        print();
    }
}
