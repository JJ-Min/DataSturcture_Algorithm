import java.util.*;
public class DivisionFunction {  
	/*해쉬 함수 중 가장 대표적인 제산 함수를 JAVA를 이용하여 구현 
	  테이블 크기는 10으로  지정 
	  사용자에게 숫자를 입력 받으면 해당 해시 주소를 알려줌 */
	
   static int table_size=10;
   int hashAdd;
   int data_num;
   
    DivisionFunction(){
		this.data_num=0;
		this.hashAdd=0;
		}
	
	void inputTableSize() {  //해시 테이블의 크기를 입력 받음
		
		Scanner sc =new Scanner(System.in);
	    System.out.println("숫자를 입력해주세욘");
	    this.data_num=sc.nextInt();
        sc.close();
    }
	
	
	public void getHashAddress() {
		this.hashAdd=this.data_num%table_size;
		System.out.print(data_num+"의 해시 주소(버킷주소)="+hashAdd);
		}
	
	public void process() { // 전체 프로세스의 흐름을 함수 안에 전부 넣어서 이것만 사용 귀찮으니까..
		inputTableSize();
		getHashAddress();
	}
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DivisionFunction a=new DivisionFunction();
		a.process();
	}

}
