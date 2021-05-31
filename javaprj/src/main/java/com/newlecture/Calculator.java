package com.newlecture;

import java.util.Scanner;   // 사용자로 부터 입력을 받기 위해 import.

public class Calculator {

           public static void main(String[] args) {

                     System.out.println("----- 사용 가능 명령어 -----");

                     System.out.println("  x + y : x와 y 더함");

                     System.out.println("  x - y : x에서 y를 뺌");

                     System.out.println("  x * y : x와 y를 곱함");

                     System.out.println("  x / y : x에서 y를 나눔");

                     System.out.println("  {[( )]}  : 소.중.대괄호(연산순서 지정)");

                     System.out.println("------------------------");

                     System.out.println();

                    

                     Scanner sc = new Scanner(System.in);     
                     Scanner ac = new Scanner(System.in);

                    

                     while(true) {                 // 사용자가 0을 입력하기 전까지 계속해서 입력을 받기 위한 무한루프.

                                System.out.print("입력 : ");

                                String input = sc.nextLine();
                                
                                Calculator cal = new Calculator();             // Caculator 클래스의 메소드들을 사용하기 위해 인스턴스.
                                                       
                                System.out.println("결과 : " + cal.evalPostfix(input));            // evalPostfix() 메소드로 결과값을 받아 출력.

                                System.out.println();
                                
                                
                                System.out.println("Continue ? ");
                                
                                String word = sc.nextLine();
                                
                                if (word.equals("N")) {      // 0을 입력하면 종료.

                                          System.out.println("End Caculator..");

                                          break;

                                }

                              
                                }                   

           }

 

          

           /**

            * 입력된 String을 Object 토큰으로 나누어 큐에 저장해두기 위한 메소드입니다.

            * 스택에 저장하고 역순으로 바꾸어 두어도 같은 기능을 가질 수 있습니다.

            * 일항연산자들은 따로 토큰으로 빼지 않고, 바로 이 메소드에서 연산해서 결과값을 토큰으로 지정했습니다.

            * - 사용된 자료구조 : 큐 -

            * @param str 입력된 수식

            * @return 중위식이 토큰으로 저장되어 있는 큐

            */

           public ListQueue infix(String str) {

                     if (checkType(str.charAt(0)) == 1

                                || checkType(str.charAt(0)) == 4

                                || checkType(str.charAt(0)) == 8

                                || checkType(str.charAt(0)) == 10 ) {          // 수식이 연산자나 닫는괄호로 시작하면 에러 출력.

                                System.out.println("수식은 연산자나 닫는괄호로 시작할 수 없습니다.");

                                return null;

                     }

                    

                     ListQueue infixQue = new ListQueue();      // String을 받아 토큰을 나누어 저장해 둘 큐.

                     for(int i = 0 ; i < str.length() ; ) {             // String을 한 문자씩 검사.

                                if (str.charAt(i) == 's') {              // sin, sqrt 명령어 검사.

                                          i++;

                                          if (str.charAt(i) == 'i') {               // sin 명령어 검사 분기점.

                                                     i++;

                                                     if (str.charAt(i) == 'n') {

                                                                i++;

                                                                int cnt = 0;

                                                                int k = i;

                                                                while (checkType(str.charAt(i)) == 5) {                  // sin명령어 뒤쪽의 숫자부분을 검사.

                                                                          i++;

                                                                          cnt++;

                                                                          if (i == str.length())        // String의 맨 끝에 도달하면 더이상 검사하지 않도록 함.(검사하면 오류 발생)

                                                                                     break;

                                                                }

                                                                String temp = str.substring(k,k+cnt);        // sin명령어 뒤쪽의 숫자부분.

                                                                double tempToDouble = Double.parseDouble(temp);

                                                                double tempSin = Math.sin(tempToDouble * Math.PI / 180); // sinA에서 A를 각도를 나타내도록 하기 위해 이렇게 썼습니다.

                                                               infixQue.enqueue(Double.toString(tempSin), 5);

                                                     } else {

                                                                System.out.println("사용할 수 없는 명령어입니다. 사용 가능 명령어를 참고해주세요.");

                                                                return null;

                                                     }

                                          } else if (str.charAt(i) == 'q') {                 // sqrt 명령어 검사 분기점.

                                                     i++;

                                                     if (str.charAt(i) == 'r') {

                                                                i++;

                                                                if (str.charAt(i) == 't') {

                                                                          i++;

                                                                          int cnt = 0;

                                                                          int k = i;

                                                                          while (checkType(str.charAt(i)) == 5) {                  // sqrt명령어 뒤쪽의 숫자부분을 검사.

                                                                                     i++;

                                                                                     cnt++;

                                                                                     if (i == str.length())        // String의 맨 끝에 도달하면 더이상 검사하지 않도록 함.(검사하면 오류 발생)

                                                                                               break;

                                                                          }

                                                                          String temp = str.substring(k,k+cnt);        // sqrt명령어 뒤쪽의 숫자부분.

                                                                          double tempToDouble = Double.parseDouble(temp);

                                                                          double tempSin = Math.sqrt(tempToDouble);

                                                                          infixQue.enqueue(Double.toString(tempSin), 5);                                                                      

                                                                } else {

                                                                          System.out.println("사용할 수 없는 명령어입니다. 사용 가능 명령어를 참고해주세요.");

                                                                          return null;

                                                                }

                                                     } else {

                                                                System.out.println("사용할 수 없는 명령어입니다. 사용 가능 명령어를 참고해주세요.");

                                                                return null;

                                                     }                                                   

                                          } else {

                                                     System.out.println("사용할 수 없는 명령어입니다. 사용 가능 명령어를 참고해주세요.");

                                                     return null;

                                          }

                                } else if (str.charAt(i) == 'c') {                 // cos 명령어 검사

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

                                                                          if (i == str.length())        // String의 맨 끝에 도달하면 더이상 검사하지 않도록 함.(검사하면 오류 발생)

                                                                                     break;

                                                                }

                                                                String temp = str.substring(k,k+cnt);          // cos명령어 뒤쪽의 숫자부분.

                                                               double tempToDouble = Double.parseDouble(temp);

                                                                double tempSin = Math.cos(tempToDouble * Math.PI / 180); // 입력된 값을 각도로 판단하기 위해..

                                                                infixQue.enqueue(Double.toString(tempSin), 5);

                                                     } else {

                                                                System.out.println("사용할 수 없는 명령어입니다. 사용 가능 명령어를 참고해주세요.");

                                                                return null;

                                                     }

                                          } else {

                                                     System.out.println("사용할 수 없는 명령어입니다. 사용 가능 명령어를 참고해주세요.");

                                                     return null;

                                          }

                                } else if (str.charAt(i) == 't') {                 // tan 명령어 검사

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

                                                                          if (i == str.length())        // String의 맨 끝에 도달하면 더이상 검사하지 않도록 함.(검사하면 오류 발생)

                                                                                     break;

                                                                }

                                                                String temp = str.substring(k,k+cnt);        // tan명령어 뒤쪽의 숫자부분.

                                                                double tempToDouble = Double.parseDouble(temp);

                                                                double tempSin = Math.tan(tempToDouble * Math.PI / 180); // tan 뒤의 숫자를 각도로 판단하기 위해..

                                                                infixQue.enqueue(Double.toString(tempSin), 5);

                                                     } else {

                                                                System.out.println("사용할 수 없는 명령어입니다. 사용 가능 명령어를 참고해주세요.");

                                                                return null;

                                                     }

                                          } else {

                                                     System.out.println("사용할 수 없는 명령어입니다. 사용 가능 명령어를 참고해주세요.");

                                                     return null;

                                          }

                                } else if (str.charAt(i) == 'l') {                  // log와 ln 명령어 검사

                                          i++;

                                          if (str.charAt(i) == 'o') {              // log 명령어 검사 분기점

                                                     i++;

                                                     if (str.charAt(i) == 'g') {

                                                                i++;

                                                                int cnt = 0;

                                                                int k = i;

                                                                while (checkType(str.charAt(i)) == 5) {

                                                                          i++;

                                                                          cnt++;

                                                                          if (i == str.length())        // String의 맨 끝에 도달하면 더이상 검사하지 않도록 함.(검사하면 오류 발생)

                                                                                     break;

                                                                }

                                                                String temp = str.substring(k,k+cnt);        // log명령어 뒤쪽의 숫자부분.

                                                                double tempToDouble = Double.parseDouble(temp);

                                                                double tempSin = Math.log10(tempToDouble);       // 상용로그.(log_10)

                                                                infixQue.enqueue(Double.toString(tempSin), 5);

                                                     } else {

                                                                System.out.println("사용할 수 없는 명령어입니다. 사용 가능 명령어를 참고해주세요.");

                                                                return null;

                                                     }

                                          } else if (str.charAt(i) == 'n') {                 // ln 명령어 검사 분기점

                                                     i++;

                                                     int cnt = 0;

                                                     int k = i;

                                                     while (checkType(str.charAt(i)) == 5) {

                                                                i++;

                                                                cnt++;

                                                                if (i == str.length())        // String의 맨 끝에 도달하면 더이상 검사하지 않도록 함.(검사하면 오류 발생)

                                                                          break;

                                                     }

                                                     String temp = str.substring(k,k+cnt);        // ln명령어 뒤쪽의 숫자부분.

                                                     double tempToDouble = Double.parseDouble(temp);

                                                     double tempSin = Math.log(tempToDouble);          // 자연로그.(log_e)

                                                     infixQue.enqueue(Double.toString(tempSin), 5);

                                          } else {

                                                     System.out.println("사용할 수 없는 명령어입니다. 사용 가능 명령어를 참고해주세요.");

                                                     return null;

                                          }

                                } else if (checkType(str.charAt(i)) == 5) {             // 숫자일 경우, 다른 타입을 만나기 전까지를 연결된 토큰으로 나타냄.

                                          int cnt = 0;

                                          int k = i;

                                          while (checkType(str.charAt(i)) == 5) {                  // 숫자부분을 통채로 토큰으로 만들기 위한 검사문.

                                                     i++;

                                                     cnt++;

                                                     if (i == str.length())        // String의 맨 끝에 도달하면 더이상 검사하지 않도록 함.(검사하면 오류 발생)

                                                                break;

                                          }

                                          String temp = str.substring(k,k+cnt);

                                          infixQue.enqueue(temp, 5);                     // 이후 계산을 편하게 하기 위해 토큰을 나눌 때 미리 타입을 써두기로 함.

                                } else if (checkType(str.charAt(i)) != 2) {                // 공백이 아닌 모든 경우.

                                          infixQue.enqueue(str.charAt(i), checkType(str.charAt(i)));                  // 이후 계산을 편하게 하기 위해 토큰을 나눌 때 미리 타입을 써두기로 함.

                                          i++;

                                } else               // 공백일 경우는 검사할 str의 자리수만 증가시키고 공백은 버림.

                                          i++;

                     }

                     if (bracketTest(infixQue))             // 수식의 괄호쌍 검사결과가 옳다면 infixQue 반환.

                                return infixQue;

                     else {               // 수식의 괄호쌍 검사결과 괄호를 올바르게 쓰지 않았다면 오류발생.

                                System.out.println("괄호가 올바르지 않습니다.");

                                return null;

                     }

           }

          

          

           /**

            * 수식의 괄호쌍 검사 메소드. 각각의 소.중.대괄호가 올바르게 열리고 닫혔는지 검사합니다.

            * - 사용된 자료구조 : 스택 -

            * @param infix 중위식을 토큰으로 저장해둔 큐

            * @return 괄호쌍이 올바르다면 true, 틀렸다면 false 반환.

            */

           public boolean bracketTest(ListQueue infix) {         // 괄호쌍 검사용

                     ListStack bracketStack = new ListStack();    // 검사에 사용할 스택.

                     ListNode pointer = infix.front;                 // 노드를 하나씩 검사할 포인터변수.

                     while(pointer != null) {    // 끝에 도달하기 전까지..

                                if (pointer.type == 3 || pointer.type == 7 || pointer.type == 9) {                  // 여는괄호는 스택에 넣습니다.

                                          bracketStack.push(pointer.data, pointer.type);

                                          pointer = pointer.link;

                                } else if (pointer.type == 4) {                  // 닫는 소괄호이면 스택에서 여는소괄호를 제거. 없다면 false반환.

                                          int typeTemp = bracketStack.top.type;

                                          if (bracketStack.isEmpty())

                                                     return false;

                                          else if (typeTemp == 3)

                                                     bracketStack.delete();

                                          else

                                                     return false;

                                          pointer = pointer.link;

                                } else if (pointer.type == 8) {                  // 닫는 중괄호이면 스택에서 여는소괄호를 제거. 없다면 false반환.

                                          int typeTemp = bracketStack.top.type;

                                          if (bracketStack.isEmpty())

                                                     return false;

                                          else if (typeTemp == 7)

                                                     bracketStack.delete();

                                          else

                                                     return false;

                                          pointer = pointer.link;

                                } else if (pointer.type == 10) {     // 닫는 대괄호이면 스택에서 여는소괄호를 제거. 없다면 false반환.

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

                     if (bracketStack.isEmpty())           // 검사를 끝내고 스택에 아무것도 남아있지 않다면 true입니다.

                                return true;

                     else      // 스택에 무언가 남아있다면 쌍이 안맞는 것이므로 false.

                                return false;

           }

 

          

           /**

            * String의 각 문자를 type별로 나누기 위한 메소드입니다.

            * @param ch 입력된 하나의 문자

            * @return 타입

            */

           public int checkType(char ch) {

                     if (ch == '+' || ch == '-') // operator +, -

                                return 1;

                     else if (ch == '/' || ch == '*') // operator *, /

                                return 6;

                     else if (ch == ' ') // 공백

                                return 2;

                     else if (ch == '(') // 여는 소괄호

                                return 3;

                     else if (ch == ')') // 닫는 소괄호

                                return 4;

                     else if (ch == '[') // 여는 중괄호

                                return 7;

                     else if (ch == ']') // 닫는 중괄호

                                return 8;

                     else if (ch == '{') // 여는 대괄호

                                return 9;

                     else if (ch == '}') // 닫는 대괄호

                                return 10;

                     else                                     // 숫자

                                return 5;

           }

          

 

           /**

            * Priority In Stack

            * @param token 토큰

            * @return 스택안에 있을 때의 우선순위

            */

           public int pis(ListNode token) {

                     if (token == null)

                                return -1;

                     if (token.type == 6)        // *. /의 우선순위

                                return 9;

                     else if (token.type == 1)  // +, -의 우선순위

                                return 8;

                     else if (token.type == 3)  // 소괄호 우선순위

                                return 3;

                     else if (token.type == 7)  // 중괄호 우선순위

                                return 2;

                     else if (token.type == 9)  // 대괄호 우선순위

                                return 1;

                     else

                                return 0;

           }

          

          

           /**

            * Priority In Expression

            * @param token 토큰

            * @return 수식에 있을 때의 우선순위

            */

           public int pie(ListNode token) {

                     if (token == null)

                                return -1;

                     if (token.type == 6) // *, /의 우선순위

                                return 9;

                     else if (token.type == 1) // +, -의 우선순위

                                return 8;

                     else if (token.type == 9) // 대괄호 우선순위

                                return 10;

                     else if (token.type == 7) // 중괄호 우선순위

                                return 11;

                     else if (token.type == 3) // 소괄호 우선순위

                                return 12;

                     else

                                return 0;

           }         

 

 

           /**

            * infix에서 나눈 토큰을 후위식으로 바꾸기 위한 메소드.

            * 자료 저장에는 큐를 사용했고, 계산에는 스택을 사용했습니다.

            * 큐 대신 스택을 사용하고 역순으로 바꿔도 같은 기능을 가집니다.

            * - 사용된 자료구조 : 스택, 큐 -

            * @param str 사용자가 입력한 String값

            * @return 후위식으로 표현된 토큰들.

            */

           public ListQueue postfix(String str) {

                     ListQueue infixQue = infix(str);      // 입력받은 데이터를 토큰으로 나눈 중위식 표현을 infixQue참조변수로 가르킴.

                     ListQueue postfixQue = new ListQueue();   // 중위식에서 바뀐 후위식을 저장.

                     ListStack st = new ListStack();                 // 중위식을 후위식으로 바꾸기 위해 사용할 스택.

                    

                     if (infixQue == null)       // infix에서 null값이 왔을 경우 (잘못된 입력을 했을 경우)

                                return null;

                    

                     ListNode pointer = infixQue.front; // 자료를 읽기 위한 포인터.

                     while (pointer != null) {

                                if (pointer.type == 5) {    // 숫자타입의 토큰일 경우

                                          postfixQue.enqueue(pointer.data, 5);         // 큐에 바로 넣음.

                                          pointer = pointer.link;     // 한칸 전진.

                                } else if (pointer.type == 4) {                  // 닫는 소괄호일 경우

                                          while (st.whatType() != 3) {                    // 여는 소괄호를 만날 때 까지 스택의 내용을 뺌.

                                                     postfixQue.enqueue(st.peek(), st.whatType());

                                                     st.delete();         // 바로 pop을 할 경우 자신의 type을 넘겨줄 수 없음.

                                          }

                                          st.delete();         // 여는 괄호는 그냥 제거

                                          pointer = pointer.link;

                                } else if (pointer.type == 8) {                  // 닫는 중괄호일 경우

                                          while (st.whatType() != 7) {                    // 여는 중괄호를 만날 때 까지 스택의 내용을 뺌.

                                                     postfixQue.enqueue(st.peek(), st.whatType());

                                                     st.delete();         // 바로 pop을 할 경우 자신의 type을 넘겨줄 수 없음.

                                          }

                                          st.delete();         // 여는 괄호는 그냥 제거

                                          pointer = pointer.link;

                                } else if (pointer.type == 10) {      // 닫는 대괄호일 경우

                                          while (st.whatType() != 9) {                    // 여는 대괄호를 만날 때 까지 스택의 내용을 뺌.

                                                     postfixQue.enqueue(st.peek(), st.whatType());

                                                     st.delete();         // 바로 pop을 할 경우 자신의 type을 넘겨줄 수 없음.

                                          }

                                          st.delete();         // 여는 괄호는 그냥 제거

                                          pointer = pointer.link;

                                } else {  // operator 혹은 여는 괄호일 때.

                                          if (!st.isEmpty()) { // 스택이 빌 때 까지

                                                     while (pis(st.top) >= pie(pointer)) {          // 우선순위를 검사해서 스택안에 있는 것이 우선순위가 더 높으면 pop.

                                                                postfixQue.enqueue(st.peek(), st.whatType());

                                                                st.delete();

                                                     }

                                          }

                                          st.push(pointer.data, pointer.type); // 우선순위 검사를 마치고 push.

                                          pointer = pointer.link;

                                }

                     }                   

                    

                     while (!st.isEmpty()) {                 // 남아있는 스택을 모두 뺌.

                                postfixQue.enqueue(st.peek(), st.whatType());

                                st.delete();

                     }                   

                     return postfixQue;                    // 최종적으로 후위식 토큰이 저장되어 있는 postfixQue 반환.

           }

          

          

           /**

            * 후위식을 사용해서 최종 결과값을 반환.

            * - 사용된 자료구조 : 스택 -

            * @param str 사용자가 입력한 수식

            * @return 최종 결과값

            */

           public double evalPostfix(String str) {

                     ListStack st = new ListStack();   // 계산을 위해 필요한 스택.

                     ListNode pointer = postfix(str).front;                   // 자료를 읽기 위한 포인터.

                    

                     if (pointer == null)        // 아무런 식도 입력하지 않았을 경우 0을 출력.

                                return 0;

                    

                     while (pointer != null) {

                                if (pointer.type == 5) {    // 피연산자일 경우 스택에 push.

                                          st.push(pointer.data, pointer.type);

                                          pointer = pointer.link;

                                } else {  // 이미 후위식에서 피연산자와 연산자만 남겼으므로 그냥 else.                   

                                          double result = 0;          // 결과값을 저장해둘 변수

                                          double operand2 = Double.parseDouble((String)st.pop());     // 스택에 저장된 값을 double형태로 뽑아냄.

                                          double operand1 = Double.parseDouble((String)st.pop());

                                          if (pointer.data.toString().equals("+"))        // 각 연산자에 따라 연산작업. 일항연산자는 infix에서 미리 계산해둠.

                                                     result = operand1 + operand2;

                                          else if (pointer.data.toString().equals("-"))

                                                     result = operand1 - operand2;

                                          else if (pointer.data.toString().equals("/"))

                                                     result = operand1 / operand2;

                                          else if (pointer.data.toString().equals("*"))

                                                     result = operand1 * operand2;

                                          st.push(Double.toString(result), 5); // 연산자에 따라 연산한 결과값을 다시 push.

                                          pointer = pointer.link;

                                }

                     } // end while.

                     double result = Double.parseDouble((String)st.pop());         // 최종 결과값은 스택에 남아있는 하나의 수 입니다.

                     if (!st.isEmpty()) { // 연산이 끝났는데도 스택이 뭔가 남아있다면 에러.

                                System.out.println("괄호와 피연산자 혹은 괄호와 괄호 사이에 연산자를 쓰지 않았습니다.");

                                throw new NullPointerException();

                     }

                     return result;     // 최종적으로 연산결과 result를 반환합니다.

           }

}