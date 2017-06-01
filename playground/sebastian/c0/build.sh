#!/bin/sh

PARSER='C0'

if [ ! -d "bin/" ]
then
  mkdir bin
fi

javacc -OUTPUT_DIRECTORY=bin/ $PARSER.jj
javac -d bin bin/*.java