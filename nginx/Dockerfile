# syntax=docker/dockerfile:experimental
FROM local/base:latest

RUN --mount=type=cache,target=/var/cache/apk \ 
    --mount=type=cache,target=/etc/cache/apk \ 
    apk-install.sh \
        composer \
        nginx \
        gnu-libiconv \
        php81 \
        php81-ctype \
        php81-curl \
        php81-dom \
        php81-fileinfo \
        php81-fpm \
        php81-gd \
        php81-iconv \
        php81-intl \
        php81-json \
        php81-ldap \
        php81-mbstring \
        php81-mysqli \
        php81-opcache \
        php81-openssl \
        php81-pdo \
        php81-pdo_mysql \
        php81-pdo_pgsql \
        php81-pdo_sqlite \
        php81-phar \
        php81-session \
        php81-simplexml \
        php81-sqlite3 \
        php81-tokenizer \
        php81-xml \
        php81-xmlwriter \
        php81-xmlreader \
        php81-xsl \
        php81-pecl-yaml \
        php81-zip \
    && \
    composer self-update --2 && \
    cleanup.sh

RUN apk add gnu-libiconv=1.17-r0 --update-cache --repository http://dl-cdn.alpinelinux.org/alpine/v3.17/community/ --allow-untrusted
ENV LD_PRELOAD /usr/lib/preloadable_libiconv.so

COPY rootfs /

RUN mkdir /var/sqlite && chmod 750 /var/sqlite && chown nginx:nginx /var/sqlite
