package jw;

import javax.crypto.NoSuchPaddingException;
import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static File CurrentFile = new File(System.getProperty("user.dir"));
    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IOException {
        Scanner scanner = new Scanner(System.in);
        FileMethod fileMethod = new FileMethod();
        System.out.println("欢迎使用文件管理系统！");
        System.out.println("mkdir:新建文件夹 输入格式：mkdir name");
        System.out.println("mkFile:新建文件 输入格式：mkFile name");
        System.out.println("del:删除文件夹或文件(delete name)");
        System.out.println("open:打开文件(open name)");
        System.out.println("dir:展示当前所在文件夹内容罗列\n输入格式：dir (by 'name/time(按时间从前往后)/byte(按字节数升序)')选写，默认按字母表顺序罗列");
        System.out.println("cd:路径跳转(cd 'path')");
        System.out.println("cd ..:返回上一级目录");
        System.out.println("copy:复制文件或文件夹(copy name)");
        System.out.println("paste:粘贴文件夹 \n输入格式：paste folder(目标路径) in front(前台运行)/back(后台运行)");
        System.out.println("encrypt:文件或文件夹加密(encrypt name to newName)");
        System.out.println("decrypt:解密(decrypt name to newName)");
        System.out.println("zip:文件或文件夹压缩(zip name)");
        System.out.println("unzip:解压缩(unzip name)");
        System.out.println("exit:退出");
        String command = "begin";
        // 执行显示系统主菜单
        String[] arg;
        while(true){
            System.out.print(CurrentFile.getAbsolutePath()+": ");
            command = scanner.nextLine();
            if (command.equals("exit"))
            {
                System.out.println("感谢使用！");
                break;
            }
            if(command.contains("  ")){
                System.out.println("输入命令中不能包含两个空格！");
                break;
            }
            arg = command.split(" ");
            commandDeal(arg,CurrentFile,fileMethod);
        }
    }
    public static void commandDeal(String[] arg,File currentFile,FileMethod fileMethod) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IOException {
        String file = currentFile.getAbsolutePath();
        String name = currentFile.getName();
        String parentFile = currentFile.getParentFile().getAbsolutePath(); //记录上一级目录 用于dir指令
        String choice = arg[0];
        switch (choice) {
            case "mkdir":
                fileMethod.mkdir(file, arg[1]);
                break;
            case "mkFile":
                fileMethod.mkFile(file, arg[1]);
                break;
            case "del":
                fileMethod.delete(file, arg[1]);
                break;
            case "open":
                fileMethod.open(file, arg[1]);
                break;
            case "dir":
                fileMethod.show(parentFile, arg, name);
                break;
            case "cd":
                CurrentFile = fileMethod.changeDirection(arg[1], CurrentFile);
                break;
            case "copy":
                fileMethod.copy(file, arg[1]);
                break;
            case "paste":
                fileMethod.paste(file, arg);
                break;
            case "encrypt":
                fileMethod.encrypt(file, arg);
                break;
            case "decrypt":
                fileMethod.decrypt(file, arg);
                break;
            case "zip":
                fileMethod.zip(file, arg[1]);
                break;
            case "unzip":
                fileMethod.unzip(file, arg[1]);
                break;
            default:
                System.out.println("当前指令未匹配");
                break;
        }
    }
}
