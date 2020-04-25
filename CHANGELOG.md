# Changelog

## 0.6.2
_2020-04-25_

Add operator functions to all dimension types, so arithmetic can be performed with them.

Deprecate `toDpFloat` and `toDpInt` in favor of more precisely named `exact` and `toOffset`,
respectively. Add `toSize` with similar rounding functionality to Android's
`Resources.getDimensionPixelSize`.

Update to Kotlin 1.3.72.

## 0.6.1
_2020-02-23_

Add extension properties on Int and Float for a nice dimen declaration syntax (e.g. `16.dp`,
`24f.px`).

## 0.6.0
_2020-02-10_

Move to Maven Central. Changed group name and package name to `dev.drewhamilton.inlinedimens`.

## 0.5.3
_2019-10-7_

Add basic LayoutParams extensions for height, width, and margins.

## 0.5.2
_2019-10-6_

* Extensions for TextView
* Additional extensions for View
* Primitive array types, e.g. DpIntArray

## 0.5.1
_2019-8-17_

* Remove internal `Dimen` and `DimenInt` interfaces, which caused unwanted boxing in some
  functions.
* Remove `@file:JvmName` tags, as inline classes are unusable from Java anyway.

## 0.5.0
_2019-8-16_

Add extensions for public View dimension-related functions.

## 0.4.0
_2019-8-6_

Add parameter-free conversion methods, e.g. `Px.toDp()`.

## 0.3.0
_2019-8-4_

* Add `Display` extensions.
* Redesign text size extensions.
* Remov `BuildConfig`.

## 0.2.0
_2019-6-26_

Add TextView extensions.

## 0.1.0
_2019-6-25_

Initial pre-release.
