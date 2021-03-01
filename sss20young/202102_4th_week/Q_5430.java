import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Q_5430 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            char[] p = br.readLine().toCharArray();
            Deque<Character> pArray = new ArrayDeque<Character>();
            for (int j = 0; j < p.length; j++) {
                pArray.offer(p[j]);
            }

            int n = Integer.parseInt(br.readLine());

            /* 이 부분을 아래와 같이 String으로 받으면 10, 100이 넘어가는 수에 대해서 1 0과 1 0 0으로 인식하게 된다.
            String x = br.readLine();
            Deque<Integer> xArray = new ArrayDeque<Integer>();
            for (int j = 0; j < n; j++) {
                xArray.offer(Character.getNumericValue(x.charAt(j*2+1)));
            }
            
            [ 반례 ]
                1
                R
                2
                [100,100]
            */

            String[] x = br.readLine().replace("[","").replace("]","").split(",");
            Deque<Integer> xArray = new ArrayDeque<Integer>();
            for (int j = 0; j < n; j++) {
                xArray.offer(Integer.parseInt(x[j]));
            }
            
            getResult(pArray, p.length, xArray);
        }

        System.out.print(sb.toString());
    } 

    public static void getResult(Deque<Character> pArray, int pSize, Deque<Integer> xArray) {
        
        boolean flag = true; // true는 앞, front를 의미하고, false는 뒤, rear를 의미한다.

        for (int i = 0; i < pSize; i++) {
            Character command = pArray.pop();
            if (command == 'R')
                flag = !flag;
            else if (command == 'D') {
                if (xArray.isEmpty()) {
                    sb.append("error\n");
                    return;
                }

                if (flag) xArray.removeFirst();
                else xArray.removeLast();
            }
        }

        print(xArray, flag);
    }

    public static void print(Deque<Integer> xArray, boolean flag) {
        sb.append("[");

        while (!xArray.isEmpty()) {
            if (flag) sb.append(xArray.pollFirst());
            else sb.append(xArray.pollLast());

            if (!xArray.isEmpty())
                sb.append(",");
        }

        sb.append("]\n");

        return;
    }
}