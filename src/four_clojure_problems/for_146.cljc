(ns four-clojure-problems.for-146)

(def tree-to-table (fn [t]
                     (let [seq-kvs (fn [tree]
                                     (apply concat (for [[k v] tree]
                                                     (for [[l w] v]
                                                       [[k l] w]))))]
                       (reduce (fn [result [k v]]
                                 (assoc result
                                        k
                                        v))
                               {}
                               (seq-kvs t)))))
