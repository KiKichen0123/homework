package List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * @author 陈淇淇
 * @version 1.8
 */
public class ListExercise02 {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new Book("三国演义",100,"罗贯中"));
        list.add(new Book("红楼梦",98,"曹雪芹"));
        list.add(new Book("水浒传",120,"施耐庵"));

        for (Object o :list) {
            System.out.println(o);
        }

        sort(list);

        System.out.println("--------------------排序后--------------------");

        for (Object o :list) {
            System.out.println(o);
        }

    }

    public static void sort(List list){
        int listSize = list.size();
        for(int i = 0;i<listSize -1;i++){
            for(int j = 0;j<listSize -1 -i;j++){
                Book book1 = (Book)list.get(j);
                Book book2 = (Book)list.get(j+1);
                if(book1.getPrice() > book2.getPrice()){
                    list.set(j,book2);
                    list.set(j+1,book1);
                }
            }
        }
    }
}

class Book{
    private String name;
    private int price;
    private String author;

    public Book(String name, int price, String author) {
        this.name = name;
        this.price = price;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "\n名称：'" + name + '\'' +
                "" +
                "\t价格:" + price +
                "\t作者：" + author + '\'';
    }
}
