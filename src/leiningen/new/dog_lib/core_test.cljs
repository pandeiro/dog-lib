(ns {{name}}.core-test
  (:require-macros [cemerick.cljs.test
                    :refer [is deftest with-test run-tests
                            testing test-var done]])
  (:require [cemerick.cljs.test :as t]
            [{{name}}.core :refer [{{name}}-state view render]]))

(defn add-root-element! []
  (let [div (.createElement js/document "div")]
    (.setAttribute div "id" "root")
    (.appendChild js/document.body div)
    div))

(def root (add-root-element!))



(deftest click-atom-state

  (render :div#root)

  (let [span   (.querySelector js/document "div#root span")
        button (.querySelector js/document "div#root button")]

    (testing "original state atom"
      (is (= {} @{{name}}-state)))

    (.click button)

    (testing "click changes state"
      (is (= {:active true} @{{name}}-state))))

  (reset! {{name}}-state {}))


(deftest ^:async click-dom-state
  
  (render :div#root)
  
  (let [span   (.querySelector js/document "div#root span")
        button (.querySelector js/document "div#root button")]

    (testing "original span state"
      (is (= "Inactive" (.-textContent span))))

    (.click button)

    (js/setTimeout
     (fn []

       (testing "click changes span (next tick)"
         (is (= "Active" (.-textContent span)))
         (done)))

     250)))
