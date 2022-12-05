# Geosamples Ingest JPA

## Building

### Build Dependencies
JDK 1.8 or higher is required to build this project.

Maven 3.6.0 or higher is required to build this project.

### Repository Configuration

Private repository URls are purposely omitted from the pom.xml to maintain build
portability, allowing for the project to be built in more than one environment and preventing
potential URL changes from breaking the build and requiring a change to the
project code.

A settings.xml file should be created to reference any private repositories. This
file should only need to be created once per developer across all projects.  The default 
location of this file is ~/.m2/settings.xml.  If you do not wish to add the
repositories to your default settings.xml, the -s flag can be added to Maven
build commands to specify a custom one.

If using a CI/CD tool like Jenkins, a settings.xml file can be configured globally or
the -s flag can be used to specify one per project.

Here is an example:
```xml
<?xml version="1.0" encoding="UTF-8"?>
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 http://maven.apache.org/xsd/settings-1.0.0.xsd">
  <profiles>
    <profile>
      <id>artifactory</id>
      <repositories>
        <repository>
          <id>artifactory-snapshot</id>
          <name>Snapshot Respository</name>
          <url>https://devtools.ngdc.noaa.gov/artifactory/libs-snapshot</url>
          <releases>
            <enabled>false</enabled>
          </releases>
          <snapshots>
            <enabled>true</enabled>
            <updatePolicy>always</updatePolicy>
            <checksumPolicy>fail</checksumPolicy>
          </snapshots>
        </repository>
        <repository>
          <id>artifactory-release</id>
          <name>Release Respository</name>
          <url>https://devtools.ngdc.noaa.gov/artifactory/libs-release</url>
          <releases>
            <enabled>true</enabled>
            <updatePolicy>never</updatePolicy>
            <checksumPolicy>fail</checksumPolicy>
          </releases>
          <snapshots>
            <enabled>false</enabled>
          </snapshots>
        </repository>
      </repositories>
    </profile>
  </profiles>
  <activeProfiles>
    <activeProfile>artifactory</activeProfile>
  </activeProfiles>
</settings>
```

### How To Build On A Developer Machine
From the root of the project run:
```bash
mvn clean install
```
To perform a build with dependency vulnerability checking, run:
```bash
mvn clean install -Pdep-check
```

### How To Build And Deploy To An Artifact Repository
It is recommended that a CI/CD tool like Jenkins do this, rather than on
a developer machine, however this is possible.

The settings.xml must be configured with the appropriate "server" and "distributionManagement"
sections.  

Run:
```bash
mvn clean deploy -Pdep-check
```

Alternately, plugins exist for CI/CD tools that can deploy artifacts to repositories
without configuring "server" and "distributionManagement". In this case follow the 
developer build instructions and configure the plugin as specified in its
documentation.
