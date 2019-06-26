# Inline Dimens
Never confuse px, dp, and sp at runtime again. Inline Dimens offers a separate inline class for each dimen type,
ensuring compile-time unit confidence without any runtime cost. `Resources` extension methods provide dimens from
resources in the appropriate unit.

## Download
[![Download](https://api.bintray.com/packages/drewhamilton/InlineDimens/InlineDimens/images/download.svg)](https://bintray.com/drewhamilton/InlineDimens)

Inline Dimens is available in JCenter. It is experimental, and the API may undergo breaking changes before version
1.0.0.

To use Inline Dimens, include the following in your Gradle dependencies:
```groovy
implementation "drewhamilton.inlinedimens:inlinedimens:$version"
```

## License
```
Copyright 2019 Drew Hamilton

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
