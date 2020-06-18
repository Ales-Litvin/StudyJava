package javarush.task.task05.task0526;

public class Solution {

    public static void main(String[] args) {
        Man man1 = new Man("man1", 32, "Berlin");
        Man man2 = new Man("man2", 22, "Paris");

        Woman woman1 = new Woman("woman1", 22, "Minsk");
        Woman woman2 = new Woman("woman2", 24, "Vilno");

        System.out.println(man1.toString());
        System.out.println(man2.toString());
        System.out.println(woman1.toString());
        System.out.println(woman2.toString());
    }

    public static class Man {
        String name;
        int age;
        String address;

        @Override
        public String toString() {
            return this.name + " " + age + " " + address;
        }

        public Man(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }
    }

    public static class Woman {
        String name;
        int age;
        String address;

        @Override
        public String toString() {
            return this.name + " " + age + " " + address;
        }

        public Woman(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }
    }
}

