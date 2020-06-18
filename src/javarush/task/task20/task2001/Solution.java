package javarush.task.task20.task2001;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
G:\Test.txt
 */

/*
Читаем и пишем в файл: Human
*/
public class Solution {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("G:\\Test.txt", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ivanov", new Asset("home", 999_999.99), new Asset("car", 2999.99));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();

            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            if (ivanov.equals(somePerson)){
                System.out.printf("Ура объект: %s, равен объекту %s", ivanov.toString(), somePerson.toString());
            }


        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            String isNamePresents = name != null ? "yes" : "no";
            bufferedWriter.write(isNamePresents);
            bufferedWriter.newLine();
            bufferedWriter.write(name);
            bufferedWriter.newLine();
            bufferedWriter.flush();


            String isAssetsPresents = !assets.isEmpty() ? "yes" : "no";
            bufferedWriter.write(isAssetsPresents);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            if (!assets.isEmpty()){
                for (Asset asset: assets){
                    String assetName = asset.getName();
                    double assetPrice = asset.getPrice();
                    bufferedWriter.write(assetName);
                    bufferedWriter.newLine();
                    bufferedWriter.write(String.valueOf(assetPrice));
                    bufferedWriter.newLine();
                }
            }
            bufferedWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            if (bufferedReader.readLine().equals("yes"))
            name = bufferedReader.readLine();

            String assetName;
            int count = 0;
            if (bufferedReader.readLine().equals("yes")){
                while ((assetName = bufferedReader.readLine()) != null)       {
                    assets.add(count, new Asset(assetName, Double.parseDouble(bufferedReader.readLine())));
                    count++;
                }
            }
            bufferedReader.close();
        }
    }
}