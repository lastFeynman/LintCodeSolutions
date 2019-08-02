package naive;

public class Solution763 {

	public String hexConversion(int n, int k) {
		String base_k = "";
		int mid = n,remainder;
		
		while((mid/k) != 0 || (mid/k == 0 && mid != 0)) {
			remainder = mid%k;
			mid /= k;
			
			if(remainder>9) {
				switch (remainder) {
				case 10:
					base_k += 'A';
					break;
				case 11:
					base_k += 'B';
					break;
				case 12:
					base_k += 'C';
					break;
				case 13:
					base_k += 'D';
					break;
				case 14:
					base_k += 'E';
					break;
				case 15:
					base_k += 'F';
					break;
				default:
					break;
				}
			}else {
				base_k += remainder;
			}
		}
		char[] base_kArray = base_k.toCharArray();
		char tmp;
		for(int i=0;i<base_kArray.length/2;i++) {
			tmp = base_kArray[i];
			base_kArray[i] = base_kArray[base_kArray.length-i-1];
			base_kArray[base_kArray.length-i-1] = tmp;
		}
		base_k = new String(base_kArray);
		return base_k;
    }
	
	public static void main(String[] args) {
		System.out.println(new Solution763().hexConversion(30, 16));
	}

}
