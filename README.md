# Java Flight Recorder & Java Mission Control demo app

##### Requirements for this demo/tutorial

* Java Open JDK and JRE installed on your machine [Download OpenJDK](https://adoptopenjdk.net/?variant=openjdk8&jvmVariant=hotspot)
* Java Mission Control tool and be able to run it [Download Java Mission Control](https://adoptopenjdk.net/jmc)

>> ##### Please note that JFR and JMC are only free to use on Open JDK on Oracle JDK these are paid commercial features. Please check your can/should use it on your JDK.

### What is Java Flight Recorder (JFR)

* The JDK Flight Recorder (JFR) produces detailed recordings about the HotSpot JVM, and the application it is running.
* It is an event recorder built into the Java virtual machine, it can be thought of as the software equivalent of a Data Flight Recorder (Black Box) in a commercial aircraft.
* Recorded events can be analyzed offline using the Java Mission Control tool. 
* Recorded data includes profiling of methods, locks and allocations, as well as garbage collection statistics, optimization decisions, event latencies and more.

>> ##### JFR offers extremely low overhead of about 1% Therefore it can be used at production environments!

* In 2018 Java Flight Recorder was open sourced and released as part of OpenJDK 11, at later date it was backported into [OpenJDK 8 from update 262](https://bugs.openjdk.java.net/browse/JDK-8223147).

### how to run JFR:

* by adding JVM options to your java process 
* by execution of ```jcmd``` instruction to your JVM process

### What is Java Mission Control (JMC)

* JDK Mission Control is an open source tools suite for the Java virtual machine.
* The tools help to find problems in, and optimizing, programs running on the JVM in production. 
* Support OpenJDK from version 8 from update 262.

#### what can you do with JMC:
* connect to the running JVM process via JMX and do current quick analysis of CPU, Memory, process spec, GC cycles. This looks similar to Visual VM
* open Flight recorder file generated by the JFR process
* use JMC command to start flight recorder on given JVM process (Instruct JVM to start/stop JFR process).
* use JMC plugins

### How to enable JFR on your service by adding VM options:
* on Open JDK8 (from update 262)

```-XX:StartFlightRecording=settings=default,dumponexit=true,disk=true,maxsize=1MB,filename=testFlightRecord.jfr```

This will start continuous recording of JFR events, with max size ever held of 1 MB it will output these recordings to ```testFlightRecord.jfr``` file upon exit, or upon receive of DUMP instruction from ```jcmd``` for example: ```jcmd <PID> JFR.dump name=1```
```setting=default``` will start JFR with default config profile, there are two profiles available (one can add more or modify existing ones) located in ```jdk-11.0.8.10-hotspot\lib\jfr```


* on Open JDK11 (the same command)

```-XX:StartFlightRecording=settings=default,dumponexit=true,disk=true,maxsize=1MB,filename=testFlightRecord.jfr```

### How to enable/disable it by jcmd

```$ jcmd <PID> JFR.start duration=10h filename=myrecording.jfr```

or 

``` $ jcmd <PID> JFR.stop``` 
   
other commands:

```
   JFR.configure
   JFR.stop
   JFR.start
   JFR.dump
   JFR.check
```

### Other ways to enable Java Flight Recorder 
- Intellij has build in ```Run with profiler```
- Java Mission Control(JMC) can start JFR recording (it is using ```jcmd``` in the background)


### How to read and interpret JFR Data
to read data use Java Mission Control tool. Open it and point to the .jfr file.


### What is coming next
from Java 14 streaming of the JFR events is available... [JEP 349](https://openjdk.java.net/jeps/349)
[Get a stream of high-volume data points about your running app.
 by Ben Evans](https://blogs.oracle.com/javamagazine/java-flight-recorder-and-jfr-event-streaming-in-java-14)

 
 
### Reference
For further reference, please consider the following sections:

* [Interesting article about JFR & JMC from Redhat by Mario Torre](https://developers.redhat.com/blog/2020/08/25/get-started-with-jdk-flight-recorder-in-openjdk-8u/)
* [(Old context) - Java Mission Control: Java Flight Recorder Deep Dive by Marcus Hirt](https://www.slideshare.net/marcushirt/java-mission-control-java-flight-recorder-deep-dive)
* [Comprehensive list of VM options for different JDK implementations by Chris Newland](https://github.com/chriswhocodes/VMOptionsExplorer)
