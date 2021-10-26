#!/usr/bin/env bash

export TOUCHCORE_SRC=$(python3 readenv.py touchcore-sources)

mvn install:install-file \
   -Dfile=modelingassistant.restapi/lib/org.eclipse.ocl-3.4.2.v20140725-2242.jar \
   -DgroupId=org.eclipse.ocl \
   -DartifactId=org.eclipse.ocl \
   -Dversion=3.4.2 \
   -Dpackaging=jar \
   -DgeneratePom=true

mvn install:install-file \
   -Dfile=modelingassistant.restapi/lib/org.eclipse.ocl.pivot_1.16.0.v20210907-2013.jar \
   -DgroupId=org.eclipse.ocl.pivot \
   -DartifactId=org.eclipse.ocl.pivot \
   -Dversion=1.16.0 \
   -Dpackaging=jar \
   -DgeneratePom=true

mvn install:install-file \
   -Dfile=modelingassistant.restapi/lib/org.eclipse.ocl.xtext.completeocl_1.16.0.v20210907-2013.jar \
   -DgroupId=org.eclipse.ocl.xtext.completeocl \
   -DartifactId=org.eclipse.ocl.xtext.completeocl \
   -Dversion=1.16.0 \
   -Dpackaging=jar \
   -DgeneratePom=true
