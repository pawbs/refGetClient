refGetClient - query all known names for a given identifier as well as fetch any associated metadata

- [Prerequisites](#prerequisites)
- [Arguments](#arguments)
- [Example](#example)
- [Example Output](#example-output)

# Prerequisites
Java 1.8 or higher

# Arguments
    -i,--id <id>                         A string specifying an identifier to retrieve metadata
                                         for using one of the defined checksum algorithms or a
                                         server-specific checksum algorithm.`

## Example
    java -jar refget-client-1.0-SNAPSHOT.jar --id 3050107579885e1608e6fe50fae3f8d0

### Example Output
    {"metadata":{"md5":"3050107579885e1608e6fe50fae3f8d0","length":7156,"aliases":[],"trunc512":null}}

# Background
This CLI tool is a lightweight client that allows users to query the metadata endpoint of the ENA CRAM archive. It is written in spring, built using maven and includes some simple unit tests. To run this tool, download the latest .jar from releases, or clone this repo locally, install maven, build using `mvn clean install`, and run RefGetClientApplication.
When running this application, the user must specify an id to lookup in the ENA CRAM archive. The return is a JSON formatted response that contains the md5 checksum, TRUNC55 checksum, length of the reference sequence, and a list of aliases.
