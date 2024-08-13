import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;


public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		DoublyLinkedList dlist;
		List<Integer> list = new LinkedList<>();
		int T = 10;
		for (int i = 1; i <= T; i++) {
			dlist = new DoublyLinkedList();
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				dlist.addData(j, Integer.parseInt(st.nextToken()));
			} 
			int cCount = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int idx = 0;
			int cnt = 0;
			while (cCount > 0) {
				
				char ch = st.nextToken().charAt(0);
				
				switch (ch) {
				case 'I':
					idx = Integer.parseInt(st.nextToken());
					cnt = Integer.parseInt(st.nextToken());
					for (int j = 0; j < cnt; j++) {
						dlist.addData(idx+j, Integer.parseInt(st.nextToken()));
					}
					break;
				case 'D':
					idx = Integer.parseInt(st.nextToken());
					cnt = Integer.parseInt(st.nextToken());
					for (int j = 0; j < cnt; j++) {
						dlist.removeIdx(idx);
					}
					break;
				case 'A':
					cnt = Integer.parseInt(st.nextToken());
					for (int j = 0; j < cnt; j++) {
						dlist.addData(dlist.size, Integer.parseInt(st.nextToken()));
					}
					break;
				}
				cCount--;
			}
			dlist.printReverseAll(i);
		}
	}
}

class Node {
	// 실제로 들어갈 데이터값
	int data;
	Node prev;
	Node next;

}

class DoublyLinkedList {

	// 이 클래스 자체가 양방향 리스트 구현체
	Node head;
	Node tail;
	int size;

	public DoublyLinkedList() {
		
		super();
		this.head = new Node();
		this.tail = new Node();
		head.next = tail;
		tail.prev = head;
		
	}
	
	// 몇번째 위치에 데이터를 삽입할건지??
	void addData(int i, int data) {

		if(0 > i || i > size) {
			return;
		}
		size++;
		Node curr = head;
		for (int k = 0; k < i; k++) {
			curr = curr.next;
		}

		Node newNode = new Node();
		newNode.data = data;
		newNode.next = curr.next;
		newNode.prev = curr;

		curr.next.prev = newNode;
		curr.next = newNode;

	}
	
	// 삭제
	void removeIdx(int i) {
		
		if(0 > i || i > size-1) {
			return;
		}
		size--;
		
		Node curr = head.next;
		for (int k = 0; k < i; k++) {
			curr = curr.next;
		}
		
		curr.next.prev = curr.prev;
		curr.prev.next = curr.next;
		
	}
	
	// 조회
	void printReverseAll(int t) {
		Node curr = head.next;
		System.out.print("#"+t+" ");
		for (int i = 0; i < 10; i++) {
			System.out.print(curr.data+" ");
			curr = curr.next;
		}
		System.out.println();
	}
}
