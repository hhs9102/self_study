package effective;

class CloneHasArray implements Cloneable{
	String[] nameArray = {"1","2","3"};
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		CloneHasArray cha =  (CloneHasArray) super.clone();
		cha.nameArray = nameArray.clone();
		return cha;
	}
	
	@Override
	public String toString() {
		return String.join("-", nameArray);
	}
}

public class CloneHasArrayTest {
	public static void main(String[] args) throws CloneNotSupportedException {
		CloneHasArray 원본 = new CloneHasArray();
		CloneHasArray 복사본 = (CloneHasArray)원본.clone();
		
		System.out.println("clone으로 객체 복사(복사본 = 원본.clone())");
		System.out.println("hashCode : "+원본.hashCode());
		System.out.println("hashCode : "+복사본.hashCode());
		
		System.out.println("복사본 name 수정");
		복사본.nameArray[0] = "3";
		System.out.println("원본 : "+원본.toString());
		System.out.println("복사본 : "+복사본.toString());
		
		System.out.println();
		원본 = new CloneHasArray();
		System.out.println("=로 객체 참조(복사본 = 원본)");
		복사본 = 원본;
		System.out.println("hashCode : "+원본.hashCode());
		System.out.println("hashCode : "+복사본.hashCode());
		
		System.out.println("복사본 name 수정");
		복사본.nameArray[0] ="3";
		System.out.println("원본 : "+원본.toString());
		System.out.println("복사본 : "+복사본.toString());
		
	}
}

