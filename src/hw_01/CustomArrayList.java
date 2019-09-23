package hw_01;

import javax.naming.OperationNotSupportedException;
import java.util.Arrays;

public class CustomArrayList<T> implements List<T> {

    private Object[] intList;
    private int size;

    public CustomArrayList() {
        this.intList =  new Object[10];
        this.size =0;
    }

    // Добавления нового значения
    @Override
    public void add(T value) {
        if(size ==intList.length)extend();
        intList[size++]=value;
    }

    // Хз чего тут делать
    @Override
    public void add(T value, int index) {
        throw new UnsupportedOperationException("Хз что делать в этом методе.");

    }

    // Добавляет список к существующему
    @Override
    public void addAll(List<T> list) {

        boolean endOfList=false;
        int num=0;
        while (!endOfList){
            try {
                add(list.get(num++));
            } catch (Exception e) {
                e.printStackTrace();
                endOfList=true;
            }
        }
    }

    // Получение конкретного значения по индексу
    @Override
    public T get(int index) throws IndexOutOfBoundsException{
        checkIndex(index);
        return (T)intList[index];
    }

    // Добавление нового значения по указанному индексу, остальные значения следующие за индексом сдвигаются в право
    @Override
    public void set(T value, int index) throws IndexOutOfBoundsException{
        checkIndex(index);
        size++;
        if(size >=intList.length)extend();
        for (int i = size; i >index ; i--) {
            intList[i]=intList[i-1];
        }
        intList[index]=value;
    }

    // Удаления значения по индексу, остальные значения следующие за индексом сдвигаются в лево
    @Override
    public T remove(int index) throws IndexOutOfBoundsException {
        checkIndex(index);

        T value=get(index);
        for (int i = index; i <size ; i++) {
            intList[i]=intList[i+1];
        }

        // set null value to last item
        intList[--size]=null;

        return value;
    }

    // Удаления первого найденого значения Т
    @Override
    public T remove(T t) throws OperationNotSupportedException {
        int index=-1;
        for (int i = 0; i < size; i++) {
            if(t.equals(intList[i])){
                index=i;
                break;
            }
        }
        if(index==-1)throw new OperationNotSupportedException("Value not found in the array");
        return remove(index);
    }


    @Override
    public String toString() {
        String result="{[";
        for (int i = 0; i < size; i++) {
            result+="{"+i+": \""+intList[i].toString()+"\"},";
        }
        result=result.substring(0,result.length()-1);
        result+="]}";
        return result;
    }

    // Проверка нахождения значения индекса в пределах заполненных значений массива
    private void checkIndex(int index) throws IndexOutOfBoundsException {
        if(index> size)
        {
            throw new IndexOutOfBoundsException("Index out of range");
        }
    }

    // Расширение массива
    private void extend(){
        int newSize=intList.length*2;
        Object[] newList= Arrays.copyOf(intList,newSize);
        intList=newList;
    }
}
