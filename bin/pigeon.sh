#!/bin/bash

bin=`which $0`
bin=`dirname ${bin}`
cd $bin

if [ $# -eq 0 ]; then
echo "Usage:"
echo "To publish message: ./pigeon publish <Topic Name> <Message> <tcp://host:port>"
echo "To subscribe to a message: ./pigeon subscribe <Topic Name> <JobScript> <tcp://host:port>"
exit
fi

if [ $1 = "publish" ]; then
    if [ $# -eq 1 ]; then
        echo "Usage: ./pigeon publish <Topic Name> <Message> <tcp://host:port>"
	exit
    elif [ $# -eq 2 ]; then
        echo "Usage: ./pigeon publish <Topic Name> <Message> <tcp://host:port>"
	exit
    elif [ $# -eq 3 ]; then
        echo "Usage: ./pigeon publish <Topic Name> <Message> <tcp://host:port>"
	exit
    else
        ./publisher.sh $2 $3 $4
    	exit
    fi
elif [ $1 = "subscribe" ]; then
    if [ $# -eq 1 ]; then
        echo "Usage: ./pigeon subscribe <Topic Name> <JobScript> <tcp://host:port>"
	exit
    elif [ $# -eq 2 ]; then
        echo "Usage: ./pigeon subscribe <Topic Name> <JobScript> <tcp://host:port>"
	exit
    elif [ $# -eq 3 ]; then
        echo "Usage: ./pigeon subscribe <Topic Name> <JobScript> <tcp://host:port>"
	exit
    else
        ./subscriber.sh $2 $3 $4
    	exit
    fi
else
	echo "Usage:"
	echo "To publish message: ./pigeon publish <Topic Name> <Message> <tcp://host:port>"
	echo "To subscribe to a message: ./pigeon subscribe <Topic Name> <JobScript> <tcp://host:port>"
	exit
fi
