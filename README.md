# 任務:
在主執行緒啟動多執行緒, 並等待所有程序跑完, 再恢復主執行緒。

# 類別:
+ Executors

      newFixedThreadPool(int nThreads) 方法: 產生一個數量的 thread pool

+ CountDownLatch

      CountDownLatch(int count) 建構子: 給定計數器的初始值

      await() 方法: 使執行緒等待, 待計數器數值為 0, 恢復執行

      countDown() 方法: 使計數器數值 -1

# 範例:
CountDownLatchExample
xxxx
