
class Deposit {
	private int account = 0; // 帳號一開始零元

	synchronized public void monDeposit(int money) {
		while (account > 2000) { // 帳戶多餘2000 媽媽就停止匯款
			System.out.println("媽媽看到餘額在2000以上，停止匯款");
			try {
				wait();// 釋出Key
				System.out.println("媽媽被熊大要求匯款!!");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		account += money; // 每次帳戶+money
		System.out.println("媽媽存了" + money + "元，帳戶共有:" + account);
		notify(); // 呼叫熊大
	}

	synchronized public void brownWithdraw(int money) {
		while (account == 0) {
			System.out.println("熊大看到帳戶沒錢，停止提款");
			try {
				wait(); // 釋出Key
				System.out.println("熊大被老媽告知帳戶已有錢!!");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		account -= money;
		System.out.println("熊大堤了" + money + "元，帳戶共有:" + account);
		if (account <= 1000) {
			System.out.println("熊大看到餘額在1000以下，威脅匯款");
			notify(); // 呼叫媽媽
		}
	}
}

class Mon extends Thread {
	Deposit key;

	public Mon(Deposit key) {
		this.key = key;
	}

	public void run() {
		for (int i = 1; i <= 10; i++) {
			key.monDeposit(2000);
		}
	}
}

class Brown extends Thread {
	Deposit key;

	public Brown(Deposit key) {
		this.key = key;
	}

	public void run() {
		for (int i = 1; i <= 10; i++) {
			key.brownWithdraw(1000);
		}
	}
}

public class Homework_9_Deposit {
	public static void main(String[] args) {
		Deposit key = new Deposit();
		Mon mon = new Mon(key);
		Brown brown = new Brown(key);
		mon.start();
		brown.start();
	}
}
