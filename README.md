# Compilerbau - SS 2017

## Overview
* [Documentation](/doc) (doc/)
* [Source code](/src) (src/)

```
./
|- src/ ................................... Project source code
|  |- test/ ............................... Test programs
|  |  |- parsing/ ......................... Test programs for parsing
|  |  '- type/ ............................ Test programs for type checking
|  |- C0.jj ............................... C0 parser
|  |- Node.java ........................... Node used for the AST
|  |- build.sh ............................ Build script for C0 (Unix)
|  '- bld.ps1 ............................. Build script for C0 (Windows)
'- README.md .............................. General hints
```

## How To
### Compiling
```
src> javacc -OUTPUT_DIRECTORY:bin C0.jj
src> javac -d bin bin/*.java
```

### Testing
```
src> java -cp bin C0
void main() {
        int i = 1 + 2 * 3;
}
^Z
[  OK  ]
```
You can test it with your own files:
```
src> java -cp bin C0 Myprogram.java
```
You can print the AST to the console:
```
src> java -cp bin C0 Myprogram.java print
```

### Windows (PowerShell)
This will compile the parser and test it with all files located in the `./test` directory:
```
PS C:\C0--\src> ./bld -c -r
```
This will test the parser with all files containing `pass`:
```
PS C:\C0--\src> ./bld -r -filter *pass*
```

### Unix
...
