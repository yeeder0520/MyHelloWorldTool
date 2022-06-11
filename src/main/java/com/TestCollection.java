import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class TestCollection {
	public static void main(String args[]) throws Exception {
		List arrayList = new ArrayList();
//		List linkedList = new LinkedList();
//		List vector = new Vector();
		
		Set set = new HashSet();
		
		arrayList.add(10);
		arrayList.add(11);
		arrayList.add(12);
		arrayList.add(13);
		
		set.add("我");
		set.add("是");
		set.add("誰");
		set.add("阿");
		
		for(Object arrayLists : arrayList) {
			System.out.print("arrayLists="+arrayLists+"\t");
		}
		
		for(Object sets : set) {
			System.out.print("sets="+sets+"\t");
		}
	}
}
