import java.util.*;

class Main {
public static void main(String[] args)
{
	List<Integer> v
	= Arrays.asList(1, 1, 1, 2, 2, 2, 2, 11, 3, 3);
	int n = v.size();
	Map<Integer, Integer> mp = new HashMap<>();
	Stack<Integer> s = new Stack<>();

	for (int i : v) {
	mp.put(i, mp.getOrDefault(i, 0) + 1);
	}

	for (int i = n - 1; i >= 0; i--)
	s.push(v.get(i));

	for (int i = 0; i < n; i++) {
	int x = mp.get(v.get(i));
	boolean flag = true;
	Stack<Integer> ss = (Stack<Integer>)s.clone();
	while (!ss.empty()) {
		if (mp.get(ss.peek()) > x) {
		System.out.println(v.get(i) + " --> "
							+ ss.peek());
		flag = false;
		break;
		}
		ss.pop();
	}
	if (flag)
		System.out.println(v.get(i) + " --> " + -1);
	s.pop();
	}
}
}