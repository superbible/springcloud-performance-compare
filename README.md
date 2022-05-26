# springcloud-performance-compare
compare springcloud performance among versions

Use a simple Spring Cloud application to test the performance among version.

Prerequisite: run a Zookeeper 3.7 server on localhost.

Steps:
1. Launch the test application through Application.java
2. Access http://localhost:8080/stressTest on your browser to run the stress test. 
3. After a few seconds, result will be shown like: Cost: 00:00:04.325, thread:100, repeatTimes:100, TPS: 2,312.139
   We need to run it at least 3 times then calculate the average TPS.

5. Swich to different branch to test correspoding version of Spring Cloud, such as Hoxton, 2020, 2021, etc.

Here is my test result:
2021.0.2: 2,312.139
2020.0.5: 2,321.802
Hoxton.SR11: 5,844.535

It seems the performance of 2020 and 2021 is only 40% of Hoxton, probably because the replacement of Netflix Ribbon to LoadBalancer.
