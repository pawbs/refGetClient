refGetClient - query all known names for a given identifier as well as fetch any associated metadata

- [Prerequisites](#prerequisites)
- [Arguments](#arguments)
- [Usage](#usage)
- [Example Output](#example-output)
- [Background](#background)
- [Write-up](#write-up)

# Prerequisites
Java 1.8 or higher

# Arguments
    -i,--id <id>                         A string specifying an identifier to retrieve metadata
                                         for using one of the defined checksum algorithms or a
                                         server-specific checksum algorithm.`

## Example
Download jar from releases and run with java

    java -jar refget-client-1.0-SNAPSHOT.jar --id 3050107579885e1608e6fe50fae3f8d0

### Example Output
    {"metadata":{"md5":"3050107579885e1608e6fe50fae3f8d0","length":7156,"aliases":[],"trunc512":null}}

# Background
This CLI tool is a lightweight client that allows users to query the metadata endpoint of the ENA CRAM archive. It is written in spring, built using maven and includes some simple unit tests. To run this tool, download the latest .jar from releases, or clone this repo locally, install maven, build using `mvn clean install`, and run RefGetClientApplication.
When running this application, the user must specify an id to lookup in the ENA CRAM archive. The return is a JSON formatted response that contains the md5 checksum, TRUNC55 checksum, length of the reference sequence, and a list of aliases.

# Write-up
Since the purpose of this repo is for technical assessment, here is a link to a doc containing the original questions, my answers to those questions, as well as other considerations I would have to extend the functionality of this little application I've built
https://docs.google.com/document/d/1gp2v_Q8wr1BJUd8deZwkFYJZcZCUIU1CfU3vwoBf6t8/edit?usp=sharing
