# dog-lib

A Leiningen template for ClojureScript libraries

## Usage

    lein new dog-lib mylib

## Output

    mylib/
    ├── project.clj
    └── src
        └── mylib
            └── core.cljs

(The project file contains no `:cljsbuild` information as
typically the library will be compiled in the project that
consumes it.)

**TODO: figure out sane testing strategy**

## License

Released unencumbered into the public domain
