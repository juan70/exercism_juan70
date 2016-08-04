import java.util.NoSuchElementException;


public class Deque<T>
{
  private Node<T> first = null;
  private Node<T> last = null;


  public void push(T val) {
    Node<T> newNode = new Node<T>();
    newNode.value = val;
    newNode.next = null;  // just for information

    // Connect the new node right after the last node.
    if (last != null) {
      newNode.previous = last;
      last.next = newNode;
    }

    // This new node is now the last node of the list.
    last = newNode;

    // If the list was initially empty, this new node is also the first node of
    // the list.
    if (first == null) {
      newNode.previous = null;
      first = newNode;
    }
  }


  public T pop() {
    if (first == null) {
      throw new NoSuchElementException();
    }

    T val = last.value;

    // Disconnect the node from the list.
    // If no previous node exists, the list is now empty.
    if (last.previous == null) {
      first = null;
      last = null;
    } else {
      // Otherwise, the previous node is now the last node.
      last = last.previous;
      last.next = null;
    }

    return val;
  }


  /*
  * The methods unshift() and shift() are symmetric to the methods push() and
  * pop() respectively. I just copy-paste the latter methods and apply the
  * necessary substitutions:
  * - push     -> unshift
  * - pop      -> shift
  * - first    -> last
  * - last     -> first
  * - next     -> previous
  * - previous -> next
  * I don't copy-paste the comments :-)
  */

  public void unshift(T val) {
    // Symmetric to the push() method.
    Node<T> newNode = new Node<T>();
    newNode.value = val;
    newNode.previous = null;  // just for information

    // Connect the new node right before the first node.
    if (first != null) {
      newNode.next = first;
      first.previous = newNode;
    }

    // This new node is now the first node of the list.
    first = newNode;

    // If the list was initially empty, this new node is also the last node of
    // the list.
    if (last == null) {
      newNode.next = null;
      last = newNode;
    }
  }


  public T shift() {
    // Symmetric to the pop() method.
    if (first == null) {
      throw new NoSuchElementException();
    }

    T val = first.value;

    // Disconnect the node from the list.
    // If no next node exists, the list is now empty.
    if (first.next == null) {
      last = null;
      first = null;
    } else {
      // Otherwise, the next node is now the first node.
      first = first.next;
      first.previous = null;
    }
    
    return val;
  }
}

