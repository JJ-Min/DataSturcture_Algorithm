
class ListNode{
	float coef; //��� ���� �Ҽ����� ���� �ֱ� ������ �Ǽ��� ����
 	int expo; // ������ ���� �� �����̱� ������ ������ ����
	ListNode next;
	
	public ListNode() {
		next =null; // ������ ��尡 ����Ű�� ���� null �̾�� ��
	}
	public ListNode(float coef,int expo) {
		this.coef=coef; // ��� �ʱ�ȭ
		this.expo=expo;  // ���� �ʱ�ȭ
		this.next=null; // ���ο� ��尡 �߰��Ǹ� �������� null
	}
	
	public ListNode(float coef,int expo,ListNode next) {
		this.coef=coef; //��� �ʱ�ȭ
		this.expo=expo; // ���� �ʱ�ȭ
		this.next=next; // ���� ��� 
	}
	
	public float getCoef() {
		return this.coef; //��� ��ȯ �Լ�
	}
	
	public int getExpo() {
		return this.expo; // ���� ��ȯ �Լ�
	}
}
// ���׽� �� ���� ����
class Polynomial{
	ListNode head;
	
	public Polynomial() {
		head=null; //���� �� ��� �ʱ�ȭ
	}
	

	@SuppressWarnings("null")
	public void insertNode(float coef, int expo) {
		ListNode node= new ListNode(coef,expo); // ������ ���� ���ο� �ν��Ͻ� ����
		if(head==null) { //head �� ���������
			head=node; //������ ��尡 ù��° ���
		}
		else {
			ListNode current=head; 
			while(current.next!=null) {
				current=current.next;
			}
			current.next=node;
		}
	}
	public void print() {
		if (head==null) {
			System.out.println("��� �� ��� ���� ���� �ʽ��ϴ�.");
		} else {
			ListNode current=head;
			while(current.next!=null) {
				System.out.print(current.coef+"x^"+current.expo+"+");
				current =current.next;
			}
			System.out.print(current.coef+"x^"+current.expo);
			System.out.println();
		}
	}
	


}


public class LinkedListPolyEx {
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Polynomial A =new Polynomial(); // ���׽� A �ν��Ͻ� ����
		A.insertNode(4,5); // �� ����ֱ� 
		A.insertNode(7,4);
		A.insertNode(1,3);
		A.insertNode(0,2);
		A.insertNode(2,1);
		A.insertNode(5,0);
		System.out.print("A(X)=");
		A.print();
		
		Polynomial B =new Polynomial();
		B.insertNode(8, 4);
		B.insertNode(3, 3);
		B.insertNode(5, 2);
		B.insertNode(2, 1);
		B.insertNode(1, 0);
		System.out.print("B(X)=");
		B.print();
		
		
		Polynomial C=AddPloynomial(A,B);
		System.out.print("C(X)=");
		C.print();
		
		Polynomial d= DivPolynomial(A,B);
		System.out.print("D(X)=");
		d.print();
		}
	
	static Polynomial AddPloynomial(Polynomial A,Polynomial B) {
		ListNode a =A.head;
		ListNode b= B.head;
		Polynomial C=new Polynomial();
		
		while(a!=null && b!=null) {
			if(a.expo<b.expo) {
				C.insertNode(b.coef, b.expo);
				b=b.next;
			}
			else if(a.expo>b.expo) {
				C.insertNode(a.coef,a.expo);
				a=a.next;
			}
			else {
				C.insertNode(a.coef+b.coef, a.expo);
				a=a.next;
				b=b.next;
			}
		}
		while(a!=null) {
			C.insertNode(a.coef, a.expo);
			a=a.next;
		}

		while(b!=null) {
			C.insertNode(b.coef, b.expo);
			b=b.next;
		}
		return C;
		
	}
	
	static Polynomial DivPolynomial(Polynomial A,  Polynomial B) { //������ �ϴ� ����,ù���� ���� ����� �����µ� �ι�° ���� ���� �ùٸ��� ����
		// �ٽ� �����ؾ��� 
		ListNode a =A.head; 
		ListNode b= B.head;
		Polynomial C=new Polynomial();
		float d = 0;
		while(a!=null && b!=null) {
			if(a.expo>b.expo) {
				C.insertNode(a.coef/b.coef, a.expo-b.expo);
				d=(a.next.coef-(b.next.coef*(a.coef/b.coef)));
				a=a.next;
				}
			else if(a.expo==b.expo) {
			    C.insertNode(d/b.coef, a.expo-b.expo);
			    a=a.next;		
               }
		   else break;
			
	}
		return C;	
}
}
