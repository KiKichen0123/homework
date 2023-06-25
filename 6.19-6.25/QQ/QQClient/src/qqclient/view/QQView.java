package qqclient.view;

import qqclient.utils.Utility;

/**
 * 该程序的说明如下：
 * 客户端的菜单界面
 */
public class QQView {
    private boolean loop = true;    //控制是否显示菜单
    private String key = "";    //接收用户的键盘输入

    public static void main(String[] args) {
        new QQView().mainMenu();
        System.out.println("客户端退出系统.......");
    }

    //显示主菜单
    private void mainMenu(){
        while(loop){
            System.out.println("============欢迎登录网络通信系统============");
            System.out.println("\t\t 1 登录系统");
            System.out.println("\t\t 9 退出系统");
            System.out.print("请输入你的选择：");
            key = Utility.readString(1);    //读一个字符

            switch (key){
                case "1":
                    System.out.print("请输入用户名：");
                    String userId = Utility.readString(50);
                    System.out.print("请输入密  码：");
                    String pwd = Utility.readString(50);
                    //这里需要到服务端去验证该用户是否合法
                    //这里编写一个类 UserClientService[用户登录/注册]
                    if(true){
                        System.out.println("===============欢迎（用户"+userId+" 登录成功）===============");
                        //进入到二级菜单
                        while(loop){
                            System.out.println("\n===========网络通信系统二级菜单（用户 "+ userId +")===========");
                            System.out.println("\t\t 1 显示在线用户列表");
                            System.out.println("\t\t 2 群发消息");
                            System.out.println("\t\t 3 私聊消息");
                            System.out.println("\t\t 4 发送消息");
                            System.out.println("\t\t 9 退出系统");
                            System.out.println("请输入你的选择：");
                            key = Utility.readString(1);
                            switch (key){
                                case "1":
                                    break;
                                case "2":
                                    break;
                                case "3":
                                    break;
                                case "4":
                                    break;
                                case "9":
                                    loop=false;
                                    break;
                            }
                        }
                    }else{
                        System.out.println("============登录失败=============");
                    }
                    break;
                case "9":
                    loop = false;
                    break;
            }
        }
    }
}
