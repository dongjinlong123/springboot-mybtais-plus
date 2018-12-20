#!/bin/bash
PID=$(ps -ef | grep app.jar | grep -v grep | awk '{ print $2 }')
if [ -z "$PID" ]
then
    echo Application is already stopped
else
    kill -9 $PID
fi
sh /opt/start.sh
echo ---application run ok-----