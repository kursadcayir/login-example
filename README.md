# login-example

Proje 8082 portunda calismaktadir. 
Asagidaki curl komutlari ile dogru ve yanlis calistirma ornekleridir.

false donus icin curl -X POST -F 'u=denemename' -F 'p=yanlis' http://localhost:8082/login
 
true donus icin curl -X POST -F 'u=testname' -F 'p=qweqweqwe1234' http://localhost:8082/login
