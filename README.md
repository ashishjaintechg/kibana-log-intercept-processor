# kibana-log-intercept-processor
Kibana logs interceptor with upstream 
```s
2021-07-11 22:34:40,816 [http-nio-8080-exec-2] [INFO ]  [t.a.j.LoggingClientHttpRequestInterceptor. ] - kibana-service-logs~#~http://localhost:8081/couponapi/coupons/SUPER10~#~~#~
~#~~#~0.0~#~~#~~#~~#~~#~~#~~#~~#~~#~~#~~#~~#~~#~~#~2021-07-11T22:34:40.770666~#~2021-07-11T22:34:40.816163~#~Request:-Http-Method:GET,  Address:http://localhost:8081/couponapi/cou
pons/SUPER10,  Payload:,  Headers{Accept=application/json, application/*+json, Content-Length=0}~#~Response:-Response Time: 29mills, Response-Code:200, Payload: {"id":101,"name":"
SUPER10","discount":10.0}~#~200~#~~#~SUCCESS~#~45
```
```s
2021-07-11 22:34:40,880 [http-nio-8080-exec-2] [INFO ]  [t.a.j.RequestResponseLogFilter. ] - kibana-service-logs~#~http://localhost:8080/~#~~#~~#~~#~0.0~#~~#~~#~~#~~#~~#~~#~~#~~#~
~#~~#~~#~~#~~#~2021-07-11T22:34:40.626968~#~2021-07-11T22:34:40.880343~#~Request:-Http-Method:GET,  Address:http://localhost:8080/,  Payload:,  Headers{postman-token=b307dd4d-c700
-412b-b5b9-5955cd56bfd5, host=localhost:8080, connection=keep-alive, accept-encoding=gzip, deflate, br, user-agent=PostmanRuntime/7.28.0, accept=*/*}~#~Response:-Response Time: 0m
ills, Response-Code:200, Payload: {"id":101,"name":"SUPER10","discount":10.0}~#~200~#~~#~SUCCESS~#~253
```
