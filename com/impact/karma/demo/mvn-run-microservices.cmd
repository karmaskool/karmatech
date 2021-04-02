R@echo  ON
SET DRIVE=D:
SET FILE_INPUT=C:\data\springboots.txt
SET PROJECT_FOLDER=%DRIVE%\data\perso\git\repo\com\impact\karma\demo\java
CD %PROJECT_FOLDER%
%DRIVE%
SET T=15
SET logFile=%PROJECT_FOLDER%/../log-start
SET mvn_cmd_file="mvn spring-boot:run > %logFile%"
SET mvn_cmd="mvn spring-boot:run"
FOR /F %%i in ('type %FILE_INPUT%') do (
	CD %PROJECT_FOLDER%/%%i
REM	start "SpringBoot start :%%i" cmd.exe @cmd /C %mvn_cmd_file%__%%i.txt
	start "SBT:%%i" cmd.exe @cmd /C %mvn_cmd%
	powershell Start-Sleep -s %T%
REM	ping localhost -n 20
)
