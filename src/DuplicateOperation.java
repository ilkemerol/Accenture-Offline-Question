public class DuplicateOperation{
	String input = "";
	int user_No = 0;
	public DuplicateOperation(String comingInput, int comingNumber){
		input = comingInput;
		user_No = comingNumber;
	}
	public String operation(){
			//Problem Solution Begin
			int count = 1;
			int ctrl_count = 1;
			StringBuilder str = new StringBuilder(input);
			//Control String - All same char or not (Begin)
			for(int ctrl=0; ctrl<str.length(); ctrl++){
				if(str.charAt(0) == str.charAt(ctrl)){
					ctrl_count++;
				}
			}
			if(ctrl_count-1 == str.length() && ctrl_count >= user_No){
				for(int ctrl=0; ctrl<str.length(); ctrl++){
					str.setCharAt(ctrl, '*');
				}
			}
			//Control End
			for(int i=0; i<str.length(); i++){
				for(int j=i+1; j <str.length(); j++){
					if(str.charAt(i) == str.charAt(j)){
						count++;
						/*System.out.println("I:" + i);
						System.out.println("I-:" + str.charAt(i));
						System.out.println("J:" + j);
						System.out.println("J-:" + str.charAt(j));
						System.out.println(count);*/
					}
					else{
						if(count >= user_No){
							for(int change=i; change<j; change++){
								str.setCharAt(change, '*');
							}
						}
						count = 1;
						i = j-1;
						break;
					}
					//For last index
					if(j == str.length() && count >= user_No){
						for(int change=i; change<=j; change++){
							str.setCharAt(change, '*');
						}
						break;
					}
				}
			}
			//Problem Solution End
			return str.toString();
		}
}
