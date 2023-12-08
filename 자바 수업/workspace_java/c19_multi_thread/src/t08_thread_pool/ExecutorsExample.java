package t08_thread_pool;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorsExample {

	public static void main(String[] args) {
		// 스레드 풀 기능을 정의 해논 인터페이스
		final ExecutorService exe;
		/*
		 * thread pool을 생성 하는 정적 메소드
		 * newCachedThreadPool()  초기 스레드 수, 코어 스레드 수  0 - 최대 스레드 수 Integer.MAX_VALUE
		 * newFixedThreadPool(int value);
		 * 초기 스레드 수 : 0 - 코어 스레드 수 - 최대 스레드수 : value
		 * 
		 * 초기 스레드 수 : 스레드 풀이 생성 될 때 기본 적으로 생성 되는 스레드 수
		 * 코어 스레드 수 : 스레드가 증가 한 후 사용하지 않는 스레드를 제거하지 않고 최소한으로 유지할 개수
		 * 최대 스레드 수 : 스레드 풀에서 생성 관리하는 최대 스레드 수
		 */
		
		// exe = Executors.newCachedThreadPool();
		exe = Executors.newFixedThreadPool(3);
		
		// 프로그램이 동작하고 있는 기기의 논리 프로세서 개수
		int coreCount = Runtime.getRuntime().availableProcessors();
		System.out.println(coreCount);
		
		for(int i = 0; i < 16; i++) {
			
			Runnable task = new Runnable() {
				@Override
				public void run() {
					// 스레드 풀의 상세 정보를 확인할때 타입 변환 하여 사용
					ThreadPoolExecutor tpe = (ThreadPoolExecutor)exe;
					// 스레드 풀에서 관리하고 있는 스레드 수
					int poolSize = tpe.getPoolSize();
					String threadName = Thread.currentThread().getName();
					System.out.printf("[총 스레드 수 : %d, 작업 스레드 이름 : %s] %n",poolSize,threadName);
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {}
					int i = Integer.parseInt("일");
				} 
			}; 
			
			// 스레드 풀에 작업 등록
			// 다쓴 스레드는 버림 - 예외가 발생하면 처리할 수 없음
			// exe.execute(task);
			
			Future<?> future = exe.submit(task);
			/*
			try {
				System.out.println("스레드 기능 완료 시 까지 blocking");
				future.get();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				System.out.println(e.getMessage());
			}
			*/
		} 
		
		// 이미 작업 큐에 등록된 작업은 완료 하고, 새로운 작업은 추가 하지 않음
		exe.shutdown();
		
		try {
		exe.execute(()->{
			System.out.println("새로운 작업 추가");
		});
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			exe.awaitTermination(2, TimeUnit.SECONDS);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("wait 완료");
		// 스레드 풀의 모든 스레드를 즉시 종료
		List<Runnable> list = exe.shutdownNow();
		System.out.println(list.size());
		System.out.println(list);
		System.out.println("Main 종료");
	} 

}














