package Amazon;

import java.util.*;

class Test {

    public static String StringChallenge(String str) {

        if (str == null || str.isEmpty()) {
            return str;
        }
        Map<String, String> map = new HashMap<>();
        map.put("zero", "0");
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine", "9");
        map.put("plus", "+");
        map.put("minus", "-");

        int start = 0;
        Queue<String> queue = new LinkedList<String>();
        for (int end = start + 1; end <= str.length(); end++) {
            String string = str.substring(start, end);
            System.out.println("end " + end);
            if (string.equals("plus") || string.equals("minus")) {
                StringBuilder stringBuilder = new StringBuilder();
                while (!queue.isEmpty() || (queue.peek() == "+" || queue.peek() == "-")) {
                    stringBuilder.append(queue.poll());
                }
                queue.offer(stringBuilder.toString());
                System.out.println("queue.offer " + stringBuilder.toString());
                queue.offer(map.get(string));
                System.out.println("queue.offer " + string);
                start = end;
            } else if (map.containsKey(string)) {
                queue.offer(map.get(string));
                System.out.println("queue.offer " + string);
                start = end;
            }

        }

        StringBuilder stringBuilder;

        int result = 0;
        boolean minus = false;

        while (!queue.isEmpty()) {
            stringBuilder = new StringBuilder();
            while (!queue.isEmpty()) {
                String queuetop = queue.peek();
                System.out.println("queue.poll() " + queuetop);
                if (queuetop.equals("+") || queuetop.equals("-")) {
                    if (minus) {
                        System.out.println(stringBuilder.toString());
                        result = result + -(Integer.valueOf(stringBuilder.toString()));
                        minus = false;
                    } else {
                        System.out.println(stringBuilder.toString());
                        result = result + (Integer.valueOf(stringBuilder.toString()));
                    }
                    break;
                }
                String polledString = queue.poll();
                stringBuilder.append(polledString);
            }

            if (queue.size() > 0) {
                String string = queue.poll();
                if (string.equals("-")) {
                    minus = true;
                }
                continue;
            }

            if (minus) {
                System.out.println(stringBuilder.toString());
                result = result + -(Integer.valueOf(stringBuilder.toString()));
                minus = false;
            } else {
                System.out.println(stringBuilder.toString());
                result = result + (Integer.valueOf(stringBuilder.toString()));
            }
        }

        String string = String.valueOf(result);

        Map<Character, String> reverseMap = new HashMap<>();
        reverseMap.put('0', "zero");
        reverseMap.put('1', "one");
        reverseMap.put('2', "two");
        reverseMap.put('3', "three");
        reverseMap.put('4', "four");
        reverseMap.put('5', "five");
        reverseMap.put('6', "six");
        reverseMap.put('7', "seven");
        reverseMap.put('8', "eight");
        reverseMap.put('9', "nine");
        reverseMap.put('-', "negative");

        stringBuilder = new StringBuilder();
        for (int index = 0; index < string.length(); index++) {
            stringBuilder.append(reverseMap.get(string.charAt(index)));
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        // keep this function call here
        System.out.print(StringChallenge("onezeropluseight"));
    }

}
