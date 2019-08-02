package easy;

import java.util.ArrayList;
import java.util.List;

public class Solution9 {
	public List<String> fizzBuzz(int n) {
        List<String> numList = new ArrayList<>();
        outer:for(int i=1;i<=n;i++) {
        	while(i%3==0 && i%5==0) {
        		numList.add("fizz buzz");
        		continue outer;
        	}
        	while(i%3==0) {
        		numList.add("fizz");
        		continue outer;
        	}
        	if(i%5==0) {
        		numList.add("buzz");
        	}else {
        		numList.add(i+"");
        	}
        }
        
        return numList;
    }
	public static void main(String[] args) {
		Solution9 s = new Solution9();
		List<String> list = s.fizzBuzz(100);
		for (String string : list) {
			System.out.println(string);
		}
	}

}
