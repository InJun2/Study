package InterfaceTest;

public class NHBank implements Bank{
	@Override
    public void withDraw(int price) {
        System.out.print("NH���ุ�� ���� ����...");
        System.out.println(price+" ���� �����Ѵ�.");  
    }
 
	@Override
    public void deposit(int price) {
        System.out.println("NH���ุ�� �Ա� ����..."+price+" ���� �Ա��Ѵ�.");
    }
     
    public void findDormancyAccount(){
        System.out.println("NH���ุ�� �޸���� ã���ֱ� ����");
    } // �ٿ�ĳ������ Main���� ����� �������̵��� ���� �ʾ� Bank�� �޼ҵ� ���

}
