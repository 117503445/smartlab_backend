# smartlab_backend

XDU物理实验计算器后端

## Docker 部署

```sh
docker rm smartlab -f
docker rmi 117503445/smartlab
docker run --name smartlab -d -e var1="var 1" -e var2="var 2" -p 80:80 --restart=always 117503445/smartlab:latest
```
## Swagger

/swagger-ui/index.html