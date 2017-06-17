MVN := /share_home/sdks/apache-maven-3.3.9/bin/mvn
JAVA := /usr/bin/java
NAME := bike-spring-boot-1.0.jar
run: 
	$(MVN) spring-boot:run

clean:
	$(MVN) clean

production:
	$(JAVA) -jar -Dspring.profiles.active=production target/$(NAME)

devel:
	$(JAVA) -jar -Dspring.profiles.active=production target/$(NAME)
build:
	$(MVN) package -Dmaven.test.skip=true
