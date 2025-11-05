@echo off
call "C:\Program Files\Microsoft Visual Studio\2022\Community\Common7\Tools\VsDevCmd.bat" -arch=x64 -host_arch=x64

set "JAVA_HOME=C:\Users\jhon1\scoop\apps\graalvm-oracle-21jdk\current"
set "PATH=%JAVA_HOME%\bin;%PATH%"

call mvnw.cmd clean package -Dnative %*