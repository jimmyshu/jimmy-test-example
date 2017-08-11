# 任務:
在主執行緒啟動多執行緒, 並等待所有程序跑完, 再恢復主執行緒。

# 類別:
+ [java.util.concurrent.Executors]

  [newFixedThreadPool(int nThreads)] 方法: 產生一個數量的 thread pool

+ CountDownLatch

      CountDownLatch(int count) 建構子: 給定計數器的初始值

      await() 方法: 使執行緒等待, 待計數器數值為 0, 恢復執行

      countDown() 方法: 使計數器數值 -1

# 範例:
[CountDownLatchExample](https://github.com/jimmyshu/jimmy-test-example/blob/master/src/main/java/jimmy/test/example/CountDownLatchExample.java)

    要計算多個數字陣列的合, 啟動多個執行緒, 分別對個別的數字陣列累加, 待所有程序執行完, 由主執行緒回傳結果

 
[java.util.concurrent.Executors]: https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/Executors.html "test"
[newFixedThreadPool(int nThreads)]: https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/Executors.html#newFixedThreadPool(int)
