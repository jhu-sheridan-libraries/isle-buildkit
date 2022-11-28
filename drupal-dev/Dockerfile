# syntax=docker/dockerfile:experimental
FROM local/drupal:latest

RUN apk --no-cache add pcre-dev php81-pear php81-dev gcc musl-dev make \
  && pecl install xdebug \
  && apk del pcre-dev

COPY rootfs /

