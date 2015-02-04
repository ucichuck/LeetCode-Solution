package leetcode.Solutions;

public class ExcelSheetColumnTitle {
	public String convertToTitle(int n) {
        if(n <= 0){
        	return "";
        }
        String res = "";
        while( n > 0){
        	int tmpInt = n%26;
        	char tmp;
        	n = n/26;
        	if(tmpInt == 0){
        		tmp = 'Z';
        		n--;
        	}else{
        		tmp = (char)(tmpInt+'A'-1);
        	}
        	 
        	res = tmp + res;
        	
        }
        return res;
    }
}
