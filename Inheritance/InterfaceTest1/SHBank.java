package InterfaceTest;

public class SHBank implements Bank {

    public void withDraw(int price) {
        System.out.println("SH���ุ�� ���� ����...");
        if(price < Bank.MAX_INTEGER){
            System.out.println(price+" ���� �����Ѵ�.");  
        }else{
            System.out.println(price+" ���� �������.");
        }
    }
 
    public void deposit(int price) {
        System.out.println("SH���ุ�� �Ա� ����..."+price+" ���� �Ա��Ѵ�.");
        System.out.println("SH������ ������ ����ó�� �۾��� ���� �Ѵ�.");
     
    }
     
    public String findDormancyAccount(String custId){
        System.out.println("**������������ 00���� ���� �޸���� ã���ֱ� �**");
        System.out.println("*SH���ุ�� ���� ����*");
        return "00���� 000-000-0000-00";
    }

}
