package InterfaceTest;

public class Main {

	public static void main(String[] args) {
		Bank bank = new SHBank();
	    bank.withDraw(100);
	    bank.deposit(100);
	    bank.findDormancyAccount("4311");
	    Bank.BCAuth("SHBank");
	         
	    System.out.println("\n*************�ν��Ͻ� ��ü!!***************\n");
	         
	    bank = new SHBank();
	    bank.withDraw(100);
	    bank.deposit(100);
	    bank.findDormancyAccount("4311");
	    Bank.BCAuth("SHBank");
	         
	    System.out.println("\n*************īī������ ���� ����!!***************\n");	        //ȣȯ�� �Ұ�
	    /*
	    bank = new KakaoBank();
	    bank.withDraw(100);
	    bank.deposit(100);
	    bank.findDormancyAccount("4311");
	    �翬������ KaKaoBank�� ��ӹ����ʾұ� ������ Bank bank �� ���� �Ұ���
	    */
	         
	    System.out.println("\n*************���б� ������  ��ü!!***************\n");
	         
	    bank = new NHBank(); //new KBBank();
	    bank.withDraw(20000);
	    bank.deposit(1000);
	    bank.findDormancyAccount("855512");
	    Bank.BCAuth("NHBank");

	}

}
