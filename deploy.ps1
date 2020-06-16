# & "C:\User\App\docker-machine-Windows-x86_64\dm.exe" env ali | Invoke-Expression
mvn clean
mvn package
docker rm smartlab -f
docker build -t 117503445/smartlab .
docker run --name smartlab -d -p 8007:80 --restart=always 117503445/smartlab

# docker push 117503445/smartlab