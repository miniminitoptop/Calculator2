package com.newlecture;

/**

 * 중위식을 후위식으로 바꿀 때와, 후위식을 계산할 때 필요한 스택클래스입니다.

 */

public class ListStack implements Stack{

          

           public ListNode top;       // 리스트로 Stack을 구현하기 위해 필요한 top 참조변수

                    

           /**

            * 이하 Stack Interface를 리스트표현을 사용해 구현.

            */

           public boolean isEmpty() {          // 스택이 비어있는지 검사

                     return (top == null);

           }

          

           public void push(Object x, int type) {       // 스택의 맨 위에 원소 x를 삽입

                     ListNode newNode = new ListNode(x);

                     newNode.link = top;

                     newNode.type = type;

                     top = newNode;

           }

          

           public Object pop() {      // 스택의 원소를 반환하고 삭제.

                     if (isEmpty())

                                return null;

                     else {

                                Object temp = top.data;

                                delete();

                                return temp;

                     }

           }

          

           public void delete() {      // 맨위를 삭제만 함.

                     if (isEmpty())

                                return;

                     else

                                top = top.link;

           }

          

           public Object peek() {     // 스택의 톱 원소를 알려줌.

                     if (isEmpty())

                                return null;

                     else

                                return top.data;

           }

          

           public int whatType() {    // stack의 top원소의 type값 반환.

                     return top.type;

           }

}
