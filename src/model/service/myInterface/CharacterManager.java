package model.service.myInterface;
import model.Character;
public interface CharacterManager<T> extends Manager < Character>{
    void sortByMoney();
    void sortByAge();
    void findByGangs(String gangs);
    void findByMoney(int money);
    void findByName(String name);
}
