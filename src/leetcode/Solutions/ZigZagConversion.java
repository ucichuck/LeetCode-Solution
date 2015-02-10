package leetcode.Solutions;

public class ZigZagConversion {
	public String convert(String s, int nRows) {
        if(nRows <= 1){
        	return s;
        }
        StringBuilder res = new StringBuilder();
        for(int i=0; i<nRows; i++){
        	for(int j=i; j<s.length(); ){
        		res.append(s.charAt(j));
        		if(i != 0 && i != nRows-1){
        			if((j+2*nRows-2*i-2)<s.length()){
        				res.append(s.charAt(j+2*nRows-2-2*i));
        			}
        		}
        		j = j+2*nRows-2;
        	}
        }
        return res.toString();
    }
}
