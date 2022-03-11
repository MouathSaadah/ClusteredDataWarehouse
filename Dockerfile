FROM openjdk:11
FROM com/neovisionaries/i18n/CountryCode
COPY target/classes/ /tmp
WORKDIR /tmp
CMD java Main