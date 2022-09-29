# Getting Started

#### 1.- mvn archetype:create-from-project
#### 2.- cd target\generated-sources\archetype\src\main\resources\archetype-resources\src\main\java
#### 3.- rm -rf archetype 
#### 4.- cd target\generated-sources\archetype
#### 5.- mvn clean install
#### 5.- mvn archetype:generate -B -DarchetypeGroupId=com.local.api -DarchetypeArtifactId=api-archetype-java-archetype -DarchetypeVersion=1.0 -DgroupId=$GROUP_ID -DartifactId=$ARTIFACT_ID -Dpackage=$PACKAGE


```sh
$ mvn archetype:create-from-project
```

```sh
$ cd target\generated-sources\archetype\src\main\resources\archetype-resources\src\main\java
```

```sh
$ rm -rf archetype
```

```sh
$ cd target\generated-sources\archetype
```

```sh
$ mvn clean install
```

```sh
```
Access to data base in memory

H2 DATABASE
============
http://localhost:8080/h2-console/
JDBC URL: jdbc:h2:mem:testdb
user:     sa
password: password