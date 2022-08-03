package async.future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureTest2 {
  private static Logger logger = LoggerFactory.getLogger(FutureTest2.class);

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    ExecutorService es = Executors.newCachedThreadPool();
    Future<String> f = es.submit(() -> {
      Thread.sleep(2000);
      logger.info("Async");
      return "Hello";
    });
    logger.info("Start");
    logger.info(f.get());
    logger.info("Exit");
  }
}
