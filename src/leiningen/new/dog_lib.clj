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
    (main/info (str "Generated a new ClojureScript lib in " (:sanitized data)))
    (->files
     data
     ["project.clj"                      (render "project.clj" data)]
     [".gitignore"                       (render "gitignore" data)]
     ["src/{{sanitized}}/core.cljs"      (render "core.cljs" data)])
    
    (do
      (main/info "Done"))))
