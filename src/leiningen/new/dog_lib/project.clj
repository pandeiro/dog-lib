(defproject {{name}} "0.1.0-SNAPSHOT"
  :description "Something that does something."
  :url "http://yoururl.com"

  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2307"]
                 [org.clojure/core.async "0.1.303.0-886421-alpha"]
                 [reagent "0.4.2"]]

  :profiles
  {:dev
   {:plugins [[lein-cljsbuild "1.0.3"]
              [com.cemerick/austin "0.1.4"]
              [com.cemerick/clojurescript.test "0.3.1"]]

    :dependencies [[com.cemerick/double-check "0.5.7"]
                   [com.cemerick/clojurescript.test "0.3.1"]]

    :cljsbuild {:builds
                [{:id "tests"
                  :source-paths ["src" "test"]
                  :notify-command
                  ["phantomjs" :cljs.test/runner
                   "window.literal_js_executed=true"
                   "test/{{sanitized}}/vendor/es5-shim.js"
                   "test/{{sanitized}}/vendor/es5-sham.js"
                   "test/{{sanitized}}/vendor/console-polyfill.js"
                   "target/tests.js"]
                  :compiler {:preamble ["reagent/react.js"]
                             :output-to "target/tests.js"
                             :optimizations :whitespace
                             :pretty-print true}}]
                :test-commands
                {"unit-tests"
                 ["phantomjs" :runner
                  "window.literal_js_executed=true"
                  "test/{{sanitized}}/vendor/es5-shim.js"
                  "test/{{sanitized}}/vendor/es5-sham.js"
                  "test/{{sanitized}}/vendor/console-polyfill.js"
                  "target/tests.js"]}}}

   :aliases {"autotest-cljs" ["do"
                              ["cljsbuild" "clean"]
                              ["cljsbuild" "auto" "tests"]]}})
