# syntax=docker/dockerfile:experimental
FROM local/base:latest

# Install packages and tools required by all downstream images.
RUN --mount=type=cache,target=/var/cache/apk \ 
    --mount=type=cache,target=/etc/cache/apk \
    apk-install.sh \
        openjdk8 \
        maven \
        patch \
    && \
    cleanup.sh

ENV JAVA_HOME=/usr/lib/jvm/default-jvm
ENV LOG4J_FORMAT_MSG_NO_LOOKUPS="true"

COPY rootfs /
