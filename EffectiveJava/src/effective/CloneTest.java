package effective;


class Clone implements Cloneable{
	String name;
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	@Override
	public String toString() {
		return name;
	}
}

public class CloneTest {
	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub

		Clone ���� = new Clone();
		����.name = "����";
		Clone ���纻 = (Clone)����.clone();
		
		System.out.println("clone���� ��ü ����(���纻 = ����.clone())");
		System.out.println("hashCode : "+����.hashCode());
		System.out.println("hashCode : "+���纻.hashCode());
		
		System.out.println("���纻 name ����");
		���纻.name = "���纻";
		System.out.println("���� : "+����.name);
		System.out.println("���纻 : "+���纻.name);
		
		System.out.println();
		System.out.println("=�� ��ü ����(���纻 = ����)");
		���纻 = ����;
		System.out.println("hashCode : "+����.hashCode());
		System.out.println("hashCode : "+���纻.hashCode());
		
		System.out.println("���纻 name ����");
		���纻.name ="���纻";
		System.out.println("���� : "+����.name);
		System.out.println("���纻 : "+���纻.name);
		
	}
}

