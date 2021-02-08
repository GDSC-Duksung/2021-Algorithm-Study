import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q_10828 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		String cmd;
		int cmd_number, top;
		Stack<Integer> stack = new Stack<>();
		ArrayList<Integer> list = new ArrayList();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			cmd = st.nextToken();
			switch (cmd) {
				case "push":
					cmd_number = Integer.parseInt(st.nextToken());
					stack.push(cmd_number);
					break;
				case "pop":
					if (stack.isEmpty())
						list.add(-1);
					else
						list.add(stack.pop());
					break;
				case "size":
					list.add(stack.size());
					break;
				case "empty":
					if (stack.isEmpty())
						list.add(1);
					else
						list.add(0);
						
					break;
				case "top":
					if (stack.isEmpty())
						list.add(-1);
					else
						list.add(stack.peek());
					break;
			}
		}
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
