package uaslp.objetos.list.List.LinkedList;
import uaslp.objetos.list.List.Iterator;
import uaslp.objetos.list.List.List;
public class LinkedList implements List {
    private  Node head,tails;
    private int size;
    public LinkedList(){
        head = tails = null;
        size = 0;
    }

    public void addAtTail(String data){
        Node node = new Node(data);
        if(tails == null) head = node;
        else
        {
            node.previous = tails;
            tails.next = node;
        }
        tails = node;
        size++;
    }
    public void addAtFront(String data){
        Node node = new Node(data);
        if(head == null) tails = node;
        else {
            node.next = head;
        }
        head = node;
        size++;
    }
    public boolean remove(int index) {
        int coun = 0;
        if (head != null) {
            Node aux;
            Node ant = null;
            aux = head;
            while (aux != null && coun != index) {
                ant = aux;
                aux = aux.next;
                coun++;
            }
            if (aux == null) {
                return false;
            } else if (ant == null) {
                head = aux.next;
                size--;
                return true;
            } else {
                ant.next = aux.next;
                size--;
                return true;
            }
        }
        return false;
    }


    public void removeAll()
    {
        while(head!=null){
            head=head.next;
        }
        size=0;

    }

    public boolean setAt(int index,String data)
    {
        Node node=head;
        int coun=0;
        while (node != null && coun != index)
        {
            node= node.next;
            coun++;
        }
        if(node !=null) {
            node.setData(data);
            return true;
        }
        return false;
    }

    public String getAt(int index){
        Node node=head;
        int coun=0;
        while (node != null && coun != index) {
            node= node.next;
            coun++;
        }
        if(node !=null){
            String s= node.GetDataNode();
            return String.valueOf(s);
        }
        return null;
    }

    public boolean removeAllWithValue(String data){
        Node node = head;
        boolean bandera=false;
        while (node != null)
        {
            if(node.GetDataNode()==data)
            {
                size--;
                Node aux1,aux2;
                aux1=node.previous;
                aux2=node.next;
                if(aux1 != null)
                {
                    aux1.next=aux2;
                }
                else//elimina el primero
                {
                    head=aux2;
                }
                if(aux2 !=null)
                {
                    aux2.previous= aux1;
                }
                else
                {
                    tails= aux1;
                }
                bandera=true;
            }
            node=node.next;
        }
        return bandera;
    }
    public int getSize() {
        return size;
    }
    public LinkedListIterator getIterator(){
        return new LinkedListIterator();
    }

    ///////NODE//////
    static class Node {
        private Node next,previous;
        private String data;
        public Node(String data) {
            next = previous = null;
            this.data = data;
        }
        public String GetDataNode() {return data;}
        public void setData(String data) {
            this.data = data;
        }
    }

    /////LINKED_LIST_ITERATOR////
    public class LinkedListIterator implements Iterator {
        private Node node;
        public LinkedListIterator(){
            this.node = head;
        }
        public boolean hasNext(){
            return node != null;
        }
        public String next(){
            String dato = node.GetDataNode();
            node = node.next;
            return dato;
        }
    }
}
