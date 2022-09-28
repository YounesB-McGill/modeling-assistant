#!/usr/bin/env bash

# This script is used to run the Modeling Assistant Java REST API server, which includes the
# Mistake Detection System (MDS).

MDS_PORT=8539  # defined in modelingassistant.restapi/src/main/java/modelingassistant/restapi/ModelingAssistantRestApi.java

# Check if the server is already running
pid=$(lsof -i:$MDS_PORT | grep LISTEN | awk '{print $2}')
if [ -n "$pid" ]; then
    echo "The Modeling Assistant Java REST API server is already running on port ${MDS_PORT} with PID ${pid}. "`
        `"Please stop it and try again."
    exit 1
fi

# Check if the TOUCHCORE_SRC environment variable is set
if [ -z "$TOUCHCORE_SRC" ]; then
    echo "The TOUCHCORE_SRC environment variable is not set. Please set it to the path of the TouchCORE source code "`
        `"using the install script and try again."
    exit 1
fi

# Run the server in the modelingassistant.restapi directory
cd modelingassistant.restapi
mvn spring-boot:run
