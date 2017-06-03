#!/bin/sh

PARSER='C0'

rm bin/*.class
rm bin/*.java

if [ ! -d "bin/" ]
then
  mkdir bin
fi

javacc -OUTPUT_DIRECTORY=bin/ $PARSER.jj
javac -d bin bin/*.java
javac -d bin *.java

echo -e "\n\e[1mBuilding completed. \e[0m \n"

for testfile in test/**/*
do
  echo -e "\e[1m$testfile:\e[0m"
  java -cp bin $PARSER $testfile
done
