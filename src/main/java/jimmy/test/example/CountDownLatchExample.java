package jimmy.test.example;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class CountDownLatchExample {

	public static void main(String[] args) {
		int[][] numbersAry = {
				{1, 2, 43, 54, 121, 34, 5},
				{-3, 4, 199, 2, -5},
				{-77, 94, 20, -3},
				{11, -43, -9, 20},
				};

		System.out.println(new CountDownLatchExample(numbersAry).sum());
	}

	// 以多執行緒 (thread pool) 執行非同步程序
	private ExecutorService executor;

	// CountDownLatch 由建構子設定一個數字,
	// 它的 await() 方法, 將使主執行緒等待,
	// 此時由其他執行緒呼叫 countDown() 方法, 將使數字 -1,
	// 待數字降為 0, 主執行緒恢復執行
	private CountDownLatch latch;

	private int sum = 0;
	private int[][] numbersAry;

	public CountDownLatchExample(int[][] numbersAry){
		executor = Executors.newFixedThreadPool(numbersAry.length);
		this.numbersAry = numbersAry;
	}

	public int sum(){
		latch = new CountDownLatch(numbersAry.length);
		for (int[] nums : numbersAry){
			executor.execute(new Summation(nums));
		}
		try {
			latch.await();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		} finally {
			executor.shutdown();
		}
		return sum;
	}

	private class Summation implements Runnable {
		int[] nums;

		Summation(int[] nums){
			this.nums = nums;
		}

		@Override
		public void run() {
			for (int num : nums){
				sum += num;
			}

			// 程序執行結束, 呼叫 CountDownLatch.countDown() 方法
			latch.countDown();
		}
	}
}