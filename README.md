# Java Flight Recorder & Java Mission Control demo app

##### Requirements for this demo/tutorial

* Java Open JDK and JRE installed on your machine [download OpenJDK](https://adoptopenjdk.net/?variant=openjdk8&jvmVariant=hotspot)
* Java Mission Control tool and be able to run it [Download Java Mission Control](https://adoptopenjdk.net/jmc)

### What is Java Flight Recorder (JFR)

* The JDK Flight Recorder (JFR) produces detailed recordings about the HotSpot JVM, and the application it is running.
* It is an event recorder built into the Java virtual machine, it can be thought of as the software equivalent of a Data Flight Recorder (Black Box) in a commercial aircraft.
* Recorded events can be analyzed offline using the Java Mission Control tool. 
* Recorded data includes profiling of methods, locks and allocations, as well as garbage collection statistics, optimization decisions, event latencies and more.

>> ##### JFR offers extremely low overhead of about 1% Therefore it can be used at production environments!

* In 2018 Java Flight Recorder was open sourced and released as part of OpenJDK 11, at later date it was backported into Open JDK 8.


### What is Java Mission Control (JMC)




### How to enable JFR on your app and how to control it



### How to read and interpret JFR Data



### What is coming next
 

For further reference, please consider the following sections:

* [Interesting article about JFR & JMC from Redhat by Mario Torre](https://developers.redhat.com/blog/2020/08/25/get-started-with-jdk-flight-recorder-in-openjdk-8u/)

* [Comprehensive list of VM options for different JDK implementations by Chris Newland](https://github.com/chriswhocodes/VMOptionsExplorer)




- 