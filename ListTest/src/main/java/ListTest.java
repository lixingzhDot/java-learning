import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<Integer>();
		List<Integer> list2 = new LinkedList();
		
		HashMap<String, Integer> test = new HashMap<> ();
		Integer x = 1;
		test.put("a", 1);
		System.out.println(test);
		test.get("a");
		
		System.out.println(manipulate("test"));
	}

	private static String manipulate(String n) {
		char[] nArray = n.toCharArray();
		char[] nArrayCopy = n.toCharArray();
		nArray[0] = 'a';
		System.out.println(n);
		System.out.println(nArray);
		System.out.println(nArrayCopy);
		return new String(nArray);
	}
}
