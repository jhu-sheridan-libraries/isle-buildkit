# syntax=docker/dockerfile:experimental
FROM local/drupal:latest
USER root
RUN apk --no-cache add pcre-dev php81-pear php81-dev gcc musl-dev make php81-pecl-xdebug \
  && apk del pcre-dev
USER builder
COPY rootfs /

