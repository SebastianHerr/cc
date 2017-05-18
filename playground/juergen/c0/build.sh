#!/bin/sh

PARSER='C0'

javacc $PARSER.jj
javac *.java

echo -e "\n\e[1mBuilding completed. \e[0m \n"

for grammar in grammars/*.grm
do
  echo -e "\e[1m$grammar:\e[0m"
  java $PARSER $grammar
done
