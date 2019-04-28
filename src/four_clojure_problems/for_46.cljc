(ns four-clojure-problems.for-46)

(def flipper (fn [f]
               (fn [& args]
                 (apply f (reverse args)))))
