(ns four-clojure-problems.solutions.51)

(def solution [1 2 3 4 5])

(defn destructure [v]
  (let [[a b & c :as d] v]
    [a b c d]))
