import java.util.*;

public class ArrDeque {

    private final static Random random = new Random();
    private ArrayDeque<String> namesList;
    private ArrayList<Long> nanoTimes = new ArrayList<>();
    public ArrDeque(int num) {
        this.namesList = (ArrayDeque<String>) addNames(num);
    }
    //public static List<String>  test = new ArrayList<>(); //для проверки getFirstNameList()

    private ArrayDeque<String> addNames(int num) {
        String[] names = {"Андрей", "Ирина", "Полина", "Татьяна", "Сергей", "Екатерина",
                "Марина", "Николай", "Артем", "Иван", "Павел", "Елена", "Семен", "Роман", "Наталья",
                "Антон", "Александр", "Алексей", "Игорь", "Олеся"};
        ArrayDeque<String> namesList = new ArrayDeque<>();
        long start = System.nanoTime();
        for (int i = 0; i < num; i++) {
            namesList.addLast(names[random.nextInt(0, names.length - 1)]);
        }
        nanoTimes.add(System.nanoTime() - start);
        return namesList;
    }
    private void getFirstNameList() {
       long start = System.nanoTime();
        Iterator iterator = namesList.iterator();
        int i = 0;
        double limit = Math.ceil(namesList.size() * 0.05);
        while(iterator.hasNext() && i <= limit ) {  //&& i <= limit
            iterator.next();  //test.add("" + iterator.next());  проверяла добавлением в список - все работает
            i++;
        }
        nanoTimes.add(System.nanoTime() - start);
    }
    private void getLastNameList() {
        long start = System.nanoTime();
        Iterator descendingIterator = namesList.descendingIterator();
        int i = 0;
        double limit = Math.ceil(namesList.size() * 0.05);
        while(descendingIterator.hasNext() && i <= limit ) {  //&& i <= limit
            descendingIterator.next(); //test.add("" + descendingIterator.next());
            i++;
        }
        nanoTimes.add(System.nanoTime() - start);
    }
    private void removeFirstNameList() {
        long start = System.nanoTime();
        for (int i = 0; i < namesList.size() * 0.05; i++) {
            namesList.pop();  //or pollFirst()
        }
        nanoTimes.add(System.nanoTime() - start);
    }
    private void removeLastNameList() {
        long start = System.nanoTime();
        for (int i = 0; i < namesList.size() * 0.05; i++) {
            namesList.pollLast();
        }
        nanoTimes.add(System.nanoTime() - start);
    }
    private void nameReplacement() {
        long start = System.nanoTime();
        namesList.pollLast();       //заменим последний элемент
        namesList.addLast("Jack");
        nanoTimes.add(System.nanoTime() - start);
    }
    private void removeRandomName() {
        long start = System.nanoTime();
        namesList.removeFirstOccurrence("Jack");
        nanoTimes.add(System.nanoTime() - start);
    }

    public ArrayList<Long>  start() {

        getFirstNameList();
        getLastNameList();
        removeFirstNameList();
        removeLastNameList();
        nameReplacement();
        removeRandomName();
        System.out.println();

        return nanoTimes;
    }
}
