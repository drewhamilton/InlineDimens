# Changelog

## 0.6.1
_2020-02-23_

Added extension properties on Int and Float for a nice dimen declaration syntax (e.g. `16.dp`,
`24f.px`).

## 0.6.0
_2020-02-10_

Moved to Maven Central. Changed group name and package name to `dev.drewhamilton.inlinedimens`.

## 0.5.3
_2019-10-7_

Added basic LayoutParams extensions for height, width, and margins.

## 0.5.2
_2019-10-6_

* Extensions for TextView
* Additional extensions for View
* Primitive array types, e.g. DpIntArray

## 0.5.1
_2019-8-17_

* Removed internal `Dimen` and `DimenInt` interfaces, which caused unwanted boxing in some
  functions.
* Removed `@file:JvmName` tags, as inline classes are unusable from Java anyway.

## 0.5.0
_2019-8-16_

Added extensions for public View dimension-related functions.

## 0.4.0
_2019-8-6_

Added parameter-free conversion methods, e.g. `Px.toDp()`.

## 0.3.0
_2019-8-4_

* Added `Display` extensions.
* Redesigned text size extensions.
* Removed `BuildConfig`.

## 0.2.0
_2019-6-26_

Added TextView extensions.

## 0.1.0
_2019-6-25_

Initial pre-release.
