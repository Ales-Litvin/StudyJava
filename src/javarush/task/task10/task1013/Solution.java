package javarush.task.task10.task1013;

/*
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // Напишите тут ваши переменные и конструкторы
        private String name;
        private String first_name;
        private int age;
        private String land;
        private String city;
        private String nationality;

        public Human(String name, String first_name, int age, String land, String city, String nationality){
            this.name = name;
            this.first_name = first_name;
            this.age = age;
            this.land = land;
            this.city = city;
            this.nationality = nationality;
        }

        public Human(String name, int age, String land, String city, String nationality){
            this.name = name;
            this.first_name = null;
            this.age = age;
            this.land = land;
            this.city = city;
            this.nationality = nationality;
        }

        public Human(int age, String land, String city, String nationality){
            this.name = null;
            this.first_name = null;
            this.age = age;
            this.land = land;
            this.city = city;
            this.nationality = nationality;
        }

        public Human(String land, String city, String nationality){
            this.name = null;
            this.first_name = null;
            this.age = 31;
            this.land = land;
            this.city = city;
            this.nationality = nationality;
        }

        public Human(String name, String first_name, int age, String land, String city){
            this.name = name;
            this.first_name = first_name;
            this.age = age;
            this.land = land;
            this.city = city;
            this.nationality = "litvin";
        }

        public Human(String name, String first_name, int age, String land){
            this.name = name;
            this.first_name = first_name;
            this.age = age;
            this.land = land;
            this.city = null;
            this.nationality = null;
        }

        public Human(String name, String first_name){
            this.name = name;
            this.first_name = first_name;
            this.age = 33;
            this.land = "ВКЛ";
            this.city = null;
            this.nationality = "Литьвин";
        }

        public Human(String name){
            this.name = name;
            this.first_name = null;
            this.age = 34;
            this.land = "ВКЛ";
            this.city = null;
            this.nationality = null;
        }

        public Human(String name, String first_name, int age){
            this.name = name;
            this.first_name = first_name;
            this.age = age;
            this.land = null;
            this.city = null;
            this.nationality = null;
        }

        public Human(){
        }
    }
}