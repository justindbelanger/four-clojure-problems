(ns four-clojure-problems.solutions.113)

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

(def tests [{:input '(2 1 3)
             :tested (fn [f i] (str (f i)))}
            {:input '(2 1 3)
             :tested (fn [f i] (seq (f i)))}
            {:input '(2 1 3 3 1 2)
             :tested (fn [f i] (seq (f i)))}
            {:input (repeat 5 1)
             :tested (fn [f i] (seq (apply f i)))}
            {:input (repeat 5 1)
             :tested (fn [f i] (str (apply f i)))}
            {:input '()
             :tested (fn [f i] (seq f i))}
            {:input '()
             :tested (fn [f i] (str f i))}])
