(ns four-clojure-problems.for-56)

(def find-distinct-items
  (fn [s]
    (let [f (fn f ([s]
                   (f s #{}))
              ([s tracked]
               (let [head (first s)
                     tail (rest s)
                     new? (not (contains? tracked head))
                     end? (not (seq tail))]
                 (if end?
                   (if new?
                     (list head)
                     (list))
                   (if new?
                     (lazy-seq (cons head (f tail (conj tracked head))))
                     (lazy-seq (f tail tracked)))))))]
      (f s))))
