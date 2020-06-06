(ns four-clojure-problems.for-143)

(def any-in-coll? (complement not-any?))

(defn group-by-index [colls]
  (let [tuple (list (map first
                         colls))
        rest-colls (map rest
                        colls)]
    (if (any-in-coll? empty?
                      rest-colls)
      tuple
      (lazy-cat tuple
                (group-by-index rest-colls)))))

(defn dot [u v]
  (apply +
         (map (partial apply
                       *) (group-by-index (list u
                                             v)))))

(def solution (fn [u v]
                (let [any-in-coll? (complement not-any?)
                      group-by-index (fn group [colls]
                                       (let [tuple (list (map first
                                                              colls))
                                             rest-colls (map rest
                                                             colls)]
                                         (if (any-in-coll? empty?
                                                           rest-colls)
                                           tuple
                                           (lazy-cat tuple
                                                     (group rest-colls)))))]
                  (apply +
                         (map (partial apply
                                       *) (group-by-index (list u
                                                                v)))))))
