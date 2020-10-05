This is sample task that will let you start sample application (with some performance issues), experiment with different Java Flight Recorder (JFR) options. 
Read and analyze produced ```myBlackBoxTest.jfr``` file with Java Mission Control (JMC). 
Add custom JFR event.

1. Read ```README.md``` :-)
1. Compile and run application with ```mvn clean spring-boot:run -Dspring-boot.run.jvmArguments="-Xmx1g"``` navigate to ```http://localhost:1234``` to test if service is working as expected
1. Add JFR VM options
  1. time limited recording (60s) with initial delay of 20 seconds ```mvn clean spring-boot:run -Dspring-boot.run.jvmArguments="-XX:StartFlightRecording=settings=default,delay=20s,duration=60s,dumponexit=true,disk=true,filename=myBlackBoxTest.jfr,maxsize=1MB -Xmx1g"```
  1. continuous recording with a dump on exit ```mvn clean spring-boot:run -Dspring-boot.run.jvmArguments="-XX:StartFlightRecording=settings=default,dumponexit=true,disk=true,filename=myBlackBoxTest.jfr,maxsize=1MB -Xmx1g"```
1. Open and analyze recorded ```.jfr``` file with JMC
1. Add custom JFR event in the code look at ```MyFirstJfrEvent``` to see how to define event and ```StartMyCustomEvent``` to see how you can use it. Then rerun app to see if your event is emitted to ```.jfr``` file.

    
    
    