package javarush.task.task05.task0502;
/*
Реализовать метод fight
 */

public class Cat {
    public int age;          // возраст
    public int weight;       // вес
    public int strength;     // возраст

    public Cat() {
    }

        public boolean fight(Cat anotherCat){
            // напишите тут ваш код
            boolean resFight;
            int thisCat = this.age + this.weight + this.strength;
            int thatCat = anotherCat.age + anotherCat.weight + anotherCat.strength;
            if (this.age == anotherCat.age) {
                thisCat++;
                thatCat++;
            }
            else if (this.age > anotherCat.age) {
                thisCat++;
            }
            else {
                thatCat++;
            }
            if (this.weight == anotherCat.weight) {
                thisCat++;
                thatCat++;
            }
            else if (this.weight > anotherCat.weight) {
                thisCat++;
            }
            else {
                thatCat++;
            }
            if (this.strength == anotherCat.strength) {
                thisCat++;
                thatCat++;
            }
            else if (this.strength > anotherCat.strength) {
                thisCat++;
            }
            else {
                thatCat++;
            }

            if (thisCat == thatCat)
                resFight = false;
            else if (thisCat > thatCat)
                resFight = true;
            else
                resFight = false;


            return resFight;
        }

        public static void main(String[] args){
            Cat cat1 = new Cat();
            cat1.age = 1;
            cat1.weight = 1;
            cat1.strength = 1;
            Cat cat2 = new Cat();
            cat2.age = 1;
            cat2.weight = 1;
            cat2.strength = 1;
            System.out.println(cat1.fight(cat2));
            System.out.println(cat2.fight(cat1));
        }
    }
