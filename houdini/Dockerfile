# syntax=docker/dockerfile:experimental
FROM golang:1.17-alpine3.15 as build

ARG REPO=https://github.com/jhu-idc/derivative-ms
ARG COMMIT=6b85caad1c53b140597120a3cfdd87c55eb7015d

WORKDIR /go/src/app

RUN apk add git && \
    git clone ${REPO} . && \
    git checkout ${COMMIT}

RUN go get -d -v ./... && \
    go install -v ./...

FROM alpine:3.15

RUN apk add --no-cache \
     imagemagick

WORKDIR /app

COPY --from=build /go/bin/derivative-ms ./derivative-ms

COPY rootfs/ /

ENTRYPOINT [ "./derivative-ms" ]

CMD [ "-h" ]