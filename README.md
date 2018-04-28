# About the project

> the ctian backend is a simple project of spring boot

> the citan fronted is just generate by 
```bash
ng new ctian-fronted
cd ctian-fronted
npm install
```
> you should not change anything of it


# What is should know

> the pom of root which artifact id is *ctian-spring-boot-angular5* we call it as *root* pom
> the pom of root which artifact id is *ctian-backend* we call it as *backend* pom
> the pom of root which artifact id is *ctian-fronted* we call it as *fronted* pom
>
> the root pom you should notice
```xml
  <modules>
    <module>ctian-fronted</module>
    <module>ctian-backend</module>
  </modules>
``` 
> the backend pom only set static files to fronted pom
```xml
<build>
    <resources>
      <resource>
        <directory>src/main/resources</directory>
        <filtering>true</filtering>
        <includes>
          <include>**/*.yml</include>
        </includes>
      </resource>
      <resource>
        <directory>../ctian-fronted/dist</directory>
        <targetPath>static</targetPath>
      </resource>
    </resources>
    <plugins>
      <plugin>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-maven-plugin</artifactId>
      </plugin>
    </plugins>
  </build>
```
> the fronted pom
```xml
<build>
    <plugins>
      <plugin>
        <groupId>com.github.eirslett</groupId>
        <artifactId>frontend-maven-plugin</artifactId>
        <version>1.3</version>

        <configuration>
          <nodeVersion>v8.9.1</nodeVersion>
          <npmVersion>5.7.1</npmVersion>
          <workingDirectory>src</workingDirectory>
        </configuration>

        <executions>
          <execution>
            <id>install node and npm</id>
            <goals>
              <goal>install-node-and-npm</goal>
            </goals>
          </execution>

          <execution>
            <id>npm install</id>
            <goals>
              <goal>npm</goal>
            </goals>
          </execution>

          <execution>
            <id>npm run build</id>
            <goals>
              <goal>npm</goal>
            </goals>

            <configuration>
              <arguments>run build</arguments>
            </configuration>
          </execution>
        </executions>
      </plugin>
    </plugins>
  </build>
```