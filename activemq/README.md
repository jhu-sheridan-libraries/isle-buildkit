# ActiveMQ

Docker image for [ActiveMQ] version 5.14.5.

Please refer to the [ActiveMQ Documentation] for more in-depth information.

As a quick example this will bring up an instance of ActiveMQ, and allow you to
log into the [WebConsole] on `http://localhost:8161` as the user `admin` with
the password `password`.

```bash
docker run --rm -ti -p 8161:8161 islandora/activemq
```

> N.B. if no credentials are given you will not be able to log in via the
[WebConsole].

## Dependencies

Requires `islandora/java` docker image to build. Please refer to the
[Java Image README](../java/README.md) for additional information including
additional settings, volumes, ports, etc.

## Ports

| Port  | Description  |
| :---- | :----------- |
| 1883  | [MQTT]       |
| 5672  | [AMPQ]       |
| 8161  | [WebConsole] |
| 61613 | [STOMP]      |
| 61614 | [WS]         |
| 61616 | [OpenWire]   |

## Volumes

| Path               | Description         |
| :----------------- | :------------------ |
| /opt/activemq/data | [AMQ Message Store] |

## Settings

| Environment Variable        | Etcd Key                     | Default  | Description                              |
| :-------------------------- | :--------------------------- | :------- | :--------------------------------------- |
| ACTIVEMQ_USER               | /activemq/user               | admin    | See [Security]: credentials.properties   |
| ACTIVEMQ_PASSWORD           | /activemq/password           | password | See [Security]: credentials.properties   |
| ACTIVEMQ_WEB_ADMIN_NAME     | /activemq/web/admin/name     | admin    | See [WebConsole]: jetty-realm.properties |
| ACTIVEMQ_WEB_ADMIN_PASSWORD | /activemq/web/admin/password | password | See [WebConsole]: jetty-realm.properties |
| ACTIVEMQ_WEB_ADMIN_ROLES    | /activemq/web/admin/roles    | admin    | See [WebConsole]: jetty-realm.properties |
| ACTIVEMQ_WEB_HOST    | /activemq/web/host     | 127.0.0.1 | Host the admin console will bind to, use 0.0.0.0 for any |
| ACTIVEMQ_WEB_PORT    | /activemq/web/iport    | 8161 | Admin console port |
| ACTIVEMQ_REDELIVERY_MAX_ATTEMPTS | /activemq/redelivery/max/attempts | 1 | Total number of attempts to redeliver a message before routing it to the DLQ |
| ACTIVEMQ_REDELIVERY_INITIAL_DELAY_MS | /activemq/redelivery/initial/delay/ms | 60000 | Delay before attempting the first redelivery |
| ACTIVEMQ_REDELIVERY_DELAY_MS | /activemq/redelivery/delay/ms | 60000 | Delay between subsequent redelivery attempts |
| ACTIVEMQ_DLQ_EXPIRATION_MS | /activemq/dlq/expiration/ms | 604800000 | Lifetime of a message in the DLQ, after which it is deleted |
| ACTIVEMQ_DLQ_PROCESS_EXPIRED | /activemq/dlq/process/expired | true | Whether undelivered, expired messages are **routed to** the DLQ.  If 'true', undelivered, expired messages will be sent to the DLQ and kept for ${ACTIVEMQ_DLQ_EXPIRATION_MS} milliseconds before being deleted. If 'false', undelivered, expired messages will be deleted, bypassing the DLQ.  | 
| ACTIVEMQ_DLQ_PROCESS_NON_PERSISTENT | /activemq/dlq/process/non/persistent | true | Whether undelivered, non-persistent are **routed to** the DLQ.  If 'true', undeliverable, non-persistent messages will be routed to the DLQ and kept for ${ACTIVEMQ_DLQ_EXPIRATION_MS} milliseconds before being deleted.  If 'false', undeliverable, non-persistent messages will be deleted. |
| ACTIVEMQ_SYSTEM_USAGE_JVM_HEAP_PERCENTAGE | /system/usage/jvm/heap/percent | 70 | |
| ACTIVEMQ_SYSTEM_USAGE_DURABLE_STORAGE_LIMIT | /system/usage/durable/storage/limit | `100 gb` | |
| ACTIVEMQ_SYSTEM_USAGE_TEMP_STORAGE_LIMIT | /system/usage/temp/storage/limit | `18 gb` | |


Additional users/groups/etc can be defined by adding more environment variables,
following the above conventions:

| Environment Variable              | Etcd Key                           | Description                              |
| :-------------------------------- | :--------------------------------- | :--------------------------------------- |
| ACTIVEMQ_USER_{USER}_NAME         | /activemq/user/{USER}/name         | See [Security]: users.properties         |
| ACTIVEMQ_USER_{USER}_PASSWORD     | /activemq/user/{USER}/password     | See [Security]: users.properties         |
| ACTIVEMQ_GROUP_{GROUP}_NAME       | /activemq/group/{GROUP}/name       | See [Security]: groups.properties        |
| ACTIVEMQ_GROUP_{GROUP}_MEMBERS    | /activemq/group/{GROUP}/members    | See [Security]: groups.properties        |
| ACTIVEMQ_WEB_USER_{USER}_NAME     | /activemq/web/user/{USER}/name     | See [WebConsole]: jetty-realm.properties |
| ACTIVEMQ_WEB_USER_{USER}_PASSWORD | /activemq/web/user/{USER}/password | See [WebConsole]: jetty-realm.properties |
| ACTIVEMQ_WEB_USER_{USER}_ROLES    | /activemq/web/user/{USER}/roles    | See [WebConsole]: jetty-realm.properties |

> N.B. These do not have defaults.

For example to add a new user `someone` to the [WebConsole] you would need to
define the following:

| Environment Variable               | Etcd Key                            | Value    |
| :--------------------------------- | :---------------------------------- | :------- |
| ACTIVEMQ_WEB_USER_SOMEONE_NAME     | /activemq/web/user/someone/name     | someone  |
| ACTIVEMQ_WEB_USER_SOMEONE_PASSWORD | /activemq/web/user/someone/password | password |
| ACTIVEMQ_WEB_USER_SOMEONE_ROLES    | /activemq/web/user/someone/roles    | admin    |

## Logs

| Path                            | Description    |
| :------------------------------ | :------------- |
| STDOUT                          | [ActiveMQ Log] |
| /opt/activemq/data/activemq.log | [ActiveMQ Log] |
| /opt/activemq/data/audit.log    | [Audit Log]    |

[ActiveMQ Documentation]: https://activemq.apache.org/components/classic/documentation
[ActiveMQ Log]: https://activemq.apache.org/how-do-i-change-the-logging
[ActiveMQ]: http://activemq.apache.org/
[AMPQ]: https://activemq.apache.org/amqp
[AMQ Message Store]: https://activemq.apache.org/amq-message-store
[Audit Log]: https://activemq.apache.org/audit-logging
[MQTT]: https://activemq.apache.org/mqtt
[OpenWire]: https://activemq.apache.org/openwire
[Security]: https://activemq.apache.org/security
[STOMP]: https://activemq.apache.org/stomp
[WebConsole]: https://activemq.apache.org/web-console
[WS]: https://activemq.apache.org/ws-notification
