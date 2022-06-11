
public class Homework_9_BigStomachKing implements Runnable {

	int i = 1;
	int rand = (int) (Math.random() * 3000) + 500;
	private String name;

	public Homework_9_BigStomachKing(String name) { // 產生建構子
		this.name = name;
	}

	public void run() { // 實作Runnable的run方法
		while (i <= 10) {
			System.out.println(name + "吃第" + i + "碗飯");
			i++;

			try { // 讓他每次睡500~3000毫秒
				Thread.sleep(rand);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println(name + "!!!吃完了!!!");
	}

	public static void main(String[] args) throws InterruptedException {
		Homework_9_BigStomachKing Moon = new Homework_9_BigStomachKing("饅頭人"); // 產生饅頭人物件
		Homework_9_BigStomachKing James = new Homework_9_BigStomachKing("詹姆士"); // 產生詹姆士物件
		Thread MoonEat = new Thread(Moon); // 產生饅頭人吃東西的執行緒
		Thread JamesEat = new Thread(James); // 產生詹姆士吃東西的執行緒
		// 啟動執行緒
		System.out.println("-----大胃王快食比賽開始!!-----");
		MoonEat.start();
		JamesEat.start();
		MoonEat.join();
		JamesEat.join();
		System.out.println("-----大胃王快食比賽結束!!-----");
	}
}
