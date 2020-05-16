(ns four-clojure-problems.for-55)

(def count-occurrences
  (fn [ss]
    (let [inc' (fnil inc 0)]
      (reduce (fn [acc s]
                (update acc s inc'))
              {}
              ss))))
