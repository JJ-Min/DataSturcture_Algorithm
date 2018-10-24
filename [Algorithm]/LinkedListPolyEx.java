
class ListNode{
	float coef; //계수 값이 소수점일 수도 있기 때문에 실수로 선언
 	int expo; // 지수의 값은 늘 정수이기 때문에 정수로 선언
	ListNode next;
	
	public ListNode() {
		next =null; // 마지막 노드가 가리키는 것은 null 이어야 함
	}
	public ListNode(float coef,int expo) {
		this.coef=coef; // 계수 초기화
		this.expo=expo;  // 지수 초기화
		this.next=null; // 새로운 노드가 추가되면 마지막은 null
	}
	
	public ListNode(float coef,int expo,ListNode next) {
		this.coef=coef; //계수 초기화
		this.expo=expo; // 지수 초기화
		this.next=next; // 다음 노드 
	}
	
	public float getCoef() {
		return this.coef; //계수 반환 함수
	}
	
	public int getExpo() {
		return this.expo; // 지수 반환 함수
	}
}
// 다항식 항 삽입 연산
class Polynomial{
	ListNode head;
	
	public Polynomial() {
		head=null; //삽입 할 노드 초기화
	}
	

	@SuppressWarnings("null")
	public void insertNode(float coef, int expo) {
		ListNode node= new ListNode(coef,expo); // 삽입을 위한 새로운 인스턴스 생성
		if(head==null) { //head 가 비어있으면
			head=node; //생성된 노드가 첫번째 노드
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
			System.out.println("출력 할 노드 존재 하지 않습니다.");
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
		Polynomial A =new Polynomial(); // 다항식 A 인스턴스 생성
		A.insertNode(4,5); // 값 집어넣기 
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
	
	static Polynomial DivPolynomial(Polynomial A,  Polynomial B) { //나눗셈 하는 과정,첫번재 항의 결과는 나오는데 두번째 항이 값이 올바르지 않음
		// 다시 생각해야함 
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
