import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// класс может реализовать Comparable<T> только один раз
class ComparableOne implements Comparable<ComparableOne> {
    private final String name;
    private final int age;

    public ComparableOne(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // переопределяем compareTo - студенты будут сравниваться по имени и по возрасту
    @Override
    public int compareTo(ComparableOne o) {
        final int nameComparison = String.CASE_INSENSITIVE_ORDER.compare(this.name, o.name);
        if (nameComparison != 0) {
            return nameComparison;
        } else {
            return Integer.compare(this.age, o.age);
        }
    }

    @Override
    public String toString() {
        return "ComparableOne{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        final ComparableOne a = new ComparableOne("aaa", 30);
        final ComparableOne b = new ComparableOne("aaa", 27);
        final ComparableOne c = new ComparableOne("ccc", 33);

        final ComparableOne d = new ComparableOne("ddd", 21);

        // создаём изменяемый список из неизменяемого List.of(..)
        final List<ComparableOne> list = new ArrayList<>(List.of(a, b, c, d));
        Collections.sort(list);
        System.out.println(list);

        // выводим минимальный элемент в соответствии с правилами сортировки Comparable<ComparableOne>
        // так как список предварительно отсортирован, минимальным будет первый элемент
        System.out.println(Collections.min(list));

        // теперь напечатаем максимальный элемент
        System.out.println(Collections.max(list));
    }
}

