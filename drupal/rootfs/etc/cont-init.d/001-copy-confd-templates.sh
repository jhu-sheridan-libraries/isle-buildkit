#!/usr/bin/with-contenv bash

# Intended for confd definitions and templates to be provided via 
# the Drupal codebase.
if [ -d /var/www/drupal/rootfs/etc/confd ]; then
	cp -r /var/www/drupal/rootfs/etc/confd/* /etc/confd/;
fi
