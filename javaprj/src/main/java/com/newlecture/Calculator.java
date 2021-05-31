package com.newlecture;

import java.util.Scanner;   // ����ڷ� ���� �Է��� �ޱ� ���� import.

public class Calculator {

           public static void main(String[] args) {

                     System.out.println("----- ��� ���� ��ɾ� -----");

                     System.out.println("  x + y : x�� y ����");

                     System.out.println("  x - y : x���� y�� ��");

                     System.out.println("  x * y : x�� y�� ����");

                     System.out.println("  x / y : x���� y�� ����");

                     System.out.println("  {[( )]}  : ��.��.���ȣ(������� ����)");

                     System.out.println("------------------------");

                     System.out.println();

                    

                     Scanner sc = new Scanner(System.in);     
                     Scanner ac = new Scanner(System.in);

                    

                     while(true) {                 // ����ڰ� 0�� �Է��ϱ� ������ ����ؼ� �Է��� �ޱ� ���� ���ѷ���.

                                System.out.print("�Է� : ");

                                String input = sc.nextLine();
                                
                                Calculator cal = new Calculator();             // Caculator Ŭ������ �޼ҵ���� ����ϱ� ���� �ν��Ͻ�.
                                                       
                                System.out.println("��� : " + cal.evalPostfix(input));            // evalPostfix() �޼ҵ�� ������� �޾� ���.

                                System.out.println();
                                
                                
                                System.out.println("Continue ? ");
                                
                                String word = sc.nextLine();
                                
                                if (word.equals("N")) {      // 0�� �Է��ϸ� ����.

                                          System.out.println("End Caculator..");

                                          break;

                                }

                              
                                }                   

           }

 

          

           /**

            * �Էµ� String�� Object ��ū���� ������ ť�� �����صα� ���� �޼ҵ��Դϴ�.

            * ���ÿ� �����ϰ� �������� �ٲپ� �ξ ���� ����� ���� �� �ֽ��ϴ�.

            * ���׿����ڵ��� ���� ��ū���� ���� �ʰ�, �ٷ� �� �޼ҵ忡�� �����ؼ� ������� ��ū���� �����߽��ϴ�.

            * - ���� �ڷᱸ�� : ť -

            * @param str �Էµ� ����

            * @return �������� ��ū���� ����Ǿ� �ִ� ť

            */

           public ListQueue infix(String str) {

                     if (checkType(str.charAt(0)) == 1

                                || checkType(str.charAt(0)) == 4

                                || checkType(str.charAt(0)) == 8

                                || checkType(str.charAt(0)) == 10 ) {          // ������ �����ڳ� �ݴ°�ȣ�� �����ϸ� ���� ���.

                                System.out.println("������ �����ڳ� �ݴ°�ȣ�� ������ �� �����ϴ�.");

                                return null;

                     }

                    

                     ListQueue infixQue = new ListQueue();      // String�� �޾� ��ū�� ������ ������ �� ť.

                     for(int i = 0 ; i < str.length() ; ) {             // String�� �� ���ھ� �˻�.

                                if (str.charAt(i) == 's') {              // sin, sqrt ��ɾ� �˻�.

                                          i++;

                                          if (str.charAt(i) == 'i') {               // sin ��ɾ� �˻� �б���.

                                                     i++;

                                                     if (str.charAt(i) == 'n') {

                                                                i++;

                                                                int cnt = 0;

                                                                int k = i;

                                                                while (checkType(str.charAt(i)) == 5) {                  // sin��ɾ� ������ ���ںκ��� �˻�.

                                                                          i++;

                                                                          cnt++;

                                                                          if (i == str.length())        // String�� �� ���� �����ϸ� ���̻� �˻����� �ʵ��� ��.(�˻��ϸ� ���� �߻�)

                                                                                     break;

                                                                }

                                                                String temp = str.substring(k,k+cnt);        // sin��ɾ� ������ ���ںκ�.

                                                                double tempToDouble = Double.parseDouble(temp);

                                                                double tempSin = Math.sin(tempToDouble * Math.PI / 180); // sinA���� A�� ������ ��Ÿ������ �ϱ� ���� �̷��� ����ϴ�.

                                                               infixQue.enqueue(Double.toString(tempSin), 5);

                                                     } else {

                                                                System.out.println("����� �� ���� ��ɾ��Դϴ�. ��� ���� ��ɾ �������ּ���.");

                                                                return null;

                                                     }

                                          } else if (str.charAt(i) == 'q') {                 // sqrt ��ɾ� �˻� �б���.

                                                     i++;

                                                     if (str.charAt(i) == 'r') {

                                                                i++;

                                                                if (str.charAt(i) == 't') {

                                                                          i++;

                                                                          int cnt = 0;

                                                                          int k = i;

                                                                          while (checkType(str.charAt(i)) == 5) {                  // sqrt��ɾ� ������ ���ںκ��� �˻�.

                                                                                     i++;

                                                                                     cnt++;

                                                                                     if (i == str.length())        // String�� �� ���� �����ϸ� ���̻� �˻����� �ʵ��� ��.(�˻��ϸ� ���� �߻�)

                                                                                               break;

                                                                          }

                                                                          String temp = str.substring(k,k+cnt);        // sqrt��ɾ� ������ ���ںκ�.

                                                                          double tempToDouble = Double.parseDouble(temp);

                                                                          double tempSin = Math.sqrt(tempToDouble);

                                                                          infixQue.enqueue(Double.toString(tempSin), 5);                                                                      

                                                                } else {

                                                                          System.out.println("����� �� ���� ��ɾ��Դϴ�. ��� ���� ��ɾ �������ּ���.");

                                                                          return null;

                                                                }

                                                     } else {

                                                                System.out.println("����� �� ���� ��ɾ��Դϴ�. ��� ���� ��ɾ �������ּ���.");

                                                                return null;

                                                     }                                                   

                                          } else {

                                                     System.out.println("����� �� ���� ��ɾ��Դϴ�. ��� ���� ��ɾ �������ּ���.");

                                                     return null;

                                          }

                                } else if (str.charAt(i) == 'c') {                 // cos ��ɾ� �˻�

                                          i++;

                                          if (str.charAt(i) == 'o') {

                                                     i++;

                                                     if (str.charAt(i) == 's') {

                                                                i++;

                                                                int cnt = 0;

                                                                int k = i;

                                                                while (checkType(str.charAt(i)) == 5) {

                                                                          i++;

                                                                          cnt++;

                                                                          if (i == str.length())        // String�� �� ���� �����ϸ� ���̻� �˻����� �ʵ��� ��.(�˻��ϸ� ���� �߻�)

                                                                                     break;

                                                                }

                                                                String temp = str.substring(k,k+cnt);          // cos��ɾ� ������ ���ںκ�.

                                                               double tempToDouble = Double.parseDouble(temp);

                                                                double tempSin = Math.cos(tempToDouble * Math.PI / 180); // �Էµ� ���� ������ �Ǵ��ϱ� ����..

                                                                infixQue.enqueue(Double.toString(tempSin), 5);

                                                     } else {

                                                                System.out.println("����� �� ���� ��ɾ��Դϴ�. ��� ���� ��ɾ �������ּ���.");

                                                                return null;

                                                     }

                                          } else {

                                                     System.out.println("����� �� ���� ��ɾ��Դϴ�. ��� ���� ��ɾ �������ּ���.");

                                                     return null;

                                          }

                                } else if (str.charAt(i) == 't') {                 // tan ��ɾ� �˻�

                                          i++;

                                          if (str.charAt(i) == 'a') {

                                                     i++;

                                                     if (str.charAt(i) == 'n') {

                                                                i++;

                                                                int cnt = 0;

                                                                int k = i;

                                                                while (checkType(str.charAt(i)) == 5) {

                                                                          i++;

                                                                          cnt++;

                                                                          if (i == str.length())        // String�� �� ���� �����ϸ� ���̻� �˻����� �ʵ��� ��.(�˻��ϸ� ���� �߻�)

                                                                                     break;

                                                                }

                                                                String temp = str.substring(k,k+cnt);        // tan��ɾ� ������ ���ںκ�.

                                                                double tempToDouble = Double.parseDouble(temp);

                                                                double tempSin = Math.tan(tempToDouble * Math.PI / 180); // tan ���� ���ڸ� ������ �Ǵ��ϱ� ����..

                                                                infixQue.enqueue(Double.toString(tempSin), 5);

                                                     } else {

                                                                System.out.println("����� �� ���� ��ɾ��Դϴ�. ��� ���� ��ɾ �������ּ���.");

                                                                return null;

                                                     }

                                          } else {

                                                     System.out.println("����� �� ���� ��ɾ��Դϴ�. ��� ���� ��ɾ �������ּ���.");

                                                     return null;

                                          }

                                } else if (str.charAt(i) == 'l') {                  // log�� ln ��ɾ� �˻�

                                          i++;

                                          if (str.charAt(i) == 'o') {              // log ��ɾ� �˻� �б���

                                                     i++;

                                                     if (str.charAt(i) == 'g') {

                                                                i++;

                                                                int cnt = 0;

                                                                int k = i;

                                                                while (checkType(str.charAt(i)) == 5) {

                                                                          i++;

                                                                          cnt++;

                                                                          if (i == str.length())        // String�� �� ���� �����ϸ� ���̻� �˻����� �ʵ��� ��.(�˻��ϸ� ���� �߻�)

                                                                                     break;

                                                                }

                                                                String temp = str.substring(k,k+cnt);        // log��ɾ� ������ ���ںκ�.

                                                                double tempToDouble = Double.parseDouble(temp);

                                                                double tempSin = Math.log10(tempToDouble);       // ���α�.(log_10)

                                                                infixQue.enqueue(Double.toString(tempSin), 5);

                                                     } else {

                                                                System.out.println("����� �� ���� ��ɾ��Դϴ�. ��� ���� ��ɾ �������ּ���.");

                                                                return null;

                                                     }

                                          } else if (str.charAt(i) == 'n') {                 // ln ��ɾ� �˻� �б���

                                                     i++;

                                                     int cnt = 0;

                                                     int k = i;

                                                     while (checkType(str.charAt(i)) == 5) {

                                                                i++;

                                                                cnt++;

                                                                if (i == str.length())        // String�� �� ���� �����ϸ� ���̻� �˻����� �ʵ��� ��.(�˻��ϸ� ���� �߻�)

                                                                          break;

                                                     }

                                                     String temp = str.substring(k,k+cnt);        // ln��ɾ� ������ ���ںκ�.

                                                     double tempToDouble = Double.parseDouble(temp);

                                                     double tempSin = Math.log(tempToDouble);          // �ڿ��α�.(log_e)

                                                     infixQue.enqueue(Double.toString(tempSin), 5);

                                          } else {

                                                     System.out.println("����� �� ���� ��ɾ��Դϴ�. ��� ���� ��ɾ �������ּ���.");

                                                     return null;

                                          }

                                } else if (checkType(str.charAt(i)) == 5) {             // ������ ���, �ٸ� Ÿ���� ������ �������� ����� ��ū���� ��Ÿ��.

                                          int cnt = 0;

                                          int k = i;

                                          while (checkType(str.charAt(i)) == 5) {                  // ���ںκ��� ��ä�� ��ū���� ����� ���� �˻繮.

                                                     i++;

                                                     cnt++;

                                                     if (i == str.length())        // String�� �� ���� �����ϸ� ���̻� �˻����� �ʵ��� ��.(�˻��ϸ� ���� �߻�)

                                                                break;

                                          }

                                          String temp = str.substring(k,k+cnt);

                                          infixQue.enqueue(temp, 5);                     // ���� ����� ���ϰ� �ϱ� ���� ��ū�� ���� �� �̸� Ÿ���� ��α�� ��.

                                } else if (checkType(str.charAt(i)) != 2) {                // ������ �ƴ� ��� ���.

                                          infixQue.enqueue(str.charAt(i), checkType(str.charAt(i)));                  // ���� ����� ���ϰ� �ϱ� ���� ��ū�� ���� �� �̸� Ÿ���� ��α�� ��.

                                          i++;

                                } else               // ������ ���� �˻��� str�� �ڸ����� ������Ű�� ������ ����.

                                          i++;

                     }

                     if (bracketTest(infixQue))             // ������ ��ȣ�� �˻����� �Ǵٸ� infixQue ��ȯ.

                                return infixQue;

                     else {               // ������ ��ȣ�� �˻��� ��ȣ�� �ùٸ��� ���� �ʾҴٸ� �����߻�.

                                System.out.println("��ȣ�� �ùٸ��� �ʽ��ϴ�.");

                                return null;

                     }

           }

          

          

           /**

            * ������ ��ȣ�� �˻� �޼ҵ�. ������ ��.��.���ȣ�� �ùٸ��� ������ �������� �˻��մϴ�.

            * - ���� �ڷᱸ�� : ���� -

            * @param infix �������� ��ū���� �����ص� ť

            * @return ��ȣ���� �ùٸ��ٸ� true, Ʋ�ȴٸ� false ��ȯ.

            */

           public boolean bracketTest(ListQueue infix) {         // ��ȣ�� �˻��

                     ListStack bracketStack = new ListStack();    // �˻翡 ����� ����.

                     ListNode pointer = infix.front;                 // ��带 �ϳ��� �˻��� �����ͺ���.

                     while(pointer != null) {    // ���� �����ϱ� ������..

                                if (pointer.type == 3 || pointer.type == 7 || pointer.type == 9) {                  // ���°�ȣ�� ���ÿ� �ֽ��ϴ�.

                                          bracketStack.push(pointer.data, pointer.type);

                                          pointer = pointer.link;

                                } else if (pointer.type == 4) {                  // �ݴ� �Ұ�ȣ�̸� ���ÿ��� ���¼Ұ�ȣ�� ����. ���ٸ� false��ȯ.

                                          int typeTemp = bracketStack.top.type;

                                          if (bracketStack.isEmpty())

                                                     return false;

                                          else if (typeTemp == 3)

                                                     bracketStack.delete();

                                          else

                                                     return false;

                                          pointer = pointer.link;

                                } else if (pointer.type == 8) {                  // �ݴ� �߰�ȣ�̸� ���ÿ��� ���¼Ұ�ȣ�� ����. ���ٸ� false��ȯ.

                                          int typeTemp = bracketStack.top.type;

                                          if (bracketStack.isEmpty())

                                                     return false;

                                          else if (typeTemp == 7)

                                                     bracketStack.delete();

                                          else

                                                     return false;

                                          pointer = pointer.link;

                                } else if (pointer.type == 10) {     // �ݴ� ���ȣ�̸� ���ÿ��� ���¼Ұ�ȣ�� ����. ���ٸ� false��ȯ.

                                          int typeTemp = bracketStack.top.type;

                                          if (bracketStack.isEmpty())

                                                     return false;

                                          else if (typeTemp == 9)

                                                     bracketStack.delete();

                                           else

                                                     return false;

                                          pointer = pointer.link;

                                } else

                                          pointer = pointer.link;

                     }

                     if (bracketStack.isEmpty())           // �˻縦 ������ ���ÿ� �ƹ��͵� �������� �ʴٸ� true�Դϴ�.

                                return true;

                     else      // ���ÿ� ���� �����ִٸ� ���� �ȸ´� ���̹Ƿ� false.

                                return false;

           }

 

          

           /**

            * String�� �� ���ڸ� type���� ������ ���� �޼ҵ��Դϴ�.

            * @param ch �Էµ� �ϳ��� ����

            * @return Ÿ��

            */

           public int checkType(char ch) {

                     if (ch == '+' || ch == '-') // operator +, -

                                return 1;

                     else if (ch == '/' || ch == '*') // operator *, /

                                return 6;

                     else if (ch == ' ') // ����

                                return 2;

                     else if (ch == '(') // ���� �Ұ�ȣ

                                return 3;

                     else if (ch == ')') // �ݴ� �Ұ�ȣ

                                return 4;

                     else if (ch == '[') // ���� �߰�ȣ

                                return 7;

                     else if (ch == ']') // �ݴ� �߰�ȣ

                                return 8;

                     else if (ch == '{') // ���� ���ȣ

                                return 9;

                     else if (ch == '}') // �ݴ� ���ȣ

                                return 10;

                     else                                     // ����

                                return 5;

           }

          

 

           /**

            * Priority In Stack

            * @param token ��ū

            * @return ���þȿ� ���� ���� �켱����

            */

           public int pis(ListNode token) {

                     if (token == null)

                                return -1;

                     if (token.type == 6)        // *. /�� �켱����

                                return 9;

                     else if (token.type == 1)  // +, -�� �켱����

                                return 8;

                     else if (token.type == 3)  // �Ұ�ȣ �켱����

                                return 3;

                     else if (token.type == 7)  // �߰�ȣ �켱����

                                return 2;

                     else if (token.type == 9)  // ���ȣ �켱����

                                return 1;

                     else

                                return 0;

           }

          

          

           /**

            * Priority In Expression

            * @param token ��ū

            * @return ���Ŀ� ���� ���� �켱����

            */

           public int pie(ListNode token) {

                     if (token == null)

                                return -1;

                     if (token.type == 6) // *, /�� �켱����

                                return 9;

                     else if (token.type == 1) // +, -�� �켱����

                                return 8;

                     else if (token.type == 9) // ���ȣ �켱����

                                return 10;

                     else if (token.type == 7) // �߰�ȣ �켱����

                                return 11;

                     else if (token.type == 3) // �Ұ�ȣ �켱����

                                return 12;

                     else

                                return 0;

           }         

 

 

           /**

            * infix���� ���� ��ū�� ���������� �ٲٱ� ���� �޼ҵ�.

            * �ڷ� ���忡�� ť�� ����߰�, ��꿡�� ������ ����߽��ϴ�.

            * ť ��� ������ ����ϰ� �������� �ٲ㵵 ���� ����� �����ϴ�.

            * - ���� �ڷᱸ�� : ����, ť -

            * @param str ����ڰ� �Է��� String��

            * @return ���������� ǥ���� ��ū��.

            */

           public ListQueue postfix(String str) {

                     ListQueue infixQue = infix(str);      // �Է¹��� �����͸� ��ū���� ���� ������ ǥ���� infixQue���������� ����Ŵ.

                     ListQueue postfixQue = new ListQueue();   // �����Ŀ��� �ٲ� �������� ����.

                     ListStack st = new ListStack();                 // �������� ���������� �ٲٱ� ���� ����� ����.

                    

                     if (infixQue == null)       // infix���� null���� ���� ��� (�߸��� �Է��� ���� ���)

                                return null;

                    

                     ListNode pointer = infixQue.front; // �ڷḦ �б� ���� ������.

                     while (pointer != null) {

                                if (pointer.type == 5) {    // ����Ÿ���� ��ū�� ���

                                          postfixQue.enqueue(pointer.data, 5);         // ť�� �ٷ� ����.

                                          pointer = pointer.link;     // ��ĭ ����.

                                } else if (pointer.type == 4) {                  // �ݴ� �Ұ�ȣ�� ���

                                          while (st.whatType() != 3) {                    // ���� �Ұ�ȣ�� ���� �� ���� ������ ������ ��.

                                                     postfixQue.enqueue(st.peek(), st.whatType());

                                                     st.delete();         // �ٷ� pop�� �� ��� �ڽ��� type�� �Ѱ��� �� ����.

                                          }

                                          st.delete();         // ���� ��ȣ�� �׳� ����

                                          pointer = pointer.link;

                                } else if (pointer.type == 8) {                  // �ݴ� �߰�ȣ�� ���

                                          while (st.whatType() != 7) {                    // ���� �߰�ȣ�� ���� �� ���� ������ ������ ��.

                                                     postfixQue.enqueue(st.peek(), st.whatType());

                                                     st.delete();         // �ٷ� pop�� �� ��� �ڽ��� type�� �Ѱ��� �� ����.

                                          }

                                          st.delete();         // ���� ��ȣ�� �׳� ����

                                          pointer = pointer.link;

                                } else if (pointer.type == 10) {      // �ݴ� ���ȣ�� ���

                                          while (st.whatType() != 9) {                    // ���� ���ȣ�� ���� �� ���� ������ ������ ��.

                                                     postfixQue.enqueue(st.peek(), st.whatType());

                                                     st.delete();         // �ٷ� pop�� �� ��� �ڽ��� type�� �Ѱ��� �� ����.

                                          }

                                          st.delete();         // ���� ��ȣ�� �׳� ����

                                          pointer = pointer.link;

                                } else {  // operator Ȥ�� ���� ��ȣ�� ��.

                                          if (!st.isEmpty()) { // ������ �� �� ����

                                                     while (pis(st.top) >= pie(pointer)) {          // �켱������ �˻��ؼ� ���þȿ� �ִ� ���� �켱������ �� ������ pop.

                                                                postfixQue.enqueue(st.peek(), st.whatType());

                                                                st.delete();

                                                     }

                                          }

                                          st.push(pointer.data, pointer.type); // �켱���� �˻縦 ��ġ�� push.

                                          pointer = pointer.link;

                                }

                     }                   

                    

                     while (!st.isEmpty()) {                 // �����ִ� ������ ��� ��.

                                postfixQue.enqueue(st.peek(), st.whatType());

                                st.delete();

                     }                   

                     return postfixQue;                    // ���������� ������ ��ū�� ����Ǿ� �ִ� postfixQue ��ȯ.

           }

          

          

           /**

            * �������� ����ؼ� ���� ������� ��ȯ.

            * - ���� �ڷᱸ�� : ���� -

            * @param str ����ڰ� �Է��� ����

            * @return ���� �����

            */

           public double evalPostfix(String str) {

                     ListStack st = new ListStack();   // ����� ���� �ʿ��� ����.

                     ListNode pointer = postfix(str).front;                   // �ڷḦ �б� ���� ������.

                    

                     if (pointer == null)        // �ƹ��� �ĵ� �Է����� �ʾ��� ��� 0�� ���.

                                return 0;

                    

                     while (pointer != null) {

                                if (pointer.type == 5) {    // �ǿ������� ��� ���ÿ� push.

                                          st.push(pointer.data, pointer.type);

                                          pointer = pointer.link;

                                } else {  // �̹� �����Ŀ��� �ǿ����ڿ� �����ڸ� �������Ƿ� �׳� else.                   

                                          double result = 0;          // ������� �����ص� ����

                                          double operand2 = Double.parseDouble((String)st.pop());     // ���ÿ� ����� ���� double���·� �̾Ƴ�.

                                          double operand1 = Double.parseDouble((String)st.pop());

                                          if (pointer.data.toString().equals("+"))        // �� �����ڿ� ���� �����۾�. ���׿����ڴ� infix���� �̸� ����ص�.

                                                     result = operand1 + operand2;

                                          else if (pointer.data.toString().equals("-"))

                                                     result = operand1 - operand2;

                                          else if (pointer.data.toString().equals("/"))

                                                     result = operand1 / operand2;

                                          else if (pointer.data.toString().equals("*"))

                                                     result = operand1 * operand2;

                                          st.push(Double.toString(result), 5); // �����ڿ� ���� ������ ������� �ٽ� push.

                                          pointer = pointer.link;

                                }

                     } // end while.

                     double result = Double.parseDouble((String)st.pop());         // ���� ������� ���ÿ� �����ִ� �ϳ��� �� �Դϴ�.

                     if (!st.isEmpty()) { // ������ �����µ��� ������ ���� �����ִٸ� ����.

                                System.out.println("��ȣ�� �ǿ����� Ȥ�� ��ȣ�� ��ȣ ���̿� �����ڸ� ���� �ʾҽ��ϴ�.");

                                throw new NullPointerException();

                     }

                     return result;     // ���������� ������ result�� ��ȯ�մϴ�.

           }

}