mvn clean
mvn package
docker rm smartlab -f
docker build -t 117503445/smartlab .
docker push 117503445/smartlab
# docker run --name githubproxy -d -p 8000:80 --restart=always 117503445/smartlab