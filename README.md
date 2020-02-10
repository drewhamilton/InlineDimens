# Inline Dimens
[![Build Status](https://travis-ci.org/drewhamilton/InlineDimens.svg?branch=master)](https://travis-ci.org/drewhamilton/InlineDimens)

Never confuse px, dp, and sp at runtime again. Inline Dimens offers a separate inline class for each dimen type,
ensuring compile-time unit confidence without any runtime cost. Extension functions provide the ability to interact with
the Android framework directly with these unit-safe types, and to convert between them easily.

## Download

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/dev.drewhamilton.inlinedimens/inlinedimens/badge.svg)](https://maven-badges.herokuapp.com/maven-central/dev.drewhamilton.inlinedimens/inlinedimens)

Inline Dimens is available on Maven Central. It is experimental, and the API may undergo breaking changes before version
1.0.0.

To use Inline Dimens, include the following in your Gradle dependencies:
```groovy
implementation "dev.drewhamilton.inlinedimens:inlinedimens:$version"
```

## Usage

Ensure inline classes are enabled in your build.gradle file:
```groovy
android {
    // ...
    kotlinOptions {
        // ...
        freeCompilerArgs += ["-XXLanguage:+InlineClasses"]
    }
}
```

Then, work directly with unit-safe types in your code. For example, get a `TextView`'s text size in the unit of your
choice:
```kotlin
val scaledTextSize = textView.textSizeSp
```

And convert between different units at will:
```kotlin
val textSizePx = scaledTextSize.toPx()
```

**Note:** Inline classes don't play nicely with Java source code, so this library is unusable in Java files.

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
