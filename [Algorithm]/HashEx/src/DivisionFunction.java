import java.util.*;
public class DivisionFunction {  
	/*�ؽ� �Լ� �� ���� ��ǥ���� ���� �Լ��� JAVA�� �̿��Ͽ� ���� 
	  ���̺� ũ��� 10����  ���� 
	  ����ڿ��� ���ڸ� �Է� ������ �ش� �ؽ� �ּҸ� �˷��� */
	
   static int table_size=10;
   int hashAdd;
   int data_num;
   
    DivisionFunction(){
		this.data_num=0;
		this.hashAdd=0;
		}
	
	void inputTableSize() {  //�ؽ� ���̺��� ũ�⸦ �Է� ����
		
		Scanner sc =new Scanner(System.in);
	    System.out.println("���ڸ� �Է����ּ���");
	    this.data_num=sc.nextInt();
        sc.close();
    }
	
	
	public void getHashAddress() {
		this.hashAdd=this.data_num%table_size;
		System.out.print(data_num+"�� �ؽ� �ּ�(��Ŷ�ּ�)="+hashAdd);
		}
	
	public void process() { // ��ü ���μ����� �帧�� �Լ� �ȿ� ���� �־ �̰͸� ��� �������ϱ�..
		inputTableSize();
		getHashAddress();
	}
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DivisionFunction a=new DivisionFunction();
		a.process();
	}

}
