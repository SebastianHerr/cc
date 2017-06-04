param (
    [string]$parser="C0",           # Parser Name
    [string]$path=$PWD,             # Execution Context
    [string]$bin="$path/bin",       # Bin Directory
    [string]$test="$path/test",     # Test Files Directory
    [string]$filter="*",            # Test Files Filter
    [switch]$r,                     # Run All Tests
    [switch]$c                      # Compile All Grammars
)
if (!(Test-Path ($bin))) {
    New-Item -ItemType Directory -Force -Path $bin
}

if($c) {
    javacc "-OUTPUT_DIRECTORY:$bin" "$parser.jj"
    javac -d $bin "$bin/*.java"
    javac -d $bin "*.java"
}

Get-ChildItem $test -Filter $filter -Recurse -File | Foreach-Object {
    if($r) {
        Write-Output ("-------------------- $_")
        java -cp $bin $parser $_.FullName
    }
}