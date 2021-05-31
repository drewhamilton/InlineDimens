# Releasing

 1. Make sure you're on the main branch.
 2. Change `ext.libraryVersion` in root build.gradle to a non-SNAPSHOT version.
 3. Update README.md with any pertinent changes.
 4. Update CHANGELOG.md for the impending release.
 5. Commit (don't push) the changes with message "Release x.y.z", where x.y.z is the new version.
 6. Tag the commit `x.y.z`, where x.y.z is the new version.
 7. Change `ext.libraryVersion` in root build.gradle to the next SNAPSHOT version.
 8. Commit the snapshot change.
 9. Push the 2 commits + 1 tag to origin/main.
10. Wait for the "Release" Action to complete.
11. `startship release -u personalSonatypeIssuesUsername -p personalSonatypeIssuesPassword -c dev.drewhamilton.inlinedimens:inlinedimens:x.y.z`
12. Create the release on GitHub with the release notes copied from the changelog.
