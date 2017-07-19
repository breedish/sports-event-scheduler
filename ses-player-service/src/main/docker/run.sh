#!/bin/sh

echo "********************************************************"
echo "Waiting for the configuration server to start on port $CS_PORT"
echo "********************************************************"
while ! `nc -z configservice $CS_PORT`; do sleep 3; done
echo "*******  Configuration service has started"

echo "********************************************************"
echo "Starting @app@ Service                                 "
echo "********************************************************"

PROFILE_NAME="${PROFILE:-default}"
SERVER_PORT="${PORT:-8080}"

java \
    -Djava.security.egd=file:/dev/./urandom \
    -Dserver.port=$SERVER_PORT   \
    -Dspring.profiles.active=$PROFILE_NAME\
    -jar /usr/local/app/@app@