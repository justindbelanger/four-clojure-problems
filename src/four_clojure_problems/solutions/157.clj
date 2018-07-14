(ns four-clojure-problems.solutions.157)

(def index (fn [ss]
             (map (fn [s] (reverse s))
                  (map-indexed vector
                               ss))))
