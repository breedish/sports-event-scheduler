#!/bin/sh

echo "********************************************************"
echo "Starting @app@ Service                                 "
echo "********************************************************"

PROFILE_NAME="${PROFILE:-default}"
SERVER_PORT="${PORT:-9999}"

java \
    -Djava.security.egd=file:/dev/./urandom \
    -Dserver.port=$SERVER_PORT\
    -Dspring.profiles.active=$PROFILE_NAME\
    -jar /usr/local/app/@app@