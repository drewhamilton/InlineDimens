# Releasing

1. Make sure you're on the master branch.
2. Change `ext.libraryVersion` in root build.gradle.
3. Update README.md with any pertinent changes.
4. Update CHANGELOG.md for the impending release.
5. `./gradlew clean assembleRelease && ./gradlew publishReleasePublicationToMavenCentralRepository`
6. Visit [Sonatype Nexus](https://oss.sonatype.org/#stagingRepositories). Verify the artifacts,
   close the staging repository, and release the closed staging repository.
7. Commit and push the release changes to master.
8. Create the release on GitHub with the new changelog entry as the release description.
