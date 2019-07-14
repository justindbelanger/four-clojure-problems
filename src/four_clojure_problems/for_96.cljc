(ns four-clojure-problems.for-96)

(def has-symmetree?
  (fn
    ([btree]
     (has-symmetree? btree btree))
    ([btree-1 btree-2]
     (let [nil-1 (nil? btree-1)
           nil-2 (nil? btree-2)
           third #(nth % 2)]
       (cond
         (= btree-1 btree-2 nil)            true
         (or (nil? btree-1) (nil? btree-2)) false
         :default                           (and (= (first btree-1)
                                                    (first btree-2))
                                                 (has-symmetree? (second btree-1)
                                                                 (third btree-2))
                                                 (has-symmetree? (third btree-1)
                                                                 (second btree-2))))))))
