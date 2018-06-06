;; we're actually grouping by index.
;; the equivalent for a hash-map would be to group by key.
(defn make-tuples [colls]
  (let [tuple (list (map first
                         colls))
        rest-colls (map rest
                        colls)]
    (if (not (not-any? empty?
                       rest-colls))
      tuple
      (lazy-cat tuple
                (make-tuples rest-colls)))))

(defn dot [u v]
  (apply +
         (map (partial apply
                       *) (make-tuples (list u
                                             v)))))

(def solution (fn [u v]
                (let [group-by-index (fn group [colls]
                                    (let [tuple (list (map first
                                                           colls))
                                          rest-colls (map rest
                                                          colls)]
                                      (if (not (not-any? empty?
                                                         rest-colls))
                                        tuple
                                        (lazy-cat tuple
                                                  (group rest-colls)))))]
                  (apply +
                         (map (partial apply
                                       *) (group-by-index (list u
                                                             v)))))))
