#!/bin/sh

PARSER='C0'

source cleanFolder.sh

if [ ! -d "bin/" ]
then
  mkdir bin
fi

javacc -OUTPUT_DIRECTORY=bin/ $PARSER.jj
javac -d bin bin/*.java

for testfile in test/*
do
  echo -e "\e[1m$testfile:\e[0m"
  java -cp bin $PARSER $testfile
done