Pigeon - An Event Driven Job Control Framework for Hadoop to help Chain Multiple MapReduce jobs

## Overview
Hadoop MapReduce is a parallel computation framework for processing large and distributed data sets. 
In many cases, users want to chain multiple MapReduce jobs to accomplishcomplex tasks. 
Usually, such complex tasks are data-driven with data funneled through a sequence of jobs. 
In this project we have implemented a distributed notification systemfor Hadoop to help chain
multiple MapReduce jobs based on events occurring in Hadoop cluster.

##Prerequisites
To run Pigeon publisher and subscriber you will need to install [activeMQ] (http://activemq.apache.org/download.html) 
We used ActiveMQ 5.8.0 Release to build and test our application

