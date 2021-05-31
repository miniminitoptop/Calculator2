package com.newlecture;

/**

 * �������� ���������� �ٲ� ����, �������� ����� �� �ʿ��� ����Ŭ�����Դϴ�.

 */

public class ListStack implements Stack{

          

           public ListNode top;       // ����Ʈ�� Stack�� �����ϱ� ���� �ʿ��� top ��������

                    

           /**

            * ���� Stack Interface�� ����Ʈǥ���� ����� ����.

            */

           public boolean isEmpty() {          // ������ ����ִ��� �˻�

                     return (top == null);

           }

          

           public void push(Object x, int type) {       // ������ �� ���� ���� x�� ����

                     ListNode newNode = new ListNode(x);

                     newNode.link = top;

                     newNode.type = type;

                     top = newNode;

           }

          

           public Object pop() {      // ������ ���Ҹ� ��ȯ�ϰ� ����.

                     if (isEmpty())

                                return null;

                     else {

                                Object temp = top.data;

                                delete();

                                return temp;

                     }

           }

          

           public void delete() {      // ������ ������ ��.

                     if (isEmpty())

                                return;

                     else

                                top = top.link;

           }

          

           public Object peek() {     // ������ �� ���Ҹ� �˷���.

                     if (isEmpty())

                                return null;

                     else

                                return top.data;

           }

          

           public int whatType() {    // stack�� top������ type�� ��ȯ.

                     return top.type;

           }

}
