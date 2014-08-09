# dog-lib

A Leiningen template for ClojureScript libraries

## Usage

    lein new dog-lib mylib

## Output

    .
    ├── project.clj
    ├── src
    │   └── mylib
    │       └── core.cljs
    └── test
        └── mylib
            ├── core_test.cljs
            ├── run.cljs
            └── vendor
                ├── console-polyfill.js
                ├── es5-sham.js
                └── es5-shim.js

## Compilation

By default the template does not include development nor
production builds, on the assumption that the library will
be consumed by another project with its own compilation
configuration.

## Testing

The template does however provide a test build and scaffolding
using [clojurescript.test](https://github.com/cemerick/clojurescript.test).
Tests are run by a function that returns 0 or 1 for success or failure
so that they can be utilized in automated builds:

    lein cljsbuild test

(Necessary polyfills and shims are included so that ReactJS can
run on PhantomJS.)

## License

Released unencumbered into the public domain
