package Test;

public class View {
	
	
	public static void ViewInfo(){
		System.out.println("========�޴�����========");
		System.out.println("1.���");
		System.out.println("2.ã��");
		System.out.println("3.����");
		System.out.println("4.��ü���");
		System.out.println("5.����");
		System.out.println("------------------");
		System.out.println("��ȣ�� �������ּ���..");	
		System.out.println("------------------");

	}
	
	public static void RegistrationView(){
		System.out.println("========�޴�����========");
		System.out.println("1.�л�");
		System.out.println("2.����");
		System.out.println("3.������");
		System.out.println("4.�����޴�");
		System.out.println("------------------");
		System.out.println("��ȣ�� �������ּ���..");	
		System.out.println("------------------");

	}

	public void InfoView(Student stu) {
		stu.getInfo();
	}
	
	public void InfoView(Professor pro) {
		pro.getInfo();
	}
	
	public void InfoView(Manager man) {
		man.getInfo();
	}
	
	
}
