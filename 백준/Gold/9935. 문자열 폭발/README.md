# [Gold IV] 문자열 폭발 - 9935 

[문제 링크](https://www.acmicpc.net/problem/9935) 

### 분류

자료 구조, 스택, 문자열

### 문제 설명

<p>상근이는 문자열에 폭발 문자열을 심어 놓았다. 폭발 문자열이 폭발하면 그 문자는 문자열에서 사라지며, 남은 문자열은 합쳐지게 된다.</p>

<p>폭발은 다음과 같은 과정으로 진행된다.</p>

<ul>
	<li>문자열이 폭발 문자열을 포함하고 있는 경우에, 모든 폭발 문자열이 폭발하게 된다. 남은 문자열을 순서대로 이어 붙여 새로운 문자열을 만든다.</li>
	<li>새로 생긴 문자열에 폭발 문자열이 포함되어 있을 수도 있다.</li>
	<li>폭발은 폭발 문자열이 문자열에 없을 때까지 계속된다.</li>
</ul>

<p>상근이는 모든 폭발이 끝난 후에 어떤 문자열이 남는지 구해보려고 한다. 남아있는 문자가 없는 경우가 있다. 이때는 "FRULA"를 출력한다.</p>

<p>폭발 문자열은 같은 문자를 두 개 이상 포함하지 않는다.</p>

### 입력 

 <p>첫째 줄에 문자열이 주어진다. 문자열의 길이는 1보다 크거나 같고, 1,000,000보다 작거나 같다.</p>

<p>둘째 줄에 폭발 문자열이 주어진다. 길이는 1보다 크거나 같고, 36보다 작거나 같다.</p>

<p>두 문자열은 모두 알파벳 소문자와 대문자, 숫자 0, 1, ..., 9로만 이루어져 있다.</p>

### 출력 

 <p>첫째 줄에 모든 폭발이 끝난 후 남은 문자열을 출력한다.</p>



#  🚀  오답노트 

```diff
/*

    문자열이 주어진다. 문자열에 '폭발 문자열'이라는 것이 있으면, 폭발한다.

    폭발동작은 다음과 같다.
    1. 한 문자열 내에 폭발 문자열이 있다면 모두 사라진다.
    2. 새로운 문자열이 생성된다.
    1~2번 과정을 폭발 문자열이 없을때까지 반복한다.

    주의할 점은 새로운 문자열이 생성되면서 폭발 문자열이 새로 등장할 수 있다는 점이다.

    폭발 문자열이 더이상 없다면 그 상태의 문자열을 출력한다.
    하지만 모든 문자열이 다 터진다면 'FRULA'라는 단어를 출력한다.

    초기 문자열의 길이는 1<= L <= 1_000_000 (10^6)

    간단하게 생각해서 선형 탐색으로 쭉 가는거로는 시간초과가 날 가능성이 높아보인다.

    생각나는 방법
    1. 첫번째엔 선형탐색을 진행한다. 이때 폭발된 문자열의 위치를 찾는다.
       새로 폭발할 문자열이 생긴다면, 어차피 이 근처니까, 그쯤에서 찾아보기.

    그런데 굳이 한번에 터뜨릴 필요가 있나? 그냥 투포인터처럼 하면 안되나? 그게 1번이랑 동일한듯?


*/

import java.util.*;
import java.io.*;

public class Main {

    static Node head;
    static Node cursor;
    static Node tail;
    static int size;

    static int targetLength;
    static char[] targetArray;

    static int index;
+    static boolean isNext;

    public static void main(String[] args) throws Exception {
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();
        String target = br.readLine();
        targetArray = target.toCharArray();

        // Node head;
        // Node cursor;
        // Node tail;

        targetLength = target.length();
        if (word.length() < targetLength) {
            System.out.println(word);
            return;
        }
+        StringBuilder sb = new StringBuilder();
+        if (targetLength == 1) {
+            for(char c : word.toCharArray()) {
+                if(c == target.charAt(0)) {
+                    continue;
+                }
+                sb.append(c);
+            }

+        } else {
+            while (index < word.length()) {
+                char v = word.charAt(index++);
+                // 일단 추가를 한다.
+                build(v);
+                // 그 다음에 비교 진행.
+                if (size < targetLength) continue;
+                // 아니면 액션
+                action();
+            }

-        // 전설의 시작
+            Node c = head;
+            while (c != null) {
+                sb.append(c.v);
+                c = c.next;
+            }

-        while (index < word.length()) {
-            char v = word.charAt(index++);
-            // 일단 추가를 한다.
-            build(v);
-            // 그 다음에 비교 진행.
-            if (size < targetLength) continue;
-            // 아니면 액션
-            action();
        }

-        Node c = head;
-        StringBuilder sb = new StringBuilder();
-        while (c != null) {
-            sb.append(c.v);
-            c = c.next;
-        }

+        // 전설의 시작
+
+
        if (sb.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb.toString());
        }


    }

    static void action() {

        int cnt = 0;
        Node c = cursor;
        boolean flag = false;
-        try {
-            while (cnt < targetLength) {

-                if (c.v != targetArray[cnt]) {
-                    flag = true;
-                    break;
-                }
-                c = c.next;
-                cnt++;
+        while (cnt < targetLength) {
+
+            if (c.v != targetArray[cnt]) {
+                flag = true;
+                break;
            }
-
-        } catch (NullPointerException e) {
-            throw new IndexOutOfBoundsException();
+            c = c.next; // NPE가 터짐.
+            cnt++;
        }

        if (flag) {
            cursor = cursor.next;
        } else {
            // cursor 부터 targetLength까지 삭제.
            // cursor는 targetLength -1 만큼 뒤로간다.

            size -= targetLength;
            if (cursor.prev != null) {
                tail = cursor.prev;
                tail.next = null;
                cnt = 0;
                while (cnt < targetLength - 1 && cursor.prev != null) {
                    cursor = cursor.prev;
                    cnt++;
                }
            } else {
                head = null;
                cursor = null;
                tail = null;
            }


        }
    }

    static void build(char v) {
        if (head == null) {
            head = new Node(v, null, null);
            tail = head;
            cursor = head;
        } else {
            tail.next = new Node(v, tail, null);
            tail = tail.next;
        }
        size++;
    }

    static class Node {
        char v;
        Node prev;
        Node next;

        public Node(char v, Node prev, Node next) {
            this.v = v;
            this.prev = prev;
            this.next = next;
        }
    }
+}

```


 ## 🏆 전체 코멘트 

흠.. 신기하네요?