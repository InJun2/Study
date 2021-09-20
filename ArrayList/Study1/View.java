package Test;

public class View {
	
	
	public static void ViewInfo(){
		System.out.println("========메뉴선택========");
		System.out.println("1.등록");
		System.out.println("2.찾기");
		System.out.println("3.삭제");
		System.out.println("4.전체출력");
		System.out.println("5.종료");
		System.out.println("------------------");
		System.out.println("번호를 선택해주세요..");	
		System.out.println("------------------");

	}
	
	public static void RegistrationView(){
		System.out.println("========메뉴선택========");
		System.out.println("1.학생");
		System.out.println("2.교수");
		System.out.println("3.관리자");
		System.out.println("4.이전메뉴");
		System.out.println("------------------");
		System.out.println("번호를 선택해주세요..");	
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
