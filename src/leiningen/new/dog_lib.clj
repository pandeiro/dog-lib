(ns leiningen.new.dog-lib
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]
            [clojure.java.io :as io]))

(def render (renderer "dog-lib"))

(defn dog-lib
  "Output the template"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (main/info (str "Generating a new ClojureScript lib in " (:sanitized data) "..."))
    (->files
     data
     ["project.clj"                       (render "project.clj" data)]
     [".gitignore"                        (render "gitignore" data)]
     ["src/{{sanitized}}/core.cljs"       (render "core.cljs" data)]
     ["test/{{sanitized}}/test.cljs"      (render "test.cljs" data)]
     ["test/{{sanitized}}/vendor/console-polyfill.js"
                                          (render "console-polyfill.js" data)]
     ["test/{{sanitized}}/vendor/es5-sham.js"
                                          (render "es5-sham.js" data)]
     ["test/{{sanitized}}/vendor/es5-shim.js"
                                          (render "es5-shim.js" data)]     
     ["test/{{sanitized}}/core_test.cljs" (render "core_test.cljs" data)])))
