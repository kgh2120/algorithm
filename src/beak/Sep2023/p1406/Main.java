package beak.Sep2023.p1406;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        LinkedList<Character> left = new LinkedList<>();
        LinkedList<Character> right = new LinkedList<>();
        for (char c : br.readLine().toCharArray()) {
            left.add(c);
        }

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String command = br.readLine();

            switch (command.charAt(0)) {
                case 'L':
                    if(!left.isEmpty())
                        right.addFirst(left.removeLast());
                    break;
                case 'D':
                    if(!right.isEmpty())
                        left.addLast(right.removeFirst());
                    break;
                case 'B':
                    if(!left.isEmpty())
                        left.removeLast();
                    break;
                case 'P':
                    left.add(command.charAt(2));
                    break;
            }
        }

        for (Character character : left) {
            sb.append(character);
        }
        for (Character character : right) {
            sb.append(character);
        }
        System.out.println(sb);

    }


}