package com.newlecture;

/**

 * ������ �� ������ ��ū�� ������ �α� ���� ���Ḯ��Ʈ ť ���� �Դϴ�.

 * �ǽð����� ó���� �뵵�� �ƴ϶� �ܼ��� �ڷ� ������̱� ������

 * ������ �������� �ٲپ ����ص� ������, ť�� �ѹ� ����غ��� �;����ϴ�.

 */

public class ListQueue {

          

           public ListNode front;

           public ListNode rear;

           public int count;

          

           public boolean isEmpty() {

                     return (count == 0);

           }

          

           public void enqueue(Object x, int type) {   // ť��  �ڷḦ ����.

                     ListNode newNode = new ListNode(x);

                     newNode.type = type;

                     newNode.link = null;

                     if (count == 0)

                                front = rear = newNode;

                     else {

                                rear.link = newNode;

                                rear = newNode;

                     }

                     count++;

           }

          

           public Object dequeue() { // ť���� �ڷḦ ������ ����. First In First Out.

                     if (count == 0)

                                return null;

                     else {

                                Object temp = front.data;

                                front = front.link;

                                if (front == null)

                                          rear = null;

                                count--;

                                return temp;

                     }

           }

}