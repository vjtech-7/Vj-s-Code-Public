package excel;

public class FindData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "About 203,000,000 results (0.67 seconds)";
	
		char[] arr = new char[] {' ',' ',' ',' '};
		//System.out.println(str.indexOf("("));
		str.getChars(str.indexOf("(")+1, str.indexOf("c")-3, arr, 0);
		//int x= (str.indexOf("c")-3) - (str.indexOf("(")+1) ;
		
		String str1 = new String(arr);
		System.out.println(str1 + "Hello");
		
		
	}

}
