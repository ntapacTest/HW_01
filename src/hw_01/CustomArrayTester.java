package hw_01;

import javax.naming.OperationNotSupportedException;

public class CustomArrayTester {

    public static void main(String[] args) {

        // Проверка метода add
        List<String> strList=new CustomArrayList<>();

        strList.add("a");
        strList.add("b");
        strList.add("c");
        strList.add("d");
        strList.add("e");

        System.out.println("strList = " + strList);

        // Проверка метода add с индексом, не реализован
        //strList.add("err1",7); Not implemented

        // Проверка метода set, индекс вне проделов массива, должна быть ошибка
        try{
            strList.set("err",8);
        }
        catch (Exception e){
            System.out.println("IndexOutOfBounds error. Ok.");
        }

        // Проверка метода set
        strList.set("insert_1",3);
        System.out.println("strList = " + strList);

        // Проверка метода remove, индекс вне проделов массива, должна быть ошибка
        try{
            strList.remove(12);
        }
        catch (Exception e){
            System.out.println("IndexOutOfBounds error. Ok.");
        }

        // Проверка метода remove
        strList.remove(3);
        System.out.println("strList = " + strList);

        strList.add("f");
        strList.add("g");
        strList.add("h");
        strList.add("i");
        strList.add("j");


        // Проверка расширения массива после добавления следующего элемента
        strList.add("k");
        System.out.println("strList = " + strList);

        // Новый массив
        strList=new CustomArrayList<>();
        strList.add("a");
        strList.add("b");
        strList.add("c");
        strList.add("d");
        strList.add("e");
        strList.add("f");
        strList.add("g");
        strList.add("h");
        strList.add("i");
        strList.add("j");
        System.out.println("strList = " + strList);

        // // Проверка расширения массива после вставки следующего элемента
        strList.set("insert_2",8);
        System.out.println("strList = " + strList);

        // Новый массив
        strList=new CustomArrayList<>();
        strList.add("a");
        strList.add("b");
        strList.add("c");
        strList.add("d");
        strList.add("e");

        // Новый массив 2
        List<String> strList2=new CustomArrayList<>();
        strList2.add("a2");
        strList2.add("b2");
        strList2.add("c2");
        strList2.add("d2");
        strList2.add("e2");
        strList2.add("f2");
        strList2.add("g2");
        strList2.add("h2");
        strList2.add("i2");
        strList2.add("j2");

        // Проверка метода addAll + проверка расширения массива
        strList.addAll(strList2);

        System.out.println("strList = " + strList);

        // Проверка remove по значению
        try {
            strList.remove("g2");
        } catch (OperationNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println("strList = " + strList);

        // Проверка метода remove значение отстутствует в массиве
        try {
            strList.remove("notExist");
        } catch (OperationNotSupportedException e) {
            System.out.println("Value not found. Ok.");
        }
    }
}
