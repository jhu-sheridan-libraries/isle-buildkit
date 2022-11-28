# syntax=docker/dockerfile:experimental
FROM local/base:latest

RUN --mount=type=cache,target=/var/cache/apk \ 
    --mount=type=cache,target=/etc/cache/apk \ 
    apk-install.sh \
        composer \
        nginx \
        gnu-libiconv \
        php \
        php-ctype \
        php-curl \
        php-dom \
        php-fileinfo \
        php-fpm \
        php-gd \
        php-iconv \
        php-intl \
        php-json \
        php-ldap \
        php-mbstring \
        php-mysqli \
        php-opcache \
        php-openssl \
        php-pdo \
        php-pdo_mysql \
        php-pdo_pgsql \
        php-pdo_sqlite \
        php-phar \
        php-session \
        php-simplexml \
        php-sqlite3 \
        php-tokenizer \
        php-xml \
        php-xmlwriter \
        php-xmlreader \
        php-xsl \
        php7-pecl-yaml \
        php-zip \
    && \
    composer self-update --2 && \
    cleanup.sh

RUN apk add gnu-libiconv=1.16-r0 --update-cache --repository http://dl-cdn.alpinelinux.org/alpine/v3.15/community/ --allow-untrusted
ENV LD_PRELOAD /usr/lib/preloadable_libiconv.so

COPY rootfs /

RUN mkdir /var/sqlite && chmod 750 /var/sqlite && chown nginx:nginx /var/sqlite
