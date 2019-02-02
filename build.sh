#!/bin/sh
git pull
admin_process=`ps -ef | grep cactusschool-adminms | awk '$8=="java" {print $2}'`
echo $admin_process
kill -9 $admin_process
echo "Running application has been stopped. Starting the application again"
mvn -DskipTests=true clean install
java -jar target/cactusschool-adminms-1.0.jar &