package Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkList {
	public static void main(String[] args) {
		LinkedList<Integer> num = new LinkedList<>();	// integer ���� �����ϴ� linklist
		LinkedList<Integer> num2 = new LinkedList<>(Arrays.asList(1,2,3));	
		// integer �� ������ linklist���� �� 1,2,3�� ����
		
		num2.addFirst(1);//���� �տ� ������ �߰�
		num2.addLast(2);//���� �ڿ� ������ �߰�
		num2.add(3);//������ �߰�
		num2.add(1, 10);//index 1�� ������ 10 �߰�
		
		num2.removeFirst(); //���� ���� ������ ����
		num2.removeLast(); //���� ���� ������ ����
		num2.remove(); //������ 0��° index����
		num2.remove(1); //index 1 ����
		num.clear(); //��� �� ����
		
		System.out.println(num2.size()); //list ũ�� : 3
		System.out.println(num2.get(0));//0��° index ���
		
		for(Integer i : num2) { //for���� ���� ��ü���
		    System.out.print(i + " ");
		}
		
		System.out.println();

		Iterator<Integer> iter = num2.iterator(); //Iterator ���� 
		while(iter.hasNext()){//�������� �ִ��� üũ
		    System.out.print(iter.next() + " "); //�� ���
		}
		
		System.out.println("\nlist�� 1�� �ִ��� �˻� : "+num2.contains(1)); //list�� 1�� �ִ��� �˻� : true
		System.out.println("list�� 1 ��ġ �˻� �� �ش� �ε��� : " + num2.indexOf(1)); //1�� �ִ� index��ȯ ������ -1
		
	}

}
