FROM golang:1.20

WORKDIR /service

COPY . .

RUN go build -o main .

EXPOSE 8081

ENTRYPOINT [ "/service/main" ]