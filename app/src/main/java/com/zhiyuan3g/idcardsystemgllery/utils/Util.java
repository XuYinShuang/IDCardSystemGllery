package com.zhiyuan3g.idcardsystemgllery.utils;

import android.os.Environment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;

/**
 * Created by Administrator on 2016/7/19.
 */
public class Util {

    public static boolean WriteFile(String data) {

        boolean result = false;
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            String path = Environment.getExternalStorageDirectory().getAbsolutePath();

            //创建文件夹，separator分隔符
            String dataPath = path + File.separator + "aaIDCardSystem";

            String p = dataPath + File.separator + "aainformation.txt";

            try {
                File file = new File(dataPath);
                File filePath = new File(p);

                if (!file.exists()) {
                    file.mkdirs();
                }
                if (!filePath.exists()) {
                    filePath.createNewFile();
                }

                FileOutputStream outputStream = new FileOutputStream(p, true);

                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
                BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
                //存数据

                bufferedWriter.write(data);
                //换行，以便于管理数据
                bufferedWriter.newLine();
                bufferedWriter.flush();
                bufferedWriter.close();

                result = true;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static String ReadData() {
        String allData = "";
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            String path = Environment.getExternalStorageDirectory().getAbsolutePath();

            //创建文件夹，separator分隔符
            String dataPath = path + File.separator + "aaIDCardSystem";

            String p = dataPath + File.separator + "aainformation.txt";

            try {
                File file = new File(p);
                if (file.exists()) {
                    FileReader fileReader = new FileReader(file);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);

                    String line = "";
                    while ((line = bufferedReader.readLine()) != null) {
                        allData += line + "/";

                        allData = allData.trim();

                    }
                    bufferedReader.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return allData;
    }
}
