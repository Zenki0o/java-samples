import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorOne {

    public static class Puppy {
        public final String name;
        public final int age;

        public Puppy(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Puppy{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static class PuppyNameComparator implements Comparator<Puppy> {

        @Override
        public int compare(Puppy puppy1, Puppy puppy2) {
            return String.CASE_INSENSITIVE_ORDER.compare(puppy1.name, puppy2.name);
        }
    }


    public static void main(String[] args) {
        List<Integer> listOfIntegers = new ArrayList<>();
        listOfIntegers.add(1);
        listOfIntegers.add(3);
        listOfIntegers.add(2);

        // класс Integer реализует Comparable
        System.out.println(Collections.max(listOfIntegers));
        System.out.println(Collections.min(listOfIntegers));

        /* Класс Puppy не реализует Comparable, 
        поэтому для поиска минимума и максимума необходимо передать Comparator. */
        List<Puppy> puppies = new ArrayList<>();
        puppies.add(new Puppy("Борис", 4));
        puppies.add(new Puppy("Гаф", 3));
        puppies.add(new Puppy("Изольда", 2));

        PuppyNameComparator comparator = new PuppyNameComparator();
        System.out.println(Collections.max(puppies, comparator));
        System.out.println(Collections.min(puppies, comparator));
    }
}