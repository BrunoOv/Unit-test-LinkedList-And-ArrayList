package uaslp.objetos.list.List.ArrayList;

import uaslp.objetos.list.List.Iterator;
import uaslp.objetos.list.List.List;

public class ArrayList implements List {
    private String[] data;
    private int size;

    public ArrayList(){
        data = new String[2];
    }

    public void addAtTail(String data){
        if(size==this.data.length){
            this.data=increaseArraySize();
        }
        this.data[size] = data;
        size++;
    }
    public void addAtFront(String data){
        if(size == this.data.length ){
            this.data=increaseArraySize();
        }
        for(int i = size; i> 0; i--){
            this.data[i] = this.data[i-1];
        }
        this.data[0] = data;
        size++;
    }
    public boolean remove(int indexToRemove){
        if(indexToRemove < 0 || indexToRemove >= size) {return false;}
        for(int i = indexToRemove; i< size-1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        data[size] = null;
        return true;
    }

    public void removeAll(){
        for(int i = 0; i < size; i++){
            data[i] = null;
        }
        size = 0;
    }
    public boolean setAt(int index, String data){
        if(index < 0 || index >= size){
            return false;
        }
        this.data[index] = data;
        return true;
    }

    public String getAt(int index) {
        if(index < 0 || index >= size){
            return null;
        }
        return this.data[index];
    }
    public boolean removeAllWithValue(String value){
        if(size==0){
            return false;
        }
        String[] newArray = new String[data.length];
        int count = 0;
        for(int i = 0; i<size; i++){
            if (!data[i].equals(value)){
                newArray[count++] = data[i];
            }
        }
        this.data= newArray;
        size = count;
        return true;
    }
    public int getSize() {
        return size;
    }

    private String[] increaseArraySize(){
        String [] newArray=new String[this.data.length+1];
        System.arraycopy(data, 0, newArray, 0, data.length);
        return newArray;
    }
    /*Iterator ArrayList*/
    public Iterator getIterator(){
        return new Iterator() {
        int currentIndex = 0;
        public boolean hasNext(){
            return currentIndex<size;
        }
        public String next(){
            return data[currentIndex++];
        }
       };
    }

}


