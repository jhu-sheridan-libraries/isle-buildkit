# syntax=docker/dockerfile:experimental
FROM local/nginx:latest

ARG COMMIT=8ad7a760564bd43d86e8ab1f49d4ff173cfda6b2

RUN --mount=id=downloads,type=cache,target=/opt/downloads \
    DOWNLOAD_CACHE_DIRECTORY="/opt/downloads" && \
    git-clone-cached.sh \
        --url https://github.com/jhu-idc/Crayfish.git \
        --cache-dir "${DOWNLOAD_CACHE_DIRECTORY}" \
        --commit "${COMMIT}" \
        --worktree /var/www/crayfish && \
    mkdir /var/log/islandora && \
    mkdir -p /opt/keys/jwt && \
    chown nginx:nginx /var/log/islandora && \
    chown nginx:nginx /opt/keys/jwt && \
    chown -R nginx:nginx /var/www && \
    cleanup.sh

COPY /rootfs /

STOPSIGNAL SIGWINCH

EXPOSE 8000
