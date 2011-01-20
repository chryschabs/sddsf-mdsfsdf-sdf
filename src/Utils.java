
public class Utils {

	public static float trim(float flt, int nb){
		if(!(new Float(flt).isNaN())){
			String tmp;
			tmp = Float.toString(flt);
			if(tmp.charAt(0) == '-'){
				tmp = tmp.substring(0, nb+1);
			}
			else{
				tmp = tmp.substring(0, nb);
			}	
			return Float.parseFloat(tmp);
		}
		else{
			return flt;
		}
		
	}
}
