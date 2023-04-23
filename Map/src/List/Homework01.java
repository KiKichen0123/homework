package List;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 陈淇淇
 * @version 1.8
 */
public class Homework01 {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new News("新冠确证病例超千万，" +
                "数百万印度教信徒赴恒河\"圣浴\"引民众担忧"));
        list.add(new News("男子突然想起2个月前钓的鱼还在网兜里，" +
                "捞起一看赶紧放生"));
        System.out.println("----------------处理前的标题----------------");
        System.out.println(list);
        System.out.println("----------------处理后的标题----------------");
        reverse(list);
    }

    public static void reverse(List list){
        int listSize = list.size();
        for(int i = listSize-1;i>=0;i--){
//            System.out.println(list.get(i));
            News news = (News) list.get(i);
            System.out.println(processTitle(news.getTitle()));
        }
    }

    public static String processTitle(String title){
        if(title == null){
            return "";
        }

        if(title.length()>15){
            return title.substring(0,15) + "...";
        }else{
            return title;
        }
    }
}

 class News{
    private String title;
    private String content;

     public News(String title) {
         this.title = title;
     }

     public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "title='" + title + '\'';
    }
}
