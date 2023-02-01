# syntax=docker/dockerfile:experimental
FROM local/drupal:latest
USER root
RUN apk --no-cache add pcre-dev php-pear php7-dev gcc musl-dev make php7-pecl-xdebug \
  && apk del pcre-dev
USER builder
COPY rootfs /

