import java.util.*;
class node{                      //composition or containersip
	int data;
	node next;
	node(){
		data=0;
		next=null;
	}
	node(int a){
		data=a;
		next=null;
	}
}
class SLL{
	node head=null;
	int size=0;
	SLL(){
		head=null;
	}
	SLL(int a){
		head=new node(a);
	}
	void insertfirst(int a) {
		if(head==null) {
			head=new node(a);
		}
		else {
			node t=new node(a);
			t.next=head;
			head=t;
		}
		size++;
	}
	void insertlast(int a) {
		size++;
		if(head!=null) {
			node t=head;
			while(t.next!=null) {
				t=t.next;
			}
			node s=new node(a);
			t.next=s;
			s.next=null;
		}
		else {
			node t=new node(a);
			head=t;
		}
	}
	int deletefirst() {
		node t=head;
		if(t==null) {
			System.out.println("List is empty");
			return 0;
		}
		else {
			int temp=t.data;
			head=t.next;
			t=null;
			size--;
			return temp;
		}
	}
	int deletelast() {
		node t=head;
		if(t==null) {
			System.out.println("List is empty");
			return 0;
		}
		else if(t.next==null) {
			int temp=t.data;
			t=null;
			size--;
			return temp;
		}
		else {
			while(t.next.next!=null) {
				t=t.next;
			}
			int temp=t.next.data;
			t.next=null;
			size--;
			return temp;
		}
	}
	int count() {
		return size;
	}
	void display() {
		node t=head;
		if(t==null) {
			System.out.println("no elements");
		}
		else {
			while(t!=null) {
				System.out.print(t.data+"\t");
				t=t.next;
			}
		}
		System.out.println();
	}
	node search(int ele) {
		node t=head;
		while(t!=null&&t.data!=ele) {
			t=t.next;
		}
		if(t==null) {
			System.out.println("Element not found");
			return null;
		}
		else if(t.data==ele) {
			return t;
		}
		else {
			return null;
		}
	}
	node searchbefore(int ele) {
		node t=head;
		node temp=new node();
		while(t!=null&&t.data!=ele) {
			temp=t;
			t=t.next;
		}
		return temp;
	}
	boolean search_element(int ele) {
		node t=head;
		while(t!=null&&t.data!=ele) {
			t=t.next;
		}
		if(t.data==ele) {
			return true;
		}
		else {
			return false;
		}
	}
	void insertafter(int e1,int e2) {
		node temp=search(e1);
		if(temp==null) {
			System.out.println("Element is not present in the list");
		}
		else {
			node t=new node(e2);
			t.next=temp.next;
			temp.next=t;
			size++;
		}
	}
	void insertbefore(int e1,int e2) {
		node temp=searchbefore(e1);
		if(temp==null) {
			System.out.println("Element is not present in the list");
		}
		else {
			node t=new node(e2);
			t.next=temp.next;
			temp.next=t;
			size++;
		}
	}
	void delete_particular_element(int e) {
		size--;
		node t1=search(e);
		node t2=searchbefore(e);
		t2.next=t1.next;
	}
	void deleteafter(int e) {
		node t1=search(e);
		if(t1.next==null) {
			System.out.println("element is not present");
		}
		else {
			t1.next=t1.next.next;
			size--;
		}
	}
	void deletebefore(int e) {
		node t1=searchbefore(e);
		if(t1==null) {
			System.out.println("Element is not present");
		}
		else {
			size--;
			t1.next=t1.next.next;
		}
	}
	void insert_particular_position(int p,int e) {
		node t=new node(e);
		node temp=head;
		int i=1;
		while(i<p-1) {
			if(temp==null) {
				break;
			}
			else {
				temp=temp.next;
				i++;
			}
		}
		if(temp!=null) {
			t.next=temp.next;
			temp.next=t;
			size++;
		}
		else {
			System.out.println("List does not contain "+p+" elements");
		}
	}
	void delete_particular_position(int p) {
		node t=head;
		int i=1;
		while(i<p-1) {
			if(t==null) {
				break;
			}
			else {
				t=t.next;
				i++;
			}
		}
		if(t!=null) {
			t.next=t.next.next;
			size--;
		}
		else
			System.out.println("Element is not present in that position");
	}
	void concatenate(SLL l) {
		if(this.head!=null) {
			node t=this.head;
			while(t.next!=null) {
				t=t.next;
			}
			t.next=l.head;
		}
		else {
			node t=l.head;
		}
	}
	void merge_sorted_lists(SLL s1,SLL s2) {
		node t=s1.head;
		node s=s2.head;
		node temp = new node();
		node tail = temp;
		while(true)  
		{
			if(t == null)
			{
				tail.next = s;
				break;
			}
			if(s == null)
			{
				tail.next = t;
				break;
			}
			if(t.data <= s.data)
			{
				tail.next = t;
				t = t.next;
			}  
			else
			{
				tail.next = s;
				s = s.next;
			}
			tail = tail.next;
		}
		System.out.println("List after merging two sorted lists :");
		this.head=temp.next;
		this.display();
	}
	void middle_element() {
		int n=size/2;
		node t=head;
		for(int i=1;i<n;i++) {
			t=t.next;
		}
		if(size%2!=0) {
			System.out.println("Middle element is "+t.next.data);
		}
		else {
			System.out.println("Middle elements are "+t.data+" and "+t.next.data);
		}
	}
	void split_equal() {
		int n=this.count();
		node t=head;
		SLL l1=new SLL();
		SLL l2=new SLL();
		for(int i=1;i<=n/2;i++) {
			l1.insertlast(t.data);
			t=t.next;
		}
		for(int i=n/2+1;i<=n;i++) {
			l2.insertlast(t.data);
			t=t.next;
		}
		System.out.println("List is splitted into two equal halves ");
		System.out.println("First half is :");
		l1.display();
		System.out.println("Second half is :");
		l2.display();
	}
	void split_position(int p) {
		node t=head;
		SLL l1=new SLL();
		SLL l2=new SLL();
		for(int i=1;i<=p;i++) {
			l1.insertlast(t.data);
			t=t.next;
		}
		for(int i=p+1;i<=size;i++) {
			l2.insertlast(t.data);
			t=t.next;
		}
		System.out.println("List is splitted into two parts at given position");
		System.out.println("First part is :");
		l1.display();
		System.out.println("Second part is :");
		l2.display();
	}
	void split_element(int e) {
		node t=head;
		SLL l1=new SLL();
		SLL l2=new SLL();
		while(t.data!=e) {
			l1.insertlast(t.data);
			t=t.next;
		}
		if(t.next==null) {
			l1.insertlast(t.data);
			t=t.next;
			System.out.println("It is the last element in the list");
		}
		else if(t==null) {
			System.out.println("Element is not present in the list");
		}
		else {
			l1.insertlast(t.data);
			t=t.next;
			while(t!=null) {
				l2.insertlast(t.data);
				t=t.next;
			}
			System.out.println("List is splitted into two parts at given element");
			System.out.println("First part is :");
			l1.display();
			System.out.println("Second part is :");
			l2.display();
		}
	}
	void remove_duplicates() {
		node t=head;
		node s=new node();
		while(t!=null) {
			s=t.next;
			while(s!=null){
				if(t.data==s.data)
					t.next=s.next;
				s=s.next;
			}
			t=t.next;
		}
		System.out.println("List after removing duplicates is :");
		this.display();
	}
	boolean isCircularList() {
		node t=head;
		for(int i=0;i<size;i++) {
			t=t.next;
		}
		if(t==head) {
			return true;
		}
		else {
			return false;
		}
	}
}
public class linked_listMain{
	public static void main(String args[]) {
		Scanner scan=new Scanner(System.in);
		int ch;
		SLL s=new SLL();
		do {
			System.out.println("1.Insert node");
			System.out.println("2.Display");
			System.out.println("3.Count");
			System.out.println("4.delete first");
			System.out.println("5.delete last");
			System.out.println("6.insert Last");
			System.out.println("7.insert after");
			System.out.println("8.insert before");
			System.out.println("9.Delete particular element");
			System.out.println("10.delete after");
			System.out.println("11.delete before");
			System.out.println("12.insert in particular position");
			System.out.println("13.Delete particular position element");
			System.out.println("14.Concatenate two lists");
			System.out.println("15.Merge two sorted lists");
			System.out.println("16.Middle element");
			System.out.println("17.Split into two equal halves");
			System.out.println("18.Split into two parts at particular position");
			System.out.println("19.Split into two parts at particular element");
			System.out.println("20.remove duplicates");
			System.out.println("21.To check whether it is a circular list or not");
			System.out.println("22.Search an element");
			int choice=scan.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter element to be inserted");
				int a =scan.nextInt();
				s.insertfirst(a);
				break;
			case 2:
				s.display();
				break;
			case 3:
				System.out.println("Number of nodes in list : "+s.count());
				break;
			case 4:
				System.out.println("First element deleted is "+s.deletefirst());
				break;
			case 5:
				System.out.println("Last element deleted is "+s.deletelast());
				break;
			case 6:
				System.out.println("Enter element to be inserted");
				int b =scan.nextInt();
				s.insertlast(b);
				break;
			case 7:
				System.out.println("Enter first element");
				int e1=scan.nextInt();
				System.out.println("Enter element to be inserted after the element");
				int e2=scan.nextInt();
				s.insertafter(e1, e2);
				break;
			case 8:
				System.out.println("Enter first element");
				int e3=scan.nextInt();
				System.out.println("Enter element to be inserted before the element");
				int e4=scan.nextInt();
				s.insertbefore(e3, e4);
				break;
			case 9:
				System.out.println("Enter element to be deleted");
				int e=scan.nextInt();
				s.delete_particular_element(e);
				break;
			case 10:
				System.out.println("Enter element");
				int e5=scan.nextInt();
				s.deleteafter(e5);
				break;
			case 11:
				System.out.println("Enter element");
				int e6=scan.nextInt();
				s.deletebefore(e6);
				break;
			case 12:
				System.out.println("Enter position");
				int p=scan.nextInt();
				System.out.println("Enter element to be inserted");
				int t=scan.nextInt();
				s.insert_particular_position(p, t);
				break;
			case 13:
				System.out.println("Enter position");
				int p1=scan.nextInt();
				s.delete_particular_position(p1);
				break;
			case 14:
				SLL s1=new SLL();
				System.out.println("Enter number of elements you want to insert in the second list");
				int n=scan.nextInt();
				System.out.println("enter elements to be inserted in second list");
				for(int i=1;i<=n;i++) {
					int a1=scan.nextInt();
					s1.insertfirst(a1);
				}
				s.concatenate(s1);
				System.out.println("Concatenation is completed");
				break;
			case 15:
				SLL l1=new SLL();
				System.out.println("Enter number of elements you want to insert in the first list");
				int m1=scan.nextInt();
				System.out.println("enter elements to be inserted in first sorted list");
				for(int i=1;i<=m1;i++) {
					int a1=scan.nextInt();
					l1.insertlast(a1);
				}
				SLL l2=new SLL();
				System.out.println("Enter number of elements you want to insert in the second list");
				int m2=scan.nextInt();
				System.out.println("enter elements to be inserted in second sorted list");
				for(int i=1;i<=m2;i++) {
					int a2=scan.nextInt();
					l2.insertlast(a2);
				}
				s.merge_sorted_lists(l1, l2);
				break;
			case 16:
				s.middle_element();
				break;
			case 17:
				s.split_equal();
				break;
			case 18:
				System.out.println("Enter the position :");
				int x=scan.nextInt();
				s.split_position(x);
				break;
			case 19:
				System.out.println("Enter the element :");
				int y=scan.nextInt();
				s.split_element(y);
				break;
			case 20:
				s.remove_duplicates();
				break;
			case 21:
				if(s.isCircularList()) {
					System.out.println("It is a circular list");
				}
				else {
					System.out.println("It is not a circular list");
				}
				break;
			case 22:
				System.out.println("Enter element to be searched ");
				int ele = scan.nextInt();
				if(s.search_element(ele)) {
					System.out.println("element is present");
				}else {
					System.out.println("element is absent");
				}
				break;
			default:
				System.out.println("invalid choice");
				break;
			}
			System.out.println("1.continue    2.end");
			ch=scan.nextInt();
		}while(ch==1);
	}
}