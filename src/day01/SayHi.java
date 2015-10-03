package day01;



public class SayHi {
	Adder adder;
	public String sayHi(String aString, String bString) {
//		Adder adder = new Adder();
//		String result = "";
//		result = adder.add(aString, bString);
//		return result;
		adder=getAdder();
		String result = "";
		try{
			result = adder.add(aString, bString);
			
		}catch(Exception  e)
		{
			e.printStackTrace();
		}
		return result;
	}
	public Adder getAdder() {
		return adder;
	}
	public void setAdder(Adder adder) {
		this.adder = adder;
	}

	
	
}

