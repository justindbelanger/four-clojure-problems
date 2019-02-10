(ns four-clojure-problems.for-113)

(def data-dance (fn [& ints]
                  (reify
                    Object
                    (toString [this]
                      (if (not (empty? ints))
                        (->> ints
                             sort
                             (map str)
                             (interpose ", ")
                             (apply str))
                        ""))
                    clojure.lang.Seqable
                    (seq [this] (if (not (empty? ints))
                                  (distinct ints)
                                  nil)))))
