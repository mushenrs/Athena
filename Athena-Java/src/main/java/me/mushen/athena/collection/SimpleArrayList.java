package me.mushen.athena.collection;

import java.util.ArrayList;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-08-15
 */
public class SimpleArrayList {
    public static void main(String[] args){
        ArrayList<ArrayListItem> arrayList = new ArrayList<>();
        arrayList.add(new ArrayListItem(0, 0));
        arrayList.add(new ArrayListItem(1, 1));

        System.out.println(arrayList.contains(new ArrayListItem(0, 1)));
    }
}

class ArrayListItem{
    int equalVal;
    int hashCodeVal;

    ArrayListItem(int equalVal, int hashCodeVal) {
        this.equalVal = equalVal;
        this.hashCodeVal = hashCodeVal;
    }

    @Override
    public int hashCode(){
        return hashCodeVal;
    }
    @Override
    public boolean equals(Object obj) {
        ArrayListItem item = (ArrayListItem)obj;
        if(this.equalVal == item.equalVal){
            return true;
        }
        return false;
    }
}