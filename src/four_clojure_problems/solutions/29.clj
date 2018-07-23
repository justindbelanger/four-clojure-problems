(ns four-clojure-problems.solutions.29)

(fn [text] 
  (clojure.string/join "" (re-seq #"[A-Z]" text))
)
