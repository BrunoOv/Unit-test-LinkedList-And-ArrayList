import uaslp.objetos.list.List.List;
import uaslp.objetos.list.List.Iterator;
import uaslp.objetos.list.List.ArrayList.ArrayList;
import uaslp.objetos.list.List.LinkedList.LinkedList;

public class Main {
    public static void main(String[] args) {
        List lista1 = new LinkedList();
        List lista2 = new ArrayList();

        lista1.addAtTail("1");
        lista2.addAtTail("1");
        lista1.addAtFront("2");
        lista2.addAtFront("2");

        Iterator lista1i= lista1.getIterator();
        Iterator lista2i= lista2.getIterator();
        while(lista1i.hasNext()){
            System.out.println(lista1i.next());
        }
        while(lista2i.hasNext()){
            System.out.println(lista2i.next());
        }

        lista1.removeAll();
        lista2.removeAll();

        lista1i= lista1.getIterator();
        lista2i= lista2.getIterator();
        while(lista1i.hasNext()){
            System.out.println(lista1i.next());
        }
        while(lista2i.hasNext()){
            System.out.println(lista2i.next());
        }
        lista1.addAtFront("1");
        lista2.addAtFront("1");

        lista1.setAt(0,"Nuevo");
        lista2.setAt(0,"Nuevo");
        lista1i= lista1.getIterator();
        lista2i= lista2.getIterator();
        while(lista1i.hasNext()){
            System.out.println(lista1i.next());
        }
        while(lista2i.hasNext()){
            System.out.println(lista2i.next());
        }
        System.out.println("getAt1 : "+lista1.getAt(0));
        System.out.println("getAt2 : "+lista1.getAt(0));
        System.out.println("getSize1: "+lista1.getSize());
        System.out.println("getSize2: "+lista2.getSize());
        lista1.removeAllWithValue("Nuevo");
        lista2.removeAllWithValue("Nuevo");

        System.out.println("getSize1: "+lista1.getSize());
        System.out.println("getSize2: "+lista2.getSize());

    }
}



