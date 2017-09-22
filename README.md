# FileUtilityRestApi
FileUtility

Curl Usage:

Upload file on the server

curl -X POST -F "file=@<File-Path>" http://localhost:8080/main/webapi/uploadFile
File saved to c:\uploadedFiles\<File-Name>

Example:

    curl -X POST -F "file=@C:\Users\dell\Desktop\Test.txt" http://localhost:8080/main/webapi/uploadFile
    File saved to c:\uploadedFiles\Test.txt

Upload file on the server

curl -X GET "http://localhost:8080/main/webapi/downloadFile?fileName=<fileName>&pageNo=<pageNo>"

Example:

    curl -X GET "http://localhost:8080/main/webapi/downloadFile?fileName=Test.txt&pageNo=2"
    <Returns line 51 to 100 (2nd Page) in the Text.txt File on the server>

Language: Java IDE used: Eclipse EE Build Tool: Maven Server: Tomcat Api Testing: Postman & cURL

    Refer images (FileUpload & FileDownload) for Postman api access.


