package hw_01;

import java.util.Arrays;

public class CostomArrayList<T> implements List<T> {

    private Object[] intList;
    private int size;

    public CostomArrayList() {
        this.intList =  new Object[10];
        this.size =0;
    }

    @Override
    public void add(T value) {
        if(size ==intList.length)extend();
        intList[size++]=value;

    }

    @Override
    public void add(T value, int index) {
        while (index>intList.length){
            extend();
        }
    }

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

    @Override
    public T get(int index) throws IndexOutOfBoundsException{
        checkIndex(index);
        return (T)intList[index];
    }

    // Insert new value end shift other values
    @Override
    public void set(T value, int index) throws IndexOutOfBoundsException{
        checkIndex(index);
        if(size ==intList.length+1)extend();
        for (int i = index; i <size ; i++) {
            intList[i+1]=intList[i];
        }
        intList[index]=value;
    }

    // Remove value and shift other values
    @Override
    public T remove(int index) throws IndexOutOfBoundsException {
        checkIndex(index);

        T value=get(index);
        for (int i = index; i <size ; i++) {
            intList[i]=intList[i+1];
        }

        // set null value to last item
        intList[size-1]=null;

        return value;
    }

    // Remove first founded T value
    @Override
    public T remove(T t) {
        int index=-1;
        for (int i = 0; i < size; i++) {
            if(t.equals(intList[i])){
                index=i;
                break;
            }
        }             
        return remove(index);
    }

    // Check index in array
    private void checkIndex(int index) throws IndexOutOfBoundsException {
        if(index> size)
        {
            throw new IndexOutOfBoundsException("Index out of range");
        }
    }

    // Extend array
    private void extend(){
        int newSize=intList.length*2;
        Object[] newList= Arrays.copyOf(intList,newSize);
        intList=newList;
    }
}
