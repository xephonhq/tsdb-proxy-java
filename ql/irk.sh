#!/usr/bin/env bash

# get the script path http://stackoverflow.com/questions/4774054/reliable-way-for-a-bash-script-to-get-the-full-path-to-itself
pushd `dirname $0` > /dev/null
SCRIPTPATH=`pwd -P`
popd > /dev/null
ORIGINAL_WD=${PWD}
cd ${SCRIPTPATH}

java -cp ./build/libs/ql-0.0.1-SNAPSHOT-all.jar io.xephon.proxy.ql.Shell

cd ${ORIGINAL_WD}
