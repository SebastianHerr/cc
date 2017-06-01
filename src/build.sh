#!/bin/sh

PARSER='C0'

if [ ! -d "bin/" ]
then
  mkdir bin
fi

javacc $PARSER.jj
javac -d bin *.java

echo -e "\n\e[1mBuilding completed. \e[0m \n"

for testfile in test/**/*.grm
do
  echo -e "\e[1m$testfile:\e[0m"
  java -cp bin $PARSER $testfile
done
