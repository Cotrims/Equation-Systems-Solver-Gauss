package teclado;

import java.io.*;

/**
 * Classe leitora de teclado. Esta singleton lê e retorna valores diretamente do
 * tecado físico do computador
 * 
 * @author Vinicius Cotrim 19040
 * @author Manuela Benassi 19184
 * @since 2019
 */
public class Teclado {
    protected static BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Retorna uma String do teclado. Após a letura do teclado o valor lido é
     * convertido para String e retornado.
     * 
     * @return Uma String linha lida do teclado.
     */
    public static String getUmString() {
        String ret = null;

        try {
            ret = teclado.readLine();
        } catch (IOException erro) {
        }

        return ret;
    }

    /**
     * Retorna um byte do teclado. Após a letura do teclado o valor lido é
     * convertido para byte e retornado.
     * 
     * @return Um byte lido do teclado.
     */
    public static byte getUmByte() throws Exception {
        byte ret = (byte) 0;

        try {
            ret = Byte.parseByte(teclado.readLine());
        } catch (IOException erro) {
        } catch (NumberFormatException erro) {
            throw new Exception("Byte invalido!");
        }

        return ret;
    }

    /**
     * Retorna um short do teclado. Após a letura do teclado o valor lido é
     * convertido para short e retornado.
     * 
     * @return Um short da linha lida do teclado.
     */
    public static short getUmShort() throws Exception {
        short ret = (short) 0;

        try {
            ret = Short.parseShort(teclado.readLine());
        } catch (IOException erro) {
        } catch (NumberFormatException erro) {
            throw new Exception("Short invalido!");
        }

        return ret;
    }

    /**
     * Retorna um int do teclado. Após a letura do teclado o valor lido é convertido
     * para int e retornado.
     * 
     * @return Um int da linha lida do teclado.
     */
    public static int getUmInt() throws Exception {
        int ret = 0;

        try {
            ret = Integer.parseInt(teclado.readLine());
        } catch (IOException erro) {
        } catch (NumberFormatException erro) {
            throw new Exception("Int invalido!");
        }

        return ret;
    }

    /**
     * Retorna um long do teclado. Após a letura do teclado o valor lido é
     * convertido para long e retornado.
     * 
     * @return Um long da linha lida do teclado.
     */
    public static long getUmLong() throws Exception {
        long ret = 0L;

        try {
            ret = Long.parseLong(teclado.readLine());
        } catch (IOException erro) {
        } catch (NumberFormatException erro) {
            throw new Exception("Long invalido!");
        }

        return ret;
    }

    /**
     * Retorna um float do teclado. Após a letura do teclado o valor lido é
     * convertido para float e retornado.
     * 
     * @return Um float da linha lida do teclado.
     */
    public static float getUmFloat() throws Exception {
        float ret = 0.0F;

        try {
            ret = Float.parseFloat(teclado.readLine());
        } catch (IOException erro) {
        } catch (NumberFormatException erro) {
            throw new Exception("Float invalido!");
        }

        return ret;
    }

    /**
     * Retorna um bouble do teclado. Após a letura do teclado o valor lido é
     * convertido para double e retornado.
     * 
     * @return Um double da linha lida do teclado.
     */
    public static double getUmDouble() throws Exception {
        double ret = 0.0;

        try {
            ret = Double.parseDouble(teclado.readLine());
        } catch (IOException erro) {
        } catch (NumberFormatException erro) {
            throw new Exception("Double invalido!");
        }

        return ret;
    }

    /**
     * Retorna um char do teclado. Após a letura do teclado o valor lido é
     * convertido para char e retornado
     * 
     * @return Um char da linha lida do teclado.
     */
    public static char getUmChar() throws Exception {
        char ret = ' ';

        try {
            String str = teclado.readLine();

            if (str == null)
                throw new Exception("Char invalido!");

            if (str.length() != 1)
                throw new Exception("Char invalido!");

            ret = str.charAt(0);
        } catch (IOException erro) {
        }

        return ret;
    }

    /**
     * Retorna um boolean do teclado. Após a letura do
     * teclado o valor lido é convertido para booelan
     * e retornado.
     * 
     * @return Um boolena da linha lida do teclado.
     */
    public static boolean getUmBoolean() throws Exception {
        boolean ret = false;

        try {
            String str = teclado.readLine();

            if (str == null)
                throw new Exception("Boolean invalido!");

            if (!str.equals("true") && !str.equals("false"))
                throw new Exception("Boolean invalido!");

            ret = Boolean.parseBoolean(str);
        } catch (IOException erro) {
        }

        return ret;
    }
}