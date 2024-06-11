FROM gcr.io/distroless/java:11

MAINTAINER Byron Cueva "bcueva@ec.krugercorp.com"

ENV TZ ${TZ}

# Default to UTF-8 file.encoding
ENV LANG C.UTF-8

EXPOSE 8080

WORKDIR /api

COPY fkp-base-services/build/libs/*.jar /api/app.jar

CMD ["app.jar"]