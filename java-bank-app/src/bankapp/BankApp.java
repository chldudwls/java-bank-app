package bankapp;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 날짜 : 2024/07/26
 * 이름 : 최영진
 * 내용 : 수행평가
 */

public class BankApp {
private static Scanner sc = new Scanner(System.in);
private static List<Account> accounts = new ArrayList<>();

public static void main(String[] args) {
		
		
		
		boolean run = true;
		while(run) {
			System.out.println("---------------------------------------");
			System.out.println("1.계좌생성 |2.계좌목록 |3.예금 |4.출금 |5.종료 ");
			System.out.println("---------------------------------------");
			System.out.println("선택>");
		
			int selectNo = Integer.parseInt(sc.nextLine());
			if(selectNo == 1) {
				createAccount();
			} else if(selectNo == 2) {
				 accountList();
			} else if(selectNo == 3) {
				deposit();
			} else if(selectNo == 4) {
				withdraw();
			} else if(selectNo == 5) {
				run = false;
			}			
		}
		System.out.println("프로그램 종료");

}
	private static void accountList(){
		System.out.println("---------계좌 목록---------");
		for(Account account : accounts) {
			System.out.println("계좌번호: " +  account.getAno() + "계좌주:" + account.getOwner() +"잔액: " + account.getBalance());
		
		}
	}
	private static Account findAccount(String ano) {
		for(Account account : accounts) {
			if(account.getAno().equals(ano)) {
		
				return account;
			}
		}
		return null;
	}
	private static void createAccount() {
		System.out.println("---------계좌생성---------");
		System.out.println("계좌번호:");
		String ano = sc.nextLine();
		System.out.println("계좌주");
		String owner = sc.nextLine();
		System.out.println("초기 입금액");
		int balance = Integer.parseInt(sc.nextLine());
		
		Account account = new Account(ano, owner, balance);
		accounts.add(account);
		System.out.println("계좌생성완료");
		
	}	
	private static void deposit() {
		System.out.println("---------예금---------");
		System.out.println("계좌번호 : ");
		String ano = sc.nextLine();
		System.out.println("예금액 : ");
		int money = Integer.parseInt(sc.nextLine());
		
		Account account = findAccount(ano);
		if(account != null) {		
			account.setBalance(account.getBalance()+ money);
			System.out.println("예금이 성공되었습니다.");		
		}else {
			System.out.println("계좌를 찾을 수 없습니다");
		}	
	}
	private static void withdraw() {
		System.out.println("---------출금---------");
		System.out.println("계좌번호");
		String ano = sc.nextLine();				
		System.out.println("출금액: ");
		int money = Integer.parseInt(sc.nextLine());
	
		Account account = findAccount(ano);
		if(account != null) {		
			account.setBalance(account.getBalance() - money);
			System.out.println("출금이 성공되었습니다.");		
		}else {
			System.out.println("계좌를 찾을 수 없습니다");
			
			
		}
	}
}
