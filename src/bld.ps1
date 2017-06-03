param(
    [string]$path=$PWD,             # execution context
    [string]$name="*.jj",
    [string]$bin="$path/bin",
    [string]$test="$path/test",
    [string]$testfilter="*",
    [switch]$r, 
    [switch]$c, 
    [switch]$rc, 
    [switch]$cr
)
if (!(Test-Path ($bin))) {
    New-Item -ItemType Directory -Force -Path $bin
}

Get-ChildItem $path -Filter $name | Foreach-Object {
    if($c -or $rc -or $cr ) {
        javacc $_.FullName
        javac -d $bin "*.java"
    }
}

Get-ChildItem $test -Filter $testfilter -Recurse -File | Foreach-Object {
    if($r -or $rc -or $cr ) {
        Write-Output ("------------------- $_")
        java -cp $bin C0 $_.FullName
    }
}