Pigeon - An Event Driven Job Control Framework for Hadoop to help Chain Multiple MapReduce jobs

## Overview
Hadoop MapReduce is a parallel computation framework for processing large and distributed data sets. 
In many cases, users want to chain multiple MapReduce jobs to accomplishcomplex tasks. 
Usually, such complex tasks are data-driven with data funneled through a sequence of jobs. 
In this project we have implemented a distributed notification system for Hadoop to help chain
multiple MapReduce jobs based on events occurring in Hadoop cluster.

##Prerequisites
To run Pigeon publisher and subscriber you will need to download [ActiveMQ] (http://activemq.apache.org/download.html). 
We used ActiveMQ 5.8.0 Release to build and test our application.

##Steps to Run the Pigeon

* Run the ActiveMQ service on all the machines: 

`~path-to-ActiveMQ-dir~$bin\activeMQ start`

* Run the subscriber on all machines, listening for event notification: 

`~path-to-pigeon-dir~$bin\pigeon.sh subscribe <topicname> <jobscript> <host:port>`

* Run the publisher on machine which publishes event notification message:

`~path-to-pigeon-dir~$bin\pigeon.sh publish <topicname> <eventmessage> <host:port>`
