#!/bin/sh

echo 'Initial Build'

TYPE=$1
NAME=$2

echo 'Tipo da build: ' $TYPE
echo 'Nome da build: ' $NAME
rm -rf distribution/Build_Dev/
mkdir -p distribution/Build_Dev/
mkdir -p distribution/Build_Dev/resources/

echo 'Copiando JAR'
cp application/target/application-0.0.1-BIC.jar distribution/Build_Dev/$NAME.jar

echo 'Copiando resources'
cp -RT application/src/main/resources/ distribution/Build_Dev/resources/

echo 'Final Build'