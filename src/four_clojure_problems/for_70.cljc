(ns four-clojure-problems.for-70
  (:require [clojure.string :as string]))

(defn word-sorting
  "Provides the words from the text, sorted."
  [text]
  (let [split (-> text
                  (string/replace #"[\.\!]" "")
                  (string/split #"\s"))]
    (sort-by (fn [word]
               (string/lower-case word))
             split)))

;; gotta be able to copy & paste into a text box on 4clojure.com
(def word-sorting-solution
  (fn [text]
    (let [split (-> text
                    (clojure.string/replace #"[\.\!]" "")
                    (clojure.string/split #"\s"))]
      (sort-by (fn [word]
                 (clojure.string/lower-case word))
               split))))
