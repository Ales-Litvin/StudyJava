package javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
Читаем и пишем в файл: JavaRush
*/

/*
G:\Test.txt
 */

public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу

        try {
            File yourFile = File.createTempFile("G:\\Test.txt", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user = new User();
            user.setFirstName("Vaska");
            user.setCountry(User.Country.UKRAINE);
            javaRush.users.add(new User());
            User user1 = new User();
            user.setFirstName("Vovka");
            user.setCountry(User.Country.RUSSIA);
            javaRush.users.add(user1);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.users.size());
            System.out.println(loadedObject.users.size());
            if (javaRush.equals(loadedObject)) System.out.println("Объекты равны!");

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            String isUsersNoEmpty = !users.isEmpty() ? "yes" : "no";
            bufferedWriter.write(isUsersNoEmpty); //1
            bufferedWriter.newLine();

            for (User user: users){
                bufferedWriter.write(user.getFirstName() != null ? "yes" : "no"); //2
                bufferedWriter.newLine();
                if (user.getFirstName() != null) {
                    bufferedWriter.write(user.getFirstName()); //3
                    bufferedWriter.newLine();
                }

                bufferedWriter.write(user.getLastName() != null ? "yes" : "no"); //4
                bufferedWriter.newLine();
                if (user.getLastName() != null) {
                    bufferedWriter.write(user.getLastName()); //5
                    bufferedWriter.newLine();
                }

                bufferedWriter.write(user.getBirthDate() != null ? "yes" : "no"); //6
                bufferedWriter.newLine();
                if (user.getBirthDate() != null) {
                    bufferedWriter.write(String.valueOf(user.getBirthDate().getTime())); //7
                    bufferedWriter.newLine();
                }

                bufferedWriter.write(user.isMale() ? "true" : "false"); //8
                bufferedWriter.newLine();

                bufferedWriter.write(user.getCountry() != null ? "yes" : "no"); //9
                bufferedWriter.newLine();
                if (user.getCountry() != null) {
                    bufferedWriter.write(user.getCountry().getDisplayName()); //10
                    bufferedWriter.newLine();
                }
                bufferedWriter.flush();
            }
            bufferedWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод

            //private String firstName;
            //private String lastName;
            //private Date birthDate;
            //private boolean isMale;
            //private User.Country country;

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String isUsersNoEmpty = bufferedReader.readLine();  //1
            if (isUsersNoEmpty.equals("yes")){
                String isFirstName;
                while ((isFirstName = bufferedReader.readLine()) != null){ //2
                    users.add(new User());
                    int thisIndex = users.size() - 1;
                    if (isFirstName.equals("yes"))
                        users.get(thisIndex).setFirstName(bufferedReader.readLine()); //3
                    if (bufferedReader.readLine().equals("yes"))  //4
                        users.get(thisIndex).setLastName(bufferedReader.readLine()); //5
                    if (bufferedReader.readLine().equals("yes")) { //6
                        Date birthDate = new Date(Long.parseLong(bufferedReader.readLine())); //7
                        users.get(thisIndex).setBirthDate(birthDate);
                    }

                        users.get(thisIndex).setMale(bufferedReader.readLine().equals("true")); //8

                    if (bufferedReader.readLine().equals("yes")) { //9
                        String countryName = bufferedReader.readLine(); //10
                        if (countryName.equals("Ukraine"))
                            users.get(thisIndex).setCountry(User.Country.UKRAINE);
                        if (countryName.equals("Russia"))
                            users.get(thisIndex).setCountry(User.Country.RUSSIA);
                        if (countryName.equals("Other"))
                            users.get(thisIndex).setCountry(User.Country.OTHER);
                    }
                }
                bufferedReader.close();
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}