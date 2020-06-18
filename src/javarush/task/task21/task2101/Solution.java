package javarush.task.task21.task2101;

/*
Определяем адрес сети
*/

import java.io.UnsupportedEncodingException;

public class Solution {
    public static void main(String[] args) throws UnsupportedEncodingException {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        byte[] result = new byte[ip.length];
        for (int i = 0; i < ip.length; i++){
            result[i] = (byte) (ip[i] & mask[i]);
        }
        return result;
    }

    public static void print(byte[] bytes) throws UnsupportedEncodingException {
        for (byte i : bytes){
            String string = Integer.toBinaryString(i & 255);
            String zeroString = "0";
            while (string.length() < 8){
                string = zeroString.concat(string);
            }
            System.out.print(string + " ");
        }
        System.out.print("\n");

    }
}