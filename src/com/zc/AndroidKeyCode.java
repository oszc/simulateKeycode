package com.zc;



import com.zc.utils.OSinfo;

import java.io.*;
import java.util.Map;

/**
 * 7/21/15  3:02 PM
 * Created by JustinZhang.
 */
public class AndroidKeyCode  implements  KeyCodeInterface{
    private String adbPath = null;
    private String fileName = "adb.conf";
    private String winPath = "c://adb.txt"+File.separator+fileName;
    private String linuxPath = "/etc"+File.separator+fileName;
    private String winErrorMsg = "请在c盘根目录中找到或创建adb.conf，将adb目录复制到该配置文件中";
    private String linuxErrorMsg = "请在/etc目录中找到或创建adb.conf，将adb目录复制到该配置文件中";

    @Override
    public String up() {
        return exec(19);
    }

    @Override
    public String left() {
        return exec(21);
    }

    @Override
    public String right() {
        return exec(22);
    }

    @Override
    public String down() {
        return exec(20);
    }

    @Override
    public String center() {
        return exec(23);
    }

    @Override
    public String back() {
        return exec(4);
    }

    @Override
    public String home() {
        return exec(3);
    }

    @Override
    public String power() {
        return exec(26);
    }

    @Override
    public String zero() {
        return exec(7);
    }

    @Override
    public String one() {
        return exec(8);
    }

    @Override
    public String two() {
        return exec(9);
    }

    @Override
    public String three() {
        return exec(10);
    }

    @Override
    public String four() {
        return exec(11);
    }

    @Override
    public String five() {
        return exec(12);
    }

    @Override
    public String six() {
        return exec(13);
    }

    @Override
    public String seven() {
        return exec(14);
    }

    @Override
    public String eight() {
        return exec(15);
    }

    @Override
    public String nine() {
        return exec(16);
    }

    @Override
    public String delete() {
        return exec(67);
    }

    @Override
    public String enter() {
        return exec(66);
    }

    @Override
    public String exec(int keycode) {
        try {

           // String cmd = "/Users/JustinZhang/Documents/adt-bundle-mac-x86_64-20130917/sdk/platform-tools/adb shell input keyevent "+keycode;

          //  String[] cmdHeader = {"/Users/JustinZhang/Documents/adt-bundle-mac-x86_64-20130917/sdk/platform-tools/adb shell input keyevent "+keycode};

            if(adbPath ==null || adbPath.length()==0) {
                if (OSinfo.isWindows()) {

                    if (!getAdbPath(winPath))
                        return winErrorMsg;


                } else {

                    if (!getAdbPath(linuxPath)) {
                        return linuxErrorMsg;
                    }
                }
            }

            String[] cmd = {adbPath,"shell","input", "keyevent" , keycode+""};
            ProcessBuilder builder= new ProcessBuilder(cmd);


          //  Map<String, String> environment = builder.environment();

            Process process = builder.start();

            /*
            // Process process = Runtime.getRuntime().exec(cmd);



            */
            BufferedInputStream in = new BufferedInputStream(process.getErrorStream());
            BufferedReader inBr = new BufferedReader(new InputStreamReader(in));
            String lineStr;
            StringBuilder sb = new StringBuilder();
            while ((lineStr = inBr.readLine())!=null){
                System.out.println(lineStr);
                sb.append(lineStr);
            }

            if (process.waitFor() != 0) {
                if (process.exitValue() == 1)//p.exitValue()==0表示正常结束，1：非正常结束
                    System.err.println("命令执行失败!");
            }
            inBr.close();
            in.close();



            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private boolean getAdbPath(String filePath) {

        BufferedReader reader = null;
        try {
            File f = new File(filePath);
            if (!f.exists()) {
                boolean newFileCreate = f.createNewFile();
                return false;
            }

            reader = new BufferedReader(new FileReader(f));
            adbPath = reader.readLine().trim();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(null!=reader) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        if(adbPath == null || adbPath.length() == 0){
            return false;
        }else {
            return true;
        }
    }
}
