#!/usr/bin/env bash

if [[ -z "${UMPLE_BIN}" ]]; then
  echo "UMPLE_BIN not defined, using default location"
  UMPLE_BIN=~/umple/dev-tools/umple
fi
${UMPLE_BIN} --generate Ecore modelingassistant.ump
