package pl.bartus.benzo.enzo.cryptoMsgService.resource.util;

import java.util.Random;

public final class IDGenerator {
    private static char[] generateAlphabetAndNumbers() {
        char[] array = new char[36];
        int index = 0;

        for (char c = 'a'; c <= 'z'; c++) {
            array[index++] = c;
        }

        for (char c = '0'; c <= '9'; c++) {
            array[index++] = c;
        }

        return array;
    }
    public static String generateId(){
        char[] array = generateAlphabetAndNumbers();
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            char randomChar = array[random.nextInt(array.length)];
            sb.append(randomChar);
        }
        return sb.toString();
    }
}
