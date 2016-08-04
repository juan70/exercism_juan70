import java.lang.reflect.Array;
import java.util.NoSuchElementException;


public class SimpleLinkedList
{
  private int element;
  private SimpleLinkedList next;


  public SimpleLinkedList() { }


  public SimpleLinkedList(Integer[] arr) {
    for (Integer n : arr) {
      this.push(n.intValue()); 
    }
  }


  public int size() {
    return next == null ? 0 : 1 + next.size();
  }


  public void push(int elem) {
    SimpleLinkedList newList = new SimpleLinkedList();
    SimpleLinkedList last = this;

    while (last.next != null) {
      last = last.next;
    }

    last.next = newList;
    last.next.element = elem;
  }


  public int pop() {
    SimpleLinkedList last = this;
    SimpleLinkedList butLast = this;

    while (last.next != null) {
      butLast = last;
      last = last.next;
    }

    if (last == this) {
      throw new NoSuchElementException();
    }

    int elem = last.element;
    butLast.next = null;

    return elem;
  }


  public void reverse() {
    SimpleLinkedList revList = new SimpleLinkedList();
    // Caution: this.size() is going to be modified at each iteration within
    // the loop, because the pop operation decreases the size of the list.
    // It's necessary to keep the value safe at the beginning, because it won't
    // make sense to use it in the condition of the for loop like in:
    //   for (...; i < this.size(); ...)
    int listSize = this.size();

    for (int i = 0; i < listSize; i++) {
      revList.push(this.pop());
    }

    this.next = revList.next;
  }


  private SimpleLinkedList copy() {
    SimpleLinkedList newList = new SimpleLinkedList();

    SimpleLinkedList current = this;
    for (int i = 0; i < this.size(); i++) {
      if (current.next != null) {
        newList.push(current.next.element);
        current = current.next;
      }
    }

    return newList;
  }


  public <T> T[] asArray(Class<T> cls) {
    // Explanation here:
    // https://stackoverflow.com/questions/18581002/how-to-create-a-generic-array
    @SuppressWarnings("unchecked")
    T[] elems = (T[])Array.newInstance(cls, this.size());

    // Make a copy of the list, otherwise the original list would end up being
    // empty because this.pop() is a destructive operation.
    SimpleLinkedList tmpList = this.copy();
    for (int i = 0; i < elems.length; i++) {
      elems[i] = cls.cast(tmpList.pop());
    }

    return elems;
  }
}

