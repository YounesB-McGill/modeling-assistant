#!/usr/bin/env bash

echo "Umple version of metamodel is deprecated and no longer in use. It will be removed in a future commit."

if [[ -z "${UMPLE_BIN}" ]]; then
  echo "UMPLE_BIN not defined, using default location"
  UMPLE_BIN=~/umple/dev-tools/umple
fi
${UMPLE_BIN} --generate Ecore modelingassistant.ump
