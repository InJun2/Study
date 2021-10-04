package InterfaceTest;

public class NHBank implements Bank{
	@Override
    public void withDraw(int price) {
        System.out.print("NH은행만의 인출 로직...");
        System.out.println(price+" 원을 인출한다.");  
    }
 
	@Override
    public void deposit(int price) {
        System.out.println("NH은행만의 입금 로직..."+price+" 원을 입금한다.");
    }
     
    public void findDormancyAccount(){
        System.out.println("NH은행만의 휴면계좌 찾아주기 로직");
    } // 다운캐스팅한 Main에서 실행시 오버라이딩을 하지 않아 Bank의 메소드 출력

}
