(ns four-clojure-problems.for-144)

(def osilrate (fn [start & functions]
                (reductions (fn [result function]
                              (function result))
                            start
                            (cycle functions))))
