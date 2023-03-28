package LoginSystem;

import java.util.ArrayList;

import javax.swing.JFrame;

public class Search extends JFrame{
	public static boolean isEmpty(ArrayList<Person> list, String to_search) {
		boolean flag = true;
		for(int i = 0; i < list.size(); i++) {
			if(to_search.equals(list.get(i).id)) {
				flag = false; //같은 id가 있으면 true
			}else {
				flag =  true;
			}
		}
		return flag;
	}
}
