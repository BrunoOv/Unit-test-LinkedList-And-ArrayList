package uaslp.objetos.list.List.LinkedList;
import uaslp.objetos.list.List.List;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import uaslp.objetos.list.List.Iterator;

public class LinkedListTest {
    /*LinkedList*/
    @Test
    public void test_addAtTail(){
        List lista = new LinkedList();
        lista.addAtTail("1");
        Assertions.assertEquals("1",lista.getAt(0));
        lista.addAtTail("2");
        Assertions.assertEquals("2",lista.getAt(1));
        Assertions.assertEquals(null,lista.getAt(2));
        Assertions.assertEquals(2,lista.getSize());
    }
    @Test
    public void test_addAtFront(){
        List lista = new LinkedList();
        lista.addAtFront("1");
        Assertions.assertEquals("1",lista.getAt(0));
        lista.addAtFront("2");
        Assertions.assertEquals("2",lista.getAt(0));
        Assertions.assertEquals(null,lista.getAt(2));
        Assertions.assertEquals(2,lista.getSize());
    }
    @Test
    public void test_remove() {
        List lista = new LinkedList();
        lista.addAtTail("1");
        lista.addAtTail("1");
        lista.addAtTail("1");
        lista.addAtTail("1");
        Assertions.assertEquals(true,lista.remove(0));//primero
        Assertions.assertEquals(false,lista.remove(6));//no existe
        Assertions.assertEquals(true,lista.remove(1));//en medio
        Assertions.assertEquals(true,lista.remove(1));//final
        Assertions.assertEquals(true,lista.remove(0));//un solo elemento
        Assertions.assertEquals(false,lista.remove(0));//no existe
        Assertions.assertEquals(0,lista.getSize());

    }
    @Test
    public void test_removeAll() {
        List lista = new LinkedList();
        lista.addAtTail("1");
        lista.addAtTail("2");
        lista.removeAll();
        Assertions.assertEquals(0,lista.getSize());
        Assertions.assertEquals(null,lista.getAt(0));

    }
    @Test
    public void test_setAt() {
        List lista = new LinkedList();
        lista.addAtTail("1");
        lista.addAtTail("2");
        lista.addAtTail("3");
        Assertions.assertEquals(true,lista.setAt(0,"Nuevo"));
        Assertions.assertEquals(true,lista.setAt(1,"Nuevo2"));
        Assertions.assertEquals(true,lista.setAt(2,"Nuevo3"));
        Assertions.assertEquals(false,lista.setAt(3,"Nuevo4"));
    }
    @Test
    public void test_getAt(){
        List lista = new LinkedList();
        lista.addAtTail("1");
        lista.addAtTail("2");
        lista.addAtTail("3");
        Assertions.assertEquals("1",lista.getAt(0));
        Assertions.assertEquals("2",lista.getAt(1));
        Assertions.assertEquals("3",lista.getAt(2));
        Assertions.assertEquals(null,lista.getAt(3));
    }
    @Test
    public void Test_removeAllWithValue() {
        List lista = new LinkedList();
        lista.addAtTail("1");
        lista.addAtTail("2");
        lista.addAtTail("2");
        lista.addAtTail("1");
        Assertions.assertEquals(false,lista.removeAllWithValue("3"));
        Assertions.assertTrue(lista.removeAllWithValue("1"));
        Assertions.assertEquals("2",lista.getAt(0));
        Assertions.assertEquals("2",lista.getAt(1));
        Assertions.assertTrue(lista.removeAllWithValue("2"));
    }
    @Test
    public void test_getSize() {
        List lista = new LinkedList();
        lista.addAtTail("1");
        lista.addAtTail("1");
        lista.addAtTail("1");
        lista.addAtTail("1");
        lista.addAtTail("1");
        lista.addAtTail("1");
        Assertions.assertEquals(6,lista.getSize());
        lista.removeAllWithValue("1");
        Assertions.assertEquals(0,lista.getSize());
    }
    @Test
    public void test_getIterator() {
        List lista = new LinkedList();
        lista.addAtTail("1");
        lista.addAtTail("1");
        lista.addAtTail("1");
        lista.addAtTail("1");
        Iterator iterator=lista.getIterator();
        int posicion=0;
        while(iterator.hasNext()){
            Assertions.assertEquals(lista.getAt(posicion),iterator.next());
            posicion++;
        }

    }
    /*Node*/
    @Test
    public void test_Node_GetDataNode() {
        LinkedList.Node node=new LinkedList.Node("1");
        Assertions.assertEquals("1",node.GetDataNode());
    }
    @Test
    public void test_Node_setData() {
        LinkedList.Node node=new LinkedList.Node("");
        node.setData("1");
        Assertions.assertEquals("1",node.GetDataNode());
    }
    /*LinkedList Iterator*/
    @Test
    public void test_Iterator_hasNext(){
        List lista = new LinkedList();
        lista.addAtTail("1");
        Iterator iterator=lista.getIterator();
        Assertions.assertEquals(true,iterator.hasNext());
    }
    @Test
    public void test_Iterator_next(){
        List lista = new LinkedList();
        lista.addAtTail("1");
        lista.addAtTail("1");
        lista.addAtTail("1");
        lista.addAtTail("1");
        Iterator iterator=lista.getIterator();
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals("1",iterator.next());
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals("1",iterator.next());
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals("1",iterator.next());
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals("1",iterator.next());
        Assertions.assertFalse(iterator.hasNext());
    }
}
