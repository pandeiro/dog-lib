(ns {{name}}.core
  (:require-macros [cljs.core.async.macros :refer [go]])
  (:require [cljs.core.async :as async :refer [chan put! <! >!]]
            [reagent.core :as r :refer [render-component]]))

(def {{name}}-state (r/atom {}))

(defn view [] 
  [:div
   [:button
    {:on-click #(swap! {{name}}-state assoc :active true)}
    "activate"]
   [:span
    (if (:active @{{name}}-state)
      "Active"
      "Inactive")]])

(defn render [selector]
  (let [el (.querySelector js/document (name selector))]
    (render-component [view] el)))


