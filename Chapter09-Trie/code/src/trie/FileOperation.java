package trie;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName FileOperation
 * @Description �ļ�������
 * @Date 2018/5/19 21:22
 */
public class FileOperation {

    public static boolean readFile(String filename, ArrayList<String> words) {
        if (filename == null || words == null) {
            System.out.println("filename is null or words is null");
            return false;
        }
        // �ļ���ȡ
        Scanner scanner = null;

        try {
            File file = new File(filename);
            if (file.exists()) {
                FileInputStream fis = new FileInputStream(file);
                scanner = new Scanner(new BufferedInputStream(fis), "UTF-8");
                scanner.useLocale(Locale.ENGLISH);
            } else {
                return false;
            }
        } catch (IOException ioe) {
            System.out.println("Cannot open " + filename);
            return false;
        }

        // �򵥷ִ�
        // ����ִʷ�ʽ��Լ�ª, û�п��Ǻܶ��ı������е���������
        // ������ֻ��demoչʾ��
        if (scanner.hasNextLine()) {

            String contents = scanner.useDelimiter("\\A").next();

            int start = firstCharacterIndex(contents, 0);
            for (int i = start + 1; i <= contents.length(); ) {
                if (i == contents.length() || !Character.isLetter(contents.charAt(i))) {
                    String word = contents.substring(start, i).toLowerCase();
                    words.add(word);
                    start = firstCharacterIndex(contents, i);
                    i = start + 1;
                } else {
                    i++;
                }
            }
        }

        return true;
    }


    /**
     * Ѱ���ַ���s�У���start��λ�ÿ�ʼ�ĵ�һ����ĸ�ַ���λ��
     *
     * @param s     �ַ���s
     * @param start ������ʼ��λ��
     * @return
     */
    private static int firstCharacterIndex(String s, int start) {

        for (int i = start; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                return i;
            }
        }
        return s.length();
    }

}